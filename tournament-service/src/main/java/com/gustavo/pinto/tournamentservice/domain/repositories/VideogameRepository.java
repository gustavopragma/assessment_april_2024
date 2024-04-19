package com.gustavo.pinto.tournamentservice.domain.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Videogame;

import java.util.List;
import java.util.Optional;

public interface VideogameRepository {
    String createVideogame(Videogame videogame);
    List<Videogame> getAllVideogames();
    Optional<Videogame> getVideogameById(String id);
}
