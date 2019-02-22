package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.FormSubmissionDto;
import com.project.scientificrepository.model.Thesis;
import com.project.scientificrepository.repository.ThesisRepository;

@Service
public class UpdatePdfText implements JavaDelegate {

	@Autowired
	private ThesisRepository thesisRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("UPDATE PDF TEXT");

		Thesis thesis = (Thesis) execution.getVariable("thesis");
		System.out.println("UPDATING THESIS " + thesis.getTitle());

		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> form = (List<FormSubmissionDto>) execution.getVariable("ispravka_pdf_dokumenta");

		for (FormSubmissionDto formField : form) {
			thesis.setPdfText(formField.getFieldValue());
		}
		
		thesisRepository.save(thesis);

	}

}
