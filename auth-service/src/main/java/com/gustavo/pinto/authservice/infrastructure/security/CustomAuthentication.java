package com.gustavo.pinto.authservice.infrastructure.security;

import com.gustavo.pinto.authservice.domain.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class CustomAuthentication implements Authentication {
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> roles;

    public CustomAuthentication(String username, String password, Collection<? extends GrantedAuthority> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static CustomAuthentication unauthenticated(String username, String password) {
        return new CustomAuthentication(username, password, null);
    }

    public static CustomAuthentication authenticated(String username, Collection<? extends GrantedAuthority> roles) {
        return new CustomAuthentication(username, null, roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == null) return List.of();
        return roles;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public boolean isAuthenticated() {
        return password == null;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("Invalid operation");
    }

    @Override
    public String getName() {
        return username;
    }
}
