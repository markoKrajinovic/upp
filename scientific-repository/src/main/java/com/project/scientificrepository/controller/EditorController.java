package com.project.scientificrepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.scientificrepository.model.Thesis;
import com.project.scientificrepository.repository.ThesisRepository;

@RestController
@RequestMapping(value = "/editor")
public class EditorController {
	
	@Autowired
	private ThesisRepository thesisRepository;

	@RequestMapping(value = "/theses", method = RequestMethod.GET)
	public ResponseEntity<List<Thesis>> getTheses(){
	
		return new ResponseEntity<>(thesisRepository.findAll(), HttpStatus.OK);
	}
}
