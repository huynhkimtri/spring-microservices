package com.spring.cloudmicroservices.departmentservice.controller;

import com.spring.cloudmicroservices.departmentservice.entity.Department;
import com.spring.cloudmicroservices.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
}
