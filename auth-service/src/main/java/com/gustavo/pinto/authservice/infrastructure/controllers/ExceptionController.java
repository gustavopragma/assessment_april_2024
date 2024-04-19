package com.gustavo.pinto.authservice.infrastructure.controllers;

import com.gustavo.pinto.authservice.domain.exceptions.InvalidCredentialsException;
import com.gustavo.pinto.authservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.authservice.infrastructure.dtos.ErrorInfoDTO;
import com.gustavo.pinto.authservice.infrastructure.dtos.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@ResponseBody
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

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidCredentialsException.class)
    public ErrorResponseDTO handleInvalidCredentialsException(InvalidCredentialsException ex, HttpServletRequest httpServletRequest) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("401")
                .build();
        ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.builder()
                .message("Invalid credentials")
                .build();
        errorResponseDTO.setErrors(List.of(errorInfoDTO));
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
