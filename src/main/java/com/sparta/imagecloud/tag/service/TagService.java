package com.sparta.imagecloud.tag.service;


import com.sparta.imagecloud.article.entity.Article;
import com.sparta.imagecloud.article.repository.ArticleRepository;
import com.sparta.imagecloud.articletag.entity.ArticleTag;
import com.sparta.imagecloud.like.entity.Likes;
import com.sparta.imagecloud.like.repository.LikeRepository;
import com.sparta.imagecloud.tag.dto.TagSearchResponseDto;
import com.sparta.imagecloud.articletag.repository.ArticleTagRepository;
import com.sparta.imagecloud.tag.entity.Tag;
import com.sparta.imagecloud.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class TagService {
    private final TagRepository tagRepository;
    private final ArticleTagRepository articleTagRepository;
    private final ArticleRepository articleRepository;
    private final LikeRepository likeRepository;

   public List<TagSearchResponseDto> searchTag(String keyword){

       List<TagSearchResponseDto> tagSearchResponseDtoList = new ArrayList<>();

       Tag searchKeywordTag = tagRepository.findByKeyword(keyword);

       List<ArticleTag> articleTags = articleTagRepository.findAllByTag(searchKeywordTag);
       for (ArticleTag articleTag : articleTags) {
            Article article = articleRepository.findById(articleTag.getArticle().getArticleId())
                    .orElseThrow(() -> new RuntimeException("해당  아티클이 없습니다."));

           List<Tag> tags = articleTagRepository.findTagByArticleId(article.getArticleId());
           List<String> tagNames = new ArrayList<>();

           for (Tag tag : tags) {
               tagNames.add(tag.getKeyword());
           }

           List<Long> likeUserIds = new ArrayList<>();
           List<Likes> LikeUser = likeRepository.findAllByArticle(article);

           for (Likes likes : LikeUser) {
               likeUserIds.add(likes.getUser().getUserId());
           }

           // ResponseDto 생성
           TagSearchResponseDto tagSearchResponseDto = new TagSearchResponseDto();
           tagSearchResponseDto.setArticle_id(article.getArticleId());
           //tagSearchResponseDto.setWriter_nickname(article.getUser().getUserWriterNickname());
           //tagSearchResponseDto.setNickname(article.getUser().getUserNickname());
           tagSearchResponseDto.setImage_url(article.getImageUrl());
           tagSearchResponseDto.setCreated_date(article.getCreatedDate());
           tagSearchResponseDto.setTags(tagNames);
           tagSearchResponseDto.setLiked_users(likeUserIds);
           tagSearchResponseDtoList.add(tagSearchResponseDto);
       }

       return tagSearchResponseDtoList;
    }
}
