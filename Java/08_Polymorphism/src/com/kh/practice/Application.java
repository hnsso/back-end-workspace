package com.kh.practice;

import java.util.Scanner;


import com.kh.practice.controller.LibraryController;
import com.kh.practice.model.AniBook;
import com.kh.practice.model.Book;
import com.kh.practice.model.CookBook;
import com.kh.practice.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();

	public static void main(String[] args) {

		Application app = new Application(); // Application 객체 생성
		app.mainMenu(); //
	}

	public void mainMenu() {
		boolean check = true;
		while (true) {
			System.out.println("이름 : ");
			String name = sc.nextLine();

			System.out.println("나이 : ");
			int age = sc.nextInt();

			System.out.println("=== 메뉴 ===");
			System.out.println("1 . 마이페이지 ");
			System.out.println("2 . 도서 대여하기 ");
			System.out.println("3 . 프로그램 종료하기");
			System.out.println("메뉴 번호 : ");

			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				myPage();
				break;
			case 2:
				bookRental();
				break;
			case 3:
				check = false;
				break;
			}
		}
	}

	
	
	public void myPage() {
		
		Member m = new Member(name, age, cookCoupon, book)
		System.out.println("Member");
	}
	
	
	
	
	public void bookRental() {
		System.out.println("0번 도서 : ");
		System.out.println("1번 도서 : ");
		System.out.println("2번 도서 : ");
		System.out.println("3번 도서 : ");

		switch (Integer.parseInt(sc.nextLine())) {

		case 0:
			System.out.println("0번 도서 : " + CookBook("맛있는 지중해식 레시피", true));
			break;
		case 1:
			System.out.println("1번 도서 : " + CookBook("카페 샌드위치 마스터 클래스", false));
			break;
		case 2:
			System.out.println("2번 도서 : " + AniBook("원피스 107", 19));
			break;
		case 3:
			System.out.println("3번 도서 : " + Anibook("주술회전 24", 15));
			break;
			

		}

	}

}