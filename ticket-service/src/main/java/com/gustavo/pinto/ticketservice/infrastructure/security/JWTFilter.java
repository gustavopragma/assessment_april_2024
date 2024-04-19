package com.gustavo.pinto.ticketservice.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavo.pinto.ticketservice.infrastructure.clients.AuthFeignClient;
import com.gustavo.pinto.ticketservice.infrastructure.dtos.ErrorInfoDTO;
import com.gustavo.pinto.ticketservice.infrastructure.dtos.ErrorResponseDTO;
import com.gustavo.pinto.ticketservice.infrastructure.dtos.JwkDTO;
import com.gustavo.pinto.ticketservice.infrastructure.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

public class JWTFilter extends OncePerRequestFilter {
    private final AuthFeignClient authFeignClient;

    public JWTFilter(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = authHeader.substring(7);
        ObjectMapper objectMapper = new ObjectMapper();
        JwkDTO jwkDTO = authFeignClient.getJwk();
        PublicKey publicKey = JWTUtils.getJwkPublicKey(jwkDTO);

        try {
            Claims claims = JWTUtils.validateJWT(token, publicKey);
            CustomAuthentication customAuthentication = new CustomAuthentication(
                    claims.getSubject(),
                    (String) claims.get("username")
            );
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(customAuthentication);
            SecurityContextHolder.setContext(securityContext);
            filterChain.doFilter(request, response);
        } catch(JwtException ex) {
            ErrorInfoDTO errorInfoDTO = ErrorInfoDTO.builder()
                    .message("Invalid JWT")
                    .build();
            ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                    .statusCode("401")
                    .errors(List.of(errorInfoDTO))
                    .build();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response
                    .getWriter()
                    .print(objectMapper.writeValueAsString(errorResponseDTO));
        }
    }
}
