package com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class LoginController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 비즈니스 로직

		// 1. 폼값 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = dao.login(id, password);

		// 3. 바인딩(데이터 보내기) - Session : 서버가 끝날때까지 남는다 !!  여러페이지에서 계속 로그인된 상태를 해야하니깐 !!
		// 						 request 에 바인딩하는거
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		return new ModelAndView("views/login_result.jsp", true);
	}

}
