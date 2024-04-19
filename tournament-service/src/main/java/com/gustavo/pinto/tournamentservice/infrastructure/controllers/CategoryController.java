package com.gustavo.pinto.tournamentservice.infrastructure.controllers;

import com.gustavo.pinto.tournamentservice.application.dtos.CategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryDTO;
import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.application.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponseDTO createCategory(@RequestBody CreateCategoryDTO createCategoryDTO) {
        return categoryService.createCategory(createCategoryDTO);
    }
}
