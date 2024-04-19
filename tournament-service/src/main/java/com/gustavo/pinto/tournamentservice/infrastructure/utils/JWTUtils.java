package com.gustavo.pinto.tournamentservice.infrastructure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavo.pinto.tournamentservice.infrastructure.dtos.JwkDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Jwks;

import java.security.PublicKey;

public class JWTUtils {
    public static PublicKey getJwkPublicKey(JwkDTO jwkDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jwk = objectMapper.writeValueAsString(jwkDTO);
        return (PublicKey) Jwks.parser().build().parse(jwk).toKey();
    }

    public static Claims validateJWT(String jwt, PublicKey publicKey) {
        return Jwts
                .parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
