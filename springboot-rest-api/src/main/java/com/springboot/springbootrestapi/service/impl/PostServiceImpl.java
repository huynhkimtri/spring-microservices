package com.springboot.springbootrestapi.service.impl;

import com.springboot.springbootrestapi.entity.Post;
import com.springboot.springbootrestapi.exception.ResourceNotFoundException;
import com.springboot.springbootrestapi.payload.PostDTO;
import com.springboot.springbootrestapi.repository.PostRepository;
import com.springboot.springbootrestapi.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        // convert DTO to entity
        Post post = mapToEntity(postDTO);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        return mapToDTO(newPost);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "id", String.valueOf(id)));
        return mapToDTO(post);
    }

    /**
     * @param dto
     * @param id
     * @return
     */
    @Override
    public PostDTO updatePost(PostDTO dto, long id) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deletePostById(long id) {

    }

    private PostDTO mapToDTO(Post post) {
//        PostDto postDto = mapper.map(post, PostDto.class);
        PostDTO postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    private Post mapToEntity(PostDTO postDto) {
//        Post post = mapper.map(postDto, Post.class);
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
