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
	// DAO 개발할 때 중요한건 매개변수(파라미터) 뭘 가지고 오는지, 리턴타입 결과 출력이 어떤게 필요한지
	// 1 . DB랑 접근하는게 몇개이고 어떤거인지 확인

	// 회원가입

	public int registerMember(Member member) throws SQLException {
		Connection conn = getConnect();

		String query = "INSERT INTO member(id, password, name) VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 우리가 채워야할 값들에 가져와야하니깐 member에서 가져온다 !
		ps.setString(1, member.getId());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getName());
		
		// 추가하고 ! => 한명 추가했다 두명 추가했다 ~~ 
		int result = ps.executeUpdate();
		// 닫아야한다 !
		close(ps, conn);

		return result;
	}

	// 로그인

	public Member login(String id, String password) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT * FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null; // 리턴타입이니깐 생성해야한다
		
		if(rs.next()) {
			member = new Member(rs.getString("id"), 
								rs.getString("password"), 
								rs.getString("name"));
		}
		
		
		close(rs, ps, conn);
		
		return member;
	}

	// 회원검색
	public Member findMember(String id) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Member member = null; // 리턴타입이니깐 생성해야한다
		
		if(rs.next()) {
			member = new Member(rs.getString("id"), 
								rs.getString("password"), 
								rs.getString("name"));
		}
		
		
		close(rs, ps, conn);
		
		return member;
	}

	// 전체회원보기
	public ArrayList<Member> allShowMember() throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			 list.add(new Member(rs.getString("id"), 
								rs.getString("password"), 
								rs.getString("name")));
		}
		
		
		close(rs, ps, conn);
		
		return list;
	}

}
