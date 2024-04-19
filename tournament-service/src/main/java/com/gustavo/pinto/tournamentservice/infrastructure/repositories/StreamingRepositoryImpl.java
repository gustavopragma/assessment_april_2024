package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Streaming;
import com.gustavo.pinto.tournamentservice.domain.repositories.StreamingRepository;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.StreamingEntity;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.StreamingEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StreamingRepositoryImpl implements StreamingRepository {
    private final StreamingEntityRepository streamingEntityRepository;

    public StreamingRepositoryImpl(StreamingEntityRepository streamingEntityRepository) {
        this.streamingEntityRepository = streamingEntityRepository;
    }

    @Override
    public String createStreaming(Streaming streaming) {
        StreamingEntity streamingEntity = StreamingEntityMapper.toEntity(streaming);
        streamingEntityRepository.save(streamingEntity);
        return streamingEntity.getId();
    }
}
