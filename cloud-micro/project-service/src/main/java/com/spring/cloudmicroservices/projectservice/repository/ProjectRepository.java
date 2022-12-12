package com.spring.cloudmicroservices.projectservice.repository;

import com.spring.cloudmicroservices.projectservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
