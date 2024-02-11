package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DBConnectionTest1 {

	public static void main(String[] args) {

		// JDBC(Java Database Connectivity) 작업 4단계
		
		// JDBC 
		
		// class.forName(드라이버 클래스이름) 드라이버 로딩 
		// Connection conn =  DriverManager.getConnection(url, user , password); 데이터베이스와 eclipse 연결 !! 
		// (쿼리문 생성!!)String query = "SELECT문 UPDATE 문 INSERT문 DELETE문" 
		//  preparedStatement ps = coon.prepareStatement(query);

		try {
			// 1. 드라이버 로딩 => MySQL 연결
			// MySQL데이터베이스에 연결하기위해 우리는 MySQL JDBC 드라이버를 이용해서 연결한다
			// 그 연결하는 클래스 이름이 "DRIVER_NAME" 이다

			// Class.forName("드라이버 클래스 이름");
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. 드라이버 로딩...!!");

			// 2. 데이터베이스와 연결 => conn은 데이터베이스 연결 객체 이다 !!
			// Connection conn = DriverManager.getConnection("URL", "USER", "PASSWORD");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			System.out.println("2. 데이터베이스와 연결...!!");

			// 3. Statement 객체 생성 - SELECT
			String query = "SELECT * FROM employee";
			PreparedStatement ps = conn.prepareStatement(query);

			// 
			// 4. 쿼리문 실행
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String empId = rs.getString("emp_id ");
				String empName = rs.getString("emp_name");
				int salary = rs.getInt("salary");
				float bonus = rs.getFloat("bonus");
				Date hireDate = rs.getDate("hire_date");
				char entYn = rs.getString("ent_yn").charAt(0);

				System.out.println("쿼리문 실행" +
						empId + " / " + empName + " / " + salary + " / " + bonus + " / " + hireDate + " / " + entYn);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패!");
		}

	}

}