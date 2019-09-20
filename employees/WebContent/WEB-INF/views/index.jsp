<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
	<h1>Index</h1>
	
	<!--  WEB APP 네비게이션 -->
	<div>
		<ul>
		<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서목록</a></li>
		<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원목록</a></li>
		</ul>
	</div>
	<div>
	
		employees table total row count : ${employeesRowCount} 
	</div>
</body>
</html>