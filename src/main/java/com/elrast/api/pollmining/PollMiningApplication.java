package com.elrast.api.pollmining;

import com.elrast.api.pollmining.domain.Category;
import com.elrast.api.pollmining.domain.SubCategory;
import com.elrast.api.pollmining.service.CategoryService;
import com.elrast.api.pollmining.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class PollMiningApplication implements CommandLineRunner {

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryService subCategoryService;

    public static void main(String[] args) {

        SpringApplication.run(PollMiningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> catNames = loadCategoriesFromFile();
        catNames.forEach(name -> {
            categoryService.createCategory(name, 1l);
        });
        List<String> subCategories = loadSubCategoriesFromFile();

        subCategories.forEach( name -> {
            subCategoryService.createSubCategory(1l,name,"Sport");
        });

        Category category = categoryService.findCategoryByName("Sport");
        Set<SubCategory> subs = category.getSubCategories();



    }

    private List<String> loadCategoriesFromFile() {
        List<String> catNames = new ArrayList<>();
        Path path = Paths.get("src/main/resources/categories.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(catNames::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catNames;
    }

    private List<String> loadSubCategoriesFromFile() {
        List<String> subCategories = new ArrayList<>();
        Path path = Paths.get("src/main/resources/subcategories.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(subCategories::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subCategories;
    }

}
