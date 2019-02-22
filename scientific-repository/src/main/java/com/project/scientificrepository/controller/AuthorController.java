package com.project.scientificrepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.scientificrepository.dto.Token;
import com.project.scientificrepository.model.Thesis;
import com.project.scientificrepository.repository.ThesisRepository;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {
	
	@Autowired
	private ThesisRepository thesisRepository;

	
	@RequestMapping(value = "/my-theses", method = RequestMethod.POST)
	public ResponseEntity<List<Thesis>> getMyTheses(@RequestBody Token token){
		
		return new ResponseEntity<>(thesisRepository.findByAuthorUsername(token.getUsername()), HttpStatus.OK);
	}
}
