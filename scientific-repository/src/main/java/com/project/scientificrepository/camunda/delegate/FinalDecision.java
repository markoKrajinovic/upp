package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.project.scientificrepository.dto.FormSubmissionDto;

public class FinalDecision implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FINAL DECISION");

		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution
				.getVariable("pregledanje_ispravljenog_rada");

		for (FormSubmissionDto field : formFields) {
			execution.setVariable("finalDecision", field.getFieldValue());
		}
	}

}
