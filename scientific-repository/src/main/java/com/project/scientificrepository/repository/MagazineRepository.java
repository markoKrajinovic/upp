package com.project.scientificrepository.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scientificrepository.model.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {

	Magazine findByIssn(String issn);
}
