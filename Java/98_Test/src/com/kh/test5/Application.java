package com.kh.test5;

import java.util.ArrayList;
import java.util.List;

public class Application {

	Application app = new Application();
	
	public static void main(String[] args) {
		
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보락"));
		list.add(new Fruit("바나나"));
		
		for(int i=0; i< list.lenght; i ++) {
			
			System.out.println(list[i].getName());
		
		}
	}
	
}
