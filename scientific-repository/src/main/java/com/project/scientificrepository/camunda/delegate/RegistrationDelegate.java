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
import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.repository.AuthorRepository;

@Service
public class RegistrationDelegate implements JavaDelegate {

	@Autowired
	private IdentityService identityService;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("REGISTRATION SERVICE");

		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> registration = (List<FormSubmissionDto>) execution
				.getVariable("unos_podataka_za_registraciju");

		Author author = createAuthor(registration);
		System.out.println("AUTHOR " + author);
		User user = identityService.newUser(author.getUsername());
		user.setEmail(author.geteMail());
		user.setFirstName(author.getFirstName());
		user.setLastName(author.getLastName());
		user.setPassword(author.getPassword());
		
		
		if(identityService.createUserQuery().userId(user.getId()).singleResult() != null)
			throw new BpmnError("duplicate_username");
		else {
			identityService.saveUser(user);
			identityService.createMembership(user.getId(), "author");
		}

	}

	private Author createAuthor(List<FormSubmissionDto> registration) {
		Author newAuthor = new Author();
		for (FormSubmissionDto formField : registration) {

			if (formField.getFieldId().equals("ime_registracija")) {
				newAuthor.setFirstName(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("prezime_registracija")) {
				newAuthor.setLastName(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("grad_registracija")) {
				newAuthor.setCity(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("drzava_registracija")) {
				newAuthor.setCountry(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("titula_registracija")) {
				newAuthor.setTitle(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("email_registracija")) {
				newAuthor.seteMail(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("password_registracija")) {
				newAuthor.setPassword(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("username_registracija")) {
				newAuthor.setUsername(formField.getFieldValue());
				if (authorRepository.findByUsername(formField.getFieldValue()) != null)
					throw new BpmnError("duplicate_username");
			}
		}

		
		Author a = authorRepository.save(newAuthor);
		return a;
	}

}
