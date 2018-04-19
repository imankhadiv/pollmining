package com.elrast.api.pollmining.controller;

import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/categories/{categoryId}/subcategories")
public class SubcategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @RequestMapping(method = RequestMethod.DELETE, path = "/{subCategoryId}")
    public SubCategory delete(@PathVariable(value = "subCategoryId") long subCategoryId) {
        return subCategoryService.delete(subCategoryId);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }
}
