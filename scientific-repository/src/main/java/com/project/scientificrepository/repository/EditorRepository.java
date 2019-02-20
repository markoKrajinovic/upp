package com.project.scientificrepository.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Editor;

public interface EditorRepository extends JpaRepository<Editor, Long> {

	Optional<Editor> findByUsernameAndPassword(String username, String password);

}
