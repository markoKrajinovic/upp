package com.project.scientificrepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.FIELD_NAME;
import com.project.scientificrepository.model.ScientificField;


public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {

	ScientificField findByFieldName(FIELD_NAME fn);

}
