package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.*;
import com.gustavo.pinto.tournamentservice.application.mappers.CreateTournamentDTOMapper;
import com.gustavo.pinto.tournamentservice.application.mappers.TournamentListResponseDTOMapper;
import com.gustavo.pinto.tournamentservice.application.mappers.TournamentResponseDTOMapper;
import com.gustavo.pinto.tournamentservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.tournamentservice.domain.models.Category;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;
import com.gustavo.pinto.tournamentservice.domain.repositories.CategoryRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.TournamentRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.VideogameRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final CategoryRepository categoryRepository;
    private final VideogameRepository videogameRepository;

    public TournamentService(TournamentRepository tournamentRepository, CategoryRepository categoryRepository, VideogameRepository videogameRepository) {
        this.tournamentRepository = tournamentRepository;
        this.categoryRepository = categoryRepository;
        this.videogameRepository = videogameRepository;
    }

    public CreateTournamentResponseDTO createTournament(CreateTournamentDTO createTournamentDTO) {
        Optional<Category> optionalCategory = categoryRepository.getCategoryById(createTournamentDTO.getCategoryId());
        if (optionalCategory.isEmpty()) throw new NotFoundException("Category does not exists");
        Optional<Videogame> optionalVideogame = videogameRepository.getVideogameById(createTournamentDTO.getVideogameId());
        if (optionalVideogame.isEmpty()) throw new NotFoundException(("Videogame does not exists"));
        Tournament tournament = CreateTournamentDTOMapper.toModel(createTournamentDTO);
        tournament.setActivate(true);
        tournament.setCreatedAt(LocalDate.now());
        tournament.setCategory(optionalCategory.get());
        tournament.setVideogame(optionalVideogame.get());
        String id = tournamentRepository.createTournament(tournament);
        return CreateTournamentResponseDTO.builder()
                .id(id)
                .build();
    }

    public TournamentResponseDTO getTournamentById(String id) {
        Optional<Tournament> optionalTournament = tournamentRepository.getTournamentById(id);
        if(optionalTournament.isEmpty()) throw new NotFoundException("Tournament does not exists");
        return TournamentResponseDTOMapper
                .toDTO(optionalTournament.get());
    }

    public List<TournamentListResponseDTO> getTournamentsByOwnerId(String ownerId) {
        return tournamentRepository
                .getTournamentsByOwnerId(ownerId)
                .stream()
                .map(TournamentListResponseDTOMapper::toDTO)
                .toList();
    }
}
