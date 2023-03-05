package com.example.demo.entity;

public class EggResponse {
	
	private String productType;
	private String EggName;
	private Double price;
	private Long merchantId;
	public String getEggName() {
		return EggName;
	}
	public void setEggName(String eggName) {
		EggName = eggName;
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
		return "EggResponse [productType=" + productType + ", EggName=" + EggName + ", price=" + price + ", merchantId="
				+ merchantId + "]";
	}
	
	
}
