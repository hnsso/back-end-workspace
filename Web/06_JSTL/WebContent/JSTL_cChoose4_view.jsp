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
	<%-- switch 조건문 el모드  --%>
	<c:choose>
		<%--  == 부등호와 eq 같은거다  --%>
		<c:when test="${param.num eq '1'}">
			<a href=""></a>
			안녕하세요
		</c:when>
		<c:when test="${param.num eq '2'}">
			반갑습니다.
		</c:when>
		<c:otherwise>
			패트와 매트
		</c:otherwise>
	</c:choose>
</body>
</html>