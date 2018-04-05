package com.elrast.api.pollmining;

import com.elrast.api.pollmining.service.CategoryService;
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
import java.util.stream.Stream;

@SpringBootApplication
public class PollMiningApplication implements CommandLineRunner {

    @Autowired
    CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(PollMiningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> catNames = loadCategoriesFromFile();
        catNames.forEach(name -> {
            categoryService.createCategory(name, 1l);
        });
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

}
