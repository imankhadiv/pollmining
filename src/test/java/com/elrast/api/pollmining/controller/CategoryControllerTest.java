package com.elrast.api.pollmining.controller;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.service.CategoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService categoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetCategories() {
        Category mockedCategory = new Category();
        mockedCategory.setId(1L);
        List<Category> mockedCatList = Arrays.asList(mockedCategory);

        when(categoryService.lookup()).thenReturn(mockedCatList);
        List<Category> categories = categoryController.getCategories();

        Assert.assertEquals(mockedCatList, categories);
        verify(categoryService).lookup();
    }

    @Test //??
    public void shouldDelete() {

        Category mockedCategory = new Category();
        mockedCategory.setId(1L);

        when(categoryService.delete(1L)).thenReturn(mockedCategory);
        categoryController.delete(1L);

        verify(categoryService).delete(1L);
        when(categoryService.delete(1L)).thenReturn(null);
    }
}
