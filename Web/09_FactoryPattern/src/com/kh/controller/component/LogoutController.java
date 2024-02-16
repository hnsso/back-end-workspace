package com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.vo.Member;

public class LogoutController implements Controller  {

	public ModelAndView handle(HttpServletRequest request, 
			HttpServletResponse response) throws SQLException {
	
		HttpSession session = request.getSession();

		// 형변환
		Member member = (Member) session.getAttribute("member");
		if (member != null) {
			session.invalidate();
		}

		return new ModelAndView("index.jsp", true);
	
	}
}