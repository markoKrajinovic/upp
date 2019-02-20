package com.project.scientificrepository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EditorComitee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "editorComitee")
	private Magazine magazine;
	
	@OneToOne(optional = false)
	private Editor chiefEditor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public Editor getChiefEditor() {
		return chiefEditor;
	}

	public void setChiefEditor(Editor chiefEditor) {
		this.chiefEditor = chiefEditor;
	}
	
	
	
}
