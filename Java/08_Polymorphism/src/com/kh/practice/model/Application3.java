package com.kh.practice.model;

import java.util.Arrays;
import java.util.Scanner;

public class Application3 {
	Scanner sc = new Scanner(System.in);
	Member3 m = new Member3();
	// dept가 5번까지 들어간다 .. 그러면 가속성이 떨어진다고 한다 ... => 그래서 dept를 2 or 3 으로 맞춘다 !!! 그래서
	// 우리는 나눈다 !!

	// 아래 4개는 저녁변수로 만들어 버리고

//	// 한 사람에 대한 정보를 담고있는 변수들 => 그래서 우리가 객체를 배우고 model 클래스를 만들어서 명확하게 캡슐화로 만들어서 묶은거다 !!
//	String name = "";
//	int age = 0;
//	int coupon = 0;
//	String[] bookList = new String[3];

	int num = -1;
	// 우리는 main에서 안건드린다 . 다 스태틱으로 다해야하니깐 나뉜다 !!!

	// 책에 대한 정보 !! 생성할때부터 넣고 싶으면 북 객체에 넣는다 !!!
	Book3[] books = { new Book3("맛있는 지중해식 레시피", true), new Book3("카페 샌드위치 마스터 클래스", false), new Book3("원피스 107", 19),
			new Book3("주술회전 24", 15) };

	public static void main(String[] args) {

		Application3 app = new Application3();
		app.mainMenu();
	}

	public void mainMenu() {

		System.out.println("이름 : ");
		m.setName(sc.nextLine()); // setter 객체에서 넣는 역할 사용하고하 하는
									// get 담아져있는 기능을 객체에서 가져오는거

		System.out.println("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine()));// setter

		// 문제를 보고 여기서 부터 반복문을 해야한다 !!! => for문 (범위가 정해져있을때)아니면 while문 (조건이나 무한일때) 으로 한다

		// 5.1 (0.6)c 1.5(h + ) > 3
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
				 myPage(); 
				break;
			case 2:
				 rentBook();
			case 3:
				check = false;
				break;
			}
		}
	}

	// 메서드로 만든다 !! 그리고 저녁 변수로 뺸다 그리서 dept를 2,3개로 나눈
	public void myPage() {
		// "book";
		System.out.println(m.toString()); // getter 내가 입력한 값들을 가져와야하니깐 getter 이다 !!!
	}

	public void rentBook() {
		for (int index = 0; index < books.length; index++) {
			System.out.println(index + "번 도서 : " + books[index]);

			System.out.println("대여할 도서 번호 선택 : ");

			num = Integer.parseInt(sc.nextLine());

			Book3 selectBook = books[num];
			// getter를 이용해서 기존 책 리스트를 일단 가지고 와야함 !!

			Book3[] newBookList = m.getBookList();

			for (int i = 0; i < newBookList.length; i++) { // 입력하는게 없잖아 getter 이다 !!! bookList !!

				if (newBookList[i] == null) {
					// 대여 가능 공간!
					if (selectBook.isCoupon() == true) {
						// 내가 대여한 책의 쿠폰이 true인 경우!
						m.setCoupon(m.getCoupon() + 1); // 쿠폰이 true인 경우 !
					}

					if (m.getAge() >= selectBook.getAccessAge()) {
						// 내가 대여한 책의 접근 제한 나이보다 많은 경우 !
						newBookList[i] = books[num]; // 대여!
					}
					break;
				}

			}

			m.setBookList(newBookList);

			if (m.getAge() < selectBook.getAccessAge()) { // getter로 가져와야한다 !
				System.out.println("나이 제한으로 대여 불가능입니다.");
			} else {
				System.out.println("성공적으로 대여되었습니다");
			}
		}
	}
}
