package com.gustavo.pinto.tournamentservice.domain.exceptions;

public class BadRequestException extends RuntimeException{
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
