<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Index.jsp</title>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<div class="container">
	<h1 class="text-primary">Index</h1>
	
	<h2 style="border:2px solid Tomato;color:Tomato;">테이블 정보</h2>
	<table id="customers">
		<thead>
			<tr>
				<th>테이블 이름</th>
				<th>전체 행의 수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>departments</td>
				<td>${departmentsRowCount }</td>
			</tr>
			<tr>
				<td>employees</td>
				<td>${employeesRowCount}</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptManagerRowCount }</td>
			</tr>
			<tr>
				<td>dept_emp</td>
				<td>${deptEmpRowCount }</td>
			</tr>
			<tr>
				<td>titles</td>
				<td>${titlesRowCount }</td>
			</tr>
			<tr>
				<td>salaries</td>
				<td>${salariesRowCount }</td>
			</tr>
		</tbody>
	</table>
	<!--  WEB APP 네비게이션 -->
	<div>
		<ul class="list-group">
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
		<li class="list-group-item">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순50</a>
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순50</a>
		</li>
		<li><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무목록(중복제거)</a></li>
		<li><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">업무통계값(count, sum, avg, max, min, std)</a></li>
		</ul>
	</div>
</div>
</body>
</html>