package com.gustavo.pinto.middlewareservice;

import com.gustavo.pinto.middlewareservice.application.services.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class MiddlewareServiceApplication {
	private final AuthService authService;

    public MiddlewareServiceApplication(AuthService authService) {
        this.authService = authService;
    }

    public static void main(String[] args) {
		SpringApplication.run(MiddlewareServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
/*			LoginDTO loginDTO = LoginDTO.builder()
					.Password("12345")
					.Username("12345")
					.build();

			authService.login(loginDTO);*/
		};
	}

}
