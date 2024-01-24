package com.kh.practice.model;

public class Book3 {
	private String title;
	private boolean coupon;
	private int accessAge;
	
	public Book3(String title, boolean coupon) {
		this.title = title;
		this.coupon = coupon;
	}
	
	public Book3(String title, int accessAge) {
		this.title = title;
		this.accessAge = accessAge;
	}
	
	@Override
	public String toString() {
		return "Book3 [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
	
	
}
