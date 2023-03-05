package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Enquiry;
import com.example.demo.entity.RateDisabled;
import com.example.demo.repo.EnquiryRepositary;
import com.example.demo.repo.RateDisabledRepositary;
import com.example.demo.service.RateDisabledService;

@RestController
public class RateDisabledController {
	
	@Autowired
	RateDisabledService rateDisabledService;
	
	@GetMapping("/disableRate" )
	  public boolean disableRate(@RequestParam("merchantId") String merchantId , @RequestParam ("productName") String productName) {
		return rateDisabledService.disableRate(merchantId,productName);
	  }
	@GetMapping("/enableRate" )
	  public boolean enableRate(@RequestParam("merchantId") String merchantId , @RequestParam ("productName") String productName) {
		return rateDisabledService.enableRate(merchantId,productName);
	  }

}
