package com.gustavo.pinto.tournamentservice.application.mappers;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Category;

public class CreateCategoryDTOMapper {
    public static Category toModel(CreateCategoryDTO createCategoryDTO) {
        Category category = new Category();
        category.setName(createCategoryDTO.getName());
        category.setIsFree(createCategoryDTO.getIsFree());
        category.setParticipantsLimit(createCategoryDTO.getParticipantsLimit());
        category.setSpectatorsLimit(createCategoryDTO.getSpectatorsLimit());
        category.setStreamingLimit(createCategoryDTO.getStreamingLimit());
        category.setCommissionPercentage(createCategoryDTO.getCommissionPercentage());
        return category;
    }
}
