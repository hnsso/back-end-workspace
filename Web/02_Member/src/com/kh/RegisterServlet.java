package com.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

		//1 . index.html에서 /register로 요청을 하여
		// => 서버를 보내라

		// 2. 요청 받은 이름, 나이, 주소를 받아서
		// => request로 키값 받는다 !!
		
		// 3. result.jsp 파일로 해당 정보 출력
		// => request.파라미터로 출력 !

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	private String age;
	private String addr;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// 2. 요청 받은 이름, 나이, 주소를 받아서
		// => request로 키값 받는다 !!

		// 요청 파라미터로 html에 있는 키
		String name = request.getParameter("name");
		// 키로 가져와야해서 "" 로가져와야한다 !!
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");

//		response.setContentType("text/html;charset=utf-8");

		// <a href='result.jsp'>결과 확인</a> <-- 이 링크를 눌렸을 시
		// 해당 result.jsp 페이지에서
		// '주소'에 사는 '나이'세인 '이름' 가입완료 ! <-- h1 태크

		PrintWriter pw = response.getWriter();
		pw.println("<h1>이름 : " + name + "</h1>");
		pw.println("<h1>나이 : " + age + "</h1>");
		pw.println("<h1>거주지 : " + addr + "</h1>");

		// http://localhost:8080/register?name=&age=2&addr= 이게 get방식이다 !!
//										키        value
		pw.println("<a href='result.jsp?name=" + name + "&age=" + age + "&addr=" + addr + "'> result.jsp로 이동</a>");
//						    주소							&하는이유는 / 랑 같음 !! 
		pw.close();
	}

}
