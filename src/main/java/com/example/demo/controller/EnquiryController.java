package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Enquiry;
import com.example.demo.repo.EnquiryRepositary;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EnquiryController {
	@Autowired
	EnquiryRepositary enquiryRepositary;
	@PostMapping("/enquiry-us" )
	  public ResponseEntity<Enquiry> createTutorial(@RequestBody Enquiry enquiry) {
	    try {
	    	Enquiry _enquiry = enquiryRepositary
	          .save(enquiry);
	      return new ResponseEntity<>(_enquiry, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
