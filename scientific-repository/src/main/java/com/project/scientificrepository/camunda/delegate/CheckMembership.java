package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.model.Magazine;

@Service
public class CheckMembership implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CHECK MEMBERSHIP");
		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		User user = (User) execution.getVariable("loggedAuthor");
		
		System.out.println(magazine.getName() + " " + user.getId());
		
		for(Author author: magazine.getAuthors()) {
			if(author.getUsername().equals(user.getId())) {
				execution.setVariable("payed", true);
				return;
			}
		}
		execution.setVariable("payed", false);
		
	}

}
