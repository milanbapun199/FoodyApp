package com.example.demo.TwilioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TwilioModel.TwilioProperties;
import com.example.demo.TwilioModel.VerificationResult;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

@Service
public class PhoneVerificationService {
	
	private final TwilioProperties twilioProperties;
	
	@Autowired
	public PhoneVerificationService(TwilioProperties twilioProperties) {
		this.twilioProperties = twilioProperties;
	}
	//method to send OTP
	
	public VerificationResult startVerifiction(String phoneNo) {
		try {
			System.out.println("enetr into service");
			System.out.println("servcieId: "+twilioProperties.getServiceId());
			System.out.println("phoneNo: "+phoneNo);
			Verification verification = Verification.creator(twilioProperties.getServiceId(), phoneNo, "sms").create();
			System.out.println("verification status: "+verification.getStatus());
			if("approved".equals(verification.getStatus()) || "pending".equals(verification.getStatus())) {
				System.out.println("enter into approved or pending state");
				System.out.println("verification result: "+verification.getSid());
				return new VerificationResult(verification.getSid());
			}
		}
		catch (ApiException e) {
			System.out.println("got error from approved or pending state");
			System.out.println(e.getMessage());
			System.out.println(e);
			return new VerificationResult(new String[] {e.getMessage()});
		}
		return null;
	}
	
	//method to verify the OTP
	public VerificationResult checkVerification(String phoneNo, String otp) {
		try {
//			System.out.println("enetr into service");
//			System.out.println("servcieId: "+twilioProperties.getServiceId());
//			System.out.println("phoneNo: "+phoneNo);
			VerificationCheck verification = VerificationCheck.creator(twilioProperties.getServiceId(), otp).setTo(phoneNo).create();
			System.out.println("verification status: "+verification.getStatus());
			if("approved".equals(verification.getStatus())) {
				System.out.println("enter into approved");
				System.out.println("verification result: "+verification.getSid());
				return new VerificationResult(verification.getSid());
			}
			return new VerificationResult(new String[] {"Invalid OTP"});
		}
		catch (ApiException e) {
			System.out.println("got error from approved or pending state");
			System.out.println(e.getMessage());
			System.out.println(e);
			return new VerificationResult(new String[] {e.getMessage()});
		}
	}
	
	
}
