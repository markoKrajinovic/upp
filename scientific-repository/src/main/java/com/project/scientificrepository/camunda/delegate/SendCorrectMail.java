package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendCorrectMail implements JavaDelegate {

	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("SEND CORRECT MAIL");

		User user = (User) execution.getVariable("loggedAuthor");
		
		emailService.sendMail(user.getEmail(), "Korigovati rad", "Korigovati greske i proloziti novu verziju.");
	}

}
