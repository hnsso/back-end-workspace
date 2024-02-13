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

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 . 폼 가져오기 !
		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		try {
			dao.findMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
