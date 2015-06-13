<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원가입 페이지 </h1>
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
		분류 : <input type="radio" name="pos" value="stu" checked>
		학생 <input type="radio" name="pos" value="pro"> 교수
		<input type="radio" name="pos" value="man"> 관리자
		<input type="submit" value="가입신청하기">
	</form>
	
	<a href="${pageContext.request.contextPath}">돌아가기</a>
</body>
</html>