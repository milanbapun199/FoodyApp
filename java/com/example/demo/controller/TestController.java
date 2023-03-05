package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.repo.CartRepositary;

@RestController
public class TestController {
	@Autowired
	CartRepositary cartRepositary;
	
	@GetMapping("/updateCartStatus") 
	public void updateCartStatus(@RequestParam("cartId") String cartId) {
		 cartRepositary.updateCartStatus(Integer.parseInt(cartId));
	}
}
