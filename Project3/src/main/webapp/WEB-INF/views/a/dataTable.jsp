<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>DataTable</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/backstagestyle.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>


<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
<!--  =============================CSS put Here============================== -->
<style>
</style>
<!--  =============================CSS put Here============================== -->
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="../z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="../z/bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<h3>
					<i class="fa fa-angle-right"></i> Blank Page
				</h3>
				<div class="row mt">
					<div class="col-lg-12">
						<!-- <p>Place your content here.</p> -->
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
										<td><input id='a' type='submit' onclick="formSubmit()"
											value='修改' /></td>
										<input type='hidden' name="date" value='${stb.day}' id='date' />
										<input type='hidden' name="time" value='${stb.time}' id='time' />
										<input type='hidden' name="hallID" value='${stb.hall.hallID}'
											id='hallID' />
									</tr>
								</c:forEach>
							</table>
							<!-- 	<input id='b' type='submit' onclick="updateAllSubmit()" value='修改全部'/> -->
							<%-- 	<a href='${pageContext.request.contextPath}/a/updateShowTime'>修改</a> --%>
							<a href='${pageContext.request.contextPath}/insertReservedSeats'>確認</a>
							<%-- 	<input type='button' name="updateAll"   value='${stb.day}' id='updateAll' /> --%>





							<!-- <p>Place your content here.</p> -->
					</div>
				</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>

	<!-- put Javascript  here-->
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
			var hallID='All';
			var date = document.getElementById("date").value;
			var time = document.getElementById("time").value;
// 		    hallID = document.getElementById("hallID").value;
			console.log(date);
			console.log(time);
			location.replace("${pageContext.request.contextPath}/showTime/update/"+date+"="+time+"="+hallID);

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

	<!-- put Javascript  here-->
</body>

</html>