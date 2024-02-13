package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

//        원래는 xml 에다가 연결을 했는데 이제는 필요없다 !!
//			= 이걸로 연결
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 우리는 이제 Servlet에 Controller 역할을 작성(= 비즈니스 로직 작성공간으로 한다)
		
		// 1. 폼을 값 받아온다(요청)
		
		//  => 클라이언트에서 우리가 입력한 id password name이 HTTP요청해서 매개변수값을 가져오는거다 !
		String id = request.getParameter("id");
		// -> 이부분은 입력한 id를 HTTP요청에서 id 매개변수 값을 가져오고 접근할수있다 !
		
		// # 클라이언트에서 ~> 웹 어플리케이션으로 전송하는 매개변수에 접근하는거다 !
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");

		// 2. VO에 작성
		
		// 나중에 DAO에 값을 던질때 만든 메서드 !! 
		Member member = new Member(id, pwd, name);

		// 3. DAO 리턴 받기
		
		// 우리가 그리고 DAO에 접근하기 위해서는 객체를 생성해줘야한다
		// DAO 호출 !! 
		MemberDAO dao = new MemberDAO();
		
		
		int result = 0; // 
		
		try {
			result = dao.registerMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 4. 바인딩 : 결과 페이지에 서버에서 받은 값을 보낼 때
		//					   키     벨류
		request.setAttribute("name", name);
		// 서버나 클라이언트에서 받은 값들을 HTML로 보내는 작업 => 바인딩
		
		
		// 5. 네비게이션 : 결과 페이지 지정
		
		//	request.getRequestDispatcher("result.jsp").forward(request, response);
		// -> 만약에 회원가입이 끝나고 view 페이지를 보여주고 싶다
		
		//   view 페이지는 폼 값 받는 로직 x
		response.sendRedirect("view");
		// 클라이언트에서 새로운 URL로 이동하도록 요청하는 메서드 => 리다이렉션이라고 말한다.
		// 결론적으로 다른 페이지로 이동시키는 거다 !!
		
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);

	}

}
