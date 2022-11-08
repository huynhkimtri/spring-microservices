package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.payload.PostDTO;
import com.springboot.springbootrestapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     * Create Blog Post Rest API
     *
     * @param postDTO request body object
     * @return created Post object
     */
    @PostMapping("/api/v1/posts")
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    /**
     * Get Post by Id
     *
     * @param id the Post id
     * @return the existed Post object
     */
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

}
