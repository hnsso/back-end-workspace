// 클래스 이름 : com.kh.practice.VariablePractice 
// FQCN(Fully Qualified Class Name)
package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		VariablePractice v = new VariablePractice();
//		v.method1();
//		v.method2();
		v.method3();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		
		int adultPrice = 10000;
		int teenPrice = 7000;
		int adultCount = 2;
		int teenCount = 3;
		
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		
		System.out.printf("성인 %d명 : %d원\n", adultCount, adultTotal);
		System.out.printf("청소년 %d명 : %d원\n\n", teenCount, teenTotal);
		System.out.printf("총 금액 : %d원", adultTotal + teenTotal);
		
	}
	
	// x=5, y=7, z=9의 값을 다음과 같이 출력하세요.
	public void method2() {

		int x = 5;
		int y = 7;
		int z = 9;
		
		int tmp = x;
		x = y;
		y = z;
		z = tmp;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
		
	}
	
	// 영어 문자열 값을 키보드로 입력 받아 문자에서 첫번째 글자와 마지막 글자를 출력하세요.
	public void method3() {
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		System.out.println("첫번째 문자 : " + str.charAt(0));
		System.out.println("마지막 문자 : " + str.charAt(str.length()-1));
	}

}