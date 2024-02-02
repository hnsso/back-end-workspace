package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		CastingPractice c = new CastingPractice();
//		c.method1();
		c.method2();
	}
	
	// 키보드로 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	public void method1() {
		System.out.print("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		int num = ch;
		System.out.println(ch + " unicode : " + num);
		
		char ch2 = (char)(num + 1);
		System.out.println(ch2 + " unicode : " + (int)ch2);
	}
	
	// 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	public void method2() {
		System.out.print("국어 : ");
		int kScore = sc.nextInt();
		System.out.print("영어 : ");
		int eScore = sc.nextInt();
		System.out.print("수학 : ");
		int mScore = sc.nextInt();
		
		int sum = kScore + eScore + mScore;
		System.out.println("총점 : " + sum);
		System.out.printf("평균 : %.2f", (double)sum / 3);
	}
	
}