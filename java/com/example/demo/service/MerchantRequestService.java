package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MerchantRequest;

public interface MerchantRequestService {

	String buyProducts(String cartId, int deliveryAddressId);
	
	void getMerchantRequest(int merchantId);

}
