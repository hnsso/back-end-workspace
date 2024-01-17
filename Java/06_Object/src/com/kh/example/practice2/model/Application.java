package com.kh.example.practice2.model;

import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

public class Application {

// Application 화면 딴 

	
	
	public static void main(String[] args) {
		// ---------------------- 화면 view 역할----------------------------------
		Scanner sc = new Scanner(System.in);
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.println("종류 : ");
		String kind = sc.nextLine();
		
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		System.out.println("맛 : ");
		String flavor = sc.nextLine();
		
		System.out.println("개수 : ");
		int numOf = Integer.parseInt(sc.nextLine()) ;
		
		System.out.println("가격 : ");
		int price = Integer.parseInt(sc.nextLine()) ;
		// --------------------------------------------------------------
		// --> 즉, 여기서 controller나 model에 직접 접근 xx
		
		// 데이터를 서버한테 요청 ! 그럼 데이터를 서버한테 전달 !
		// 전달할 때 controller 한테 전달하면 됨 !!
		SnackController control = new SnackController();
		control.saveDate(kind, name, flavor, numOf, price);
		
		// 서버한테 요청해서 응답받은 결과를 다시 화면으로 !
		System.out.println(control.confirmDate());
//		Snack s = new Snack();
//	
//		s.setKind("빵");
//		s.setName("케이크");
//		s.setFlavor("블루베리");
//		s.setNumOf(1);
//		s.setPrice(15000);
//		
//		System.out.println("스낵류를 입력하세요." , "종류" , s.setKind("빵") 
//				,  "이름" , s.setName("케이크") , "맛" , s.setFlavor("블루베리") 
//				, s.setNumOf(1), s.setPrice(15000), "저장 완료했습니다");
		
	}
	
}
			