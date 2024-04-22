package com.gustavo.pinto.tournamentservice.application.services;

import com.gustavo.pinto.tournamentservice.application.dtos.CreateCategoryResponseDTO;
import com.gustavo.pinto.tournamentservice.domain.models.Category;
import com.gustavo.pinto.tournamentservice.domain.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTests {

    @Mock
    CategoryRepository categoryRepository;
    @InjectMocks
    CategoryService categoryService;

    @Test
    public void testCreateCategorySuccessfully() {
        //Given
        Mockito.when(categoryRepository.createCategory(Mockito.any(Category.class))).thenReturn("1234567");

        //When
        CreateCategoryResponseDTO createCategoryResponseDTO = categoryService.createCategory(
                CategoryData.createCategoryDTO
        );

        //Then
        assertThat(createCategoryResponseDTO.getId(), equalTo("1234567"));
        Mockito
                .verify(categoryRepository, Mockito.times(1))
                .createCategory(Mockito.any(Category.class));
    }

    @Test
    public void testGetAllCategoriesSuccessfully() {
        //Given
        Mockito.when(categoryRepository.getAllCategories()).thenReturn(List.of());

        //When
        categoryService.getAllCategories();

        //Then
        Mockito.verify(categoryRepository, Mockito.times(1)).getAllCategories();
    }
}
