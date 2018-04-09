package com.elrast.api.pollmining.repository;

import com.elrast.api.pollmining.domain.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

}
