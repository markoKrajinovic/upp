package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.FormSubmissionDto;

@Service
public class LoginDelegate implements JavaDelegate {

	@Autowired
	private IdentityService identityService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution.getVariable("logovanje");

		String username = "";
		String password = "";
		System.out.println("LOGIN SERVICE");
		for (FormSubmissionDto field : formFields) {
			if (field.getFieldId().equals("username_login"))
				username = field.getFieldValue();
			if (field.getFieldId().equals("password_login"))
				password = field.getFieldValue();
		}

		System.out.println("USER " + username + " " + password + " TRYING TO LOGIN ");
		boolean logged = identityService.checkPassword(username, password);

		if (logged) {
			System.out.println("USER FOUND");
			List<User> authors = identityService.createUserQuery().memberOfGroup("author").list();
			
			if (isAuthor(username, authors)) {
				identityService.setAuthenticatedUserId(username);
				User user = identityService.createUserQuery().userId(username).singleResult();
				execution.setVariable("loggedAuthor", user);
				System.out.println("USER " + username + " AUTHENTICATED");
			} else {
				System.out.println("WRONG USER GROUP");
				throw new BpmnError("wrong_group");
			}
		} else {
			System.out.println("USER NOT FOUND");
			throw new BpmnError("user_not_found");
		}

	}

	private boolean isAuthor(String username, List<User> authors) {
		for(User user: authors) {
			if(user.getId().equals(username))
				return true;
		}
		return false;
	}

}
