package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.CreateClientDTO;
import com.gustavo.pinto.ticketservice.domain.models.Client;

public class ClientData {
    public static CreateClientDTO createClientDTO = CreateClientDTO.builder()
            .documentNumber("123")
            .email("tavo@email.com")
            .name("Gustavo")
            .build();

    public static Client createClient() {
        Client client = new Client();
        client.setDocumentNumber("123");
        client.setEmail("tavo@email.com");
        client.setName("Gustavo");
        return client;
    }
}
