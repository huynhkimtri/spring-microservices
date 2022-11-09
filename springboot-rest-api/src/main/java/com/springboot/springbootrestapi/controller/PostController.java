package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.payload.PostDTO;
import com.springboot.springbootrestapi.payload.PostResponse;
import com.springboot.springbootrestapi.service.PostService;
import com.springboot.springbootrestapi.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
public class PostController {

    private final PostService postService;

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
     * Get Post by Id REST API
     *
     * @param id the Post id
     * @return the existed Post object
     */
    @GetMapping("/api/v1/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    /**
     * Get All Posts REST API
     *
     * @param pageNo   page number
     * @param pageSize page size
     * @param sortBy   sort by
     * @param sortDir  sort direction
     * @return PostResponse object
     */
    @GetMapping("/api/v1/posts")
    public ResponseEntity<PostResponse> getPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        return ResponseEntity.ok(postService.getPosts(pageNo, pageSize, sortBy, sortDir));
    }


    /**
     * Update Post REST API
     *
     * @param postDTO the request object
     * @return the updated object
     */
    @PutMapping("/api/v1/posts")
    public ResponseEntity<PostDTO> updatePost(@Valid @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(postService.updatePost(postDTO, postDTO.getId()));
    }

    /**
     * Delete Post By Id REST API
     *
     * @param id post id
     * @return message successfully
     */
    @DeleteMapping("/api/v1/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully", HttpStatus.OK);
    }

}
