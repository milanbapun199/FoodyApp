package com.example.demo.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerEntity.Address;
import com.example.demo.customerRepo.AddressRepositary;
import com.example.demo.dto.OrderDetails;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepositary;

@RestController
public class MyOrderController {
	
	@Autowired
	ProductRepositary productRepositary;
	
	@Autowired
	AddressRepositary addressRepositary;
	
	@GetMapping("/findAllProductByOrderId") 
	public OrderDetails findAllProductByOrderId(@RequestParam("orderId") String orderId) {
		 List<Product> findAllProductByOrderId = productRepositary.findAllProductByOrderId(Integer.parseInt(orderId)); //correct
		 Address findAddressByOrderId = addressRepositary.findAddressByOrderId(Integer.parseInt(orderId));
		 OrderDetails orderDetails = new OrderDetails();
		 orderDetails.setProduct(findAllProductByOrderId);
		 orderDetails.setAddress(findAddressByOrderId);
		return orderDetails;
	}

}
