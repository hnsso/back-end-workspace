package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading.....!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}

	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		close(ps, conn);
	}

	public int registerMember(Member vo) throws SQLException {
		// 디비 연결
		Connection conn = getConnect();
		
		// 쿼리문 생성 !
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, vo.getId());
		// 		        데이터베이스에 사용한 vo객체에서 id를 가져오겠다 !!
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());

		int result = ps.executeUpdate();
		close(ps, conn);
		
		return result;
		// 이작업들을 다 수행하고 난다음에 !!
		// Servlet에 result로 다시 리턴 반환하겠다 !!
		// 그리고 앞에서 JDBC에서 본 다시 Controller로 돌아갈때 
		// 실패시에는 0으로 반환되는거다 . 반환되는 값이 성공하면 1이되는거고
	}

	public ArrayList<Member> showAllMember() throws SQLException {
		Connection conn = getConnect();
		
		// 쿼리문 생성
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		ArrayList<Member> list = new ArrayList<>();

		// 실행
		while (rs.next()) {
			// 우리는 member안에 list라는 변수를 담아내어야하니깐 !!
			list.add(new Member(rs.getString("id"), rs.getString("password"), rs.getString("name")));
		}
		close(rs, ps, conn);
		
		return list;
		 
	}

	public Member searchMember(String name) throws SQLException {
		Connection conn = getConnect();
//											'?' 이름이 ?인사람을 찾는표현이다
		String query = "SELECT * FROM member WHERE name=? ";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		Member member = null;
		if (rs.next()) {
			member = new Member(rs.getString("id"), 
								rs.getString("password"), 
								rs.getString("name"));
		}

		close(rs, ps, conn);

		return member;

	}

}
