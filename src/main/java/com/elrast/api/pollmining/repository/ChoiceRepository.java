package com.elrast.api.pollmining.repository;

import com.elrast.api.pollmining.domain.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}
