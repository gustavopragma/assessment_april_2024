package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.application.dtos.ClientResponseDTO;
import com.gustavo.pinto.ticketservice.application.dtos.CreateClientDTO;
import com.gustavo.pinto.ticketservice.application.dtos.CreateClientResponseDTO;
import com.gustavo.pinto.ticketservice.application.mappers.ClientResponseDTOMapper;
import com.gustavo.pinto.ticketservice.application.mappers.CreateClientDTOMapper;
import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.Client;
import com.gustavo.pinto.ticketservice.domain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public CreateClientResponseDTO createClient(CreateClientDTO createClientDTO) {
        Client client = CreateClientDTOMapper.toModel(createClientDTO);
        client.setActivate(true);
        String documentNumber = clientRepository.createClient(client);
        return CreateClientResponseDTO.builder()
                .documentNumber(documentNumber)
                .build();
    }

    public ClientResponseDTO getClientById(String id) {
        Optional<Client> optionalClient = clientRepository.getClientById(id);
        if(optionalClient.isEmpty()) throw new NotFoundException("Client not found");
        return ClientResponseDTOMapper.toDTO(optionalClient.get());
    }
}
