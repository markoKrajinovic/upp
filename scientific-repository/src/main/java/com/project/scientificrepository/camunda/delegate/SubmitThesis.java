package com.project.scientificrepository.camunda.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scientificrepository.dto.FormSubmissionDto;
import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.model.FIELD_NAME;
import com.project.scientificrepository.model.Magazine;
import com.project.scientificrepository.model.ScientificField;
import com.project.scientificrepository.model.Thesis;
import com.project.scientificrepository.repository.AuthorRepository;
import com.project.scientificrepository.repository.ScientificFieldRepository;
import com.project.scientificrepository.repository.ThesisRepository;

@Service
public class SubmitThesis implements JavaDelegate {

	@Autowired
	private ScientificFieldRepository scientificFieldRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ThesisRepository thesisRepository;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SUBMIT THESIS");

		User loggedAuthor = (User) execution.getVariable("loggedAuthor");
		Author author = authorRepository.findByUsername(loggedAuthor.getId());
		
		Magazine magazine = (Magazine) execution.getVariable("chosenMagazine");
		
		@SuppressWarnings("unchecked")
		Thesis thesis = loadThesis((List<FormSubmissionDto>) execution.getVariable("unos_podataka_o_radu"));
		thesis.setAuthor(author);
		thesis.getMagazines().add(magazine);
		
		thesisRepository.save(thesis);

		execution.setVariable("thesis", thesis);
		execution.setVariable("chiefEditor", magazine.getEditorComitee().getChiefEditor());

	}

	private Thesis loadThesis(List<FormSubmissionDto> thesisForm) {
		Thesis thesis = new Thesis();
		for (FormSubmissionDto formField : thesisForm) {

			if (formField.getFieldId().equals("naslov")) {
				thesis.setTitle(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("kljucniPojmovi")) {
				thesis.setKeyWords(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("koautori")) {
				// thesis.setCoAuthors(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("naucnaOblast")) {
				FIELD_NAME fn = FIELD_NAME.valueOf(formField.getFieldValue());
				ScientificField sf = scientificFieldRepository.findByFieldName(fn);
				thesis.setScientificField(sf);
			}
			if (formField.getFieldId().equals("pdfText")) {
				thesis.setPdfText(formField.getFieldValue());
			}
			if (formField.getFieldId().equals("apstrakt")) {
				thesis.setSummary(formField.getFieldValue());
			}
		}
		
		return thesis;
	}

}
