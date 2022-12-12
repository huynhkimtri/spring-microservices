package com.spring.cloudmicroservices.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
