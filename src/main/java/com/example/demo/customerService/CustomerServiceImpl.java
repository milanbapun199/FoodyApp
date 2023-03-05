package com.example.demo.customerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customerEntity.Address;
import com.example.demo.customerEntity.Customer;
import com.example.demo.customerRepo.CustomerRepositary;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLogin;
import com.example.demo.vo.CustomerLoginInfo;
import com.example.demo.vo.MerchantLoginInfo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepositary customerRepositary;

	@Override
	public Customer customerAddressUpdate(Customer customer) {
		System.out.println("from customer");
		Customer _existingcustomer = customerRepositary.findById(customer.getCustomerId()).orElse(null);
		List<Address> _existingAddress = _existingcustomer.getAddress();
		_existingAddress.addAll(customer.getAddress());
		_existingcustomer.setAddress(_existingAddress);
		_existingcustomer.setCustomerName(customer.getCustomerName());
		_existingcustomer.setMobNo(customer.getMobNo());
		_existingcustomer.setEmail(customer.getEmail());
		Customer updateCustomer = customerRepositary.save(_existingcustomer);
		System.out.println(updateCustomer);
		List<Address> address = updateCustomer.getAddress();
		for(Address a: address) {
			System.out.println(a.getArea());
		}
		return updateCustomer;
	}

	@Override
	public CustomerLoginInfo logInCustomer(UserLogin customerLogin) {
		Customer existingCustomer = customerRepositary.findByuserName(customerLogin.getUserName());
		CustomerLoginInfo customer=new CustomerLoginInfo();
		if(existingCustomer == null) {
			customer.setUserName("Invalid Username");
			return customer;
		}else {
//			System.out.println("username is exist");
			if(existingCustomer.getPassword().equals(customerLogin.getPassword())) {
				//set all User data into LoginInfo object
				customer.setCustomerId(existingCustomer.getCustomerId());
				customer.setCustomerName(existingCustomer.getCustomerName());
				customer.setEmail(existingCustomer.getEmail());
				customer.setMobNo(existingCustomer.getMobNo());
				customer.setLoggedin(true);
				customer.setAddress(existingCustomer.getAddress());
			}else {
				//password invalid
				customer.setPassword("Invalid Password");
			}
			return customer;
		}
	}

}
