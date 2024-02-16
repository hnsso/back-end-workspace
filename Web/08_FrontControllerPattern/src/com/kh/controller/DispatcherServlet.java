package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// DispatcharServlet 에서 기능구현을 다만들수있도록 하게 한다 !! 
// command 로 받을려고 

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 반듣다.
		String command = request.getParameter("command");
		String path = "index.jsp";

		try {
			// command가 register인 경우
			if (command.equals("register")) {
				path = register(request, response); // index.jsp
			} else if (command.equals("login")) {
				path = login(request, response);
			} else if (command.equals("search")) {
				path = search(request, response);
			} else if (command.equals("allShow")) {
				path = allShow(request, response);
			} else if (command.equals("logout")) {
				path = logout(request, response);
			}
		} catch (SQLException e) {

		}

		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1 . 폼 가져오기 !
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2 . DAO 접근 !!
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);

		dao.registerMember(member);

		return "index.jsp";
	}

	protected String login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		// 1. 폼값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();

		Member member = dao.login(id, password);

		// 3. 바인딩 - Session
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return "";

	}

	protected String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1 . 폼값 받는다.
		String id = request.getParameter("id");

		// 2 . DAO
		MemberDAO dao = new MemberDAO();
		Member member = dao.findMember(id);

		if (member != null) {
			// 3. 바인딩
			request.setAttribute("member", member);

			return "view/find_ok.jsp";

		} else {

			return "view/find_fail.jsp";
		}
//  	삼항 연산자	
//		if (member != null)	request.setAttribute("member", member);
//		return member != null ? "view/find_ok.jsp" : "view/find_fail.jsp";
	}

	protected String allShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 2 . DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;

		try {
			list = dao.allShowMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 바인딩 !!
		request.setAttribute("list", list);
		
		// 네비게이션
		return "views/allShow.jsp";
}
		

	protected String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 3. Session에 있는 바인딩 죽이기
		HttpSession session = request.getSession();

		// 형변환
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			session.invalidate();
		}

		return "index.jsp";
	}
}
