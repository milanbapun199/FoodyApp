package com.example.demo.customerEntity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.entity.Product;

@Entity
@Table(name = "customer")
public class Customer {
	
	public Customer() {
		
	}
	
	
	public Customer(Long customerId, String customerName, String mobNo, String email, String password, String userName,
			String confirmPassword, List<Address> address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobNo = mobNo;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.confirmPassword = confirmPassword;
		this.address = address;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "name")
	private String customerName;
	@Column(name = "mob_no")
	private String mobNo;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "retype_password")
	private String confirmPassword;
	
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId",referencedColumnName = "customer_id")
	private List<Address> address;
	
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", mobNo=" + mobNo + ", email="
				+ email + ", password=" + password + ", userName=" + userName + ", confirmPassword=" + confirmPassword
				+ ", address=" + address + "]";
	}
	
	
}

