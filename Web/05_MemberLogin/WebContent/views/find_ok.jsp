<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 검색 결과</h1>
	<%
	Member member = (Member) request.getAttribute("member");
	%>
	<ul>
		<%-- <%= 화면에 보여주는건 이거다 !!  --%>
		<li>아이디 : <%=member.getId() %></li>
		<li>비밀번호 : <%=member.getPassword() %></li>
		<li>이름 : <%=member.getName() %></li>
	</ul>
	<a href="index.jsp">첫 페이지로 이동</a>
</body>
</html>