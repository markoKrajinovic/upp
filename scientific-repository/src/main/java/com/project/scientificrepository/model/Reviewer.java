package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Reviewer {

	@Id
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String city;
	
	@Column
	private String country;
	
	@Column
	private String eMail;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "reviewers")
	private List<ReviewerComitee> reviewerComitees;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "reviewers")
	private List<ScientificField> scientificFields;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ReviewerComitee> getReviewerComitees() {
		return reviewerComitees;
	}

	public void setReviewerComitees(List<ReviewerComitee> reviewerComitees) {
		this.reviewerComitees = reviewerComitees;
	}

	public List<ScientificField> getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(List<ScientificField> scientificFields) {
		this.scientificFields = scientificFields;
	}
	
	
	
}
