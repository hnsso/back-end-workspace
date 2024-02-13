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


@WebServlet("/search") 
// 여기는 Controller 역할을 한다 !!
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// 서비스가 뭘하는지를 작성한다 !! 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 폼 값 받아온다 .
		String name = request.getParameter("name");
		
		// 2. VO작성 인데 name 하나여서 
		
		// 3. DAO = 데이터 접근 !!
		MemberDAO dao = new MemberDAO(); // 그래서 MemberDAO가 필요하다 !! 그리거 DAO로 이동
		Member member = null;
		try {
		 member = dao.searchMember(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 바인딩 내가 가지고온 정보 담아내는곳 !!
		request.setAttribute("info", member);
//							 아무거나로 가능하다 
		
		// 4. 네비게이션으로 : 나이거 어디서 보여줄거야 !! (만약에 맴버 정보가 없으면 .. 이라는것 추가 !)
		if(member!=null) {
		request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp"); // null인경우 !! 
		}
		
	}

}
