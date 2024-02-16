package com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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

@WebServlet("*.do")
// *.do로 보내겠다 !!
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// hidden 값으로 들어온 요청을 받지 않고,
		// 들어온 요청의 주소를 직접 인식시킨다 .
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		
		// 사용자가 어떤 기능을 요구하는지 받는 주문서 !
		String command = requestURIList[requestURIList.length -1];
		// 공장 역할을 하는 아이들 만들어야한다 !!
		
		// 주문한 것에 따라 기능이 들어간 컨트롤러 생성(컴포넌트)
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			// 각 컴포넌트의 비즈니스 로직 실행!
			ModelAndView mv = controller.handle(request, response);
		
			if(mv != null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				} else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
//		======================================================================================
		
		
		
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

		return "views/login_result.jsp";

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
