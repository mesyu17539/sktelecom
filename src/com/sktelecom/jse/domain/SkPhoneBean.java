package com.sktelecom.jse.domain;

public class SkPhoneBean {
	private String brand, number, mcount;//mcount 키 역할
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) { 
		this.brand = brand;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	public String getMcount() {
		return mcount;
	}
	public void setMcount(String mcount) {
		this.mcount = mcount;
	}
}
