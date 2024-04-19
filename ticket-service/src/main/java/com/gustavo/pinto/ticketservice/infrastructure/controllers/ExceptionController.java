package com.gustavo.pinto.ticketservice.infrastructure.controllers;

import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.infrastructure.dtos.ErrorInfoDTO;
import com.gustavo.pinto.ticketservice.infrastructure.dtos.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDTO handleValidationExceptions(
            MethodArgumentNotValidException ex, HttpServletRequest httpServletRequest) {
        ArrayList<ErrorInfoDTO> errors = new ArrayList<>();
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("400")
                .build();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(new ErrorInfoDTO(error.getDefaultMessage()));
        });
        errorResponseDTO.setErrors(errors);
        return errorResponseDTO;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponseDTO handleUserNotFoundException(NotFoundException ex, HttpServletRequest httpServletRequest) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("404")
                .build();
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.builder()
                .message(ex.getMessage())
                .build();
        errorResponseDTO.setErrors(List.of(errorInfoDTO));
        return errorResponseDTO;
    }
}
