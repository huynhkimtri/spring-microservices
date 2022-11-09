package com.springboot.springbootrestapi.service;

import com.springboot.springbootrestapi.payload.PostDTO;
import com.springboot.springbootrestapi.payload.PostResponse;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    PostDTO getPostById(long id);

    PostResponse getPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDTO updatePost(PostDTO dto, long id);

    void deletePostById(long id);
}
