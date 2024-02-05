package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {

	public MemberController() {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. DB 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}

	// 5. 자원 반납
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

	public boolean signUp(Member m) throws SQLException {
		Connection conn = getConnect();
		// 회원가입 기능 구현!
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> kh.member 테이블에 해당 값 추가! (INSERT)
		// INSERT INTO member VALUES('test', 'test1234', '테스트');

		if (!idCheck(m.getId())) {
			String query = "INSERT INTO Member VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());

			ps.executeUpdate();
			close(ps, conn);
			return true;
		}

		return false;
	}

	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT id FROM member WHERE id = ?";
		PreparedStatement ps = getConnect().prepareStatement(query);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		String checkId = null;

		if (rs.next())
			checkId = rs.getString("id");
		close(rs, ps, conn);

		if (checkId != null)
			return true;
		return false;
	}

	public String login(String id, String password) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT name FROM member WHERE id =? AND password=?";
		PreparedStatement ps = getConnect().prepareStatement(query);

		ps.setString(1, id);
		ps.setString(2, password);

		ResultSet rs = ps.executeQuery();
		String name = null;
		if (rs.next())
			name = rs.getString("name");
		close(rs, ps, conn);

		// 로그인 기능 구현! -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기 (SELECT)
		return null;
	}

	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		Connection conn = getConnect();
		boolean result = false;
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현!
		PreparedStatement ps = null; // =============== ? null 시작한다
		if (login(id, oldPw) != null) {
			// -> member 테이블에서 id로 새로운 패스워드로 변경(UPDATE)
			String query = "UPDATE member SET password=? WHERE id= ?"; // 변경해야될게 비밀번호
			ps = conn.prepareStatement(query);

			ps.setString(1, newPw); // 우리가 변경해야한게 무었인지 ?
			ps.setString(2, id);
			ps.executeUpdate(); // 마무리 !!

			result = true;

		}

		close(ps, conn);
		return result;
	}

	public void changeName(String id, String changename) throws SQLException {
		// 이름 바꾸기 기능 구현
		// 이름 바꾸기 기능 구현! -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
	Connection conn = getConnect();
	String query = "UPDATE member SET name = ? WHERE id =?";
	PreparedStatement ps = conn.prepareStatement(query);
	
	ps.setString(1, changename);
	ps.setString(2, id);
	ps.executeUpdate();
	
	close(ps, conn);
	}
}