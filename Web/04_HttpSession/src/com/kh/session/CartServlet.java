package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;


@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// session에 있는거 들고 옴
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("info");
		
		// request에 있는거 들고 왔다 
		String product = (String) request.getAttribute("product");
	
		System.out.println(member);
		System.out.println(product);
		
		// 로그아웃! 즉 세션 정보 죽여버리기 ~~~ !!!!!!
		session.invalidate();
		response.sendRedirect("index.html");
		
	}

}
