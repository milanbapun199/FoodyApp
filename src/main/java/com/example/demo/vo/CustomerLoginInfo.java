package com.example.demo.vo;

import java.util.List;

import com.example.demo.customerEntity.Address;

public class CustomerLoginInfo {
	private Long customerId;
	private String customerName;
	private String mobNo;
	private String email;
	private String password;
	private String userName;
	private boolean loggedin;
	private List<Address> address;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public boolean isLoggedin() {
		return loggedin;
	}
	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}
	@Override
	public String toString() {
		return "CustomerLoginInfo [customerId=" + customerId + ", customerName=" + customerName + ", mobNo=" + mobNo
				+ ", email=" + email + ", password=" + password + ", userName=" + userName + ", loggedin=" + loggedin
				+ ", address=" + address + "]";
	}
	
	
	

}
