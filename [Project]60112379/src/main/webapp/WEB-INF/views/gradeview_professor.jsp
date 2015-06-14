<%@page import="kr.ac.mju.RegistForCourse"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.RegistForCourse"%>
<%
	ArrayList<RegistForCourse> rfc = (ArrayList<RegistForCourse>) request.getAttribute("grantList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>성적 열람 화면</h1>
	<table style="width: 70%">
		<tr>
			<td>학생</td>
			<td>성적</td>
			<td>성적부여</td>
		</tr>
			<%
				for (int i = 0; i < rfc.size(); i++) {
					RegistForCourse tPro = rfc.get(i);
			%>
			<tr>
			<td><%=tPro.getStudentname()%></td>
			<td><%=tPro.getClassGrade()%></td>
			<td><form action="${pageContext.request.contextPath}/ProController/grantgrade"
		method="GET">
				<input type = "hidden" name = "name" value = <%=tPro.getStudentname() %>>
				<input type = "hidden" name = "classname" value = <%=tPro.getClassname() %>>
				<input type = "text" name = "classgrade">
				<button>성적 부여</button>
			</form>
			</td></tr>
			<%
				}
			%>
	</table>

	<br />
	<a href="${pageContext.request.contextPath}/LoginController/logout"
		method="get"> 로그아웃 </a>
</body>
</html>