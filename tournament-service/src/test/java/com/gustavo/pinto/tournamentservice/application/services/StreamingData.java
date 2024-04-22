package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingDTO;

public class StreamingData {
    public static CreateStreamingDTO createStreamingDTO = CreateStreamingDTO.builder()
            .platform("Twitch")
            .tournamentId("1")
            .url("www.twitch.com")
            .build();
}
