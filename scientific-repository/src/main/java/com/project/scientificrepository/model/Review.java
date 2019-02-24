package com.project.scientificrepository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	@ManyToOne(optional = false)
	private Reviewer reviewer;*/
	
	@Column
	private String comment;
	
	@Column
	private String commentForEditor;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PUBLISHING_SUGGESTION publishingSuggestion;
	
	@JsonIgnore
	@ManyToOne
	private Thesis thesis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}*/

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentForEditor() {
		return commentForEditor;
	}

	public void setCommentForEditor(String commentForEditor) {
		this.commentForEditor = commentForEditor;
	}

	public PUBLISHING_SUGGESTION getPublishingSuggestion() {
		return publishingSuggestion;
	}

	public void setPublishingSuggestion(PUBLISHING_SUGGESTION publishingSuggestion) {
		this.publishingSuggestion = publishingSuggestion;
	}

	public Thesis getThesis() {
		return thesis;
	}

	public void setThesis(Thesis thesis) {
		this.thesis = thesis;
	}
	
	
}
