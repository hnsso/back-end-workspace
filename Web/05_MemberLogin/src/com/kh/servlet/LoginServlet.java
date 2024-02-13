package com.kh.servlet;

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

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		Member member = new Member(id, password, "name");
		
		// 1) 세션을 하나 받아온다
		HttpSession session = request.getSession();
		
		session.setAttribute(password, session);
	
		// 2. 네비케이션
		response.sendRedirect("login_result.jsp");
		
	}

}
