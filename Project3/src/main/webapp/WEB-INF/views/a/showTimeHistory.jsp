<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>showTimeHitory</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

</head>
<body>
	<table id="table" class="display">
		<thead>
			<tr>
				<td>日期:</td>
				<td>廳:</td>
				<td>代號:</td>
				<td>電影名稱:</td>
				<td>片長:</td>
				<td>播出時間:</td>
				<td>權重:</td>

			</tr>
		</thead>
		<c:forEach var="stb" items="${AllShowTime}">
			<tr>
				<td>${stb.day}</td>
				<td>${stb.hall.hallID}</td>
				<td>${stb.stID}</td>
				<td>${stb.rb.movie.title}</td>
				<td>${stb.runningTime}</td>
				<td>${stb.time}</td>
				<td>${stb.price_time}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		$(document).ready(function() {
			$("#table").dataTable();
		});
	</script>
</body>
</html>