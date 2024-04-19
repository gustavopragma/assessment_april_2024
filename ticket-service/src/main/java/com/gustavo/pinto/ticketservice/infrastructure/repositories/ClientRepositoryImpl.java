package com.gustavo.pinto.ticketservice.infrastructure.repositories;

import com.gustavo.pinto.ticketservice.domain.models.Client;
import com.gustavo.pinto.ticketservice.domain.repositories.ClientRepository;
import com.gustavo.pinto.ticketservice.infrastructure.entities.ClientEntity;
import com.gustavo.pinto.ticketservice.infrastructure.mappers.ClientEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final ClientEntityRepository clientEntityRepository;

    public ClientRepositoryImpl(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    @Override
    public String createClient(Client client) {
        ClientEntity clientEntity = ClientEntityMapper.toEntity(client);
        clientEntityRepository.save(clientEntity);
        return clientEntity.getDocumentNumber();
    }

    @Override
    public Optional<Client> getClientById(String id) {
        return clientEntityRepository
                .findById(id)
                .map(ClientEntityMapper::toModel);
    }
}
