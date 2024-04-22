package com.gustavo.pinto.ticketservice.application.mappers;

import com.gustavo.pinto.ticketservice.application.dtos.ClientResponseDTO;
import com.gustavo.pinto.ticketservice.domain.models.Client;

public class ClientResponseDTOMapper {
    public static ClientResponseDTO toDTO(Client client) {
        return ClientResponseDTO.builder()
                .documentNumber(client.getDocumentNumber())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }
}
