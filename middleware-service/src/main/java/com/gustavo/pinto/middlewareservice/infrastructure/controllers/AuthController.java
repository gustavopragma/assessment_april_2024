package com.gustavo.pinto.middlewareservice.infrastructure.controllers;

import com.gustavo.pinto.middlewareservice.application.dtos.LoginRequestDTO;
import com.gustavo.pinto.middlewareservice.application.dtos.RegisterRequestDTO;
import com.gustavo.pinto.middlewareservice.application.dtos.TokenResponseDTO;
import com.gustavo.pinto.middlewareservice.application.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        authService.register(registerRequestDTO);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO);
    }
}
