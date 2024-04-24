package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateTournamentDTO;
import com.gustavo.pinto.tournamentservice.domain.exceptions.BadRequestException;
import com.gustavo.pinto.tournamentservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.domain.repositories.CategoryRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.TournamentRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class TournamentServiceTests {
    @Mock
    private TournamentRepository tournamentRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private VideogameRepository videogameRepository;
    @InjectMocks
    private TournamentService tournamentService;

    @Test
    public void testCreateTournamentIfCategoryNotExists() {
        //Given
        Mockito.when(categoryRepository.getCategoryById("1")).thenReturn(Optional.empty());
        CreateTournamentDTO createTournamentDTO = TournamentData.createTournamentDTO;
        //Then
        assertThatThrownBy(() -> {
            tournamentService.createTournament(createTournamentDTO);
        }).isInstanceOf(NotFoundException.class);
        Mockito.verify(categoryRepository, Mockito.times(1)).getCategoryById("1");
        Mockito.verify(videogameRepository, Mockito.times(0)).getVideogameById("1");
    }

    @Test
    public void testCreateTournamentIfVideogameNotExists() {
        //Given
        Mockito.when(categoryRepository.getCategoryById("1")).thenReturn(Optional.of(CategoryData.createCategory()));
        Mockito.when(videogameRepository.getVideogameById("1")).thenReturn(Optional.empty())
;        CreateTournamentDTO createTournamentDTO = TournamentData.createTournamentDTO;
        //Then
        assertThatThrownBy(() -> {
            tournamentService.createTournament(createTournamentDTO);
        }).isInstanceOf(NotFoundException.class);
        Mockito.verify(categoryRepository, Mockito.times(1)).getCategoryById("1");
        Mockito.verify(videogameRepository, Mockito.times(1)).getVideogameById("1");
    }

    @Test
    public void testCreateTournamentIfFreeExceed() {
        //Given
        Mockito.when(categoryRepository.getCategoryById("1")).thenReturn(Optional.of(CategoryData.createCategory()));
        Mockito.when(videogameRepository.getVideogameById("1")).thenReturn(Optional.of(VideogameData.createVideogame()));
        Mockito.when(tournamentRepository.getTotalFreeTournaments("123")).thenReturn(2);
        //Then
        assertThatThrownBy(() -> {
            tournamentService.createTournament(TournamentData.createTournamentDTO);
        }).isInstanceOf(BadRequestException.class);
        Mockito.verify(categoryRepository, Mockito.times(1)).getCategoryById("1");
        Mockito.verify(videogameRepository, Mockito.times(1)).getVideogameById("1");
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTotalFreeTournaments("123");
    }

    @Test
    public void testCreateTournamentSuccessfully() {
        //Given
        Mockito.when(categoryRepository.getCategoryById("1")).thenReturn(Optional.of(CategoryData.createCategory()));
        Mockito.when(videogameRepository.getVideogameById("1")).thenReturn(Optional.of(VideogameData.createVideogame()));
        Mockito.when(tournamentRepository.getTotalFreeTournaments("123")).thenReturn(0);
        //When
        tournamentService.createTournament(TournamentData.createTournamentDTO);
        //Then
        Mockito.verify(categoryRepository, Mockito.times(1)).getCategoryById("1");
        Mockito.verify(videogameRepository, Mockito.times(1)).getVideogameById("1");
        Mockito.verify(tournamentRepository, Mockito.times(1)).createTournament(Mockito.any(Tournament.class));
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTotalFreeTournaments("123");
    }

    @Test
    public void testGetTournamentByIdIfTournamentNotExists() {
        //Given
        Mockito.when(tournamentRepository.getTournamentById("1")).thenReturn(Optional.empty());
        //Then
        assertThatThrownBy(() -> {
            tournamentService.getTournamentById("1");
        }).isInstanceOf(NotFoundException.class);
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTournamentById("1");
    }

    @Test
    public void testGetTournamentByIdSuccessfully() {
        //Given
        Mockito.when(tournamentRepository.getTournamentById("1")).thenReturn(Optional.of(TournamentData.createTournament()));
        //When
        tournamentService.getTournamentById("1");
        //Then
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTournamentById("1");
    }
}
