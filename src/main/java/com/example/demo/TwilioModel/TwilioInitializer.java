package com.example.demo.TwilioModel;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	
	private final TwilioProperties twilioProperties;
	
	public TwilioInitializer(TwilioProperties twilioProperties) {
		this.twilioProperties=twilioProperties;
		Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
		System.out.println("Twilo initialized with account"+twilioProperties.getAccountSid());
	}
	
}
