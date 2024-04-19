package com.gustavo.pinto.middlewareservice.infrastructure.repositories;
import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.TokenDTO;
import com.gustavo.pinto.middlewareservice.domain.repositories.AuthRepository;
import com.gustavo.pinto.middlewareservice.infrastructure.clients.AuthFeignClient;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private final AuthFeignClient authFeignClient;

    public AuthRepositoryImpl(AuthFeignClient authFeignClient) {
        this.authFeignClient = authFeignClient;
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return authFeignClient.login(loginDTO);
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        authFeignClient.register(registerDTO);
    }
}
