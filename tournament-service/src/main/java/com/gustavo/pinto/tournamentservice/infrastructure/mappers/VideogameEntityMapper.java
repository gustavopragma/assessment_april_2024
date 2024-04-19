package com.gustavo.pinto.tournamentservice.infrastructure.mappers;

import com.gustavo.pinto.tournamentservice.domain.models.Videogame;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.VideogameEntity;

public class VideogameEntityMapper {
    public static Videogame toModel(VideogameEntity videogameEntity) {
        Videogame videogame = new Videogame();
        videogame.setId(videogameEntity.getId());
        videogame.setName(videogameEntity.getName());
        videogame.setNumberPlayers(videogameEntity.getNumberPlayers());
        videogame.setActivate(videogameEntity.getIsActivate());
        return videogame;
    }

    public static VideogameEntity toEntity(Videogame videogame) {
        return VideogameEntity.builder()
                .id(videogame.getId())
                .name(videogame.getName())
                .numberPlayers(videogame.getNumberPlayers())
                .isActivate(videogame.getActivate())
                .build();
    }
}
