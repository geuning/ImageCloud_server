package com.sparta.imagecloud.article.repository;

import com.sparta.imagecloud.article.entity.Article;
import com.sparta.imagecloud.articletag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}
