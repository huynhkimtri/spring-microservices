package com.springboot.springbootrestapi.repository;

import com.springboot.springbootrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
