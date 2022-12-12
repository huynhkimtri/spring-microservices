package com.spring.cloudmicroservices.userservice.controller;

import com.spring.cloudmicroservices.userservice.dto.ResponseDTO;
import com.spring.cloudmicroservices.userservice.entity.User;
import com.spring.cloudmicroservices.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
