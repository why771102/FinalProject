<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>

<meta charset="UTF-8">

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>showTimeHitory</title>

</head>
<body>

<div>
		<table>
		<tr>
			<td>日期:</td>
			<td>廳:</td>
			<td>代號:</td>
			<td>電影名稱:</td>
			<td>片長:</td>
			<td>播出時間:</td>
			<td>權重:</td>
		
		</tr>
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
	</div>
	上映日:		<input type='text' name="release"   value='${AllShowTime}' id='release' /><br>
	 <input id='a' type='submit' onclick="formSubmit()"/>
		<c:forEach var="stb" items="${AllShowTime}"> 
		<script>

        var a="${stb.time}";
		console.log(a);

		function c(){
		console.log(document.getElementById("movieBean").value);
		}
		
		
		
		</script>
		</c:forEach>  
		<script>
		
		function formSubmit(){
	
		alert("aaaaa");
		console.log($('#release').val());
        var aaa=JSON.stringify(document.getElementById('release').value);
        
        console.log(typeof(aaa));
		
		$.ajax({
			url : "${pageContext.request.contextPath}/save/showtime",
			data : {release:aaa},
			type : "POST",
			success : function() {
				alert("新增成功");
				window.location.href = "${pageContext.request.contextPath}/index-a";
			}
		});
		  
		}
		</script>
		
</body>
</html>
