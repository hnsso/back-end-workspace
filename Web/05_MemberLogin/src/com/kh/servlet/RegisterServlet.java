package com.kh.servlet;

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

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 . 폼 가져오기 !
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		// 2 . DAO 접근 !! 
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);
		
		try {
			dao.registerMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3 . 바인딩
		request.setAttribute("id", id );
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		
		
		// 4 . 보내야한다
		if(member!=null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			} 
		
	}
}
