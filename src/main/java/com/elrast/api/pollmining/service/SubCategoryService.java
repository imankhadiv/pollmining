package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Autowired
    CategoryService categoryService;


    public SubCategory createSubCategory(long userId, String subCategoryName, String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        SubCategory subCategory = new SubCategory(userId, subCategoryName, category);
        return subCategoryRepository.saveAndFlush(subCategory);
    }
}
