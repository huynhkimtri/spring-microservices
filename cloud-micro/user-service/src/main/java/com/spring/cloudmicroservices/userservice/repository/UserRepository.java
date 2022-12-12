package com.spring.cloudmicroservices.userservice.repository;

import com.spring.cloudmicroservices.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
