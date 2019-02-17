package com.project.scientificrepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.scientificrepository.model.CoAuthor;

@Repository
public interface CoAuthorRepository<T extends CoAuthor> extends JpaRepository<T, Long> {

}
