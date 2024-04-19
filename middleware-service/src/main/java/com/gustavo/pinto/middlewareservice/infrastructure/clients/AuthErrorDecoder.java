package com.gustavo.pinto.middlewareservice.infrastructure.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gustavo.pinto.middlewareservice.domain.exceptions.InternalServerError;
import com.gustavo.pinto.middlewareservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.middlewareservice.infrastructure.dtos.ErrorResponseDTO;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class AuthErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        try {
            InputStream inputStream = response.body().asInputStream();
            ErrorResponseDTO errorResponse = objectMapper.readValue(inputStream, ErrorResponseDTO.class);

            if(response.status() == 404) {
                throw new NotFoundException(errorResponse.getErrors().get(0).getMessage());
            }

            throw new InternalServerError("Server error");
        } catch(IOException ex) {
            throw new InternalServerError(ex.getMessage());
        }

    }
}
