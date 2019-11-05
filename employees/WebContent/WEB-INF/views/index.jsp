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
#notice {
	color : red;
	font-weight: 600;
}
#homebtn {
	font-size: xx-large;
}
#logout {
	float : right;
	font-size: large;
}
input[type=number] {
  width: 46%;
  padding: 2px 3px;
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
	<div>
		<a href="${pageContext.request.contextPath}/index" id = "homebtn">Home</a>
		<!-- 로그인시 로그아웃뜨게하기 -->
		<c:if test="${sessionEmpNo != null }">
			<a href="${pageContext.request.contextPath}/LogoutServlet" id="logout">로그아웃</a>
		</c:if>
	</div> 
	<h2 style="border:2px solid Tomato;color:Tomato;">테이블 정보</h2>
	<!--  WEB APP 네비게이션 -->
	<div class="row">
	<div class="col-sm-2">
		<ul class="list-group">
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
		<li class="list-group-item">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a>
		</li>
		<li class="list-group-item">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순50</a>
		</li>
		<li class="list-group-item">
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순50</a>
		</li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">부서목록(중복X)</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">업무통계</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">현재 재직자 수</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">부서별 사원 수</a></li>
		<li class="list-group-item"><a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록페이징(10명씩)</a></li>
		</ul>
	</div>
	<!--  좌우 나눠지는 경계선 -->
	<div class="col-sm-10">
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
				<td>${departmentsRowCount}</td>
			</tr>
			<tr>
				<td>employees</td>
				<td>${employeesRowCount}</td>
			</tr>
			<tr>
				<td>dept_manager</td>
				<td>${deptManagerRowCount}</td>
			</tr>
			<tr>
				<td>dept_emp</td>
				<td>${deptEmpRowCount}</td>
			</tr>
			<tr>
				<td>titles</td>
				<td>${titlesRowCount}</td>
			</tr>
			<tr>
				<td>salaries</td>
				<td>${salariesRowCount}</td>
			</tr>
		</tbody>
	</table>
	
	<div>
		<br>
		<label id= "notice">${minEmpNo}~${maxEmpNo}의 값만 입력하세요.</label>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<span><input type="number" name="begin"></span><span>~</span><span><input type = "number" name="end"></span>
			<button type="submit" class="btn btn-outline-success">검색</button>
		</form>
	</div>
	</div>
	</div>
</div>
</body>
</html>