package com.elrast.api.pollmining.controller;

import com.elrast.api.pollmining.domain.Question;
import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.service.QuestionService;
import com.elrast.api.pollmining.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/{subCategoryId}/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    SubCategoryService subCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> getAllTheQuestionsForSubcategory(@PathVariable(value = "subCategoryId") long subCategoryId) {
        verifySubcategory(subCategoryId);
        return questionService.lookup();
    }

    private SubCategory verifySubcategory(long subCategoryId) {
        Optional<SubCategory> optionalSubCategory = subCategoryService.findById(subCategoryId);
        return optionalSubCategory.orElseThrow(() -> new NoSuchElementException("Sub Category does not exists " + subCategoryId));
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    private String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }

}
