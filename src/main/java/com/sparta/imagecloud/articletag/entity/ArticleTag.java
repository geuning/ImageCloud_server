package com.sparta.imagecloud.articletag.entity;

import com.sparta.imagecloud.article.entity.Article;
import com.sparta.imagecloud.tag.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ArticleTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;


}
