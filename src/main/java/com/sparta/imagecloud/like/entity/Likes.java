package com.sparta.imagecloud.like.entity;

import com.sparta.imagecloud.article.entity.Article;
import com.sparta.imagecloud.user.entity.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
