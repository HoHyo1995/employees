<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
  background-color: #47C83E;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

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
	<h1>10개씩 페이징한 사원리스트</h1>
	
	<!-- 출력 -->
	<table id="customers">
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
				<c:forEach var="pg" items="${list }">
					<tr>
						<td>${pg.empNo }</td>
						<td>${pg.birthDate }</td>
						<td>${pg.firstName }</td>
						<td>${pg.lastName }</td>
						<td>${pg.gender }</td>
						<td>${pg.hireDate }</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	<!-- 이전 -->
		<c:if test="${currentPage > 1 }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}" >이전</a>
		</c:if>
	<!-- 다음-->
		<c:if test="${currentPage < lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}" >다음</a>
		</c:if>
</body>
</html>