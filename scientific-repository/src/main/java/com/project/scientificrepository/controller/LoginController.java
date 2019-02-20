package com.project.scientificrepository.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.scientificrepository.dto.LoginDto;
import com.project.scientificrepository.dto.Token;
import com.project.scientificrepository.model.Author;
import com.project.scientificrepository.model.Editor;
import com.project.scientificrepository.model.Reviewer;
import com.project.scientificrepository.repository.AuthorRepository;
import com.project.scientificrepository.repository.EditorRepository;
import com.project.scientificrepository.repository.ReviewerRepository;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private EditorRepository editorRepository;
	
	@Autowired
	private ReviewerRepository reviewerRepository;

	@RequestMapping(value = "/author", method = RequestMethod.POST)
	public ResponseEntity<Token> loginAuthor(@RequestBody LoginDto loginDto){
		Optional<Author> author = authorRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if(author.isPresent())
			return new ResponseEntity<>(new Token(author.get().getUsername(), "author"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/reviewer", method = RequestMethod.POST)
	public ResponseEntity<Token> loginReviewer(@RequestBody LoginDto loginDto){
		Optional<Reviewer> reviewer = reviewerRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if(reviewer.isPresent())
			return new ResponseEntity<>(new Token(reviewer.get().getUsername(), "reviewer"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/editor", method = RequestMethod.POST)
	public ResponseEntity<Token> loginEditor(@RequestBody LoginDto loginDto){
		Optional<Editor> editor = editorRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		
		if(editor.isPresent())
			return new ResponseEntity<>(new Token(editor.get().getUsername(), "editor"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);	}
}
