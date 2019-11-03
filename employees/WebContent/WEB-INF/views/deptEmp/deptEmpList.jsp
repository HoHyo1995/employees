<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeptEmpList</title>
</head>
<body>
	<h1>사원정보 한눈에 보기(부서번호, 부서이름, 사원번호, 이름(성+이름), 부서배정일)</h1>
	<form method="get" action="${pageContext.request.contextPath}/deptEmp/getDeptEmpList">
		<select name = "limit">
			<option value = "10">10</option>
			<option value = "20">20</option>
			<option value = "30">30</option>
			<option value = "40">40</option>
			<option value = "50">50</option>
		</select>
		<button type= "submit">선택</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>사원번호</th>
				<th>성</th>
				<th>이름</th>
				<th>부서배정일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dey" items="${list }">
				<tr>
					<td>${dey.departments.deptNo }</td>
					<td>${dey.departments.deptName }</td>
					<td>${dey.employees.empNo }</td>
					<td>${dey.employees.firstName}</td>
					<td>${dey.employees.lastName}</td>
					<td>${dey.toDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 이전 -->
	<c:if test="${currentPage > 1}">
	<a href="${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
	</c:if>
	<!-- 다음 -->
	<c:if test="${currentPage < totalRow }">
	<a href="${pageContext.request.contextPath}/deptEmp/getDeptEmpList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
	</c:if>
</body>
</html>