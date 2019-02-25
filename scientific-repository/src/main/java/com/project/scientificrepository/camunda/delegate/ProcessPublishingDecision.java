package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.project.scientificrepository.dto.FormSubmissionDto;

public class ProcessPublishingDecision implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("PROCESS PUBLISHING DECISION");
				
		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution
				.getVariable("odluka_da_li_se_rad_prihvata");

		for (FormSubmissionDto field : formFields) {
			execution.setVariable("publishingDecision", field.getFieldValue());
		}
		
	}

}
