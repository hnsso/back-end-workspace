package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest {
	
	// 1. 드라이버 로딩 ---> 2. 데이터베이스 연결 ---> 3. 쿼리문 + PreparedStatement 
	

	
	public static void main(String[] args) {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. DB 연결
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			
			// 3. 쿼리문 + PreparedStatement
				
			String query1 = "INSERT INTO member VALUES(?, ?, ?)";
			String query2 = "SELECT * FROM member WHERE id = ?";
			
			// 트랜잭션 시작 .. ! (다시 되돌리는 !!)
			conn.setAutoCommit(false);   // ===> RollBack 하면 여기로 온다 !
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			// 4. 쿼리문 실행 !!
			ps1.setString(1, "test4");
			ps1.setString(2, "pass4");
			ps1.setString(3, "테스트4");
			ps1.executeUpdate();
			
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, "test100");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) { // 회원이 존재하면
				// INSERT 취소.... !
				conn.rollback();
				System.out.println("회원이 존재하여 회원 추가 취소 !");
			} else { // 회원이 존재하지 않는다면 -- 추가하겠다!!
				conn.commit(); // 추가하겠다는 commit
				System.out.println("회원이 존재하지 않으므로 추가 !");
			}
			
			// 트랜잭션 처리를 다시 원래대로 돌려놓음
			conn.setAutoCommit(true);	// ===>  다처리가 되면 되돌려놓기위한 작업 !!
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
