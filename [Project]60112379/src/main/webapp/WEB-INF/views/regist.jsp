<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> ȸ������ ������ </h1>
		<form
		action="${pageContext.request.contextPath}/UserController/dataInsert"
		method="post">
		</p>
		ID : <input type="text" name="id">
		</p>
		PWD : <input type="password" name="pwd">
		</p>
		NAME : <input type="text" name="name">
		</p>
		�з� : <input type="radio" name="pos" value="stu" checked>
		�л� <input type="radio" name="pos" value="pro"> ����
		<input type="radio" name="pos" value="man"> ������
		<input type="submit" value="���Խ�û�ϱ�">
	</form>
	
	<a href="${pageContext.request.contextPath}">���ư���</a>
</body>
</html>