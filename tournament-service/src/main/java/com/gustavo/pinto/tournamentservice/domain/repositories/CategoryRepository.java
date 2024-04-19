package com.gustavo.pinto.tournamentservice.domain.repositories;

import com.gustavo.pinto.tournamentservice.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    String createCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(String id);
}
