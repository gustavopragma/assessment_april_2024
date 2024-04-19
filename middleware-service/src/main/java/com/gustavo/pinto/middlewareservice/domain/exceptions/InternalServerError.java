package com.gustavo.pinto.middlewareservice.domain.exceptions;

public class InternalServerError extends RuntimeException {
    private final String message;

    public InternalServerError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
