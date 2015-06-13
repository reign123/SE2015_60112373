<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>학사관리시스템</h1>

	<P>The time on the server is ${serverTime}.</P>
	
	<form action="${pageContext.request.contextPath}/LoginController/login" method="post">
		사용자 아이디 <input type="text" name="id"></input> <br /> 비밀번호 <input
			type="password" name="pwd"></input><br /> <input
			type="submit" value="로그인"></input>
	</form>
	<a href="${pageContext.request.contextPath}/UserController/userPage">회원가입</a>
</body>
</html>
