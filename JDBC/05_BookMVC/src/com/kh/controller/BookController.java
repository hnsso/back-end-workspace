package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookController {

	public BookController() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void registerBook() throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		
		
//		
//		if() {	
//			
//		
//			
//		}
		String query = "INSERT INTO Book VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, );
		
		
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
