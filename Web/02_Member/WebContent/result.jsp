<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	// 3. result.jsp 파일로 해당 정보 출력 ---- 그리고 파일을 만들때는 html뒤에 오도록 만든다 !!
		//    => request.파라미터로 출력 !				 -->
	<%= request.getParameter("addr") %>에 사는
	<%= request.getParameter("age") %> 세인
	<%= request.getParameter("name") %> 가입 완료 !
	<!-- '주소'에 사는 '나이'세인 '이름' 가입완료 ! <-- h1 태크 
	if 만약에 한글이 안나오고 깨지면 인코딩을 해야한다 !! 근데  --> 
</body>
</html>