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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Servlet의 중요 비즈니스 로직인데 상황에 따라 달라진다 !!
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 . 폼 가져오기 !
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		// 2 . DAO 접근 !! 
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);
		
		try {
			int result = dao.registerMember(member);
			
			if(result == 1) {
			
			// 4. 네비게이션
			response.sendRedirect("index.jsp");
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}		
	}
}
