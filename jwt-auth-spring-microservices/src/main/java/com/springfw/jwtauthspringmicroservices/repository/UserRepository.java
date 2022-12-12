package com.springfw.jwtauthspringmicroservices.repository;

import com.springfw.jwtauthspringmicroservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndPassword(String userName, String password);
}
