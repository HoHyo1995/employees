<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
	<h2 id="title">샘플DB employees로 구현</h2>
</div>
<hr>
<div style="text-align: center;">
	<a href="/employees/selectEmployees" class="btn btn-outline-secondary join menuBtn">사원조회</a>
	<a href="/employees/selectPosition" class="btn btn-outline-secondary join menuBtn">직책조회</a>
	<a href="/employees/selectDepartments" class="btn btn-outline-secondary join menuBtn">부서조회</a>
	<a href="/employees/selectSalaries" class="btn btn-outline-secondary join menuBtn">연봉통계</a>
</div>
<hr>
<div>
	<form method="post" action="/employees/login">
		<h2>Login</h2>
		<b>이름 : </b><input type="text" name="name" value="Facello">
		<b>사번 : </b><input type="text" name="no" value="10001">
		<button type="submit" class="btn btn-outline-secondary join">로그인</button>
	</form>
</div>
</body>
<script>
$(".menuBtn").attr("href","/employees/home");
$(".menuBtn").click(function(){
	alert("로그인을 한 후 사용이 가능합니다.");
});
</script>
</html>