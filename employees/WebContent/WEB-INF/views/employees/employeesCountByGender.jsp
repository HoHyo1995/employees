<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GroupBy</h1>
	<table>
		<thead>
			<tr>
				<th>성별</th>
				<th>인원</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sl" items="${list }">
			<tr>
				<td>${sl.gen }</td>
				<td>${sl.genCnt }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>