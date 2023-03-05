package com.example.demo.dto;

import java.util.List;

import com.example.demo.customerEntity.Address;
import com.example.demo.entity.Product;

public class OrderDetails {
	private List<Product> product;
	private Address address;
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderDetails [product=" + product + ", address=" + address + "]";
	}
	
	
}
