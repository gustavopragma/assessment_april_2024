package com.gustavo.pinto.middlewareservice.application.services;

import com.gustavo.pinto.middlewareservice.application.dtos.LoginRequestDTO;
import com.gustavo.pinto.middlewareservice.application.dtos.RegisterRequestDTO;
import com.gustavo.pinto.middlewareservice.application.dtos.TokenResponseDTO;
import com.gustavo.pinto.middlewareservice.application.mappers.LoginRequestDTOMapper;
import com.gustavo.pinto.middlewareservice.application.mappers.RegisterRequestDTOMapper;
import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.TokenDTO;
import com.gustavo.pinto.middlewareservice.domain.repositories.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    public TokenResponseDTO login(LoginRequestDTO loginRequestDTO) {
        LoginDTO loginDTO = LoginRequestDTOMapper.toDomainDTO(loginRequestDTO);
        TokenDTO tokenDTO = authRepository.login(loginDTO);
        return TokenResponseDTO.builder()
                .token(tokenDTO.getToken())
                .build();
    }

    public void register(RegisterRequestDTO registerRequestDTO) {
        RegisterDTO registerDTO = RegisterRequestDTOMapper.toDomainDTO(registerRequestDTO);
        authRepository.register(registerDTO);
    }
}
