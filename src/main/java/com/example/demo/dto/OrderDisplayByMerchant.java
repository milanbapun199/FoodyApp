package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Product;

public class OrderDisplayByMerchant {
	private String customerName;
	private DeliveryAddressInformation deliveryAddress; 
	private List<Product> products;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public DeliveryAddressInformation getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(DeliveryAddressInformation deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "OrderDisplayByMerchant [customerName=" + customerName + ", products=" + products + "]";
	}
	

}
