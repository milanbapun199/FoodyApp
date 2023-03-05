package com.example.demo.TwilioController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.TwilioModel.VerificationResult;
import com.example.demo.TwilioService.PhoneVerificationService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class TwilioController {
	
	@Autowired
	PhoneVerificationService phoneVerificationService;
	
	@PostMapping("/sendotp")
	public ResponseEntity<String> sendOtp(@RequestParam("phoneNo") String phonNo) {
		System.out.println("enetr into contoller");
		VerificationResult result=phoneVerificationService.startVerifiction("+91"+phonNo);
		if(result.isValid()) {
			return new ResponseEntity<>("OTP sent", HttpStatus.OK);
		}
		return new ResponseEntity<>("OTP failed to sent", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/verifyOtp")
	public ResponseEntity<String> verifyOtp(@RequestParam("phoneNo") String phonNo, @RequestParam("otp") String otp) {
		System.out.println("enetr into contoller");
		VerificationResult result=phoneVerificationService.checkVerification("+91"+phonNo, otp);
		System.out.println(result);
		if(result.isValid()) {
			System.out.println("verified");
			return new ResponseEntity<>("Your number is verified", HttpStatus.OK);
		}
		System.out.println("not veridfied");
		return new ResponseEntity<>("Incorrect OTP", HttpStatus.BAD_REQUEST);
	}
}
