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
		<input type="submit" value="���� ����">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/createDB"
		method="post">
		<input type="submit" value="������ ���̽� ����">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/createTable"
		method="post">
		<input type="submit" value="User ���̺� ����">
	</form>
	</p>
	</p>
	
	<form
		action="${pageContext.request.contextPath}/UserController/createTable2"
		method="post">
		<input type="submit" value="Class ���̺� ����">
	</form>
	</p>
	</p>
	
	<form
		action="${pageContext.request.contextPath}/UserController/createTable3"
		method="post">
		<input type="submit" value="RegistForCourse ���̺� ����">
	</form>
	</p>
	</p>
	
	<a href="${pageContext.request.contextPath}/UserController/regist">ȸ������</a>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropTable"
		method="post">
		<input type="submit" value="User ���̺� ���">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropTable2"
		method="post">
		<input type="submit" value="RFC ���̺� ���">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropDB"
		method="post">
		<input type="submit" value="�����ͺ��̽� ���">
	</form>
	</p>
	</p>
	<form
		action="${pageContext.request.contextPath}/UserController/dropAccount"
		method="post">
		<input type="submit" value="���� ���">
	</form>
	</p>
	</p>
</body>
</html>