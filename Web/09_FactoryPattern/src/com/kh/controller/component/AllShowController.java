package com.kh.controller.component;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class AllShowController implements Controller  {

	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
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
				return new ModelAndView("views/allShow.jsp", true);
	}
}
