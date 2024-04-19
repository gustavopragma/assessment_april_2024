package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Streaming;

public class CreateStreamingDTOMapper {
    public static Streaming toModel(CreateStreamingDTO createStreamingDTO) {
        Streaming streaming = new Streaming();
        streaming.setPlatform(createStreamingDTO.getPlatform());
        streaming.setUrl(createStreamingDTO.getUrl());
        return streaming;
    }
}
