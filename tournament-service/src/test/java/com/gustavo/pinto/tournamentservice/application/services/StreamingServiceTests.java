package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.domain.exceptions.BadRequestException;
import com.gustavo.pinto.tournamentservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.tournamentservice.domain.models.Streaming;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.domain.repositories.StreamingRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.TournamentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StreamingServiceTests {
    @Mock
    private StreamingRepository streamingRepository;
    @Mock
    private TournamentRepository tournamentRepository;
    @InjectMocks
    private StreamingService streamingService;

    @Test
    public void testCreateStreamingIfTournamentNotExists() {
        //Given
        Mockito.when(tournamentRepository.getTournamentById("1")).thenReturn(Optional.empty());
        //Then
        assertThatThrownBy(() -> {
            streamingService.createStreaming(StreamingData.createStreamingDTO);
        }).isInstanceOf(NotFoundException.class);
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTournamentById("1");
    }

    @Test
    public void testCreateStreamingIfStreamingsExceed() {
        //Given
        Tournament tournament = TournamentData.createTournament();
        tournament.getCategory().setStreamingLimit(1);
        Mockito.when(tournamentRepository.getTournamentById("1")).thenReturn(Optional.of(tournament));
        //Then
        assertThatThrownBy(() -> {
            streamingService.createStreaming(StreamingData.createStreamingDTO);
        }).isInstanceOf(BadRequestException.class);
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTournamentById("1");
    }

    @Test
    public void testCreateStreamingSuccessfully() {
        //Given
        Mockito.when(tournamentRepository.getTournamentById("1")).thenReturn(Optional.of(TournamentData.createTournament()));
        //When
        streamingService.createStreaming(StreamingData.createStreamingDTO);
        //Then
        Mockito.verify(tournamentRepository, Mockito.times(1)).getTournamentById("1");
        Mockito.verify(streamingRepository, Mockito.times(1)).createStreaming(Mockito.any(Streaming.class));
    }
}
