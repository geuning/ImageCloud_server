package com.sparta.imagecloud.like.repository;

import com.sparta.imagecloud.article.entity.Article;
import com.sparta.imagecloud.like.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    List<Likes> findAllByArticle(Article article);
}
