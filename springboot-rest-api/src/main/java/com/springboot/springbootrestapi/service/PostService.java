package com.springboot.springbootrestapi.service;

import com.springboot.springbootrestapi.payload.PostDTO;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    PostDTO getPostById(long id);

    PostDTO updatePost(PostDTO dto, long id);

    void deletePostById(long id);
}
