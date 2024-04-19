package com.gustavo.pinto.tournamentservice.infrastructure.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Category;
import com.gustavo.pinto.tournamentservice.domain.repositories.CategoryRepository;
import com.gustavo.pinto.tournamentservice.infrastructure.entities.CategoryEntity;
import com.gustavo.pinto.tournamentservice.infrastructure.mappers.CategoryEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private final CategoryEntityRepository categoryEntityRepository;

    public CategoryRepositoryImpl(CategoryEntityRepository categoryEntityRepository) {
        this.categoryEntityRepository = categoryEntityRepository;
    }

    @Override
    public String createCategory(Category category) {
        CategoryEntity categoryEntity = CategoryEntityMapper.toEntity(category);
        categoryEntityRepository.save(categoryEntity);
        return categoryEntity.getId();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryEntityRepository
                .findAll()
                .stream()
                .map(CategoryEntityMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Category> getCategoryById(String id) {
        return categoryEntityRepository
                .findById(id)
                .map(CategoryEntityMapper::toModel);
    }
}
