package com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// Extend 는 클래스 끼리 상속
// 
public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, 
			HttpServletResponse response) throws SQLException {

		// 1 . 폼 가져오기 !
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		// 2 . DAO 접근 !!
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, password, name);
		dao.registerMember(member);

		return new ModelAndView("index.jsp", true);
	}

}
