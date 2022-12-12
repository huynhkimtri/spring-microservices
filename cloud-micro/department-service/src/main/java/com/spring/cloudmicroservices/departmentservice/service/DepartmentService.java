package com.spring.cloudmicroservices.departmentservice.service;

import com.spring.cloudmicroservices.departmentservice.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);
}
