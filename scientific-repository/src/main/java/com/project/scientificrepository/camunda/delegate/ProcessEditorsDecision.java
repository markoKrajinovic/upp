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
public class ProcessEditorsDecision implements JavaDelegate {
	
	@Autowired
	private ThesisRepository thesisRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("PROCESS EDITORS DECISION");
		
		Thesis thesis = (Thesis) execution.getVariable("thesis");
		
		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution
				.getVariable("odluka_da_li_je_rad_relevantan");

		boolean relevant = false;
		boolean formatted = false;
		for (FormSubmissionDto field : formFields) {
			if (field.getFieldId().equals("relevant"))
				if(field.getFieldValue().equals("true"))
					relevant = true;
			if (field.getFieldId().equals("pdfFormatiran"))
				if(field.getFieldValue().equals("true"))
					formatted = true;
			if (field.getFieldId().equals("comment")) {
				thesis.setChiefEditorsComment(field.getFieldValue());
				thesisRepository.save(thesis);
			}
		}
		
		System.out.println("FORMATED " + formatted + " RELEVANT " + relevant);
		execution.setVariable("relevant", relevant);
		execution.setVariable("formatted", formatted);
	}

}
