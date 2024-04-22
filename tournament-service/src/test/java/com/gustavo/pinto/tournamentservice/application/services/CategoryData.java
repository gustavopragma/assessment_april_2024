package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Category;

public class CategoryData {
    public static CreateCategoryDTO createCategoryDTO = CreateCategoryDTO.builder()
            .name("Category 1")
            .isFree(true)
            .commissionPercentage(20)
            .participantsLimit(10)
            .spectatorsLimit(50)
            .streamingLimit(2)
            .build();

    public static Category createCategory() {
        Category category = new Category();
        category.setName("Category 1");
        category.setIsFree(true);
        category.setCommissionPercentage(20);
        category.setParticipantsLimit(10);
        category.setSpectatorsLimit(50);
        category.setStreamingLimit(2);
        return category;
    }
}
