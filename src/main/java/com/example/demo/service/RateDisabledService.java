package com.example.demo.service;

public interface RateDisabledService {
	
	public boolean disableRate(String merchantId, String productName);

	public boolean enableRate(String merchantId, String productName);
}
