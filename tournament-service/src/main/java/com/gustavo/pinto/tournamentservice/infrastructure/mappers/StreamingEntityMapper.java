package com.gustavo.pinto.tournamentservice.infrastructure.mappers;

import com.gustavo.pinto.tournamentservice.domain.models.Streaming;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.StreamingEntity;

public class StreamingEntityMapper {
    public static StreamingEntity toEntity(Streaming streaming) {
        return StreamingEntity.builder()
                .id(streaming.getId())
                .platform(streaming.getPlatform())
                .url(streaming.getUrl())
                .isActivate(streaming.getActivate())
                .tournamentEntity(TournamentEntityMapper.toEntity(streaming.getTournament()))
                .build();
    }

    public static Streaming toModel(StreamingEntity streamingEntity){
        Streaming streaming = new Streaming();
        streaming.setId(streamingEntity.getId());
        streaming.setPlatform(streamingEntity.getPlatform());
        streaming.setUrl(streamingEntity.getUrl());
        streaming.setActivate(streamingEntity.getIsActivate());
        return streaming;
    }
}
