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
<title>샘플DB employees로 구현-사원 조회</title>
</head>
<body>
<hr>
<div id="titleBox">
	<h2 id="title">샘플DB employees로 구현</h2>
</div>
<hr>
<div style="text-align: center;">
	<a href="/employees/selectEmployees" class="btn btn-outline-secondary join">사원조회</a>
	<a href="/employees/selectPosition" class="btn btn-outline-secondary join">직책조회</a>
	<a href="/employees/selectDepartments" class="btn btn-outline-secondary join">부서조회</a>
	<a href="/employees/selectSalaries" class="btn btn-outline-secondary join">연봉통계</a>
	<a href="/employees/logout" class="btn btn-outline-secondary join">로그아웃</a>
</div>
<hr>
<table>
	<tr>
		<td>사번</td>
		<td>이름</td>
		<td>부서</td>
		<td>직책</td>
		<td>성별</td>
		<td>입사일</td>
	</tr>
	<c:forEach var="item" items="${list }">
		<tr>
			<td>${item.empNo }</td>
			<td>${item.firstName }</td>
			<td>${item.departments.deptName }</td>
			<td>${item.titles.title }</td>
			<td>${item.gender }</td>
			<td>${item.hireDate }</td>
		</tr>
	</c:forEach>
</table>
<div>
	<c:if test="${currentPage>1 }">
		<a href="/employees/selectEmployees?currentPage=${currentPage-1 }">이전</a>
	</c:if>
	<c:if test="${lastPage > currentPage}">
		<a href="/employees/selectEmployees?currentPage=${currentPage+1 }">다음</a>
	</c:if>
	
</div>
</body>
<script>
	$("#title").click(function(){
		location.href="/employees/home"
	});
</script>
</html>