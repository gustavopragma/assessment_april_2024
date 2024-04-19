package com.gustavo.pinto.authservice.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"user\"")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(
            unique = true
    )
    private String username;
    @Column(
            unique = true
    )
    private String password;
    @Column(
            unique = true
    )
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean isActivate;
}
