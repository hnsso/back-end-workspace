<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전체 회원 목록</h1>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
		</tr>
		<%-- 바인딩 한 값을 가져와야한다 !! --%>
		<c:forEach items="${list}" var="m">

			<tr>
				<td>${m.id}</td>
				<td>${m.name}</td>
				<td>${m.password}</td>
			</tr>

		</c:forEach>
	</table>

	<a href="/index.jsp">첫 페이지로 이동</a>

</body>
</html>