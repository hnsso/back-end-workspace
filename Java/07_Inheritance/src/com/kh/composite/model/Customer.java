package com.kh.composite.model;

/*
 * 클래스 간의 관계 : 상속 vs 포함
 * 
 * */


public class Customer {
	protected String name; // 고객 이름
	protected String grade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio;// 포인트 적립 비율
	
	
	public Customer() {
		System.out.println("기본 생성자로 만듦! ");
	}
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
	}

	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}

	@Override // 어노테이션 ! '이 메서드는 재정의된 메서드이다.' 라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;   // 다향성! => obj; 를 customer로 형변환 
		return this.name == c.name;  // equals 이름이 같은면 같은사람으로 하겠다고 함
	}
	public int calcprice(int price) {
		this.bonusPoint += price * bonusRatio;// 보너스 포인트 계산
		return price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	
	
}
