package com.kh.practice.controller;

import java.util.Scanner;


// 우리는 객체지향적인게 좋은 이유는 출력할때의 속도와 그리고 캡슐화로 인한 정교함이다 !! 가속성이 떨어짐 ... 
public class Application {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Application ac = new Application();

		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		boolean check = true;
		while(true) {
			System.out.println("1 . 마이 페이지");
			System.out.println("2 . 도사 대여하기");
			System.out.println("3 . 프로그램 종료");
		int menu = Integer.parseInt(sc.nextLine());
			
			
		switch(menu) {
		case 1 : 
			myPage();
			break;
		}
		
		}
		
		
	}
	
	public void myPage() {
		
	}
	
	
	
	
	
	
	
}