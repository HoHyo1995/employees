<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
#title {
	text-align: center;
	
}

</style>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<hr>
<div id="titleBox">
	<h2 id="title">샘플DB employees로 구현-부서통계</h2>
</div>
<hr>
<div style="text-align: center;">
	<a href="/employees/selectEmployees" class="btn btn-outline-secondary join">사원조회</a>
	<a href="/employees/selectPosition" class="btn btn-outline-secondary join">직책통계</a>
	<a href="/employees/selectDepartments" class="btn btn-outline-secondary join">부서통계</a>
	<a href="/employees/selectSalaries" class="btn btn-outline-secondary join">연봉통계</a>
	<a href="/employees/logout" class="btn btn-outline-secondary join">로그아웃</a>
</div>
<hr>

</body>
<script>
	$("#title").click(function(){
		location.href="/employees/home"
	});
</script>
</html>