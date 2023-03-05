package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_request")
public class MerchantRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "merchant_request_id")
	private int merchantRequestId;
	@Column(name = "merchant_id")
	private int merchantId;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "cart_id")
	private int cartId;
	@Column(name = "pid")
	private int pId;
	@Column(name = "product_status")
	private String productStatus;
	@Column(name = "delivery_address_id")
	private int deliveryAddressId;
	public int getMerchantRequestId() {
		return merchantRequestId;
	}
	public void setMerchantRequestId(int merchantRequestId) {
		this.merchantRequestId = merchantRequestId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
	public int getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(int deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}
	@Override
	public String toString() {
		return "MerchantRequest [merchantRequestId=" + merchantRequestId + ", merchantId=" + merchantId
				+ ", customerId=" + customerId + ", cartId=" + cartId + ", pId=" + pId + ", productStatus="
				+ productStatus + ", deliveryAddressId=" + deliveryAddressId + "]";
	}
	
	
}
