package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ReviewerComitee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy = "reviewerComitee")
	private List<Magazine> magazines;
	
	@ManyToMany
	private List<Reviewer> reviewers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	public List<Reviewer> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewer> reviewers) {
		this.reviewers = reviewers;
	}
	
	
}
