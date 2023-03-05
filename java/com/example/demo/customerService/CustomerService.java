package com.example.demo.customerService;

import com.example.demo.customerEntity.Customer;
import com.example.demo.entity.UserLogin;
import com.example.demo.vo.CustomerLoginInfo;

public interface CustomerService {
	public Customer customerAddressUpdate(Customer customer);

	public CustomerLoginInfo logInCustomer(UserLogin customerLogin);
}
