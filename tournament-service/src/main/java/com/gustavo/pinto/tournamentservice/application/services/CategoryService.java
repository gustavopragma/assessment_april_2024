package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.application.mappers.CategoryResponseDTOMapper;
import com.gustavo.pinto.tournamentservice.application.mappers.CreateCategoryDTOMapper;
import com.gustavo.pinto.tournamentservice.domain.models.Category;
import com.gustavo.pinto.tournamentservice.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CreateCategoryResponseDTO createCategory(CreateCategoryDTO createCategoryDTO) {
        Category newCategory = CreateCategoryDTOMapper.toModel(createCategoryDTO);
        newCategory.setActivate(true);
        String id = categoryRepository.createCategory(newCategory);
        return CreateCategoryResponseDTO.builder()
                .id(id)
                .build();
    }

    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.getAllCategories();
        return categories
                .stream()
                .map(CategoryResponseDTOMapper::toDTO)
                .toList();
    }
}
