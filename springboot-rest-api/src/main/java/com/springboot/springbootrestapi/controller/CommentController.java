package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.payload.CommentDTO;
import com.springboot.springbootrestapi.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> saveComment(@PathVariable(value = "postId") Long postId,
                                                  @Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO createdComment = commentService.saveComment(postId, commentDTO);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}/comments/{cmtId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "cmtId") Long cmtId,
                                                    @Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.updateComment(postId, cmtId, commentDTO);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }
}
