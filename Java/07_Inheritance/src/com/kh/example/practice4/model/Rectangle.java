package com.kh.example.practice4.model;

public class Rectangle extends Point {
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(int width, int height, int x, int y) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + " 너비 : " 
				+ width + ", 높이 : " + height +  " / " ;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
