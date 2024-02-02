package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Controller 기능(= query)을 따로 빼놓는다 !! 
public class PersonController {

	// 기본 생성자 !! 생성 !!
	public PersonController() {
		// 1. 드라이버 로딩(자바랑 MYSQL를 연동하겠다 !!) // 트라이 캣치는 잡는다는 말이다 !!
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	===============================================================================================
	// 고정적으로 반복되는 아이들은 뻬주자 -- > 새롭게 생성해서 만든다 !!
	public Connection getConnect() throws SQLException {

		// 2. DB 연결 ------ conn 의 리턴타입이 Connection이여서 void를 Connection으로
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn; // kh 스크마를 적용한거다 !!
	}

	// 5. 자원반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	// 오버로딩이 일어남 !!
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

//	================================================================================================
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object) public void ___() ___ ___ {}
	public int addPerson(int id, String name, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreParedStatement () - INSERT
		String query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		// 해당하는 쿼리를 담아서 가져온다(prepareStatement)를 이용해서 사용!
		// 여기에서 기록된거여서 나중에 framework랑 spring 에서 이해가 더쉽고 더 잘 보일거다 !
		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate();

		// 5. 자원 반납 공통적인거
		closeAll(ps, conn);

		return result;

	}

	public int updatePerson(int id, String address) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreParedStatement () - UPDATE
		String query = "UPDATE person SET  address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행 (? 개수 만큼 우리가 set한다 !!)
		ps.setInt(2, id); // ? 순서대로 지정
		ps.setString(1, address);

		int result = ps.executeUpdate(); // 실행할때 !!

		// 자원반납 !!
		closeAll(ps, conn);

		return result;

	}

	public int removePerson(int id) throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreParedStatement () - DELETE
		String query = "DELETE FROM person where id=1;";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id); // ? 순서대로 지정

		int result = ps.executeUpdate();

		// 5. 자원 반납
		closeAll(ps, conn);

		return result;

	}

	public ArrayList<Person> searchAllPerson() throws SQLException {
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreParedStatement () - DELETE
		String query = "SELECT * FROM person;";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();

		while (rs.next()) {
			// 생성자 방식 !!
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

		// 3. 쿼리문 -> PreParedStatement () - SELECT
		String query = "SELECT * FROM person WhERE id = 111";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		Person person = null;
		
		if (rs.next()) {
			person = new Person(rs.getInt("id"),
								rs.getString("name"),
								rs.getString("address"));
		} // ? 순서대로 지정

		// 5. 자원 반납
		closeAll(rs, ps, conn);

		return person;
	}
}
