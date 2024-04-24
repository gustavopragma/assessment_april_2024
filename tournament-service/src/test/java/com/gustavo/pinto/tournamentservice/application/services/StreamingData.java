package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Streaming;

public class StreamingData {
    public static CreateStreamingDTO createStreamingDTO = CreateStreamingDTO.builder()
            .platform("Twitch")
            .tournamentId("1")
            .url("www.twitch.com")
            .build();



    public static Streaming createStreaming() {
        Streaming streaming = new Streaming();
        streaming.setPlatform("Twitch");
        streaming.setUrl("www.twitch.com");
        return  streaming;
    }
}
