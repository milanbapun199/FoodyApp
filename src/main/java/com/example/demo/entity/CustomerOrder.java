package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custorderId;
	
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "order_status")
	private String orderStatus;
	


	public int getCustorderId() {
		return custorderId;
	}

	public void setCustorderId(int custorderId) {
		this.custorderId = custorderId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "CustomerOrder [custorderId=" + custorderId + ", cartId=" + cartId + ", orderStatus=" + orderStatus
				+ "]";
	}

	
}
