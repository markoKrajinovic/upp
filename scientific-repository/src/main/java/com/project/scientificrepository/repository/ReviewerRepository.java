package com.project.scientificrepository.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Reviewer;

public interface ReviewerRepository extends JpaRepository<Reviewer, Long> {

	Optional<Reviewer> findByUsernameAndPassword(String username, String password);

}
