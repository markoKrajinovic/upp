package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.project.scientificrepository.model.Magazine;

public class SupportedPayments implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		System.out.println("GET SUPPORTED PAYMENTS");
		System.out.println("MAGAZINE NAME " + magazine.getName());
	}

}
