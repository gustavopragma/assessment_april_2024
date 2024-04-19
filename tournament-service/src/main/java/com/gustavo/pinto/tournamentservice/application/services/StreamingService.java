package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingResponseDTO;
import com.gustavo.pinto.tournamentservice.application.mappers.CreateStreamingDTOMapper;
import com.gustavo.pinto.tournamentservice.application.mappers.CreateTournamentDTOMapper;
import com.gustavo.pinto.tournamentservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.tournamentservice.domain.models.Streaming;
import com.gustavo.pinto.tournamentservice.domain.models.Tournament;
import com.gustavo.pinto.tournamentservice.domain.repositories.StreamingRepository;
import com.gustavo.pinto.tournamentservice.domain.repositories.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreamingService {
    private final TournamentRepository tournamentRepository;
    private final StreamingRepository streamingRepository;

    public StreamingService(TournamentRepository tournamentRepository, StreamingRepository streamingRepository) {
        this.tournamentRepository = tournamentRepository;
        this.streamingRepository = streamingRepository;
    }

    public CreateStreamingResponseDTO createStreaming(CreateStreamingDTO createStreamingDTO) {
        Optional<Tournament> optionalTournament = tournamentRepository.getTournamentById(createStreamingDTO.getTournamentId());
        if(optionalTournament.isEmpty()) throw new NotFoundException(("Tournament does not exists"));
        Streaming streaming = CreateStreamingDTOMapper.toModel(createStreamingDTO);
        streaming.setTournament(optionalTournament.get());
        String id = streamingRepository.createStreaming(streaming);
        return CreateStreamingResponseDTO.builder()
                .id(id)
                .build();
    }
}
