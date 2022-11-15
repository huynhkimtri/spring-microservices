package com.springboot.springbootrestapi.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentDTO {
    private Long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @Email
    @NotEmpty(message = "Email should not be null or empty")
    private String email;

    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;
}
