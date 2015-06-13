<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/UserController/createAccount"
		method="get">
		<input type="submit" value="계정 생성">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/createDB"
		method="post">
		<input type="submit" value="데이터 베이스 생성">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/createTable"
		method="post">
		<input type="submit" value="User 테이블 생성">
	</form>
	</p>
	</p>
	
	<form
		action="${pageContext.request.contextPath}/UserController/createTable2"
		method="post">
		<input type="submit" value="Class 테이블 생성">
	</form>
	</p>
	</p>
	
	<form
		action="${pageContext.request.contextPath}/UserController/createTable3"
		method="post">
		<input type="submit" value="RegistForCourse 테이블 생성">
	</form>
	</p>
	</p>
	
	<a href="${pageContext.request.contextPath}/UserController/regist">회원가입</a>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropTable"
		method="post">
		<input type="submit" value="User 테이블 드랍">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropTable2"
		method="post">
		<input type="submit" value="RFC 테이블 드랍">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropDB"
		method="post">
		<input type="submit" value="데이터베이스 드랍">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropAccount"
		method="post">
		<input type="submit" value="계정 드랍">
	</form>
	</p>
	</p>
</body>
</html>