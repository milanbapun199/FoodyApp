package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int customerId;
	private String cartStatus;
	
	@OneToMany(targetEntity = Product.class)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "cartId",referencedColumnName = "cartId")
	private List<Product> products;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, int customerId, String cartStatus, List<Product> products) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.cartStatus = cartStatus;
		this.products = products;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", cartStatus=" + cartStatus + ", products="
				+ products + "]";
	}
	
	
}
