package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.CreateClientDTO;
import com.gustavo.pinto.ticketservice.domain.models.Client;

public class CreateClientDTOMapper {
    public static Client toModel(CreateClientDTO createClientDTO) {
        Client client = new Client();
        client.setDocumentNumber(createClientDTO.getDocumentNumber());
        client.setEmail(createClientDTO.getEmail());
        client.setName(createClientDTO.getName());
        return client;
    }
}
