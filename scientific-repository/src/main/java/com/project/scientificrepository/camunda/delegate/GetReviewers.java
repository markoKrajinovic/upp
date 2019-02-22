package com.project.scientificrepository.camunda.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.repository.ReviewerRepository;

@Service
public class GetReviewers implements JavaDelegate {

	@Autowired
	private ReviewerRepository revRepository;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GET REVIEWERS");
	}

}
