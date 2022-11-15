package com.springboot.springbootrestapi.service;

import com.springboot.springbootrestapi.payload.CommentDTO;

import java.util.List;

public interface CommentService {

    CommentDTO saveComment(Long postId, CommentDTO commentDTO);

    CommentDTO getCommentById(Long id, Long postId);

    List<CommentDTO> getCommentsByPostId(Long postId);

    CommentDTO updateComment(Long postId, Long cmtId, CommentDTO cmtPayload);

    void deleteComment(Long postId, Long cmtId);
}
