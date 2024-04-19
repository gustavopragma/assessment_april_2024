package com.gustavo.pinto.authservice.application.mappers;

import com.gustavo.pinto.authservice.application.dtos.CreateUserRequestDTO;
import com.gustavo.pinto.authservice.domain.models.User;
import org.springframework.stereotype.Component;

@Component
public class CreateRequestDTOMapper {
    public User toEntity(CreateUserRequestDTO createUserRequestDTO){
        User user = new User();
        user.setEmail(createUserRequestDTO.getEmail());
        user.setFirstName(createUserRequestDTO.getFirstName());
        user.setLastName(createUserRequestDTO.getLastName());
        user.setAge(createUserRequestDTO.getAge());
        user.setUsername(createUserRequestDTO.getUsername());
        user.setPassword(createUserRequestDTO.getPassword());
        return user;
    }
}
