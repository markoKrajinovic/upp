package com.project.scientificrepository.camunda.delegate;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Service
public class GetThesesDelegate implements JavaDelegate {


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		/*List<Thesis> theses = thesisRepository.findAll();

		Task task = taskService.createTaskQuery().taskName("Biranje casopisa").singleResult();

		*/

	}

}
