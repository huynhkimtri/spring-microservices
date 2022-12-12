package com.spring.cloudmicroservices.departmentservice.service.impl;

import com.spring.cloudmicroservices.departmentservice.dto.DepartmentDTO;
import com.spring.cloudmicroservices.departmentservice.dto.ResponseDTO;
import com.spring.cloudmicroservices.departmentservice.dto.UserDTO;
import com.spring.cloudmicroservices.departmentservice.entity.Department;
import com.spring.cloudmicroservices.departmentservice.repository.DepartmentRepository;
import com.spring.cloudmicroservices.departmentservice.service.DepartmentService;
import com.spring.cloudmicroservices.departmentservice.utils.APIClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private APIClient apiClient;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(new Department());
    }

    /**
     * Make a REST API to user-service
     * @param id user id
     * @return UserDTO
     */
    private UserDTO getUserById(Long id) {
        return apiClient.getUserById(id);
    }
}
