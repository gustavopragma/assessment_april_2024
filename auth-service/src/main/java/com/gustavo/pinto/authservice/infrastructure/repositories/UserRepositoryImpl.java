package com.gustavo.pinto.authservice.infrastructure.repositories;

import com.gustavo.pinto.authservice.domain.models.User;
import com.gustavo.pinto.authservice.domain.repositories.UserRepository;
import com.gustavo.pinto.authservice.infrastructure.entities.UserEntity;
import com.gustavo.pinto.authservice.infrastructure.mappers.UserEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserEntityRepository userEntityRepository;

    public UserRepositoryImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userEntityRepository.findByUsername(username).map(UserEntityMapper::toModel);
    }

    @Override
    public void createUser(User user) {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        userEntityRepository.save(userEntity);
    }

    @Override
    public Boolean usernameExists(String username) {
        return userEntityRepository.existsByUsername(username);
    }

    @Override
    public Boolean emailExists(String email) {
        return userEntityRepository.existsByEmail(email);
    }
}
