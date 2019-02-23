package com.project.scientificrepository.camunda.delegate;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.model.Reviewer;
import com.project.scientificrepository.model.ScientificField;
import com.project.scientificrepository.model.Thesis;

@Service
public class GetReviewers implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("GET REVIEWERS");

		List<String> retVal = new LinkedList<String>();

		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		Thesis thesis = (Thesis) execution.getVariable("thesis");
		ScientificField field = thesis.getScientificField();

		System.out.println("FIELD ID " + field.getId());

		if (magazine.getReviewerComitee() != null) {
			List<Reviewer> reviewers = magazine.getReviewerComitee().getReviewers();

			for (Reviewer r : reviewers) {
				for (ScientificField scf : r.getScientificFields()) {
					if (scf.getId() == field.getId()) {
						retVal.add(r.getUsername());
					}
				}
				System.out.println("REVIEWER " + r.getUsername());
			}
		}

		execution.setVariable("reviewerUsernames", retVal);
		
	}

}
