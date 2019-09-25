<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택범위 사원목록</h1>
	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>생일</th>
				<th>성</th>
				<th>이름</th>
				<th>성별</th>
				<th>고용일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="se" items="${list }">
			<tr>
				<td>${se.empNo}</td>
				<td>${se.birthDate }</td>
				<td>${se.firstName }</td>
				<td>${se.lastName }</td>
				<td>${se.gender }</td>
				<td>${se.hireDate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>