package com.sparta.imagecloud.like.service;


import com.sparta.imagecloud.like.entity.Likes;
import com.sparta.imagecloud.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class LikeService {

    private final LikeRepository likeRepository;


    public Boolean getLikes(Long articleId) {
        Boolean articleLike = likeRepository.findByArticleId(articleId);


    }
}
