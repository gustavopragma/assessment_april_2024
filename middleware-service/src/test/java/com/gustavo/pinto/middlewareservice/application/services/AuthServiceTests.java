package com.gustavo.pinto.middlewareservice.application.services;

import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;
import com.gustavo.pinto.middlewareservice.domain.repositories.AuthRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTests {
    @Mock
    private AuthRepository authRepository;
    @InjectMocks
    private AuthService authService;

    @Test
    public void testLoginSuccessfully() {
        //Given
        Mockito.when(authRepository.login(Mockito.any(LoginDTO.class))).thenReturn(AuthData.createTokenDTO());
        //When
        authService.login(AuthData.loginRequestDTO);
        //Then
        Mockito.verify(authRepository, Mockito.times(1)).login(Mockito.any(LoginDTO.class));
    }

    @Test
    public void testRegisterSuccessfully() {
        //When
        authService.register(AuthData.registerRequestDTO);
        //Then
        Mockito.verify(authRepository, Mockito.times(1)).register(Mockito.any(RegisterDTO.class));
    }
}
