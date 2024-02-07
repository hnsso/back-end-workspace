//package com.kh.controller;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import com.kh.model.vo.Book;
//import com.kh.model.vo.Rent;
//
//public class RentController {
//
//	public RentController() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public Connection getConnect() throws SQLException {
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
//	}
//
//	public void close(PreparedStatement ps, Connection conn) throws SQLException {
//		if (ps != null)
//			ps.close();
//		if (conn != null)
//			conn.close();
//	}
//
//	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
//		if (rs != null)
//			rs.close();
//		close(ps, conn);
//	}
//
//	// 1. 책 대여
//	public void rentBook(int bkNo, int memberNo) throws SQLException {
//		Connection conn = getConnect();
//
//		String query = "INSERT INTO tb_rent(member_no, bk_no) VALUES(?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		ps.setInt(1, memberNo);
//		ps.setInt(2, bkNo);
//		ps.executeUpdate();
//
//		close(ps, conn);
//
//	}
//
//	// 2. 내가 대여한 책 조회
//	public ArrayList<Rent> printRentBook(int no) throws SQLException {
//		Connection conn = getConnect();
//
//		String query = "SELECT * FROM tb_rent JOIN tb_book USING(bk_no) WHERE member_no=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setInt(1, no);
//
//		ResultSet rs = ps.executeQuery();
//
//		ArrayList<Rent> list = new ArrayList<>();
//		while(rs.next()) {
//			Rent rent = new Rent();
//			rent.setRentNo(rs.getInt("rent_no"));
//			rent.setRentDate(rs.getDate("rent_date"));
//			rent.setBook(new Book(rs.getString("bk_title"),
//									rs.getString("bk_author")));
//			list.add(rent);
//		}
//		return list;
//	}
//	
//	// 3. 대여 취소
//	public void deletRent(int no) throws SQLException {
//		Connection conn = getConnect();
//		
//		String query = "DELETE FROM tb_rent WHERE rent_no = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		// 			입력받을거 받아와야된다 !!
//		ps.setInt(1, no);
//		
//		// 대여취소번호가 없는것이 취소되었을때 우리는 조건을 걸어야한다 !! 1 = 성공
//		if(ps.executeUpdate() != 1) throw new SQLException();
//		
//		close(ps, conn);
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
