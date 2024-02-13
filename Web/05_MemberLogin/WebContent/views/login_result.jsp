<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<li><a href="views/login.html">로그인</a></li>
	<%--
			로그인 : 아이디, 비밀번호 입력받아서
			-> LoginServlet / post
			-> 세션 데이터 바인딩 !! 
			-> views/login_result.jsp로 이동해서 정보 출력
		 --%>
	<form action="LoginServlet" method="post">
		ID : <input type="text" name="id"><br>
		password :<input type ="password" name="password"><br>
		<input type="submit" value="로그인">
	</form>

</body>
</html>