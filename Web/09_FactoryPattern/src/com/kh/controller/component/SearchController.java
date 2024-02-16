package com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class SearchController implements Controller {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// 1 . 폼값 받는다.
		String id = request.getParameter("id");

		// 2 . DAO
		MemberDAO dao = new MemberDAO();
		Member member = dao.findMember(id);

		if (member != null) {
			// 3. 바인딩
			request.setAttribute("member", member);

			return new ModelAndView("view/find_ok.jsp");

		} else {

			return new ModelAndView("view/find_fail.jsp", true);
		}

	}

}
