package com.gustavo.pinto.authservice.infrastructure.mappers;

import com.gustavo.pinto.authservice.domain.models.User;
import com.gustavo.pinto.authservice.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .isActivate(user.getIsActivate())
                .build();
    }

    public User toModel(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setAge(userEntity.getAge());
        user.setIsActivate(userEntity.getIsActivate());
        return user;
    }
}
