package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.StreamingResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Streaming;

public class StreamingResponseDTOMapper {
    public static StreamingResponseDTO toDTO(Streaming streaming) {
        return StreamingResponseDTO.builder()
                .id(streaming.getId())
                .url(streaming.getUrl())
                .platform(streaming.getPlatform())
                .build();
    }
}
