package com.sparta.imagecloud.tag.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class TagSearchResponseDto {

    private List<String> tags;
    private LocalDateTime created_date;

}
