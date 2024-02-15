package com.kh.test6.model;

import java.util.Scanner;

public class Application {
	
	Application app = new Application();
	static Scanner sc = new Scanner(System.in);
	Food f = new Food();
	
	
	public static void main(String[] args) {
		
		
		boolean check = false;
		
		while (true) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.printf("번호 선택 : ");
			
			int num = Integer.parseInt(sc.nextLine());

			switch (num){
			case 1:
				System.out.println("추가할 음식 입력 : ");
				String foodName = sc.nextLine();
				
				System.out.println("칼로리 입력 : ");
				int kcal = Integer.parseInt(sc.nextLine());
				
				System.out.println("음식 정보가 추가 되었습니다");
				break;
			case 2:
//				System.out.println("Food [name = " + foodName + "kcal = " + kcal);
				break;
			case 3:
				System.out.println("삭제하고 싶은 음식 선택 : ");
//				System.out.println("Food [name = " + foodName + "kcal = " + kcal + " ] 가 삭제되었습니다 .";
				break;
			case 4:
				check = false ;
				break;
			}

		}
	}
}


