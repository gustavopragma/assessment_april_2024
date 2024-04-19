package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.VideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.application.mappers.CreateVideogameDTOMapper;
import com.gustavo.pinto.tournamentservice.application.mappers.VideogameResponseDTOMapper;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;
import com.gustavo.pinto.tournamentservice.domain.repositories.VideogameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService {
    private final VideogameRepository videogameRepository;

    public VideogameService(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public List<VideogameResponseDTO> getAllVideogames() {
        return videogameRepository
                .getAllVideogames()
                .stream()
                .map(VideogameResponseDTOMapper::toDTO)
                .toList();
    }

    public CreateVideogameResponseDTO createVideogame(CreateVideogameDTO createVideogameDTO) {
        Videogame videogame = CreateVideogameDTOMapper.toModel(createVideogameDTO);
        videogame.setActivate(true);
        String id = videogameRepository.createVideogame(videogame);
        return CreateVideogameResponseDTO.builder()
                .id(id)
                .build();
    }
}
