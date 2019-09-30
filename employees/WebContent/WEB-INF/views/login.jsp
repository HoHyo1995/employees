<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<div>
				<label>first_name :</label>
				<input type="text" name="firstName">
			</div>
			<div>
				<label>last_name :</label>
				<input type="text" name="lastName">
			</div>
			<div>
				<label>emp_no :</label>
				<input type="text" name="empNo">
			</div>
			<button type="submit">로그인</button>
		</form>

</body>
</html>