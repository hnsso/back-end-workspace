package com.kh.inheritence.child;

import com.kh.inheritence.parent.Product;

public class Tv extends Product{

	public Tv(String brand, String pCode, String name, int price) {
		super(brand, pCode, name, price);
		// TODO Auto-generated constructor stub
	}

	private int inch; // 인치
	
}
