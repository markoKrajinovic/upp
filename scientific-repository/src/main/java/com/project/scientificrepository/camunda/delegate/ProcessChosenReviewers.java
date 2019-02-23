package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.project.scientificrepository.dto.FormSubmissionDto;

public class ProcessChosenReviewers implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PROCESS CHOSEN REVIEWERS");
		
		@SuppressWarnings("unchecked")
		List<String> reviewerUsernames = (List<String>) execution.getVariable("reviewerUsernames");
		
		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution
				.getVariable("dodeljivanje_uloge_recenzenata");

		for (FormSubmissionDto field : formFields) {
			if(field.getFieldValue().equals("true")) {
				reviewerUsernames.add(field.getFieldId());
			}

		}
		
	}

}
