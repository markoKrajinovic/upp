package com.project.scientificrepository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByThesisId(Long thesisId);

}
