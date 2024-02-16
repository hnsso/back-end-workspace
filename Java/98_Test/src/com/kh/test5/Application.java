package com.kh.test5;

import java.util.ArrayList;
import java.util.List;

import com.kh.test5.model.Fruit;

public class Application {

	Application app = new Application();
	
	public static void main(String[] args) {
		
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보락"));
		
//		list.add(new Fruit("바나나"));  이거 지워도 괜찮음 !
		// 출제 의도에 따른 여러가지 방식이 있다 !! 
		
		for(int i=0; i < list.size(); i ++) {
			
			System.out.println(list.get(i).getName());
		
		}
	}
	
}
