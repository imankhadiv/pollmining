package com.elrast.api.pollmining.service;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    public List<SubCategory> lookup() {
        return subCategoryRepository.findAll();
    }

    public SubCategory delete(long subCategoryId) {
        Optional<SubCategory> optionalSubCategory = subCategoryRepository.findById(subCategoryId);
        optionalSubCategory.ifPresent(subCategory -> subCategoryRepository.delete(subCategory));
        return optionalSubCategory.orElseThrow(() -> new NoSuchElementException("Can't find subcategory!"));
    }

    public Optional<SubCategory> findById(long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId);
    }
}
