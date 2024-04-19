package com.gustavo.pinto.ticketservice.infrastructure.security;

import com.gustavo.pinto.ticketservice.infrastructure.clients.AuthFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {
    private final AuthFeignClient authFeignClient;

    public SpringSecurityConfig(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(config -> config.anyRequest().authenticated())
                .addFilterBefore(new JWTFilter(authFeignClient), AuthorizationFilter.class)
                .build();
    }
}
