package com.spring.cloudmicroservices.userservice.service;

import com.spring.cloudmicroservices.userservice.dto.ResponseDTO;
import com.spring.cloudmicroservices.userservice.entity.User;

public interface UserService {

    User saveUser(User user);

    ResponseDTO getUserById(Long id);
}
