package com.gustavo.pinto.tournamentservice.domain.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Streaming;

import java.util.List;

public interface StreamingRepository {
    String createStreaming(Streaming streaming);
}
