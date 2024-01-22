package com.kh.composite.model;

	/*
	 * 모든 클래스는 Object 클래스의 후손이다.
	 * 즉, 최상위 클래스는 항상 Object이다.
	 * Object 클래스에 있는 모든 메서드를 사용할 수 있다.
	 * 
	 * */

// 3개의 클래스 모두 공통적으로 가지고 있는 요소만 추출하여 부모 클래스를 만든다.
// - 공통적으로 가진걸 부모 product 에 빼놓는다
public class Product /*extends Object*/ {
	
	private String brand; // 브랜드
	String pCode; // 상품코드
	protected String name; // 상품명
	private int price; // 가격
	
	// 기본 생성자
	public Product() {
	}

	// 오버 로딩은 같은 생성자 함수이지만 매개변수가 들어가있으면 오버 로딩이라고 한다
	
	// 이 생성자는 기본생성자가 무조건 필요하다 !
	public Product(String brand, String pCode, String name, int price) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [brand=" + brand + ", pCode=" + pCode + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
