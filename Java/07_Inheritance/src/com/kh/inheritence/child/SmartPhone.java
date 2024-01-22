package com.kh.inheritence.child;

import com.kh.inheritence.parent.Product;

public class SmartPhone extends Product {

	private String mobileAgecy;
	
	public SmartPhone() {
	}

	public SmartPhone(String brand, String pCode, String name, int price, String mobileAgency) {
		super(brand, pCode, name, price);
		this.mobileAgecy = mobileAgency;

	}

	public String getMobileAgecy() {
		return mobileAgecy;
	}

	public void setMobileAgecy(String mobileAgecy) {
		this.mobileAgecy = mobileAgecy;
	}

	@Override
	public String toString() {
		return super.toString() + ", SmartPhone [mobileAgecy=" + mobileAgecy + "]";
	}


}
