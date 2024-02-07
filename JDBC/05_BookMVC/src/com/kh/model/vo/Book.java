package com.kh.model.vo;

// VO(Value Object) : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

// 쿠팡 : 테이블 하나의 vo 하나
// 1번째 모델들의 
// 

public class Book {

	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;
	// 하는이유는 상속관계이기(Forginkey) 때문에 !!
	private Publisher Publisher;

	public Book() {

	}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, com.kh.model.vo.Publisher publisher) {
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		Publisher = publisher;
	}
	// rentcontroller 에 2번 !!
	public Book(String bkTitle, String bkAuthor) {
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}

	public Publisher getPublisher() {
		return Publisher;
	}

	public void setPublisher(Publisher publisher) {
		Publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", bkPrice=" + bkPrice
				+ ", Publisher=" + Publisher + "]";
	}

}
