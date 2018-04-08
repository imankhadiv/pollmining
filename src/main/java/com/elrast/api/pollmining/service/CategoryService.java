package com.elrast.api.pollmining.service;


import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String name, long userId) {
        if (!categoryRepository.existsByName(name)) {
            return categoryRepository.save(new Category(capitalizeName(name), userId));
        }
        return null;
    }

    public Category findCategoryByName(@NotNull String categoryName) {
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(categoryName);
        return categoryOptional.orElseThrow( () -> new RuntimeException("can not find category name!"));
    }

    private String capitalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
    }
    public Iterable<Category> lookup() {
        return categoryRepository.findAll();
    }

    public long total() {
        return categoryRepository.count();
    }

}
