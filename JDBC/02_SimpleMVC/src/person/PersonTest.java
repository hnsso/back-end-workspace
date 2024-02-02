package person;

// 총집합으로 하나의 파일로 만든 문이다 !!
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonTest {

	PersonController pc = new PersonController(); // method전에 생성자를 먼저 호출한다.
	
	public static void main(String[] args) {
		PersonTest pt = new PersonTest(); // 객체 생성 하고
		// JDBC(Java Database Connectivity) 작업 4단계(1단계 드라이버 로딩)
		try {
			// 기능별로 만들었다 
			// 1. 드라이버 로딩(자바랑 mysql를 연동하겠다 !!)
//			Class.forName("com.mysql.cj.jdbc.Driver"); // 어느어느 패키지내에 class를 가져오겠다 !!

			// person 테이블에 추가 INSERT
//			pt.addPerson(111, "김강우", "서울");
//			pt.addPerson(222, "고아라", "제주도");
//			pt.addPerson(333, "강태주", "경기도");

			// person 테이블에서 데이터 수정 UPDATE
//			pt.updatePerson(111, "제주도");

			// person 테이블에서 데이터 삭제 DELETE

//			pt.removePerson(333);

			// person 테이블에 있는 데이터 전체 보여주기
			pt.searchAllPerson();

			// person 테이블에서 데이터 한개만 가져오기
			pt.searchPerson(111);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 고정적으로 반복되는 아이들은 뻬주자 -- > 새롭게 생성해서 만든다 !!
	
	// -- DB 연결, 자원 반납 -- => 공통적인 메서드 정의.. 메서드마다 호출해서 사용 !
	
	// 리턴타입이 모르겠다 그럼 일단 void
	
	public Connection getConnect() throws SQLException {

		// 2. DB 연결 ------ conn 의 리턴타입이 Connection이여서 void를 Connection으로
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;									// kh 스크마를 적용한거다 !!
	}

	// 5. 자원 반납 아라서 처리한다 ..
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	// 오버로딩이 일어남 !!
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object) public void ___() ___ ___ {}
	// 공통적으로 반복이걸

	// person 테이블에 추가 - INSERT
	public void addPerson(int id, String name, String address) throws SQLException {
		int result = pc.addPerson(id, name, address);
		if (result == 1) { // result로 반환 !!
			System.out.println(name + "님, 회원가입 완료");
		}
		
		
		
		
		// 2. DB 연결
		// Connection conn =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root",
		// "1234");

//		Connection conn = getConnect();
//
//		// 3. 쿼리문 -> PreParedStatement () - INSERT
//		String query = "INSERT INTO person VALUES(?, ?, ?)";
//		PreparedStatement ps = conn.prepareStatement(query); 
//							// 해당하는 쿼리를 담아서 가져온다(prepareStatement)를 이용해서 사용!
//							// 여기에서 기록된거여서 나중에 framework랑 spring 에서 이해가 더쉽고 더 잘 보일거다 !
//		// 4. 쿼리문 실행
//		ps.setInt(1, id);
//		ps.setString(2, name);
//		ps.setString(3, address);
//
//		int result = ps.executeUpdate();
//		if (result == 1) {
//			System.out.println(name + "님, 회원가입 완료");
//		}
//
//		// 5. 자원 반납 공통적인거
//		closeAll(ps, conn);

	}

	// person 테이블에서 데이터 수정 - UPDATE
	public void updatePerson(int id, String address) throws SQLException {
		int result = pc.updatePerson(id, address);
		if (result == 1) {
			System.out.println(result + "명 수정");
		}
//		Connection conn = getConnect();
//
//		// 3. 쿼리문 -> PreParedStatement () - UPDATE
//		String query = "UPDATE person SET  address = ? WHERE id = ?";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		// 4. 쿼리문 실행 (? 개수 만큼 우리가 set한다 !!)
//		ps.setInt(2, id); // ? 순서대로 지정
//		ps.setString(1, address);
//
//		
//		int result = ps.executeUpdate(); // 실행할때 !!
//		if (result == 1) {
//			System.out.println(result + "명 수정");
//		}
//
//		// 자원반납 !!
//		closeAll(ps, conn);

	}

	// person 테이블에서 데이터 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if (result == 1) {
			System.out.println(result + "명 삭제!");
		}
//		Connection conn = getConnect();
//
//		// 3. 쿼리문 -> PreParedStatement () - DELETE
//		String query = "DELETE FROM person where id=1;";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		// 4. 쿼리문 실행
//		ps.setInt(1, id); // ? 순서대로 지정
//
//		int result = ps.executeUpdate();
//		if (result == 1) {
//			System.out.println(result + "명 삭제!");
//		}
//		// 5. 자원 반납
//		closeAll(ps, conn);

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELETE
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p.getId() + ", " + p.getName() + ", " + p.getAddress());
//							   == p
		}
//		Connection conn = getConnect();
//
//		// 3. 쿼리문 -> PreParedStatement () - DELETE
//		String query = "SELECT * FROM person;";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		// 4. 쿼리문 실행
//		ResultSet rs = ps.executeQuery();
//
//		while (rs.next()) {
//			System.out.println(rs.getString("name") + ", " + rs.getString("address"));
//		} // ? 순서대로 지정
//
//		// 5. 자원 반납
//
//		closeAll(rs, ps, conn);

	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECTE
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);
//		Connection conn = getConnect();
//
//		// 3. 쿼리문 -> PreParedStatement () - SELECT
//		String query = "SELECT * FROM person WhERE id = 111";
//		PreparedStatement ps = conn.prepareStatement(query);
//
//		// 4. 쿼리문 실행
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//
//		if (rs.next()) {
//			System.out.println(rs.getString("name") + ", " + rs.getString("address"));
//		} // ? 순서대로 지정
//
//		// 5. 자원 반납
//		closeAll(rs, ps, conn);

	}
}