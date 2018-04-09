package com.elrast.api.pollmining.controller;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.lookup();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{categoryId}")
    public void delete(@PathVariable(value = "categoryId") long categoryId) {
        categoryService.delete(categoryId);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }

}
