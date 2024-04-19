package com.gustavo.pinto.middlewareservice.application.mappers;

import com.gustavo.pinto.middlewareservice.application.dtos.RegisterRequestDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;

public class RegisterRequestDTOMapper {
    public static RegisterDTO toDomainDTO(RegisterRequestDTO registerRequestDTO) {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setUsername(registerRequestDTO.getUsername());
        registerDTO.setPassword(registerRequestDTO.getPassword());
        registerDTO.setEmail(registerRequestDTO.getEmail());
        registerDTO.setFirstName(registerRequestDTO.getFirstName());
        registerDTO.setLastName(registerRequestDTO.getLastName());
        registerDTO.setAge(registerRequestDTO.getAge());
        return registerDTO;
    }
}
