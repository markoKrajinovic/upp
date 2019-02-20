package com.project.scientificrepository.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Thesis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String title;
	
	@Column
	private String keyWords;

	@Column
	// @Size(min = 3, max = 35)
	private String summary;

	private String pdfLocation;

	private String pdfFinalLocation;

	private String pdfText;

	@ManyToMany
	private List<Magazine> magazines = new LinkedList<Magazine>();

	@ManyToOne(optional = false)
	@JoinColumn(name = "author_fk")
	private Author author;

	@ManyToMany
	private List<CoAuthor> coAuthors;

	@ManyToOne
	@JoinColumn(name = "field_fk")
	private ScientificField scientificField;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPdfLocation() {
		return pdfLocation;
	}

	public void setPdfLocation(String pdfLocation) {
		this.pdfLocation = pdfLocation;
	}

	public String getPdfFinalLocation() {
		return pdfFinalLocation;
	}

	public void setPdfFinalLocation(String pdfFinalLocation) {
		this.pdfFinalLocation = pdfFinalLocation;
	}
	
	

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<CoAuthor> getCoAuthors() {
		return coAuthors;
	}

	public void setCoAuthors(List<CoAuthor> coAuthors) {
		this.coAuthors = coAuthors;
	}

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}

	public String getPdfText() {
		return pdfText;
	}

	public void setPdfText(String pdfText) {
		this.pdfText = pdfText;
	}

	public List<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}
	
}
