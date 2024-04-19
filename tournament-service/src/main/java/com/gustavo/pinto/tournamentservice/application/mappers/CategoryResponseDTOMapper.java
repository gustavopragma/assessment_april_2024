package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.CategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Category;

public class CategoryResponseDTOMapper {
    public static CategoryResponseDTO toDTO(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .isFree(category.getIsFree())
                .spectatorsLimit(category.getSpectatorsLimit())
                .participantsLimit(category.getParticipantsLimit())
                .streamingLimit(category.getStreamingLimit())
                .commissionPercentage(category.getCommissionPercentage())
                .build();
    }
}
