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
	<h1>salary 통계 값</h1>
	<table id="customers">
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