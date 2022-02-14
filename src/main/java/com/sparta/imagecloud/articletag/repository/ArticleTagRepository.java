package com.sparta.imagecloud.articletag.repository;

import com.sparta.imagecloud.articletag.entity.ArticleTag;
import com.sparta.imagecloud.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag,Long> {

    List<ArticleTag> findAllByTag(Tag tag);

    @Query("select  t.tag " +
            "from ArticleTag t " +
            "where t.article.articleId = :articleId")
    List<Tag> findTagByArticleId(@Param("articleId") Long articleId);

}
