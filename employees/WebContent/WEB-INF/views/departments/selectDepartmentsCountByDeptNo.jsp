<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서별 사원수</h1>
	<table id="customers">
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>부서사원수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="deptEmp" items="${list}">
			<tr>
				<td>${deptEmp.deptNo }</td>
				<td>${deptEmp.deptName }</td>
				<td>${deptEmp.cnt}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>