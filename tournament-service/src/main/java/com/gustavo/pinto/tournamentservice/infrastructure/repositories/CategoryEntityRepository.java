package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.infrastructure.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, String> {
}
