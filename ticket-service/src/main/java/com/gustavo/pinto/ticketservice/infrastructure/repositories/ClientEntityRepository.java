package com.gustavo.pinto.ticketservice.infrastructure.repositories;

import com.gustavo.pinto.ticketservice.infrastructure.entities.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends MongoRepository<ClientEntity, String> {
}
