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
<title>부서 목록</title>
</head>
<body>
<div class="container">
	<h1>부서 목록</h1>
	<!--  List<Departments> list = (List<Departments>)request.getAttribute("list");
		${list}  -->
<!-- 출력하자 -->
	<table id="customers">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list }">
				<tr class="table-primary">
					<td>${departments.deptNo }</td>
					<td>${departments.deptName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>