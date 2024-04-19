package com.gustavo.pinto.middlewareservice.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDTO {
    @NotBlank(message = "Username is required")
    @JsonProperty("Username")
    private String username;
    @NotBlank(message = "Password is required")
    @JsonProperty("Password")
    private String password;
    @NotBlank(message = "email is required")
    @JsonProperty("Email")
    private String email;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Age")
    private Integer age;
}
