package com.kh.operator;

public class C_Arithmetic {

	/*
	 *	 산술 연산자
	 *	 + : 더하기
	 *	 - : 뻬기
	 *	 * : 곱하기
	 *	 / : 나누기
	 *	 % : 나머지
	 * 
	 * */
	
	public static void main(String[] args) {

		C_Arithmetic c = new C_Arithmetic();
		c.method1();
		c.method2();
	}
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 정수끼리 연산해서 3(3.3333)
		System.out.println(" % : " + (num1 % num2)); // 1 - 나머지
		
	}
	
	public void method2() {
		int a = 5 ; 
		int b = 10 ;
		int c = (++a) + b;  
		int d = c / a ; 
		int e = c % a ; 
		int f = e++; 
		int g = (--b) + (d--); 
		int h = 2;  
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
		
		System.out.println(i); 
	}
}
