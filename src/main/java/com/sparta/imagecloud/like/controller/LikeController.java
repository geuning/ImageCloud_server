package com.sparta.imagecloud.like.controller;


import com.sparta.imagecloud.like.dto.LikeResponseDto;
import com.sparta.imagecloud.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/pictures/{articleId}/like")
    public ResponseEntity<LikeResponseDto> getLikes(@PathVariable Long articleId){
        likeService.getLikes(articleId);
        return ResponseEntity.ok().build();
    }
}
