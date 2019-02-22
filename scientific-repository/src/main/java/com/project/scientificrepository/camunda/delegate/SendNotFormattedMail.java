package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendNotFormattedMail implements JavaDelegate {

	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NOT FORMATED MAIL");
		
		User user = (User) execution.getVariable("loggedAuthor");
		
		emailService.sendMail(user.getEmail(), "Rad nije dobro formatiran", "rad koji ste prilozili nije dobro formatiran, imate 12 sati da ispravite");

	}

}
