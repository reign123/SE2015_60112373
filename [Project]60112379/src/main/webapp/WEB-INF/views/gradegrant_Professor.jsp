<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.Pro"%>
<%@ page import="kr.ac.mju.User"%>
<%
	ArrayList<Pro> pro = (ArrayList<Pro>) request
			.getAttribute("proList");
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� �ο� ȭ�� ����</h1>
	<table style="width: 70%">
		<tr>
			<td>���¹�ȣ</td>
			<td>�����</td>
			<td>�����⵵</td>
			<td>�г�</td>
			<td>����</td>
			<td>����</td>
		</tr>
			<%
				for (int i = 0; i < pro.size(); i++) {
					Pro tPro = pro.get(i);
					if (tPro.getProname().equals(user.getName())) {
			%>
			<tr>
			<td><%=tPro.getNo()%></td>
			<td><%=tPro.getName()%></td>
			<td><%=tPro.getYear()%></td>
			<td><%=tPro.getGrade()%></td>
			<td><%=tPro.getMax()%></td>
			<td><%=tPro.getCredit()%></td></tr>
			<%
				}
				}
			%>
	</table>
	</p>
	<form
		action="${pageContext.request.contextPath}/ProController/gradegrant"
		method="get">
		������ �ο��� ������ ���¹�ȣ�� ������ �ּ���.
		</p>
		<input type="text" name="no">
		<button>���� �ο��ϱ�</button>
	</form>
	</p>

	<a href="${pageContext.request.contextPath}/LoginController/logout"
		method="get"> �α׾ƿ� </a>
</body>
</html>