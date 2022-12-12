package com.springfw.jwtauthspringmicroservices.service;

import com.springfw.jwtauthspringmicroservices.entity.User;
import com.springfw.jwtauthspringmicroservices.exception.UserNotFoundException;
import com.springfw.jwtauthspringmicroservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        User user = userRepository.findByUserNameAndPassword(name, password);
        if (user == null) {
            throw new UserNotFoundException("Invalid id and password");
        }
        return user;
    }
}
