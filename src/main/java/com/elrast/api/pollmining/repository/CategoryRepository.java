package com.elrast.api.pollmining.repository;

import com.elrast.api.pollmining.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    boolean existsByName(String name);


    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Category category);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Category> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @Override
    @RestResource(exported = false)
    <S extends Category> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Category> Iterable<S> saveAll(Iterable<S> iterable);
}
