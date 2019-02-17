package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.Token;

@Service
public class CheckAuthenticationDelegate implements JavaDelegate {

	@Autowired
	private IdentityService identityService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Token token = (Token) execution.getVariable("starter");
		System.out.println("TOKEN " + token.getUsername());

		if(token.getUsername() == null) {
			execution.setVariable("loggedAuthor", null);
			return;
		}
		
		User user = identityService.createUserQuery().userId(token.getUsername()).singleResult();

		if (user == null)
			execution.setVariable("loggedAuthor", null);
		else {

			System.out.println(user);
			execution.setVariable("loggedAuthor", user);
		}
	}

}
