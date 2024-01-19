package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();

	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		// 넓이 : 너비 * 높이 
		return r + " 넓이 : " +  (height *  width);
	}

	public String calcPerimeter(int x, int y, int height, int width) {
		
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		// 둘레 : 2 * (너비 + 높이)
		return r + " 둘레 : " +  (2 * (height +  width));
	}
	
}