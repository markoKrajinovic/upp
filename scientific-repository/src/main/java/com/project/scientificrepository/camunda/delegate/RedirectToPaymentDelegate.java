package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.repository.AuthorRepository;
import com.project.scientificrepository.repository.MagazineRepository;

@Service
public class RedirectToPaymentDelegate implements JavaDelegate {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("REDIRECT TO PAYMENT");
		
		
		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		User user = (User) execution.getVariable("loggedAuthor");
		
		Author author = authorRepository.findByUsername(user.getId());
		
		author.getMemberships().add(magazine);
		magazine.getAuthors().add(author);
		magazineRepository.save(magazine);
		authorRepository.save(author);

	}

}
