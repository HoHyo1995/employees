<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>10개씩 페이징한 사원리스트</h1>
	
	<!-- 출력 -->
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
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}">이전</a>
		</c:if>
	<!-- 다음-->
		<c:if test="${currentPage < lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}">다음</a>
		</c:if>
</body>
</html>