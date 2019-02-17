package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.FormSubmissionDto;
import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.repository.AuthorRepository;
import com.project.scientificrepository.repository.MagazineRepository;

@Service
public class SubmitPayment implements JavaDelegate {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution.getVariable("odabir_tipa_placanja");
		
		for (FormSubmissionDto ff: formFields) {
			System.out.println("SELECTED TYPE " + ff.getFieldValue());
		}
		
		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		User user = (User) execution.getVariable("loggedAuthor");
		
		Author author = authorRepository.findByUsername(user.getId());
		
		author.getMemberships().add(magazine);
		magazine.getAuthors().add(author);
		authorRepository.save(author);
		magazineRepository.save(magazine);
		
	}

}
