package com.example.demo.dto;

public class DeliveryAddressInformation {
	private String area;
	private String landmark;
	private String pin;
	private String mobNo;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	@Override
	public String toString() {
		return "DeliveryAddressInformation [area=" + area + ", landmark=" + landmark + ", pin=" + pin + ", mobNo="
				+ mobNo + "]";
	}
	
}
