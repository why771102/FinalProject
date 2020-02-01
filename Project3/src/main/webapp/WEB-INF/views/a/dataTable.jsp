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
				<td>修改:</td>

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
				<td><input id='a' type='submit' onclick="formSubmit()" value='修改'/></td>
				<input type='hidden' name="date"   value='${stb.day}' id='date' />
				<input type='hidden' name="time"   value='${stb.time}' id='time' />
			</tr>
		</c:forEach>
	</table>
<!-- 	<input id='b' type='submit' onclick="updateAllSubmit()" value='修改全部'/> -->
<%-- 	<a href='${pageContext.request.contextPath}/a/updateShowTime'>修改</a> --%>
	<a href='${pageContext.request.contextPath}/index-a'>確認</a>
	
	<script>
		$(document).ready(function() {
			$("#table").dataTable();
		});
	   var a=${jsonString}
		console.log(a[0].showTimeId);
		
		function updateAllSubmit(){
			var date1 = a[0].day;
			var time1 = a[0].time;
			console.log(date1);
			console.log(time1);
			$.ajax({
				url : "${pageContext.request.contextPath}/showTime/upadate",
				data : {date: date1,time:time1},
				type : "POST",
				success : function() {
					alert("修改成功");
					window.location.href = "${pageContext.request.contextPath}/index-a";
				}
			});
			
		}
		
		
		
		
		function formSubmit(){
			
			var date = document.getElementById("date").value;
			var time = document.getElementById("time").value;
			console.log(date);
			console.log(time);
			location.replace("${pageContext.request.contextPath}/showTime/update/"+date+"="+time);

// 			$.ajax({
// 				url : "${pageContext.request.contextPath}/showTime/upadate",
// 				data : {date: date,time:time},
// 				type : "POST",
// 				success : function() {
// 					alert("修改成功");
// // 					window.location.href = "${pageContext.request.contextPath}/showTime/upadate";
// 				}
// 			});
		}
		
		
	</script>
</body>
</html>