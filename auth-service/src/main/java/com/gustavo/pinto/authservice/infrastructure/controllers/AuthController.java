package com.gustavo.pinto.authservice.infrastructure.controllers;

import com.gustavo.pinto.authservice.application.dtos.CreateUserRequestDTO;
import com.gustavo.pinto.authservice.application.dtos.LoginUserDTO;
import com.gustavo.pinto.authservice.application.dtos.TokenResponseDTO;
import com.gustavo.pinto.authservice.application.services.UserService;
import com.gustavo.pinto.authservice.infrastructure.utils.JWTUtils;
import io.jsonwebtoken.security.PublicJwk;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@Controller
@RequestMapping("/api/v1/auth")
@ResponseBody
public class AuthController {
    private final UserService userService;
    private final JWTUtils jwtUtils;

    public AuthController(UserService userService, JWTUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO) {
        userService.createUser(createUserRequestDTO);
    }

    @GetMapping("/jwk")
    @ResponseStatus(HttpStatus.OK)
    public PublicJwk<PublicKey> getPublicJWK() {
        return jwtUtils.getPublicJWK();
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO login(@Valid @RequestBody LoginUserDTO loginUserDTO) {
        return userService.login(loginUserDTO);
    }
}
