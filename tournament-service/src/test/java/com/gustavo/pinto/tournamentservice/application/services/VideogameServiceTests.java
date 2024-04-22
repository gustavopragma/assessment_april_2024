package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateVideogameResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Videogame;
import com.gustavo.pinto.tournamentservice.domain.repositories.VideogameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class VideogameServiceTests {
    @Mock
    private VideogameRepository videogameRepository;
    @InjectMocks
    private VideogameService videogameService;

    @Test
    public void testCreateVideogameSuccessfully() {
        //Given
        Mockito.when(videogameRepository.createVideogame(Mockito.any(Videogame.class))).thenReturn("1234567");

        //Whenn
        CreateVideogameResponseDTO createVideogameResponseDTO = videogameService.createVideogame(
                VideogameData.createVideogameDTO
        );

        //Then
        assertThat(createVideogameResponseDTO.getId(), equalTo("1234567"));
        Mockito
                .verify(videogameRepository, Mockito.times(1))
                .createVideogame(Mockito.any(Videogame.class));
    }

    @Test
    public void testGetAllVideogamesSuccessfully() {
        //Given
        Mockito.when(videogameRepository.getAllVideogames()).thenReturn(List.of());

        //When
        videogameService.getAllVideogames();

        //Then
        Mockito.verify(videogameRepository, Mockito.times(1)).getAllVideogames();
    }
}
