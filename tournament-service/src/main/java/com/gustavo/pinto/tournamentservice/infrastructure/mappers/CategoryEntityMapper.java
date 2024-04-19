package com.gustavo.pinto.tournamentservice.infrastructure.mappers;

import com.gustavo.pinto.tournamentservice.domain.models.Category;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.CategoryEntity;

public class CategoryEntityMapper {
    public static Category toModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setIsFree(categoryEntity.getIsFree());
        category.setParticipantsLimit(categoryEntity.getParticipantLimit());
        category.setStreamingLimit(categoryEntity.getStreamingLimit());
        category.setSpectatorsLimit(categoryEntity.getSpectatorsLimit());
        category.setCommissionPercentage(categoryEntity.getCommissionPercentage());
        return category;
    }

    public static CategoryEntity toEntity(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .isFree(category.getIsFree())
                .participantLimit(category.getParticipantsLimit())
                .spectatorsLimit(category.getSpectatorsLimit())
                .streamingLimit(category.getStreamingLimit())
                .commissionPercentage(category.getCommissionPercentage())
                .isActivate(category.getActivate())
                .build();
    }
}
