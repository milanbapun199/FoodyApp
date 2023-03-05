package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MerchantRequest;
import com.example.demo.service.MerchantRequestService;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class MerchantRequestController {
	@Autowired
	MerchantRequestService merchantRequestService;
	
	@GetMapping("/buyProducts" )
	public String buyProducts(@RequestParam("cartId") String cartId, @RequestParam("deliveryAddressId") String deliveryAddressId) {
		String orderId = merchantRequestService.buyProducts(cartId, Integer.parseInt(deliveryAddressId));
		return orderId;
	}
	
	@GetMapping("/getMerchantRequest" )
	public  void getMerchantRequest(@RequestParam("merchantId") String merchantId) {
		merchantRequestService.getMerchantRequest(Integer.parseInt(merchantId));
	}
	
}
