package com.spring.cloudmicroservices.departmentservice.repository;

import com.spring.cloudmicroservices.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
