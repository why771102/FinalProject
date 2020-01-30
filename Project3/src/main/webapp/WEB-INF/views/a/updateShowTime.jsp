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
<h1>修改頁面</h1>
    <input  />
	<table id="table" class="display">
	   <div>日期:  廳:</div>
	   
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
	<tbody id='table_tr'>
			<tr>
				<td>${stb.hall.hallID}</td>
				<td>${stb.stID}</td>
				<td>${stb.rb.movie.title}</td>
				<td>${stb.runningTime}</td>
				<td>${stb.time}</td>
				<td>${stb.price_time}</td>
			</tr>
	</tbody>
	</table>
	
	
	<table id="table" class="display">
	   <div>日期:  廳:</div>
	   
		<thead>
			<tr>
			
				<td>日期:</td>
				<td>廳:</td>
				<td>排片類別:</td>
				<td>電影名稱:</td>
				<td>片長:</td>
				<td>播出時間:</td>
				<td>權重:</td>
				

			</tr>
		</thead>
	
			<tr>
				<td>${stb.hall.hallID}</td>
				<td>${stb.stID}</td>
				<td>${stb.rb.movie.title}</td>
				<td>${stb.runningTime}</td>
				<td>${stb.time}</td>
				<td>${stb.price_time}</td>
			</tr>
	
	</table>
	
	<a href=''>修改</a>
	<a href='index-a'>確認</a>
	<script>
 	
	   var a=${jsonString}
		console.log(a[0].stID);
		console.log(a.length);
		console.log(a);
		
		//分出包場和電影  往上append to Data table
		for(let i =0 ;i<a.length;i++){
			
			//包場
			if(a[i]["stID"]=="0"){
				console.log("包場"+a[i].stID);
				$(document).ready(function () {
	                   $("#table_tr").append(
	                       " <tr id=tr" + i + ">" +
	                       "<td>" + a[i].day + "</td>" +
	                       "<td>" + a[i].sthb.hall.hallID + "</td>" +
	                       "<td>" + a[i].stID + "</td>" +
	                       "<td>" +a[i].hob.hallPurpose+
	                       "</td>" +
	                       "<td><p id='runningTime" + i + "'>" + a[i].runningTime+ "</p></td>" +
	                       "<td id='time" + i + "'>" +a[i].time
	 
	                       + "</td>" +
	                       "<td>max</td>" +
	 
	                       "</tr>");
	               });

				
		    //電影
			}else if(a[i]["stID"]=="1"){
				console.log("電影"+a[0].stID);
				
				$(document).ready(function () {
	                   $("#table_tr").append(
	                       " <tr id=tr" + i + ">" +
	                       "<td>" + a[i].day.year +"-"+a[i].day.month+"-"+a[i].day.day+ "</td>" +
	                       "<td>" + a[i].sthb.hall.hallID + "</td>" +
	                       "<td>" + a[i].stID + "</td>" +
	                       "<td>" +
	                       "<select name='' id='title' onchange='change(this.value," + i + ")' value='" + i + "'>" +
	 
	                       "<option  selected='' disabled='' value='" + i + "'>" + a[i].sthb.run.movie.title + "</option>" +
	                      
	                       "</select>" +
	 
	                       "</td>" +
	                       "<td><p id='runningTime" + i + "'>" + a[i].runningTime + "</p></td>" +
	                       "<td id='time" + i + "'>" + "<input id='appt-time' type='time' name='appt-time'" +
	                       "value='" + a[i].time.hour+":"+ a[i].time.minute + "'min='" +  a[i].time.hour+":"+ a[i].time.minute + "' max='24:00' onchange='changeTime(this.value)'><span class='validity'></span>"
	 
	 
	                       + "</td>" +
	                       "<td>" + a[i].price_time + "</td>" +
	 
	                       "</tr>");
	               });

				
			}
			
			
		}
		
		
		
		
		//準備movie 有多少個陣列
		var movieTitle="";
		for(let i =0 ;i<a.length;i++){
			if(a[i]["stID"]=="0"){
			}else if(a[i]["stID"]=="1"){
				
// 				movieTitle+=
			}
		}
		
		
		
		
		
// 		function formSubmit(){
// 			var showID = document.getElementById("showID").value;
// 			$.ajax({
// 				url : "${pageContext.request.contextPath}/movie/add",
// 				data : {showID: showID},
// 				type : "POST",
// 				success : function() {
// 					alert("修改成功");
// 					window.location.href = "${pageContext.request.contextPath}/index-a";
// 				}
// 			});
// 		}
			$(document).ready(function() {
 			$("#table").dataTable();
 		});
 		
		
	</script>
</body>
</html>