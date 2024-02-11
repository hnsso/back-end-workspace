package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class TXCommitTest2 {

	public static void main(String[] args) {
		/*
		 * 대윤 -> 대규 : 50만원씩 이체 이 관련 모든 쿼리를 하나로 묶는다 ! 트랜잭션 사용 !
		 * 대윤님의 잔액이 마이너스가 되면 이체 취소가 되어야 함 !
		 * 
		 */
		try {
			// 1. 드라이버 로딩   +    우리는 연결시켜야한다 
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");

			conn.setAutoCommit(false); // ====================================

			// 3. 쿼리문 생성 4. 쿼리문 실행

			String query1 = "UPDATE bank SET balance = balance - ? WHERE name = ?"; // UPDATE
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setInt(1, 500000);
			ps1.setString(2, "정대윤");
			ps1.executeUpdate(); // 쿼리문 실행 !!

			String query2 = "UPDATE bank SET balance = balance + ? WHERE name = ? "; // UPDATE
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setInt(1, 500000);
			ps2.setString(2, "신대규");
			ps2.executeUpdate(); // 쿼리문 실행 !!

			// 대윤님의 잔액 !!
			String query3 = "SELECT balance FROM bank WHERE name = ?"; // SELECT
			PreparedStatement ps3 = conn.prepareStatement(query3);
			ps3.setString(1, "정대윤");
			ResultSet rs = ps3.executeQuery();

			if (rs.next()) {
				// 대윤님의 잔액이 마이너스가 되면 이체 취소가 되어야 함 !
				if (rs.getInt("balance") < 0) {
					conn.rollback();
					System.out.println("잔액이 없으므로 이체 취소!");
				} else {
					conn.commit();
					System.out.println("잔액이 있으므로 이체 성공!");
				}

			}

			conn.setAutoCommit(true); // ======================================

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
