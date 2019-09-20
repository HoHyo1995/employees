<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
</head>
<body>
	<h1>부서 목록</h1>
	<!--  List<Departments> list = (List<Departments>)request.getAttribute("list");
		${list}  -->
<!-- 출력하자 -->
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list }">
				<tr>
					<td>${departments.deptNo }</td>
					<td>${departments.deptName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>