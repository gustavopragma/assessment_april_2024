package com.gustavo.pinto.middlewareservice.domain.dtos;

public class LoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "Username='" + username + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
