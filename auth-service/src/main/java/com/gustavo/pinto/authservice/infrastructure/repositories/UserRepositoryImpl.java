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
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryImpl(UserEntityRepository userEntityRepository, UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userEntityRepository.findByUsername(username).map(userEntityMapper::toModel);
    }

    @Override
    public void createUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntityRepository.save(userEntity);
    }
}
