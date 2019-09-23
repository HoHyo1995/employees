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
</head>
<body>
<div class="container">
	<h1 class="text-primary">Index</h1>
	
	<h2>테이블 정보</h2>
	<table>
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
		<a href="${pageContext.request.contextPath}"/employees/getEmployeesListOrderBy?order=asc">오름차순50</a>
		<a href="${pageContext.request.contextPath}"/employees/getEmployeesListOrderBy?order=desc">내림차순50</a>
		</li>
		</ul>
	</div>
	<div>
		employees table total row count : ${employeesRowCount} 
	</div>
</div>
</body>
</html>