package com.example.demo.entity;

public class ChickenResponse {
	
	private String chickeName;
	private Double price;
	private Long merchantId;
	private String productType;
	public String getChickeName() {
		return chickeName;
	}
	public void setChickeName(String chickeName) {
		this.chickeName = chickeName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "ChickenResponse [chickeName=" + chickeName + ", price=" + price + ", merchantId=" + merchantId
				+ ", productType=" + productType + "]";
	}
	
	
	
}