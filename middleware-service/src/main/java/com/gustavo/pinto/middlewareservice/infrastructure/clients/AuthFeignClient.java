package com.gustavo.pinto.middlewareservice.infrastructure.clients;

import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.TokenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-CLIENT", url = "${services.auth.url}")
public interface AuthFeignClient {
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    TokenDTO login(@RequestBody LoginDTO loginDTO);

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    void register(@RequestBody RegisterDTO registerDTO);
}