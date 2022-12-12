package com.spring.cloudmicroservices.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDTO {
    private DepartmentDTO departmentDTO;
    private List<UserDTO> userDTOs;
}
