package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleController {

	private Circle c = new Circle();
		
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		// 넓이 : PI * 반지름 * 반지름
		return c + " 넓이 : " +  (Math.PI * radius * radius);
	}
//	 c  =변환= "위치 : (" + x + ", " + y + "), 반지름 : " + radius + " / " + " 넓이 : "
	public String calcCircum(int x, int y, int radius) {

		c.setX(x); // 초기화 셋팅
		c.setY(y); // ==
		c.setRadius(y); // ==

		// 둘레 : PI * 반지름 * 2
		return c + "둘레 : " +  (Math.PI * radius * 2) ;
	}
}
