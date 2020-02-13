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
<title>oldShowTimeHitory</title>

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
	<!-- Custom styles for jueryDataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">




<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
<!--  =============================CSS put Here============================== -->
<style>

    tbody>tr>td{
  padding-left:20px;
}

thead{
     background: #4ECDC4;
    color: white;
    font-size:18px;
    }
table{
       width: 100%;
    text-align: center;
}


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
				<div class="row mt">
					<div class="col-lg-12">
				<!-- <p>Place your content here.</p> -->
		<h1 style='  padding:20px 10px;  text-align: center;'>排片場次查詢</h1>
		<label>請選擇日期：</label> <label>起始日期：</label> <input type="date"
			id="startShowDate" name="startDate" min="2019-11-01" max="2020-04-30">
		<label>結束日期：</label> <input type="date" id="endShowDate"
			name="endDate" min="2019-11-01" max="2020-04-30"> 
			<label>選擇影廳：</label> 
			<select name='hallID' id='hall' value=''>
			<option selected='' disabled='' value=''>請選擇廳</option>
			<option selected='' value='All'>全部</option>
			<option selected='' value='A'>A廳</option>
			<option selected='' value='B'>B廳</option>
			<option selected='' value='C'>C廳</option>
			<option selected='' value='D'>D廳</option>
			<option selected='' value='E'>E廳</option>
			<option selected='' value='F'>F廳</option>
			<option selected='' value='G'>G廳</option>
		</select> <input   class='btn btn-theme04' id='a' type='submit' onclick="formSubmit()" value='確定送出' /> <br>
		<!--    <div id ='AllTable'> -->
		<table id="table1" class="display">
			<thead id='table_thead'>
				<tr >
					<td>日期:</td>
					<td>廳:</td>
					<td>showID</td>
					<td>runID</td>
					<td>代號:</td>
					<td>電影名稱:</td>
					<td>片長:</td>
					<td>播出時間:</td>
					<td>權重:</td>
					<td>修改：</td>
				</tr>
			</thead>
			<tbody id='table_tbody'>
			</tbody>




		</table>


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

<script type="text/javascript" charset="utf8"src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
	  $(document).ready(function() {
		$("#table1").DataTable();
	  });
	  
	  function updateSubmit(row){
		  alert("uapdate");
		  var date = document.getElementById("strDay" + row).innerHTML;
          var time = document.getElementById("time" + row).childNodes[0].value;
          var hallID= "All";
              hallID = (document.getElementById("hallID" + row)).innerHTML;
			console.log(date);
			console.log(time);
			console.log(hallID);
			location.replace("${pageContext.request.contextPath}/showTime/update/"+date+"="+time+"="+hallID);
	  }
	
	  
	  
	  function formSubmit(){
		  var start = document.getElementById("startShowDate").value;
		  var end = document.getElementById("endShowDate").value;
		  var hallID =document.getElementById("hall").value;
			console.log(start);
			console.log(end);
			console.log(hallID);
			
			
			$.ajax({
				url : "${pageContext.request.contextPath}/showTimeHistory/show",
				data : {start: start, end: end,hallID:hallID},
				type : "POST",
				success : function(data) {
					alert("送出成功");
					 var a =data;
// 					 var b=${showTime};
// 					 console.log(b);
// 					 alert(b);
// 						console.log("stID"+a[0].stID);
// 					  var divObj = document.getElementById("AllTable");
// 					  divObj.innerHTML = "";
// 	                    $("#AllTable").append(
// 		                    		"<table id='table' class='display'>"+
// 		                    		"<thead id='table_thead'>"+
// 		                    			"<tr id='table_tr' >"+
// 		                    				 "<td>日期:</td>"+
// 		                                   " <td>廳:</td>"+
// 		                                   " <td>showID</td>"+
// 		                                    "<td>runID</td>"+
// 		                                    "<td>代號:</td>"+
// 		                                   " <td>電影名稱:</td>"+
// 		                                   " <td>片長:</td>"+
// 		                                   " <td>播出時間:</td>"+
// 		                                   " <td>權重:</td>"+
// 		                    			"</tr>"+
// 		                    		"</thead>	");
					     var divObj = document.getElementById("table_tbody");
					     divObj.innerHTML = "";
					     var channelName=encodeURI(encodeURI(a[0].sthb.run.movie.title));
					     alert(channelName);
						for(i=0;i<a.length-1;i++){
 		                    $("#table_tbody").append(

		                    		
		                        " <tr id=tr" + i + ">" +
		                        "<td id='strDay" + i + "'>" + a[i].strDay + "</td>" +
		                        "<td id='hallID" + i + "'>" + a[i].sthb.hall.hallID + "</td>" +
		                        "<td  id='showTimeId" + i + "'>" + a[i].sthb.showTimeId + "</td>" +
		                        "<td id='runID" + i + "'>" + a[i].sthb.run.runID + "</td>" +
		                        "<td>" + a[i].stID + "</td>" +
		                        "<td>" +
		                        "<select name='' id='title' onchange='change(this.value," + i + ")' value='" + i + "'>" +
		                       
		                        "<option  selected='' disabled='' value='" + i + "'>" + a[i].sthb.run.movie.title + "</option>" +

		                        "</select>" +

		                        "</td>" +
		                        "<td><p id='runningTime" + i + "'>" + a[i].runningTime + "</p></td>" +
		                        "<td id='time" + i + "'>" + "<input id='appt-time' type='time' name='appt-time'" +
		                        "value='" + a[i].strTime + "'min='" + a[i].strTime + "' max='24:00' onchange='changeTime(this.value," + i + ")'><span class='validity'></span>"


		                        + "</td>" +
		                        "<td id='price_time" + i + "'>" + a[i].price_time + "</td>" +
		                        
		                        "<td id='update" + i + "'>"+" <input id='update' type='submit' onclick='updateSubmit("+i+")' value='修改'/>"+ "</td>" +

		                        "</tr>");
		                
						}
						$("#table1").DataTable();

				}
			});
		  
	  }
	  
	</script>


	<!-- put Javascript  here-->
</body>

</html>