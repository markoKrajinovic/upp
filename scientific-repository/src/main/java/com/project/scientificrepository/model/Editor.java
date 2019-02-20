package com.project.scientificrepository.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Editor extends Reviewer {

	@OneToOne(mappedBy = "chiefEditor")
	private EditorComitee editorComiteeChief;

	public EditorComitee getEditorComiteeChief() {
		return editorComiteeChief;
	}

	public void setEditorComiteeChief(EditorComitee editorComiteeChief) {
		this.editorComiteeChief = editorComiteeChief;
	}
	
	
}
