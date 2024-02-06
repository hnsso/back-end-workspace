package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

	public BookController() throws SQLException {
		try {
//		1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	2. 디비연결 객체로 간단하게 정리
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
	}

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
	
	
	
	public void registerBook() throws SQLException {
		
		if()
		Connection conn = getConnection();
		
		String query = "INSERT INTO Book(title, author) VALUES('?', '?')";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, b.);
	}
	
	
	// 중복된 책을 설정할때 
	public boolean bookCheck(String title) throws SQLException {
		
		Connection conn = getConnection();
		
		String query = "SELECT title FROM Book WHERE title=?";
		PreparedStatement ps = conn.prepareStatement(query);
	
		ps.setString(1, title);
		
		ResultSet rs = ps.executeQuery();
		
		String checkTitle = null;
		
		if(rs.next()) 
			checkTitle = rs.getString("title");
		
		close(rs, ps, conn);

		if (checkTitle != null)
			return true;
		
		return false;
	}
	
	
	
	public void sellBook() {

	}

	public void registerMember() {

	}

	public void rentBook() {

	}

	public void printRentBook() {

	}

	public void deletRent() {

	}

	public void deleteMember() {

	}

}
