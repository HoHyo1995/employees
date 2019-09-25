<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h1 {
  color: green;
}
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
<title>사원 목록</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<body>
<div class="container">
	<h1>사원목록</h1>
	<form method = "get" action="${pageContext.request.contextPath}/employees/getEmployeesList">
	<select name="limit" class="custom-select">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
		<option value="50">50</option>
	</select>
	<label>개씩보기</label>
	<button type="submit" class="btn btn-info">사원목록</button>
	</form>
	<table id="customers">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>생년월일</th>
				<th>성</th>
				<th>이름</th>
				<th>성별</th>
				<th>고용일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">
				<tr class="table-primary">
					<td>${employees.empNo}</td>
					<td>${employees.birthDate}</td>
					<td>${employees.firstName}</td>
					<td>${employees.lastName}</td>
					<td>${employees.gender}</td>
					<td>${employees.hireDate}</td>
				</tr>
				</c:forEach>
		</tbody>
	</table>
	
<div class="container">
</body>
</html>