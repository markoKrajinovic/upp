package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Magazine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	@Column(nullable = false, unique = true)
	private String issn;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ACCESS_TYPE type;

	@ManyToMany(mappedBy = "magazines")
	private List<Thesis> theses;
	
	@OneToOne(optional = false)
	private EditorComitee editorComitee;
	
	@ManyToMany(mappedBy = "memberships")
	private List<Author> authors;
	
	@ManyToMany(mappedBy = "magazines")
	private List<ScientificField> scientificFields;
	
	@ManyToOne
	private ReviewerComitee reviewerComitee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Thesis> getTheses() {
		return theses;
	}

	public void setTheses(List<Thesis> theses) {
		this.theses = theses;
	}

	public ACCESS_TYPE getType() {
		return type;
	}

	public void setType(ACCESS_TYPE type) {
		this.type = type;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public EditorComitee getEditorComitee() {
		return editorComitee;
	}

	public void setEditorComitee(EditorComitee editorComitee) {
		this.editorComitee = editorComitee;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public List<ScientificField> getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(List<ScientificField> scientificFields) {
		this.scientificFields = scientificFields;
	}

	public ReviewerComitee getReviewerComitee() {
		return reviewerComitee;
	}

	public void setReviewerComitee(ReviewerComitee reviewerComitee) {
		this.reviewerComitee = reviewerComitee;
	}
	
	

}
