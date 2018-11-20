package com.qa.SweetSpot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.SweetSpot.exception.ResourceNotFoundException;
import com.qa.SweetSpot.mySpringBootDatabaseApp.Users;
import com.qa.SweetSpot.repository.*;

@RestController
@RequestMapping("/api")
public class SpringBootController {

	@Autowired
	personRepository myRepository;
	
	//Method to create a person
	@PostMapping("/person")
	public Users createPerson(@Valid @RequestBody Users mSDM) {
		return myRepository.save(mSDM);
	}
	
	//Get a person by ID
	@GetMapping("/person/{id}")
	public Users getPersonByID(@PathVariable(value = "id")Long personID) {
		return myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("mySpringBootDataModel", "id", personID));
	}
	
	@GetMapping("/person")
	public List<Users> getPersonByID() {
		return myRepository.findAll();
	}
	
}
