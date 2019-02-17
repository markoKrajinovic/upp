package com.project.scientificrepository.config;

import javax.annotation.PostConstruct;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Data {

	
	@Autowired
	private IdentityService identityService;
	
	
	@PostConstruct
	private void init() {
		/*
		try {
			identityService.createGroupQuery().groupId("author").singleResult();
		} catch (NullPointerException e) {
			Group group = identityService.newGroup("author");
			identityService.saveGroup(group);
		}*/
		
	}
	
	@SuppressWarnings("unused")
	private void smece(){
/*
		keyWordRepository.deleteAll();
		authorRepository.deleteAll();
		magazineRepository.deleteAll();
		fieldRepository.deleteAll();
		thesisRepository.deleteAll();
		
		KeyWord word1 = new KeyWord();
		word1.setWord("matematika");
		keyWordRepository.save(word1);
		
		KeyWord word2 = new KeyWord();
		word2.setWord("laplas");
		keyWordRepository.save(word2);
		
		Author author = new Author();
		author.setFirstName("Marko");
		author.setLastName("Krajinovic");
		author.seteMail("marko.krajinovic@gmail.com");
		author.setAddress("Novosadskog Sajma 231");
		author.setCity("Novi Sad");
		author.setCountry("Srbija");
		authorRepository.save(author);
		
		ScientificField math = new ScientificField();
		math.setFieldName(FIELD_NAME.Mathematics);
		fieldRepository.save(math);
		
		ScientificField psychology = new ScientificField();
		psychology.setFieldName(FIELD_NAME.Psychology);
		fieldRepository.save(psychology);
		
		Magazine magazine1 = new Magazine();
		magazine1.setName("Obican Magazin");
		magazineRepository.save(magazine1);
		
		Magazine magazine2 = new Magazine();
		magazine2.setName("Neki Drugi Magazin");
		magazineRepository.save(magazine2);
		
		
		Thesis thesis = new Thesis();
		thesis.setTitle("Markova doktorska disertacija");
		thesis.setSummary("vrlo bitan naucni rad");
		thesis.setScientificField(math);
		thesis.getMagazines().add(magazine1);
		thesis.getMagazines().add(magazine2);
		thesis.setAuthor(author);
		thesis.getKeyWords().add(word1);
		thesis.getKeyWords().add(word2);
		thesis.setPdfText("Moj probni pdf tekst koji ne kaze nista pametno");
		thesisRepository.save(thesis);
		
		Thesis thesis2 = new Thesis();
		thesis2.setTitle("Tuzna Disertacija");
		thesis2.setSummary("jako tuzna prica");
		thesis2.setScientificField(psychology);
		thesis2.getMagazines().add(magazine2);
		thesis2.getKeyWords().add(word2);
		thesis2.setPdfText("Moj drugi probni pdf tekst...");
		thesisRepository.save(thesis2);
		*/
		//math.getTheses().add(thesis);
		//fieldRepository.save(math);
	}
}
