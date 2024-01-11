package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if(조건식){ 조건식이 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 */

	public void method1() {

		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력

		System.out.println("성적을 입력 : ");
//		int score = sc.nextInt()
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) { // 권장 !
			System.out.println("합격입니다");
			System.out.println("축하합니다");
		}

		// 한줄로만 들어갔을때는 유용 !
		if (score >= 60)
			System.out.println("합격입니다");

		if (score >= 60)
			System.out.println("합격입니다"); // 비추천!
		System.out.println("축하합니다22"); // if문 바깥에 있는 걸로 인식
	}

	/*
	 * if-else 문
	 * 
	 * if(조건식) { 조건식이 참(true)일 때 실행 } else { 조건식이 거짓(false)일 때 실행 }
	 * 
	 */
	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다" ,
		// 아니면 "불합격입니다"를 출력
		System.out.println("성적을 입력 : ");
		int score = Integer.parseInt(sc.nextLine());

		if (score >= 60) { // 권장 !
			System.out.println("합격입니다");
		} else {
			System.out.println("불합격입니다");
		}

		// 삼항연산자

		String result = score >= 60 ? "합격입니다" : "불합격입니다";
		System.out.println(result);

	}

	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다" , 아니면 "본인이 아니다"를 출력
		System.out.println("본인의 이름을 입력 :");
		String name = sc.nextLine();

		System.out.println("name의 주소값 : " + System.identityHashCode("김현수"));
		System.out.println("본인의이름 주소값 : " + System.identityHashCode("김현수"));
		System.out.println(name == "김현수"); // false
		// String -> 참조형 변수 (클래스 변수)는 주소값을 저장!
		System.out.println(name.equals("김현수")); // true

		// 문자열 조건은 equals 를 사용한다 !!!!
		if (name.equals("김현수")) {
			System.out.println("본인이다");
		} else {
			System.out.println("본인이 아니다");
		}

	}

	public void method4() {

		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력

		System.out.println("숫자를 입력 :");
		int number = Integer.parseInt(sc.nextLine());

		// 삼항 연산자

//		String result = number > 0 ? "양수" : munber == 0 ? "0이다" : "음수";

		// if문
		if (number > 0) {
			System.out.println("양수");
		} else {
			if (number == 0) { // if문은 중첩 가능!
				System.out.println("0이다");
			} else {
				System.out.println("음수");
			}
		}

	}
	/*
	 * if-else if-else문
	 * 
	 * if(조건식1){ 조건식1이 참(true)일 때 실행 }else if(조건식2){ 조건식1이 거짓(false)이면서 조건식2가
	 * 참(true)일 때 실행 } else { 조건식1, 조건식2 모두 거짓(false)일 때 실행 }
	 * 
	 * - else if 수는 제한이 없다
	 * 
	 */

	public void method5() {
		System.out.println("숫자를 입력 :");
		int number = Integer.parseInt(sc.nextLine());

		// if~else --> if~else if~else로 변경!

		if (number > 0) {
			System.out.println("양수");
		} else if (number == 0) {
			System.out.println("0이다");
		} else {
			System.out.println("음수");
		}
	}

	/*
	 * 사용자에게 점수(0~100)를 입력받아서 점수별 등급을 출력 - 90점 이상은 A 등급 - 90점 미만 80점 이상은 B 등급 - 80점
	 * 미만 70점 이상은 C 등급 - 70점 미만 60점 이상은 D 등급 - 60점 미만 F등급
	 * 
	 */

	public void practice1() {

		System.out.println("사용자 점수 : ");
		int grade = Integer.parseInt(sc.nextLine());

		if (grade >= 90) {
			System.out.println("A등급");
		} else if (grade >= 80) {
			System.out.println("B등급");
		} else if (grade >= 70) {
			System.out.println("C등급");
		} else if (grade >= 60) {
			System.out.println("D등급");
		} else {
			System.out.println("F등급");
		}
		
//		위 방식은 String으로 변수에 값을 지정하고 한 구문 !!!
//		String score = "";
//
//		if (grade >= 90) {
//			score = "A";
//		} else if (grade >= 80) {
//			score = "B";
//		} else if (grade >= 70) {
//			score = "C";
//		} else if (grade >= 60) {
//			score = "D";
//		} else {
//			score = "F";
//		} 

	}

	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 > 3 num2 입력 > 4 num3 입력 > 6
	 * 
	 * 4 6
	 * 
	 */

	public void practice2() {
		
		// if문 하나가지고 !! 비추천
		
		System.out.println("num1 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.println("num2 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.println("num3 입력 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		
		if (num1 % 2 == 0) 
			System.out.println(num1);
		

		if (num2 % 2 == 0) 
			System.out.println(num2);
		

		if (num3 % 2 == 0) 
			System.out.println(num3);
		

	}

	/*
	 * 정수 1개 입력했을 때 음(minus)/양(plus)/0(zere), 짝(even)/홀(odd) 출력
	 * 
	 * 정수 입력 > -3 minus odd
	 */
	
	// 이문제도 String 변수로 값을 넣어서 문을 만들수 있다 !!
	public void practice3() {
		System.out.println("정수를 입력 >");
		int num1 = Integer.parseInt(sc.nextLine());

		if (num1 < 0) {
			System.out.println("minus");
		} else if (num1 > 0) {
			System.out.println("plus");
		} else {
			System.out.println("zere");
		}

		if (num1 % 2 == 0) System.out.println("짝(even)");
		

		if (num1 % 2 != 0) System.out.println("홀(odd)");
		
	}

	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.practice1();
//		a.practice2();
		a.practice3();
	}

}
