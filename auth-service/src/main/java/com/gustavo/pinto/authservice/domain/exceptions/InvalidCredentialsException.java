package com.gustavo.pinto.authservice.domain.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    private final String message;

    public InvalidCredentialsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
