package com.springfw.jwtauthspringmicroservices.config;

import com.springfw.jwtauthspringmicroservices.entity.User;

import java.util.Map;

public interface JwtGenerator {
    Map<String, String> generateToken(User user);
}
