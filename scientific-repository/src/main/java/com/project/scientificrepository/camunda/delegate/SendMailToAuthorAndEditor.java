package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Editor;
import com.project.scientificrepository.model.Thesis;

@Service
public class SendMailToAuthorAndEditor implements JavaDelegate {

	@Autowired
	private EmailService emailService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SEND MAIL TO AUTHOR AND EDITOR");
		
		User loggedAuthor = (User) execution.getVariable("loggedAuthor");
		Editor chiefEditor = (Editor) execution.getVariable("chiefEditor");
		Thesis thesis = (Thesis) execution.getVariable("thesis");
		
		
		System.out.println("CHIEF EDITOR " + chiefEditor.getUsername());
		System.out.println("AUTHOR " + loggedAuthor.getId());
		
		emailService.sendThesisSubmitetMail(loggedAuthor.getEmail(), chiefEditor.geteMail(), thesis);
		

	}

}
