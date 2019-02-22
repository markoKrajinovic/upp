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
import javax.persistence.OneToMany;


@Entity
public class ScientificField {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Enumerated(EnumType.STRING)
	private FIELD_NAME fieldName;

	@OneToMany(mappedBy = "scientificField")
	private List<Thesis> theses;
	
	@ManyToMany
	private List<Magazine> magazines;
	
	@ManyToMany
	private List<Editor> editors;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FIELD_NAME getFieldName() {
		return fieldName;
	}

	public void setFieldName(FIELD_NAME fieldName) {
		this.fieldName = fieldName;
	}

	public List<Thesis> getTheses() {
		return theses;
	}

	public void setTheses(List<Thesis> theses) {
		this.theses = theses;
	}

	public List<Magazine> getMagazines() {
		return magazines;
	}

	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	public List<Editor> getEditors() {
		return editors;
	}

	public void setEditors(List<Editor> editors) {
		this.editors = editors;
	}



}
