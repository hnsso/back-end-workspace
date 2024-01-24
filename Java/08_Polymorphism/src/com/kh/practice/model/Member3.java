package com.kh.practice.model;

import java.util.Arrays;

// model class : 캡슐화 !!! <- 변수 private! 설정하는 순간 
// 클래스 내에서만 가능한게 private
public class Member3 {

	private String name = "";
	private int age = 0;
	private int coupon = 0;
	private Book3[] bookList = new Book3[3];

	public String getName() { 
		return name; // 리턴은 값을 그대로 전달한다라는 뜻이다
	}

	
	// 입력만 넣는 친구이다 반환 할게 없다 그래서 리턴이 없다 !근데 값을 받아야하니깐 매개변수가 있어야한다
	public void setName(String name) { 
		this.name = name;    // this 본인의 이름을 받은걸 넣겠다라는 뜻이다 !!
	}
	

	@Override
	public String toString() {
		return "Member3 [name=" + name + ", age=" + age + ", coupon=" + coupon + ", bookList="
				+ Arrays.toString(bookList) + "]";
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getCoupon() {
		return coupon;
	}


	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}


	public Book3[] getBookList() {
		return bookList;
	}


	public void setBookList(Book3[] bookList) {
		this.bookList = bookList;
	}


}
