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
//import com.kh.model.vo.Publisher;
//
//// # 우리는 기능관련된걸 구현할때는 Controller안에서 해결한다 !!
//public class BookController {
//	
//	public BookController() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public Connection getConnect() throws SQLException {
//		return DriverManager.getConnection
//								("jdbc:mysql://localhost:3306/sample", "root", "1234");
//	}
//	
//	public void close(PreparedStatement ps, Connection conn) throws SQLException {
//		if(ps!=null) ps.close();
//		if(conn!=null) conn.close();
//	}
//	
//	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
//		if(rs!=null) rs.close();
//		close(ps, conn);
//	}
//	
//	// 1. 전체 책 조회 (는 기능)!!
//	public ArrayList<Book> printBookAll() throws SQLException {
//		Connection conn = getConnect();
//		
//		String query = "SELECT * FROM tb_book LEFT JOIN tb_publisher USING (pub_no)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ResultSet rs = ps.executeQuery();
//		
//		
//		ArrayList<Book> list = new ArrayList<>();
//		// rs.next 각각에것을 돌려야하니깐 !!
//		while(rs.next()) {
//			// 북을 하나씩 추가해야하니깐 !
//			Book book = new Book();
//			book.setBkNo(rs.getInt("bk_no"));
//			book.setBkTitle(rs.getString("bk_title"));
//			book.setBkAuthor(rs.getString("bk_author"));
//			book.setBkPrice(rs.getInt("bk_price"));
//			book.setPublisher(new Publisher(rs.getInt("pub_no"),
//											rs.getString("pub_name"),
//											rs.getString("phone")));
//			list.add(book);
//		}
//		return list;
//	}
//	
//	
//	
//	// 2. 책등록
//	//							받았다 !!!
//	public void registerBook(String title, String author) throws SQLException {
//		Connection conn = getConnect();
//		//															문자를 짚어 ''아니다 !
//		String query = "INSERT INTO tb_book(bk_title, bk_author)VALUES(?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setString(1, title);
//		ps.setString(2, author);
//		
//		ps.executeUpdate();
//		close(ps, conn);
//	}
//	
//	// 3. 책 삭제
//	public void sellBook(int no) throws SQLException {
//		Connection conn = getConnect();
//		
//		String query = "DELETE FROM tb_book WHERE bk_no=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setInt(1, no);
//		ps.executeUpdate();
//		
//		
//		if(ps.executeUpdate() == 0) throw new SQLException();
//			close(ps, conn);
//		}
//		
//
//	}
//	
//	
//	
//
