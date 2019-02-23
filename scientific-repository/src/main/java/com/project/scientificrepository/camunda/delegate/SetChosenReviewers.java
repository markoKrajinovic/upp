package com.project.scientificrepository.camunda.delegate;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.project.scientificrepository.dto.FormSubmissionDto;

public class SetChosenReviewers implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SET CHOSEN REVIEWERS");
		
		List<String> reviewerUsernames = new LinkedList<String>();
		
		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution
				.getVariable("biranje_recenzenata");

		for (FormSubmissionDto field : formFields) {
			if(field.getFieldValue().equals("true")) {
				reviewerUsernames.add(field.getFieldId());
			}

		}
		
		execution.setVariable("chosenReviewers", reviewerUsernames);
	}

}
