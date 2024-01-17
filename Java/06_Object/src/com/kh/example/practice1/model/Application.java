package com.kh.example.practice1.model;

import com.kh.example.practice1.model.Member;

public class Application {
	
	public static void main(String[] args) {
			Member m = new Member();
			
			m.changeName("김현수");
			m.printName();
	}
}