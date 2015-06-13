<%@page import="kr.ac.mju.RegistForCourse"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.Pro"%>
<%@ page import="kr.ac.mju.User"%>
<%
	ArrayList<RegistForCourse> rfc = (ArrayList<RegistForCourse>) request.getAttribute("rfc");
	User user = (User) session.getAttribute("user");
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
			<td>강좌번호</td>
			<td>과목명</td>
			<td>담당교수</td>
			<td>개설년도</td>
			<td>학년</td>
			<td>학점</td>
			<td>정원</td>
			<td>성적</td>
		</tr>
			<%
				for (int i = 0; i < rfc.size(); i++) {
					RegistForCourse tPro = rfc.get(i);
					if (user.getName().equals(tPro.getStudentname())) {
			%>
			
			<tr><td><%=tPro.getNo()%></td>
			<td><%=tPro.getClassname()%></td>
			<td><%=tPro.getProname()%></td>
			<td><%=tPro.getYear()%></td>
			<td><%=tPro.getGrade()%></td>
			<td><%=tPro.getCredit()%></td>
			<td><%=tPro.getMax()%></td>
			<td><%=tPro.getClassGrade()%></td></tr>
			<%
				}
				}
			%>
	</table>

	<a href="${pageContext.request.contextPath}/LoginController/logout"
		method="get"> 로그아웃 </a>
</body>
</html>