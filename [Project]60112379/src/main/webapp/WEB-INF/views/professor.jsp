<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>교수 페이지</h1>
	<a href="${pageContext.request.contextPath}/ProController/openclasspage"> 1. 강좌개설</a></p>
	<a href="${pageContext.request.contextPath}/ProController/gradegrantpage"> 2. 성적부여</a>
	</p>
	<a href="${pageContext.request.contextPath}/LoginController/logout" method = "get"> 로그아웃 </a>
</body>
</html>