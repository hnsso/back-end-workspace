package com.kh.practice1;

public class C_UnCheckedException {

	/*
	 *	UnCheckedException
	 * 	- RuntimeException을 상속하고 있는 예외들
	 *  - 컴파일 시 예외 처리 코드가 이는지 검사하지 않는 예외
	 *  - RuntimeException의 경우 프로그램 실행할 때 문제가 발생될 것을
	 *    충분히 예측 가능해서 조건문 등을 통해 처리 가능
	 * */
	
	public static void main(String[] args) {

			C_UnCheckedException c = new C_UnCheckedException();
			c.method1();
			c.method2();
			c.method3();
	}
	// ArrayIndeOutOfBoundsException : 배열의 접근에 잘 못된 인덱스 값을 사용하는 경우 예외 발생 
	public void method1() {
		String[] str = {"Hello Java", "Nice to meet you", "No I mean It"};
		
//		for(int i=0; i<=3; i++) {
//			try {
//				System.out.println(str[i]);
//			}catch() {
//				
//				System.out.println(e.getMessge);
//			}
//	// NehativeArraySizeException
	public void method2() {
		try {
		int[] arr = new int[-3];
		} catch()
	
	}
}

