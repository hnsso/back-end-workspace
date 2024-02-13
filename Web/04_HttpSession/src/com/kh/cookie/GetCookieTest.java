package com.kh.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetCookieTest")
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();	// Cookie 배열로 가져온다 !!
		for(Cookie c : cookies) { // 각각의 쿠키를 가져오는 향상된 for문
			System.out.println(c.getName() + " : " + c.getValue());
		}
	
	}

}
