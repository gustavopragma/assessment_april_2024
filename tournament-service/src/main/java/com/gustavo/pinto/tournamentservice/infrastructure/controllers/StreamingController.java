package com.gustavo.pinto.tournamentservice.infrastructure.controllers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateStreamingResponseDTO;
import com.gustavo.pinto.tournamentservice.application.services.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/streamings")
public class StreamingController {
    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateStreamingResponseDTO createStreaming(@RequestBody CreateStreamingDTO createStreamingDTO) {
        return streamingService.createStreaming(createStreamingDTO);
    }
}
