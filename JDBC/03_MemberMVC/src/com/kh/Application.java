package com.kh;

import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	Member member = new Member();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() {

		System.out.println("===== KH 사이트 =====");

// 		=========== 반복문 형식 ============
		boolean check = true;
		while (check) {
//		=================================
			System.out.println("****** 메인 메뉴 ******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
//		==== 상황별 조건문으로 switch 사용 ====
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				signUp();
				break;
			case 2:
				login();
				break;
			case 9:
				// "프로그램 종료" 출력 후 반복문 종료
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	public void signUp() {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// MemberController의 signUp 메서드 반환 결과에 따라
		// true면 "성공적으로 회원가입 완료하였습니다." 츨력
		// false면 "중복된 아이디입니다. 다시 입력해주세요." 출력

		MemberController mc = new MemberController();

		System.out.println("==== 로그인 ====");
		System.out.println("1 . 아이디 > ");
		System.out.println("2 . 비밀번호 > ");
		System.out.println("3 . 이름 > ");

//		int i = 0;
//		String id = id;
//		String password = password;
//		String name = name;

//		if (id != null && password != null && name != null) {
//			System.out.println("성공적으로 회원가입 완료하였습니다.");
//		} else {
//			System.out.println("중복된 아이디입니다. 다시 입력해주세요");
//		}
//		break;
	}

	public void login() {
		// 아이디, 비밀번호를 사용자한테 입력받아
		// MemberController의 login 메서드 반환 결과를 이름으로 받고
		// 이름이 null이 아니면 "~~님, 환영합니다! " 출력
		// --> login 성공! 성공했다면 memberMenu() 호출
		// null이면 "틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요." 출력

	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("****** 회원 메뉴 ******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.println("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				// 로그아웃 처리 -> 프로그램 종료처럼 하시면 됩니다 ~
				check = false;
				System.out.println("프로그램을 종료합니다" + check);
				break;
			}
		}
	}

	public void changePassword() {
		// 아이디, 현재 비밀번호, 새로운 비밀번호를 사용자한테 입력받아
		// MemberController의 changePassword 메서드 반환 결과에 따라
		// true면 "비밀번호 변경에 성공했습니다." 출력
		// false면 "비밀번호 변경에 실패했습니다. 다시 입력해주세요. " 출력
		System.out.println("1. 아이디 > ");
		System.out.println("2. 현재 비밀번호 > ");
		System.out.println("3. 새로운 비밀번호 > ");

	}

	public void changeName() {
		// 아이디, 비밀번호를 사용자한테 입력받아
		// 사용자가 맞는지 확인 후 - MemberController의 login 메서드 활용
		// 이름이 null이 아니면
		// --> "현재 설정된 이름 : OOO" 출력
		// --> 변경할 이름을 사용자한테 입력받아
		// MemberController의 changeName 메서드로 이름 변경 후
		// "이름 변경에 성공하였습니다." 출력
		// 이름이 null이면 "이름 변경에 실패했습니다. 다시 입력해주세요." 츨력

		System.out.println("1. 아이디 > ");
		System.out.println("2. 비밀번호 > ");

//		if (id != null) {
//
//		}

	}

}
