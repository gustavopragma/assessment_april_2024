package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Videogame;
import com.gustavo.pinto.tournamentservice.domain.repositories.VideogameRepository;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.VideogameEntity;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.VideogameEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VideogameRepositoryImpl implements VideogameRepository {
    private final VideogameEntityRepository videogameEntityRepository;

    public VideogameRepositoryImpl(VideogameEntityRepository videogameEntityRepository) {
        this.videogameEntityRepository = videogameEntityRepository;
    }

    @Override
    public String createVideogame(Videogame videogame) {
        VideogameEntity videogameEntity = VideogameEntityMapper.toEntity(videogame);
        videogameEntityRepository.save(videogameEntity);
        return videogameEntity.getId();
    }

    @Override
    public List<Videogame> getAllVideogames() {
        return videogameEntityRepository
                .findAll()
                .stream()
                .map(VideogameEntityMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Videogame> getVideogameById(String id) {
        return videogameEntityRepository
                .findById(id)
                .map(VideogameEntityMapper::toModel);
    }
}
