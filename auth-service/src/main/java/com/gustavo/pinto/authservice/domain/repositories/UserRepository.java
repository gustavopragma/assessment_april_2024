package com.gustavo.pinto.authservice.domain.repositories;

import com.gustavo.pinto.authservice.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByUsername(String username);
    void createUser(User user);

    Boolean usernameExists(String username);
    Boolean emailExists(String email);
}
