package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

// 실습예제에 표에 옆에 아무것도 없는 거는 접근제한자가 없는거다 !

public class Application {
	Scanner sc = new Scanner(System.in); // 객체 생성

	Employee viewEmployee = new Employee();

	EmployeeController employeeController = new EmployeeController();

	// 메인 메서드
	public static void main(String[] args) {
		// 인스턴스 메서드는 객체 생성이 되어야 쓸수있다 ..
		Application app = new Application();
		
		boolean check = true;
		while(true) {
			int select = app.employeeMenu();
			switch(select) {
			case 1:
				app.insertEmp();
				break;
			case 2:
				app.updateEmp();
				break;
			case 3:
				app.printEmp();
				break;
			case 9: 
				System.out.println("프로그램을 종료합니다. ");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 ~ ");
			}
		}
		
	}
	
	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.println("1. 사원 정보 추가");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());		
	}
	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		System.out.println("사원 번호 : ");
		int empNo = Integer.parseInt(sc.nextLine());
		
		System.out.println("사원 이름 : ");
		String name = sc.nextLine();
		
		System.out.println("사원 성별 : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.println("전화 번호 :");
		String phone = sc.nextLine();
		
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		String add = sc.nextLine();
		
	    if(add.equals("y")) {
	    	System.out.println("사원 부서 : ");
	    	String dept = sc.nextLine();
	    	
	    	System.out.println("사원 연봉 : ");
	    	int salary = Integer.parseInt(sc.nextLine());
	    	
	    	System.out.println("보너스 율 : ");
	    	double bonus = Double.parseDouble(sc.nextLine());
	    	
	    	employeeController.add(empNo, name, gender, phone, 
	    												dept, salary, bonus);
	    }else {
	    	
	    	employeeController.add(empNo, name, gender, phone);
	    	
	    }

	}
	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("사원의 어떤 정보를 수정하시겠습니까 ?");
		System.out.println("1. 전화 번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 :");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		 	case 1:
		 		System.out.println("전화 번호 입력 : ");
		 		String phone = sc.nextLine();
		 		employeeController.modify(phone);
		 		break;
			case 2:
				System.out.println("사원 연봉 입력 : ");
				int salary = Integer.parseInt(sc.nextLine());
				employeeController.modify(salary);
				break;
			case 3:
				System.out.println("보너스 율 입력 : ");
				double bonus = Double.parseDouble(sc.nextLine());
				employeeController.modify(bonus);
				break;
			case 9:
				break;
		}
		
	}

	public void printEmp() {
		System.out.println(employeeController.info());
	}
}
