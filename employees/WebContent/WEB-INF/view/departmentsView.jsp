<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- Google chart API -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
  google.charts.load('current', {'packages':['bar']});
  google.charts.setOnLoadCallback(drawStuff);
  
 	var chartContents = [['Opening Move', 'Percentage']];
	<c:forEach var="item" items="${list}">
  		var plusContents = ["${item.sort}", ${item.peoples}];
  		chartContents.push(plusContents);
	</c:forEach>
	console.log(chartContents);

 	function drawStuff() {
	    var data = new google.visualization.arrayToDataTable(chartContents);

    	var options = {
	      title: 'Chess opening moves',
	      width: 900,
	      legend: { position: 'none' },
	      chart: { title: '',
	               subtitle: '' },
	      bars: 'horizontal', // Required for Material Bar Charts.
	      axes: {
	        x: {
	          0: { side: 'top', label: '인원 수'} // Top x-axis.
	        },
	        y: {
	        	0: {side: 'top', label: '부서 이름'}
	        }
	      },
	      bar: { groupWidth: "90%" }
	    };
	
	    var chart = new google.charts.Bar(document.getElementById('top_x_div'));
	    chart.draw(data, options);
	  };
</script>
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
<div id="titleBox">
	<h2 id="title">샘플DB employees로 구현-부서통계</h2>
</div>
<hr>
<div style="text-align: center;">
	<a href="/employees/selectEmployees" class="btn btn-outline-secondary join">사원조회</a>
	<a href="/employees/selectPosition" class="btn btn-outline-secondary join">직책통계</a>
	<a href="/employees/selectDepartments" class="btn btn-outline-secondary join">부서통계</a>
	<a href="/employees/selectSalaries" class="btn btn-outline-secondary join">연봉통계</a>
	<a href="/employees/logout" class="btn btn-outline-secondary join">로그아웃</a>
</div>
<hr>
  <h3>부서 별 인원 수</h3>
  <div id="top_x_div" style="width: 900px; height: 500px;"></div>
  
      
</body>
<script>
	$("#title").click(function(){
		location.href="/employees/home"
	});
</script>
</html>