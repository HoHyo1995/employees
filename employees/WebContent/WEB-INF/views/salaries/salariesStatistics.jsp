<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>salary 통계 값</h1>
	<table>
		<thead>
			<tr>
				<th>count</th>
				<th>sum</th>
				<th>avg</th>
				<th>max</th>
				<th>min</th>
				<th>std</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${map.count }</td>
				<td>${map.sum }</td>
				<td>${map.avg }</td>
				<td>${map.max }</td>
				<td>${map.min }</td>
				<td>${map.std }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>