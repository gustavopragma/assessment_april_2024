package com.gustavo.pinto.middlewareservice.domain.repositories;
import com.gustavo.pinto.middlewareservice.domain.dtos.LoginDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.RegisterDTO;
import com.gustavo.pinto.middlewareservice.domain.dtos.TokenDTO;

public interface AuthRepository {
    TokenDTO login(LoginDTO loginDTO);

    void register(RegisterDTO registerDTO);
}
