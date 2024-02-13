<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>			<!--   형변환	     여기는 객체이기때문에   -->
	<% Member info = (Member) request.getAttribute("info"); %>
	<h1>회원 정보 결과</h1>
	<ul>
		<li>아이디 : <%= info.getId() %></li>
		<li>비밀번호 : <%= info.getPassword() %></li>
		<li>이름 : <%= info.getName() %></li>
	</ul>
</body>
</html>