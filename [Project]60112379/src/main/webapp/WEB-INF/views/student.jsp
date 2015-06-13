<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>학생페이지</h1>
	<a href="${pageContext.request.contextPath}/StudentController/RFCpage" method = "get"> 1.수강신청 </a></p>
	<a href="${pageContext.request.contextPath}/StudentController/gradeview" method = "get"> 2.성적열람 </a></p>
	
	<a href="${pageContext.request.contextPath}/LoginController/logout" method = "get"> 로그아웃 </a>
</body>
</html>