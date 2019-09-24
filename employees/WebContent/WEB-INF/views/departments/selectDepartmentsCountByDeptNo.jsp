<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서별 사원수</h1>
	<table>
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>부서사원수</td>
		</tr>
		<c:forEach var="deptEmp" items="${list}">
		<tr>
			<td>${deptEmp.deptNo }</td>
			<td>${deptEmp.deptName }</td>
			<td>${deptEmp.cnt}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>