package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.infrastructure.entities.StreamingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingEntityRepository extends JpaRepository<StreamingEntity, String> {
}
