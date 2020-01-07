<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
	height: 300px;
	text-align: center;
	padding-top: 250px;
}
form{
	background: #EAEAEA;
	width:330px; 
	height: 300px;
	position: absolute;
	top: 350px;
	left: 800px;
	padding-left: 20px;
	border-radius:0.5em;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
		<form method="post" action="${pageContext.request.contextPath}/login">
			<div class="form-group">
				<label>first_name :</label>
				<input type="text" name="firstName" class="form-control" style="width: 90%" value="Georgi">
			</div>
			<div class="form-group">
				<label>last_name :</label>
				<input type="text" name="lastName" class="form-control" style="width: 90%" value="Facello">
			</div>
			<div class="form-group">
				<label>emp_no :</label>
				<input type="text" name="empNo" class="form-control" style="width: 90%" value="10001">
			</div>
			<button type="submit" class="btn btn-primary" style="width: 90%">로그인</button>
	</form>
</body>
</html>