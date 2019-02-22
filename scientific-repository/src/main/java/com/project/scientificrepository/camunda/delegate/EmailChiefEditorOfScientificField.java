package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Editor;
import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.model.ScientificField;
import com.project.scientificrepository.model.Thesis;

@Service
public class EmailChiefEditorOfScientificField implements JavaDelegate {

	@Autowired
	private EmailService emailService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("EMAIL CHIEF EDITOR OF SCIENTIFIC FIELD");

		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		Thesis thesis = (Thesis) execution.getVariable("thesis");

		List<Editor> allEditors = magazine.getEditorComitee().getEditors();
		boolean editorFound = false;

		for (Editor editor : allEditors) {
			for (ScientificField scientificField : editor.getScientificFields()) {
				if (scientificField.getId() == thesis.getScientificField().getId()) {
					execution.setVariable("fieldEditor", editor);
					emailService.sendMail(editor.geteMail(), "Odabir recenzenata", "Odaberite recenzente za rad " + thesis.getTitle());
					editorFound = true;
					break;
				}
			}
		}

		if (!editorFound) {
			Editor chiefEditor = (Editor) execution.getVariable("chiefEditor");
			emailService.sendMail(chiefEditor.geteMail(), "Odabir recenzenata", "Odaberite recenzente za rad " + thesis.getTitle());
			execution.setVariable("fieldEditor", chiefEditor);
		}
	}

}
