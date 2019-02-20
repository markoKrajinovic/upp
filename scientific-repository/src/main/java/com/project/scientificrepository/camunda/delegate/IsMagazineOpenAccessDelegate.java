package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.FormSubmissionDto;
import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.repository.MagazineRepository;

@Service
public class IsMagazineOpenAccessDelegate implements JavaDelegate {
	
	@Autowired
	private MagazineRepository magazineRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<FormSubmissionDto> formFields = (List<FormSubmissionDto>) execution.getVariable("biranje_casopisa");

		String magazineIssn = "";
		System.out.println("is MAGAZINE OPEN ACCESS SERVICE");
		for (FormSubmissionDto field : formFields) {
			magazineIssn = field.getFieldValue();
		}
		
		Magazine m = magazineRepository.findByIssn(magazineIssn);
		System.out.println("MAGAZIN " + m.getName() + " " + m.getType());
		execution.setVariable("chosenMagazine", m);
		
	}

}
