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
	<h1>������ûȭ��</h1>
	<table style="width: 70%">
		<tr>
			<td>���¹�ȣ</td>
			<td>�����</td>
			<td>��米��</td>
			<td>�����⵵</td>
			<td>�г�</td>
			<td>����</td>
			<td>����</td>
			<td>��û�ϱ�</td>
		</tr>
		<tr>
			<%
				for (int i = 0; i < pro.size(); i++) {
					Pro tPro = pro.get(i);
			%>
			<form
				action="${pageContext.request.contextPath}/StudentController/RFC"
				method="POST">
			<td><%=tPro.getNo()%></td>
			<td><%=tPro.getName()%></td>
			<td><%=tPro.getProname()%></td>
			<td><%=tPro.getYear()%></td>
			<td><%=tPro.getGrade()%></td>
			<td><%=tPro.getCredit()%></td>
			<td><%=tPro.getMax()%></td>
			
			<input type = "hidden" name = "stuname" value = <%=user.getName() %>>
			<input type = "hidden" name = "classnum" value  =<%=tPro.getNo() %>>
			<input type = "hidden" name = "classname" value = <%=tPro.getName() %>>
			<input type = "hidden" name = "proname" value = <%=tPro.getProname() %>>
			<input type = "hidden" name = "year" value = <%=tPro.getYear() %>>
			<input type = "hidden" name = "grade" value = <%=tPro.getGrade() %>>
			<input type = "hidden" name = "credit" value = <%=tPro.getCredit() %>>
			<input type = "hidden" name = "max" value = <%=tPro.getMax() %>>
			<td><button>��û</button></td>
			</form>
			</tr>
			<%
				}
			%>
	</table><br/>
	<a href="${pageContext.request.contextPath}/LoginController/logout" method = "get"> �α׾ƿ� </a>

</body>
</html>