package com.sparta.imagecloud.tag.repository;

import com.sparta.imagecloud.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByKeyword(String keyword);
}
