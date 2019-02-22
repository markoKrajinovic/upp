package com.project.scientificrepository.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Editor extends Reviewer {

	@OneToOne(mappedBy = "chiefEditor")
	private EditorComitee editorComiteeChief;

	@ManyToMany(mappedBy = "editors")
	private List<ScientificField> scientificFields;
	
	@ManyToOne
	private EditorComitee editorComitee;

	public EditorComitee getEditorComiteeChief() {
		return editorComiteeChief;
	}

	public void setEditorComiteeChief(EditorComitee editorComiteeChief) {
		this.editorComiteeChief = editorComiteeChief;
	}

	public List<ScientificField> getScientificFields() {
		return scientificFields;
	}

	public void setScientificFields(List<ScientificField> scientificFields) {
		this.scientificFields = scientificFields;
	}

	public EditorComitee getEditorComitee() {
		return editorComitee;
	}

	public void setEditorComitee(EditorComitee editorComitee) {
		this.editorComitee = editorComitee;
	}

	
}
