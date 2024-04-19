package com.gustavo.pinto.authservice.infrastructure.utils;

import com.gustavo.pinto.authservice.domain.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.PublicJwk;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;

@Component
public class JWTUtils {
    private final String kid = "123456";
    private final Integer expirationMinutes = 60;
    private final KeyPair keyPair = Jwts.SIG.RS256.keyPair().build();

    public String createJWT(User user) {
        Date issueDate = new Date();
        return Jwts.builder()
                .header()
                .keyId(kid)
                .and()
                .subject(user.getId())
                .claim("username", user.getUsername())
                .issuedAt(issueDate)
                .expiration(new Date(issueDate.getTime() + (expirationMinutes * 60000)))
                .claims(new HashMap<>())
                .signWith(keyPair.getPrivate())
                .compact();
    }

    public Claims verifyJWT(String jwt) {
        JwtParser jwtParser = Jwts.parser().verifyWith(keyPair.getPublic()).build();
        return jwtParser.parseSignedClaims(jwt).getPayload();
    }

    public PublicJwk<PublicKey> getPublicJWK() {
        return Jwks.builder()
                .add("kid", kid)
                .key(keyPair.getPublic())
                .build();
    }
}
