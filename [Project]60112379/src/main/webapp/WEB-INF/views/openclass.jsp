<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "kr.ac.mju.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> ���� ���� ȭ��</h1>
	<table style = "width:100%">
		<tr>
			<td>���¹�ȣ</td>
			<td>�����</td>
			<td>����</td>
			<td>�г�</td>
			<td>����</td>
			<td>����</td>
		</tr>
		<tr>
		<%
		User user = (User) session.getAttribute("user");%>
		<form action = "${pageContext.request.contextPath}/ProController/openclass" method="post">
			<td><input type="text" name = "no"></td>
			<input type="hidden" name = "proname" value = <%=user.getName() %>>
			<td><input type="text" name = "name"></td>
			<td><input type="text" name = "year"></td>
			<td><input type="text" name = "grade"></td>
			<td><input type="text" name = "max"></td>
			<td><input type="text" name = "credit"></td>
			<td><button>���񰳼�</button></td>
		</form>
		</tr>
	</table></p>
	<a href="${pageContext.request.contextPath}/LoginController/logout" method = "get"> �α׾ƿ� </a>
</body>
</html>