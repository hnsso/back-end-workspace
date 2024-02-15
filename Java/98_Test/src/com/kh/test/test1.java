package com.kh.test;

import java.util.Scanner;

public class test1 {

//	사용자에게 문자열을 입력 받아 그 문자열의 길이를 출력하고, 
//	입력한 문자열이 "exit"면 본 프로그램을 종료하도록 만들고 싶다. 
//	하지만 코드의 일부분 때문에 본 의도대로 프로그램이 제대로 돌지 않는다.
//	아래의 코드를 보고 문제점이 있는 부분을 찾아 파악된 문제점을 
//	[원인](15점)에 기술하고, 각 문제점을 해결한 전체 코드를 [조치내용](15점)에 작성하시오. (30점)
//	
//	[정상 실행 결과 예시]
//	문자열을 입력해주세요 : Hello
//	5글자 입니다.
//	문자열을 입력해주세요 : World
//	5글자 입니다.
//	문자열을 입력해주세요 : Hello World
//	11글자 입니다.
//	문자열을 입력해주세요 : 자바
//	2글자 입니다.
//	문자열을 입력해주세요 : exit
//	프로그램을 종료합니다.
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

	test1 t1 = new test1();
	
	System.out.println("문자열을 입력해주세요 : ");
	String str = sc.nextLine();
		
		
		
	}

}
