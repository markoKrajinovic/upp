package com.project.scientificrepository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scientificrepository.model.Thesis;

@Repository
public interface ThesisRepository extends JpaRepository<Thesis, Long> {

	List<Thesis> findByAuthorUsername(String username);
}
