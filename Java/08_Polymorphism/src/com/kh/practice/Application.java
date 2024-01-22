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

		
		
		
	}
	
	public void mainMenu() {
		
		Book b = new Book();
		CookBook cb = new CookBook();
		AniBook ab = new AniBook();
		Member m = new Member();
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.println("=== 메뉴 ===");
		
		System.out.println("1 . 마이페이지 ");
		
		System.out.println("2 . 도서 대여하기 ");
		
		System.out.println("3 . 프로그램 종료하기");
		
		System.out.println("메뉴 번호 : ");
		
		
		
		
	}
}
