package com.elrast.api.pollmining.service;


import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name, long userId) {
        if (!categoryRepository.existsByName(name)) {
            return categoryRepository.save(new Category(capitalizeName(name), userId));
        }
        return null;
    }

    private String capitalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }
}
