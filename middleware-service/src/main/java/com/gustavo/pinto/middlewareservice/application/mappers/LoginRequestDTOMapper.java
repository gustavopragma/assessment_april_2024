package com.gustavo.pinto.middlewareservice.application.mappers;

import com.gustavo.pinto.middlewareservice.application.dtos.LoginRequestDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;

public class LoginRequestDTOMapper {
    public static LoginDTO toDomainDTO(LoginRequestDTO loginRequestDTO) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername(loginRequestDTO.getUsername());
        loginDTO.setPassword(loginRequestDTO.getPassword());
        return loginDTO;
    }
}
