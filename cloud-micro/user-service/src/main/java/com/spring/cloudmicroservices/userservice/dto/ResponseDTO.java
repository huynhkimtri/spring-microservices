package com.spring.cloudmicroservices.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    private DepartmentDTO departmentDTO;
    private UserDTO userDTO;
}
