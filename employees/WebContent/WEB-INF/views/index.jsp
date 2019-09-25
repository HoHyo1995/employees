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
input[type=number] {
  width: 100%;
  padding: 3px 5px;
  margin: 3px 0;
  box-sizing: border-box;
}
input[type=submit]{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
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
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무목록(중복제거)</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">업무통계값(count, sum, avg, max, min, std)</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">사원 수(성별 group by gender)</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재 부서별 사원수</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록페이징(10명씩)</a></li>
		</ul>
	</div>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type="number" name="begin">~<input type = "number" name="end">
			<input button type="submit">사원 목록 between..and..</button>
			<label>${minEmpNo}~${maxEmpNo}</label>
		</form>
	</div>
</div>
</body>
</html>