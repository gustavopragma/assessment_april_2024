package com.gustavo.pinto.ticketservice.infrastructure.mappers;

import com.gustavo.pinto.ticketservice.domain.models.Client;
import com.gustavo.pinto.ticketservice.infrastructure.entities.ClientEntity;

public class ClientEntityMapper {
    public static Client toModel(ClientEntity clientEntity) {
        Client client = new Client();
        client.setDocumentNumber(clientEntity.getDocumentNumber());
        client.setName(clientEntity.getName());
        client.setEmail(clientEntity.getEmail());
        client.setActivate(clientEntity.getIsActivate());
        return client;
    }

    public static ClientEntity toEntity(Client client) {
        return ClientEntity.builder()
                .name(client.getName())
                .documentNumber(client.getDocumentNumber())
                .email(client.getEmail())
                .isActivate(client.getActivate())
                .build();
    }
}
