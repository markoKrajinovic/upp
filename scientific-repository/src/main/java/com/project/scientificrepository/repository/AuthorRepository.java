package com.project.scientificrepository.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	Author findByUsername(String username);

	Optional<Author> findByUsernameAndPassword(String username, String password);

}
