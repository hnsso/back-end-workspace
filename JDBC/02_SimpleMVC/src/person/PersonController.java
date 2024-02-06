package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController {
	
	public PersonController() {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// 고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!
	
	// 2. DB 연결
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}
	
	// 5. 자원 반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate(); // 성공하면 1
		
		closeAll(ps, conn);
		
		return result;
	}
	
	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate(); 

		closeAll(ps, conn);
		
		return result;
	}
	
	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "DELETE FROM person WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setInt(1, id);

		int result = ps.executeUpdate();
		
		closeAll(ps, conn);
		return result;
	}
	
	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "SELECT * FROM person";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();

		while (rs.next()) {
			// 생성자 방식 
//			list.add(new Person(rs.getInt("id"), 
//								rs.getString("name"), 
//								rs.getString("address")));
			
			// setter 방식
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAddress(rs.getString("address"));
			list.add(person);
		}

		closeAll(rs, ps, conn);
		return list;
	}
	
	public Person searchPerson(int id) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "SELECT * FROM person WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 실행
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Person person = null;

		if (rs.next()) {
			person = new Person(rs.getInt("id"),
										rs.getString("name"),
										rs.getString("address"));
		}

		closeAll(rs, ps, conn);
		
		return person;
	}
}