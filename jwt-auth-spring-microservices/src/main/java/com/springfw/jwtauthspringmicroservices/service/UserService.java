package com.springfw.jwtauthspringmicroservices.service;

import com.springfw.jwtauthspringmicroservices.entity.User;
import com.springfw.jwtauthspringmicroservices.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(User user);

    User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
