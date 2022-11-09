package com.springboot.springbootrestapi.service.impl;

import com.springboot.springbootrestapi.entity.Post;
import com.springboot.springbootrestapi.exception.ResourceNotFoundException;
import com.springboot.springbootrestapi.payload.PostDTO;
import com.springboot.springbootrestapi.payload.PostResponse;
import com.springboot.springbootrestapi.repository.PostRepository;
import com.springboot.springbootrestapi.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param id the request Post ID
     * @return the retrieved Post object
     */
    @Override
    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "id", String.valueOf(id)));
        return mapToDTO(post);
    }

    /**
     * Get all POSTS with pagination
     *
     * @param pageNo   no of page
     * @param pageSize size
     * @param sortBy   sort by
     * @param sortDir  sort direction
     * @return PostResponse object with list of posts
     */
    @Override
    public PostResponse getPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        // Create sort instance
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        // Create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

        // Get content for page object
        List<PostDTO> content = posts.stream().map(this::mapToDTO).collect(Collectors.toList());

        return PostResponse.builder()
                .content(content)
                .pageNo(posts.getNumber())
                .pageSize(posts.getSize())
                .totalPages(posts.getTotalPages())
                .totalElements(posts.getTotalElements())
                .last(posts.isLast())
                .build();
    }

    /**
     * @param dto the object to updates
     * @param id  the id
     * @return the updated Post object
     */
    @Override
    public PostDTO updatePost(PostDTO dto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "id", String.valueOf(id)));
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }

    /**
     * Delete POST entity by id
     *
     * @param id post id
     */
    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "id", String.valueOf(id)));
        postRepository.delete(post);
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
