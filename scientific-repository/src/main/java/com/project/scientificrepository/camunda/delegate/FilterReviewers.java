package com.project.scientificrepository.camunda.delegate;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FilterReviewers implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("FILTER REVIEWERS");
		@SuppressWarnings("unchecked")
		List<String> possibleReviewers = (List<String>) execution.getVariable("reviewerUsernames");
		@SuppressWarnings("unchecked")
		List<String> chosenReviewers = (List<String>) execution.getVariable("chosenReviewers");

		List<String> retVal = new LinkedList<String>();

		for (String useraname : possibleReviewers) {
			boolean found = false;
			for (String username2 : chosenReviewers) {
				if (useraname.equals(username2))
					found = true;
			}
			if(!found)
				retVal.add(useraname);
		}

		execution.setVariable("reviewerUsernames", retVal);

	}

}
