package com.springboot.springbootrestapi.service.impl;

import com.springboot.springbootrestapi.entity.Comment;
import com.springboot.springbootrestapi.entity.Post;
import com.springboot.springbootrestapi.exception.BlogAPIException;
import com.springboot.springbootrestapi.exception.ResourceNotFoundException;
import com.springboot.springbootrestapi.payload.CommentDTO;
import com.springboot.springbootrestapi.repository.CommentRepository;
import com.springboot.springbootrestapi.repository.PostRepository;
import com.springboot.springbootrestapi.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Override
    public CommentDTO saveComment(Long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);
        // retrieve post entity by id
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("posts", "id", String.valueOf(postId)));
        // set post to comment entity
        comment.setPost(post);
        return mapToDTO(commentRepository.save(comment));
    }

    @Override
    public CommentDTO getCommentById(Long id, Long postId) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("comments", "id", String.valueOf(id)));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("posts", "id", String.valueOf(postId)));
        checkValidComment(comment.getPost().getId(), post.getId());
        return mapToDTO(comment);
    }

    @Override
    public List<CommentDTO> getCommentsByPostId(Long postId) {
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);
        // convert list of comment entities to list of comment dto's
        return comments.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CommentDTO updateComment(Long postId, Long cmtId, CommentDTO cmtPayload) {
        Comment comment = commentRepository.findById(cmtId)
                .orElseThrow(() -> new ResourceNotFoundException("comments", "id", String.valueOf(cmtId)));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("posts", "id", String.valueOf(postId)));
        checkValidComment(comment.getPost().getId(), post.getId());
        comment.setName(cmtPayload.getName());
        comment.setEmail(cmtPayload.getEmail());
        comment.setBody(cmtPayload.getBody());
        return mapToDTO(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(Long postId, Long cmtId) {
        Comment comment = commentRepository.findById(cmtId)
                .orElseThrow(() -> new ResourceNotFoundException("comments", "id", String.valueOf(cmtId)));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("posts", "id", String.valueOf(postId)));
        checkValidComment(comment.getPost().getId(), post.getId());
        commentRepository.delete(comment);
    }

    private void checkValidComment(Long postId, Long cmtId) {
        if (!Objects.equals(postId, cmtId)) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }
    }

    private Comment mapToEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setName(dto.getName());
        comment.setEmail(dto.getEmail());
        comment.setBody(dto.getBody());
        return comment;
    }

    private CommentDTO mapToDTO(Comment e) {
        CommentDTO dto = new CommentDTO();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setBody(e.getBody());
        dto.setEmail(e.getEmail());
        return dto;
    }
}
