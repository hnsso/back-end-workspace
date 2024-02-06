package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {

	// 1. 드라이버 로딩
	public MemberController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}

	// 자원반납 !!        매개변수까지 작성
	public void close(PreparedStatement ps, Connection conn) throws SQLException  {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	// 자원반납 !!
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		close(ps, conn);
	}

	public boolean signUp(Member m) throws SQLException {
		// 위 중복되는 로딩과 데이터 베이스 연결을 빼놓음 !!
		Connection conn = getConnect();

		// 회원가입 기능 구현!
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가! (INSERT)
		// -> 미리 추가할 쿼리문 복사 해놓은거 !! = INSERT INTO member VALUES('test', 'test1234', '테스트')

		// signUp 메서드 반환한다 !
		if (!idCheck(m.getId())) {
			// 쿼리문 객체 생성 !! !!
			String query = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);

			// 쿼리문 실행
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());

			ps.executeUpdate();
			// 반납
			close(ps, conn);
			// 결과 도출한다 !
			return true;
		}
		// 위 결과가 아니면 false
		return false;
	}

	public boolean idCheck(String id) throws SQLException {
		Connection conn = getConnect();

		String query = "SELECT id FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		
		String checkId = null;

		if (rs.next())
			checkId = rs.getString("id");
		// 자원반납 close()매개변수로 바꾼거 !!
		close(rs, ps, conn);

		if (checkId != null)
			return true;
		
		return false;
	}

	public String login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		// 로그인 기능 구현!
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기! (SELECT)
		String query = "SELECT name FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, password);

		// JDBC연결한 rs라는 id password가 포함된 쿼리문
		ResultSet rs = ps.executeQuery();
		
		String name = null;
		
		if (rs.next())
			name = rs.getString("name");
		
		close(rs, ps, conn);
		
		return name;
	}

	public boolean changePassword(String id, String oldPw, String newPw) throws SQLException {
		Connection conn = getConnect();
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE 문 구현!
		PreparedStatement ps = null;
		boolean result = false;
		if (login(id, oldPw) != null) {
			// -> member 테이블에서 id로 새로운 패스워드로 변경 (UPDATE)
			String query = "UPDATE member SET password=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, newPw);
			ps.setString(2, id);
			ps.executeUpdate();
			result = true;
		}
		close(ps, conn);
		return result;
	}

	public void changeName(String id, String changeName) throws SQLException {
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
		Connection conn = getConnect();
		String query = "UPDATE member SET name=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, changeName);
		ps.setString(2, id);
		ps.executeUpdate();
		close(ps, conn);

	}

}