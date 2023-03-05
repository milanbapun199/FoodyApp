package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate_disabled")
public class RateDisabled {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rate_id")
	private Long rateId;
	@Column(name = "merchant_id")
	private Long merchantId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "rate_status")
	private String rateStatus;
	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRateStatus() {
		return rateStatus;
	}
	public void setRateStatus(String rateStatus) {
		this.rateStatus = rateStatus;
	}
	@Override
	public String toString() {
		return "RateDisabled [rateId=" + rateId + ", merchantId=" + merchantId + ", productName=" + productName
				+ ", rateStatus=" + rateStatus + "]";
	}

	
	
}
