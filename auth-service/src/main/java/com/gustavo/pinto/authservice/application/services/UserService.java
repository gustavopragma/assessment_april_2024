package com.gustavo.pinto.authservice.application.services;

import com.gustavo.pinto.authservice.application.dtos.CreateUserRequestDTO;
import com.gustavo.pinto.authservice.application.dtos.LoginUserDTO;
import com.gustavo.pinto.authservice.application.dtos.TokenResponseDTO;
import com.gustavo.pinto.authservice.application.mappers.CreateRequestDTOMapper;
import com.gustavo.pinto.authservice.domain.exceptions.InvalidCredentialsException;
import com.gustavo.pinto.authservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.authservice.domain.models.User;
import com.gustavo.pinto.authservice.domain.repositories.UserRepository;
import com.gustavo.pinto.authservice.infrastructure.utils.JWTUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final JWTUtils jwtUtils;
    private final UserRepository userRepository;
    private final CreateRequestDTOMapper createRequestDTOMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(JWTUtils jwtUtils, UserRepository userRepository, CreateRequestDTOMapper createRequestDTOMapper, PasswordEncoder passwordEncoder) {
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.createRequestDTOMapper = createRequestDTOMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(CreateUserRequestDTO createUserRequestDTO) {
        User newUser = createRequestDTOMapper.toEntity(createUserRequestDTO);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setIsActivate(true);
        userRepository.createUser(newUser);
    }

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        if(optionalUser.isEmpty()) throw new NotFoundException("User not found");
        return optionalUser.get();
    }

    public TokenResponseDTO login(LoginUserDTO loginUserDTO) {
        User user = getUserByUsername(loginUserDTO.getUsername());
        if(!passwordEncoder.matches(loginUserDTO.getPassword(), user.getPassword())) throw new InvalidCredentialsException();
        String token = jwtUtils.createJWT(user);
        return TokenResponseDTO.builder()
                .token(token)
                .build();
    }
}
