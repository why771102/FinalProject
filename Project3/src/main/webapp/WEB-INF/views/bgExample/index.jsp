<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>76影城</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/zabuto_calendar.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/gritter/css/jquery.gritter.css" />
  <link href="${pageContext.request.contextPath}/lib/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/css/backstagestyle.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet">
  <script src="${pageContext.request.contextPath}/lib/chart-master/Chart.js"></script>
  <script src="https://kit.fontawesome.com/2b661327b6.js" crossorigin="anonymous"></script>

  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
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
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    
    <section id="main-content">
      <section class="wrapper">
      <br>
      <br>
      <div class="border-head">
              <h3>資訊</h3>
            </div>
      <div class="row">
      	<div class="col-md-5 mb">
      		<div class="weather pn">
            	<i class="fa fa-4x"id="weatherIcon"></i>
            	<h2 id="weather"></h2>
                <h2 id="temp"></h2>
                <h4 id="location"></h4>
            </div>
        </div>
        <div class="col-md-7 mb">
                <div class="">
                  <table id="example" class="display table table-striped table-advance table-hover"
						style="width: 100%; text-align: center;">
						<thead>
							<tr>
								<th><strong>內部公告</strong></th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td style="text-align:left">因應冠狀病毒，上班時請配戴口罩，以避免感染。</td>	
							</tr>
							<tr>
								<td style="text-align:left">上下班請記得打卡，避免出缺勤有缺紀錄。</td>	
							</tr>
							<tr>
								<td style="text-align:left">辦公室拾獲波提貓一隻，請飼主前來認領。</td>	
							</tr>
							<tr>
								<td style="text-align:left">本月即將結束，請各部門主管盡早批改請假申請。</td>	
							</tr>
							<tr>
								<td style="text-align:left">三月份班表已公布，請提早確認，方便進行調動。</td>	
							</tr>
							<tr>
								<td style="text-align:left">本月聚餐訂於3月14日舉辦，請至信件夾查看詳細資訊。</td>	
							</tr>
						</tbody>
						<tfoot>
							
						</tfoot>
					</table>
                </div>
              </div>
      </div>
      
      
      
      <div class="border-head">
              <h3>休假列表</h3>
            </div>
      
      
<!--         <h3><i class="fa fa-angle-right"></i> 班表</h3> -->
        <!-- page start-->
        <div class="row mt">
        
        
        <aside class="col-lg-8 mt">
            <section class="panel">
              <div class="panel-body">
                <div id="calendar" class="has-toolbar"></div>
              </div>
            </section>
          </aside>
          <aside class="col-lg-3 mt">
            <h4><i></i></h4>
            <div id="external-events">
<!--               <div class="external-event label label-theme">七六</div> -->
<!--               <div class="external-event label label-success">Ally</div> -->
<!--               <div class="external-event label label-info">Mary</div> -->
<!--               <div class="external-event label label-warning">雅菁</div> -->
<!--               <div class="external-event label label-danger">Paul</div> -->
<!--               <div class="external-event label label-default">My Event 6</div> -->
<!--               <div class="external-event label label-theme">My Event 7</div> -->
<!--               <div class="external-event label label-info">My Event 8</div> -->
<!--               <div class="external-event label label-success">My Event 9</div> -->
            </div>
          </aside>
          
        </div>
        <!-- page end-->
      </section>
      <!-- /wrapper -->
    </section>
    
    
    
    <!--main content end-->
    <!--footer start-->
    <jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->

  
  <script src="${pageContext.request.contextPath}/lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/fullcalendar/fullcalendar.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <!--common script for all pages-->
  <!--script for this page-->
  <script src="${pageContext.request.contextPath}/lib/calendar-conf-events.js"></script>
 <script>
 	$(document).ready(function() {
 		$.ajax({
 			url : "https://opendata.cwb.gov.tw/fileapi/v1/opendataapi/F-A0010-001?Authorization=CWB-A1021C75-3099-40F7-9580-7601A4116BA1&downloadType=WEB&format=JSON",
 			type : "GET",
 			success: function(data) {
 				var north = data.cwbdata.resources.resource.data.agrWeatherForecasts.weatherForecasts.location[0];
 				var place = north.locationName;
 				var weather = north.weatherElements.Wx.daily[0].weather;
 				var weatherid = north.weatherElements.Wx.daily[0].weatherid;
 				var maxT = north.weatherElements.MaxT.daily[0].temperature;
 				var mixT = north.weatherElements.MinT.daily[0].temperature;
 				var temper = mixT + "ºC - " + maxT + "ºC";
 				$("#temp").html(temper);
 				$("#location").html(place);
 				$("#weather").html(weather);
 				switch (weatherid){
 					case "16":
 						$("#weatherIcon").addClass("fa-cloud-showers-heavy");
 						break;
 					case "8":
 					case "11":
 						$("#weatherIcon").addClass("fa-cloud-rain");
 						break;
 					case "4":
 						$("#weatherIcon").addClass("fa-cloud");
 						break;
 					case "2":
 						$("#weatherIcon").addClass("fa-cloud-sun");
 						break;		
 				}
 			}
 		})
 	})
 
 </script>
</body>

</html>
