//package com.kh;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.kh.controller.BookController;
//import com.kh.controller.MemberController;
//import com.kh.controller.RentController;
//import com.kh.model.vo.Book;
//import com.kh.model.vo.Member;
//import com.kh.model.vo.Rent;
//
//public class Application {
//
//	private Scanner sc = new Scanner(System.in);
//	private BookController bc = new BookController(); // 컨트롤러를 받기위해서 객체 생성 !!
//	private MemberController mc = new MemberController();
//	private RentController rc = new RentController();
//	
//	private Member member = new Member(); // 로그인 했을 시 사용자 정보를 담은 객체!
//	
//	
//	public static void main(String[] args) throws SQLException {
//		Application app = new Application();
//		app.mainMenu();
//	}
//
//	public void mainMenu() throws SQLException {
//		System.out.println("===== 도서 관리 프로그램 =====");
//
////		반목문
//		boolean check = true;
//		while (check) {
//			System.out.println("1. 전체 책 조회");
//			System.out.println("2. 책 등록");
//			System.out.println("3. 책 삭제");
//			System.out.println("4. 회원가입");
//			System.out.println("5. 로그인");
//			System.out.println("9. 종료");
//			System.out.println("메뉴 번호 입력 : ");
//			switch (Integer.parseInt(sc.nextLine())) {
//			case 1:
//				printBookAll();
//				break;
//			case 2:
//				registerBook();
//				break;
//			case 3:
//				sellBook();
//				break;
//			case 4:
//				registerMember();
//				break;
//			case 5:
//				login();
//				break;
//			case 9:
//				check = false;
//				System.out.println("프로그램 종료");
//				break;
//			}
//		}
//	}
//
//	// 1. 전체 책 조회
//	public void printBookAll()  {
//		// for문(반복문)을 이용해서 책 리스트 출력
//		//  향상된 for문 !! 
//		try {
//			for(Book book : bc.printBookAll()) {
//				//					퍼블리셔안에있는 이름을 가져오기위해서 get 두번 !
//				String pubName = book.getPublisher().getPubName(); // 변수로 설정 !!
//				System.out.println("책 번호 : " + book.getBkNo() + "/" + book.getBkTitle() 
//									+ "/" + book.getBkAuthor() + "/" + (pubName!=null ? "/" + pubName : ""));
//			}																// // 삼항연산자 !! 사용 !!
//		} catch (SQLException e) {
//			
//			System.out.println("책 정보 리스트를 불러오지 못 했습니다");
//		}																
//			
//	}
//	// 2. 책 등록
//	// 일부로 try catch를 잡고 간다 !!
//	public void registerBook() {
//		
//		// 책 제목, 책 저자를 사용자한테 입력 받아
//		System.out.println("책 제목 :");
//		String title = sc.nextLine();
//		
//		System.out.println("책 저자 : ");
//		String author = sc.nextLine();
//	
////						   보낸다 !!  -> Controller로 !!
////		bc.registerBook(title, author); 그리고 try catch로 잡았다 !!
//		
//		try {
//			// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
//			bc.registerBook(title, author);
//			System.out.println("성공적을 책을 등록했습니다.");
//		} catch (SQLException e) {
//			// 실패하면 "책을 등록하는데 실패했습니다." 출력
////			e.printStackTrace();
//			System.out.println("책을 등록하는데 실패했습니다.");
//		}
//		
//
//	}
//	// 3. 책 삭제
//	public void sellBook() {
//		// printBookAll(전체 책 조회)를 한후
//		printBookAll();
//		
//		// 삭제할 책 번호 선택을 사용자한테 입력 받아
//		System.out.println("삭제할 책 번호 : ");
//		int no = Integer.parseInt(sc.nextLine());
//		
//		try {
//			// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
//			bc.sellBook(no);
//			System.out.println("성공적으로 책을 삭제했습니다");
//		} catch (SQLException e) {
//			// 실패하면 "책을 삭제하는데 실패했습니다." 출력
//			System.out.println("책을 삭제하는데 실패했습니다.");
//		}
//		
//	
//		
//		
//		
//	}
//	// 4. 회원가입
//	public void registerMember() {
//		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아	
//		System.out.println("아이디 : ");
//		String id = sc.nextLine();
//		
//		System.out.println("비밀번호 : ");
//		String password = sc.nextLine();
//		
//		System.out.println("이름 : ");
//		String name = sc.nextLine();
//		
//		try {
//			// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
//			mc.registerMember(id, password, name);
//			System.out.println("성공적으로 회원가임을 완료하였습니다.");
//		} catch (SQLException e) {
//			// 실패하면 "회원가입에 실패했습니다." 출력
//			System.out.println("회원가입에 실패했습니다.");
//		}
//		
//}
//	// 5. 로그인
//	public void login() {
//		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
//		System.out.println("아이디 : ");
//		String id = sc.nextLine();
//		
//		System.out.println("비밀번호 : ");
//		String password = sc.nextLine();
//		
//		System.out.println("이름 : ");
//		String name = sc.nextLine();
//		
////		보내고 있다 !!
//		
//		try {
//			// 로그인에 성공하면 " ~~님, 환영합니다!" 출력
//			member = mc.login(id, password);
//			System.out.println(member.getMemberName() + "님, 환영합니다!");
//			// --> memberMenu() 호출
//			memberMenu();
//		} catch (SQLException e) {
//			// 실패하면 "로그인에 실패했습니다." 출력
//			System.out.println("로그인에 실패했습니다");
//		}
//		
//	}
//	public void memberMenu() {
//		boolean check = true;
//		while(check) {
//			System.out.println("1. 책 대여");
//			System.out.println("2. 내가 대여한 책 조회");
//			System.out.println("3. 대여 취소");
//			System.out.println("4. 로그아웃");
//			System.out.println("5. 회원탈퇴");
//			System.out.println("메뉴 번호 입력 : ");
//			switch(Integer.parseInt(sc.nextLine())) {
//			case 1:
//				rentBook();
//				break;
//			case 2:
//				printRentBook();
//				break;
//			case 3:
//				deletRent();
//				break;
//			case 4:
//				check = false;
//				break;
//			case 5:
//				deleteMember();
//				check = false;
//				break;
//			}
//		}
//	}
//	// 1. 책 대여 -> RentController 로 이동
//	public void rentBook() {
//		// printBookAll(전체 책 조회) 출력 후
//		printBookAll();
//		// 대여할 책 번호 선택을 사용자한테 입력받아
//		System.out.println("대여할 책 번호 : ");
//		int no = Integer.parseInt(sc.nextLine());
//		
//		try {
//			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
//			rc.rentBook(no, member.getMemberNo());
//			System.out.println("성공적으로 책을 대여했습니다.");
//		} catch (SQLException e) {
//			// 실패하면 "책을 대여하는데 실패했습니다." 출력
//			System.out.println("책을 대여하는데 실패했습니다.");
//		}
//}
//	
//	// 2. 내가 대여한 책 조회 -> RentController 로 이동
//	public void printRentBook() {
//		try {
//			// 내가 대여한 책들을 반복문을 이용하여 조회
//			ArrayList<Rent> list = rc.printRentBook(member.getMemberNo());
//			
//		
//			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회 (조인을 해야한다)
//			for(Rent rent : list) {
////				날짜 관련 객체 생성 
//				LocalDate localDate = new java.sql.Date(rent.getRentDate().getTime()).toLocalDate();
//				
//				System.out.println("대여 번호 : " + rent.getRentNo() 
//						+ "/" + rent.getBook().getBkTitle() 
//						+ "/" + rent.getBook().getBkAuthor()
//						+ "/" + rent.getRentDate()
//						+ "/ 반납 기한  : " + localDate.plusDays(7));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//	
//	// 3. 대여 취소 -> RentController 로 이동
//	public void deletRent() {
//		//printRentBook(내가 대여한 책 조회) 출력 후
//		printRentBook();
//		// 취소할 책 번호 선택을 사용자한테 입력 받아
//		System.out.println("취소할 책 번호 : ");
//		int no = Integer.parseInt(sc.nextLine());
//		
//		try {
//			// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
//			rc.deletRent(no);
//			System.out.println("성공적으로 대여를 취소했습니다.");
//		} catch (SQLException e) {
//			// 실패하면 "대여를 취소하는데 실패했습니다." 출력
//			System.out.println("대여를 취소하는데 실패했습니다.");
//		}
//		
//		
//		
//	
//	}
//	
//	// 4. 회원탈퇴 -> MemberController 로 이동 !!
//	// status (상태) Y 회원탈퇴 인걸 적용해서 
//	public void deleteMember() {
//		try {
//			// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
//			mc.deleteMember(member.getMemberNo());
//			System.out.println("회원탈퇴 하였습니다 ㅠㅠ");
//		} catch (SQLException e) {
//			// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
//			System.out.println("회원탈퇴하는데 실패했습니다.");
//		}
//		
//		
//		
//	}
//}
