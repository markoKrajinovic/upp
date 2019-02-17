package com.project.scientificrepository.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

	Author findByUsername(String username);

}
