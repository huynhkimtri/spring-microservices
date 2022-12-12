package com.spring.cloudmicroservices.userservice.service.impl;

import com.spring.cloudmicroservices.userservice.dto.DepartmentDTO;
import com.spring.cloudmicroservices.userservice.dto.ResponseDTO;
import com.spring.cloudmicroservices.userservice.dto.UserDTO;
import com.spring.cloudmicroservices.userservice.entity.User;
import com.spring.cloudmicroservices.userservice.repository.UserRepository;
import com.spring.cloudmicroservices.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;
    private WebClient webClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDTO getUserById(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findById(id).orElse(new User());
        DepartmentDTO departmentDTO = getDepartmentDTOUsingRestTemplate(user.getDepartmentId());
        responseDTO.setUserDTO(mapToUser(user));
        responseDTO.setDepartmentDTO(departmentDTO);
        return responseDTO;
    }

    private UserDTO mapToUser(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    /**
     * Make a REST API call to department-service
     *
     * @param id department id
     * @return DepartmentDTO
     */
    private DepartmentDTO getDepartmentDTOUsingRestTemplate(Long id) {
        ResponseEntity<DepartmentDTO> responseEntity =
                restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + id, DepartmentDTO.class);
        System.out.println(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    /**
     * Make a REST API call to department-service
     * @param id department id
     * @return DepartmentDTO
     */
    private DepartmentDTO getDepartmentDTOUsingWebClient(Long id) {
        return webClient.get()
                .uri("http://localhost:8080/api/departments/" + id)
                .retrieve()
                .bodyToMono(DepartmentDTO.class)
                .block();
    }
}
