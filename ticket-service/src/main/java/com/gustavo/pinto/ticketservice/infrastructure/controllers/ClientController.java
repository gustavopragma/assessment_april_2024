package com.gustavo.pinto.ticketservice.infrastructure.controllers;

import com.gustavo.pinto.ticketservice.application.dtos.ClientResponseDTO;
import com.gustavo.pinto.ticketservice.application.dtos.CreateClientDTO;
import com.gustavo.pinto.ticketservice.application.dtos.CreateClientResponseDTO;
import com.gustavo.pinto.ticketservice.application.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateClientResponseDTO createClient(@RequestBody CreateClientDTO createClientDTO) {
        return clientService.createClient(createClientDTO);
    }

    @GetMapping("/{clientId}")
    public ClientResponseDTO getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }
}
