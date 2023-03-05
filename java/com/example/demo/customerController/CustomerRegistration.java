package com.example.demo.customerController;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customerEntity.Address;
import com.example.demo.customerEntity.Customer;
import com.example.demo.customerRepo.AddressRepositary;
import com.example.demo.customerRepo.CustomerRepositary;
import com.example.demo.customerService.CustomerService;
import com.example.demo.dto.CartRequest;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.UserLogin;
import com.example.demo.vo.CustomerLoginInfo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRegistration {
	
	@Autowired
	CustomerRepositary customerRepositary;
	
	@Autowired
	AddressRepositary addressRepositary;
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer" )
	  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		ResponseEntity<Customer> responseEntity =null;
	    try {
	    	String _customerMobNo=customer.getMobNo();
	    	String _customerUserName=customer.getUserName();
	    	Customer findByMobNo = customerRepositary.findByMobNo(_customerMobNo);
	    	Customer findByUserName = customerRepositary.findByUserName( _customerUserName);
	    	System.out.println(findByMobNo);
	    	System.out.println(findByUserName);
	    	if(findByMobNo == null && findByUserName==null) {
	    		System.out.println("created");
	    		Customer _customer = customerRepositary
	    				.save(customer);
	    		responseEntity= new ResponseEntity<>(_customer, HttpStatus.CREATED); 
	    	}
	    	else if(findByMobNo !=null && findByUserName !=null){
	    		findByMobNo.setMobNo("mobileNo exist");
	    		findByMobNo.setUserName("userName is exist");
	    		responseEntity= new ResponseEntity<>(findByMobNo, HttpStatus.OK); 
	    	}
	    	else if(findByMobNo != null) {
	    		findByMobNo.setMobNo("mobileNo exist");
	    		responseEntity= new ResponseEntity<>(findByMobNo, HttpStatus.OK); 
	    	}else if(findByUserName != null) {
	    		findByUserName.setUserName("userName exist");
	    		responseEntity= new ResponseEntity<>(findByUserName, HttpStatus.OK); 
	    	}
	    	 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return responseEntity;
	  }
	
	@PutMapping("/customerAddressUpdate") 
	public Customer customerAddressUpdate(@RequestBody Customer customer) {
		Customer customerAddressUpdate = customerService.customerAddressUpdate(customer);
		return customerAddressUpdate;
	}
	
	@PostMapping("/customer-login" )
	  public CustomerLoginInfo logInUser(@RequestBody UserLogin customerLogin) {
		return customerService.logInCustomer(customerLogin);
		
	  }
	
	@GetMapping("/getCustomer" )
	  public Customer getCustomer(@RequestParam("customerId") String customerId) {
		Customer customer = customerRepositary.findById(Long.parseLong(customerId)).orElse(null);
		System.out.println(customer);
		List<Address> address = customer.getAddress();
		for(Address a: address) {
			System.out.println(a.getArea());
		}
		return customer;
	  }
	
	@Transactional
	@GetMapping("/deleteCustomerAddress" )
	  public Customer deleteCustomerAddress(@RequestParam("addressId") String addressId, @RequestParam("customerId") String customerId) {
			addressRepositary.deleteById(Long.parseLong(addressId));
			Customer customer = customerRepositary.findById(Long.parseLong(customerId)).orElse(null);
		return customer;
	  }
}
