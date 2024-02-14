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
	<h1>회원 관리 기능</h1>

	<ul>
		<%-- 
			== : eq , 
			!= : ne, 
			== null : empty => 비어있냐 ?, 
			!=null : not empty 
		--%>
		<c:choose>
			
			<c:when test="${empty member == null}">
				<li><a href="views/register.html">회원가입</a></li>
				<li><a href="views/login.html">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="views/search.html">회원가입</a></li>
				<li><a href="AllMemberServlet">전체회원보기</a></li>
				<li><a href="LogoutServlet">로그아웃</a></li>
				<%-- 로그아웃 : 로그아웃하고 index.jsp로 오면됨--%>
			</c:otherwise>
		</c:choose>
	</ul>

</body>
</html>