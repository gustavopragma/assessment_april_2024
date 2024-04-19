package com.gustavo.pinto.authservice;

import com.gustavo.pinto.authservice.infrastructure.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class AuthServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}
