package com.kh.example.practice4.model;

public class Circle extends Point {

	private int radius;

	public Circle() {
	}

	public Circle(int radius, int x, int y) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "위치 : (" + super.getX() + ", " + super.getY() + ")," + "반지름 : " + radius + " / ";
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
