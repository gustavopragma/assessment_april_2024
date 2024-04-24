package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.infrastructure.entities.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentEntityRepository extends JpaRepository<TournamentEntity, String> {
    List<TournamentEntity> findByOwnerId(String ownerId);

    List<TournamentEntity> findByOwnerIdAndAndCategoryEntityIsFree(String ownerId,Boolean isFree);
}
