package com.kh.test6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.test5.Fruit;

public class Application {

	List<Food> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Application app = new Application();
		app.mainmenu();

	}

	public void mainmenu() {

		boolean check = false;
		while (true) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.println("번호 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				add();
				break;
			case 2:
				info();
				break;
			case 3:
				delete();
				break;
			case 4:
				check = false;
				break;
			}
		}
	}

	public void add() {
		System.out.println("추가할 음식 입력 : ");
		String name = sc.nextLine();
		System.out.println("칼로리 입력 : ");
		int kcal = Integer.parseInt(sc.nextLine());
	}

	public void info() {
		for (Food food : list) {
			System.out.println(list.add(food));
		}
	}

	public void delete() {
		System.out.println("삭제하고 싶은 음식 선택 :");
		String name = sc.nextLine();
	}
}
