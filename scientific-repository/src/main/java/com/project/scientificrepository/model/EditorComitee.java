package com.project.scientificrepository.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EditorComitee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "editorComitee")
	private Magazine magazine;
	
	@OneToOne(optional = false)
	private Editor chiefEditor;
	
	@OneToMany(mappedBy = "editorComitee")
	private List<Editor> editors;

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

	public List<Editor> getEditors() {
		return editors;
	}

	public void setEditors(List<Editor> editors) {
		this.editors = editors;
	}
	
	
	
}
