package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CategoryServiceTest {

    public static final String CATEGORY1 = "Category1";
    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateCategory() {

        Category mockCategory = new Category(CATEGORY1, 1l);
        when(categoryRepository.existsByName(CATEGORY1)).thenReturn(false);
        when(categoryRepository.save(any(Category.class))).thenReturn(mockCategory);

        Category category = categoryService.createCategory(CATEGORY1, 1l);

        Assert.assertEquals(mockCategory, category);
        verify(categoryRepository).save(any());
    }

    @Test
    public void shouldNotCreateCategory() {

        Category mockCategory = new Category(CATEGORY1, 1l);
        when(categoryRepository.existsByName(CATEGORY1)).thenReturn(true);

        Category category = categoryService.createCategory(CATEGORY1, 1l);

        Assert.assertEquals(null, category);
        verify(categoryRepository, times(0)).save(any());
    }


    @Test
    public void shouldFindCategory() {

        Category mockCategory = new Category(CATEGORY1, 1l);
        Optional<Category> optionalCategory = Optional.of(mockCategory);
        when(categoryRepository.findCategoryByName(CATEGORY1)).thenReturn(optionalCategory);

        Assert.assertEquals(mockCategory.getName(), categoryService.findCategoryByName(CATEGORY1).getName());
        verify(categoryRepository, times(0)).save(mockCategory);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldNotFindCategory() {

        when(categoryRepository.findCategoryByName(CATEGORY1)).thenThrow(NoSuchElementException.class);
        categoryService.findCategoryByName(CATEGORY1);
        verify(categoryRepository).findCategoryByName(CATEGORY1);
    }

}