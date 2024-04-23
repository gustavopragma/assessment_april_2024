package com.gustavo.pinto.middlewareservice.application.services;

import com.gustavo.pinto.middlewareservice.application.dtos.LoginRequestDTO;
import com.gustavo.pinto.middlewareservice.application.dtos.RegisterRequestDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.TokenDTO;

public class AuthData {
    public static LoginRequestDTO loginRequestDTO = LoginRequestDTO.builder()
            .username("tavo")
            .password("123456")
            .build();

    public static RegisterRequestDTO registerRequestDTO = RegisterRequestDTO.builder()
            .username("tavo")
            .password("123456")
            .email("tavo@email.com")
            .firstName("Gustavo")
            .lastName("Pinto")
            .age(20)
            .build();

    public static TokenDTO createTokenDTO() {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken("tokenbase64");
        return tokenDTO;
    }
}
