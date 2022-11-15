package com.springboot.springbootrestapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class BlogAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
