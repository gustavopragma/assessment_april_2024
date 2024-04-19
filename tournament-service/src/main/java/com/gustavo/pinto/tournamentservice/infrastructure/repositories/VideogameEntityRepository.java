package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.infrastructure.entities.VideogameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameEntityRepository extends JpaRepository<VideogameEntity, String> {
}
