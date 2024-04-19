package com.gustavo.pinto.tournamentservice.infrastructure.clients;

import com.gustavo.pinto.tournamentservice.infrastructure.dtos.JwkDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AUTH-CLIENT", url = "${services.auth.url}")
public interface AuthFeignClient {
    @GetMapping(value = "/jwk", consumes = MediaType.APPLICATION_JSON_VALUE)
    JwkDTO getJwk();
}
