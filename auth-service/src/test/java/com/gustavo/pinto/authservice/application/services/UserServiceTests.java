package com.gustavo.pinto.authservice.application.services;

import com.gustavo.pinto.authservice.domain.exceptions.BadRequestException;
import com.gustavo.pinto.authservice.domain.exceptions.InvalidCredentialsException;
import com.gustavo.pinto.authservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.authservice.domain.models.User;
import com.gustavo.pinto.authservice.domain.repositories.UserRepository;
import com.gustavo.pinto.authservice.infrastructure.utils.JWTUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private JWTUtils jwtUtils;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUserIfUsernameExists() {
        //Given
        Mockito.when(userRepository.usernameExists("tavo")).thenReturn(true);
        //When
        Assertions.assertThatThrownBy(() -> {
            userService.createUser(UserData.createUserRequestDTO);
        }).isInstanceOf(BadRequestException.class);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).usernameExists("tavo");
    }

    @Test
    public void testCreateUserIfEmailExists() {
        //Given
        Mockito.when(userRepository.usernameExists("tavo")).thenReturn(false);
        Mockito.when(userRepository.emailExists("tavo@email.com")).thenReturn(true);
        //When
        Assertions.assertThatThrownBy(() -> {
            userService.createUser(UserData.createUserRequestDTO);
        }).isInstanceOf(BadRequestException.class);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).usernameExists("tavo");
        Mockito.verify(userRepository, Mockito.times(1)).emailExists("tavo@email.com");
    }

    @Test
    public void testCreateUserSuccessfully() {
        //Given
        Mockito.when(userRepository.usernameExists("tavo")).thenReturn(false);
        Mockito.when(userRepository.emailExists("tavo@email.com")).thenReturn(false);
        Mockito.when(passwordEncoder.encode("123")).thenReturn("123");
        //When
        userService.createUser(UserData.createUserRequestDTO);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).createUser(Mockito.any(User.class));
        Mockito.verify(userRepository, Mockito.times(1)).usernameExists("tavo");
        Mockito.verify(userRepository, Mockito.times(1)).emailExists("tavo@email.com");
    }

    @Test
    public void testGetUserByUsernameIfUsernameNotExists() {
        //Given
        Mockito.when(userRepository.getUserByUsername("tavo")).thenReturn(Optional.empty());
        //When
        Assertions.assertThatThrownBy(() -> {
            userService.getUserByUsername("tavo");
        }).isInstanceOf(NotFoundException.class);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername("tavo");
    }

    @Test
    public void testGetUserByUsernameSuccessfully() {
        //Given
        Mockito.when(userRepository.getUserByUsername("tavo")).thenReturn(Optional.of(UserData.createUser()));
        //When
        userService.getUserByUsername("tavo");
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername("tavo");
    }

    @Test
    public void testLoginUserIfUserNotExists() {
        //Given
        Mockito.when(userRepository.getUserByUsername("tavo")).thenReturn(Optional.empty());
        //When
        Assertions.assertThatThrownBy(() -> {
            userService.login(UserData.loginUserDTO);
        }).isInstanceOf(NotFoundException.class);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername("tavo");
    }

    @Test
    public void testLoginUserIfPasswordIsIncorrect() {
        //Given
        Mockito.when(userRepository.getUserByUsername("tavo")).thenReturn(Optional.of(UserData.createUser()));
        Mockito.when(passwordEncoder.matches("123", "123")).thenReturn(false);
        //When
        Assertions.assertThatThrownBy(() -> {
            userService.login(UserData.loginUserDTO);
        }).isInstanceOf(InvalidCredentialsException.class);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername("tavo");
        Mockito.verify(passwordEncoder, Mockito.times(1)).matches("123", "123");
    }

    @Test
    public void testLoginUserSuccessfully() {
        //Given
        Mockito.when(userRepository.getUserByUsername("tavo")).thenReturn(Optional.of(UserData.createUser()));
        Mockito.when(passwordEncoder.matches("123", "123")).thenReturn(true);
        Mockito.when(jwtUtils.createJWT(Mockito.any(User.class))).thenReturn("tokenbase64");
        //When
        userService.login(UserData.loginUserDTO);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).getUserByUsername("tavo");
        Mockito.verify(passwordEncoder, Mockito.times(1)).matches("123", "123");
        Mockito.verify(jwtUtils, Mockito.times(1)).createJWT(Mockito.any(User.class));
    }
}
