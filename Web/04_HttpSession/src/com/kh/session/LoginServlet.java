package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 어떤기능이 들어가는지 하는 부분 !! 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 폼값 가져오기 !!!!!!!!!!!! => html에 있는 키값
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. vo로 담기 ~ ~ ! 
		
		
		// 3. DAO 생략 .. 로그인 성공했다 가정 !! 
		// member 정보를 가져온다 !! 
		Member member = new Member(id, password, "테스트");
		
	
		// HttpSession
		// 1) 세션을 하나 받아온다
		HttpSession session = request.getSession();
		
		// 원래는 request.setAttribute로 바인딩을 했는데 로그인은 다르다
		// 2) 세션에 바인딩한다 !! 
		session.setAttribute("info", member);
		
		// 2. 네비케이션
		response.sendRedirect("ProductServlet");
		
	}

}
