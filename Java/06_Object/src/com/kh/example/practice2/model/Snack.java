package com.kh.example.practice2.model;

// 임시 저장 공간 !!
// private 직접접근이 안된다 그래서 생성자 함수나 색터에 넣는다
public class Snack {

	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;
	
// 2기본 생성자 명시 : 
	public Snack() {
		
	}
// 3꽉 채워진 생성자 명시 :
	public Snack(String kind, String name, String flavor, int numOf, int price) {

		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;

	}
// getter 내가 가져오기 setter
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}
}
