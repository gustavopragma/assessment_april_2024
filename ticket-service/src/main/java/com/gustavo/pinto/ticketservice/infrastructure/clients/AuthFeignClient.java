package com.gustavo.pinto.ticketservice.infrastructure.clients;

import com.gustavo.pinto.ticketservice.infrastructure.dtos.JwkDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AUTH-CLIENT", url = "${services.auth.url}")
public interface AuthFeignClient {
    @GetMapping(value = "/jwk", consumes = MediaType.APPLICATION_JSON_VALUE)
    JwkDTO getJwk();
}
