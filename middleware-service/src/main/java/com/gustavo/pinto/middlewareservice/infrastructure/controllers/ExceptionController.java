package com.gustavo.pinto.middlewareservice.infrastructure.controllers;

import com.gustavo.pinto.middlewareservice.domain.exceptions.BadRequestException;
import com.gustavo.pinto.middlewareservice.domain.exceptions.InternalServerError;
import com.gustavo.pinto.middlewareservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.middlewareservice.infrastructure.dtos.ErrorInfoDTO;
import com.gustavo.pinto.middlewareservice.infrastructure.dtos.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponseDTO handleBadRequestException(BadRequestException ex, HttpServletRequest httpServletRequest) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("404")
                .build();
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.builder()
                .message(ex.getMessage())
                .build();
        errorResponseDTO.setErrors(List.of(errorInfoDTO));
        return errorResponseDTO;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError.class)
    public ErrorResponseDTO handleInternalServerError(InternalServerError ex, HttpServletRequest httpServletRequest) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("500")
                .build();
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.builder()
                .message(ex.getMessage())
                .build();
        errorResponseDTO.setErrors(List.of(errorInfoDTO));
        return errorResponseDTO;
    }
}
