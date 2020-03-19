<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#title {
	text-align: center;
	
}
</style>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
<hr>
<div>
	<h2 id="title">샘플DB employees로 구현</h2>
</div>
<hr>
<div style="text-align: center;">
	<button type="submit">사원조회</button> <button type="submit">직책조회</button> <button type="submit">부서조회</button> <button type="submit">연봉통계</button> <button type="submit">로그아웃</button>
</div>
<hr>
<h2>총 자료 Count</h2>
<table>
	<tr>
		<td>테이블 명</td>
		<td>카운트</td>
		<td>설명</td>
	</tr>
	<tr>
		<td>Department</td>
		<td>${departmentsCount }</td>
		<td>부서 번호 별 부서이름을 확인 할 수 있다.</td>
	</tr>
	<tr>
		<td>Dept_emp</td>
		<td>${deptEmpCount }</td>
		<td>사원의 사번을 통해 어디 부서인지 알 수 있다.</td>
	</tr>
	<tr>
		<td>Dept_manager</td>
		<td>${deptManagerCount }</td>
		<td>매니저의 사번을 통해 어디 부서 매니저인지 알 수 있다.</td>
	</tr>
	<tr>
		<td>Employees</td>
		<td>${employeesCount }</td>
		<td>직원의 자세한 정보를 알 수 있다.</td>
	</tr>
	<tr>
		<td>Salaries</td>
		<td>${salariesCount }</td>
		<td>직원의 연봉을 알 수 있다.</td>
	</tr>
	<tr>
		<td>titles</td>
		<td>${titlesCount }</td>
		<td>직원의 직종을 알 수 있다.</td>
	</tr>
</table>
</body>
</html>