package com.kh.practice;

import java.util.Scanner;


// 우리는 객체지향적인게 좋은 이유는 출력할때의 속도와 그리고 캡슐화로 인한 정교함이다 !! 가속성이 떨어짐 ... 
public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름 : ");
		String name = sc.nextLine();

		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		// 문제를 보고 여기서 부터 반복문을 해야한다 !!! => for문 (범위가 정해져있을때)아니면 while문 (조건이나 무한일때) 으로 한다
		int num = -1;
		int coupon = 0;
		String book = null;
		boolean check = true;
		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.println("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			// 변수를 밖에다가 선언을하고 안에다가 자료형없이 쓰면 가능하다
//			 조건문일때는 일대일로할때 메뉴가 뭐일때 메뉴가 뭐일때 그러면 무조건 switch !!
			switch (menu) {
			case 1:
				System.out.println(
						"Member[name" + name + ", age= " + age + ", cookCoupon=" + coupon + ", book=" + book + "]");
				break;
			case 2:
				System.out.println("0번 도서 : Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]");
				System.out.println("1반 도서 : Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]");
				System.out.println("2번 도서 : Book [title=원피스 107] / AniBook [accessAge=19]");
				System.out.println("3번 도서 : Book [title=주술회전 24] / AniBook [accessAge=15]");
				System.out.println("대여할 도서 번호 선택 : ");
				num = Integer.parseInt(sc.nextLine());
				if (num == 0) {
					coupon++;
					book = "Book [title=맛있는 지중해식 레시피] / CookBook [coupon=true]";
				} else if (num == 1) {
					book = "Book [title=카페 샌드위치 마스터 클래스] / CookBook [coupon=false]";
				} else if (num == 2 && age >= 19) {
					book = "Book [title=원피스 107] / AniBook [accessAge=19]";
				} else if (num == 3 && age >= 15) {
					book = "Book [title=주술회전 24] / AniBook [accessAge=15]";
				}

				if (num == 2 && age < 19 || num == 3 && age < 15) {
					System.out.println("나이 제한으로 대여 불가능입니다.");
				} else {
					System.out.println("성공적으로 대여되었습니다");
				}
				break;
			case 3:
				check = false;
				break;
			}
		}
		
		
		
	}
}