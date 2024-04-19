package com.gustavo.pinto.ticketservice.domain.repositories;

import com.gustavo.pinto.ticketservice.domain.models.Client;

import java.util.Optional;

public interface ClientRepository {
    String createClient(Client client);
    Optional<Client> getClientById(String id);
}
