package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfNotCorrectedOnTime implements JavaDelegate {

	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PDF NOT CORRECTED ON TIME");
		
		User user = (User) execution.getVariable("loggedAuthor");
		emailService.sendMail(user.getEmail(), "Rad nije korigovan na vreme", "Niste formatirali pdf tekst u zadatom vremenskom roku.");
	}

}
