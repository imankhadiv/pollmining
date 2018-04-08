package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.repository.SubCategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class SubCategoryServiceTest {

    public static final String CATEGORY1 = "Category1";
    public static final String SUB_CATEGORY1 = "SubCategory1";
    @InjectMocks
    SubCategoryService subCategoryService;

    @Mock
    SubCategoryRepository subCategoryRepository;
    @Mock
    CategoryService categoryService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateSubcategory() {

        Category mockCat = new Category();
        mockCat.setName(CATEGORY1);
        when(categoryService.findCategoryByName(CATEGORY1)).thenReturn(mockCat);

        SubCategory mockSubcategory = new SubCategory(1L, SUB_CATEGORY1, mockCat);
        ArgumentCaptor<SubCategory> argumentCaptor = ArgumentCaptor.forClass(SubCategory.class);
        when(subCategoryRepository.saveAndFlush(argumentCaptor.capture())).thenReturn(mockSubcategory);

        SubCategory subCategory = subCategoryService.createSubCategory(1L, SUB_CATEGORY1, CATEGORY1);

        Assert.assertEquals(mockSubcategory, subCategory);
        verify(subCategoryRepository).saveAndFlush(argumentCaptor.capture());

    }
}