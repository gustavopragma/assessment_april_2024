package com.gustavo.pinto.authservice.application.services;

import com.gustavo.pinto.authservice.application.dtos.CreateUserRequestDTO;
import com.gustavo.pinto.authservice.application.dtos.LoginUserDTO;
import com.gustavo.pinto.authservice.domain.models.User;

public class UserData {
    public static CreateUserRequestDTO createUserRequestDTO = CreateUserRequestDTO.builder()
            .username("tavo")
            .password("123")
            .email("tavo@email.com")
            .firstName("gustavo")
            .lastName("pinto")
            .age(20)
            .build();

    public static LoginUserDTO loginUserDTO = LoginUserDTO.builder()
            .username("tavo")
            .password("123")
            .build();

    public static User createUser() {
        User user = new User();
        user.setUsername("tavo");
        user.setPassword("123");
        user.setEmail("tavo@email.com");
        user.setFirstName("Gustavo");
        user.setLastName("Pinto");
        user.setAge(20);
        return user;
    }
}
