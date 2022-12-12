package com.spring.cloudmicroservices.departmentservice.utils;

import com.spring.cloudmicroservices.departmentservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER-SERVICE", url = "http://localhost:8081")
public interface APIClient {
    @GetMapping(value = "/api/users/{id}")
    UserDTO getUserById(@PathVariable("id") Long userId);
}
