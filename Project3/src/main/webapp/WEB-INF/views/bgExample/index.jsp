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
              <h3>INFORMATION</h3>
            </div>
      <div class="row">
      <div class="col-md-4 mb">
                <div class="weather pn">
                  <i class="fa fa-cloud fa-4x"></i>
                  <h2 id="weather"></h2>
                  <h2 id="temp"></h2>
                  <h4 id="location"></h4>
                </div>
              </div>
      </div>
      <div class="border-head">
              <h3>班表</h3>
            </div>
      
      
<!--         <h3><i class="fa fa-angle-right"></i> 班表</h3> -->
        <!-- page start-->
        <div class="row mt">
        
        
        <aside class="col-lg-7 mt">
            <section class="panel">
              <div class="panel-body">
                <div id="calendar" class="has-toolbar"></div>
              </div>
            </section>
          </aside>
          <aside class="col-lg-4 mt">
            <h4><i class="fa fa-angle-right"></i> 員工清單</h4>
            <div id="external-events">
              <div class="external-event label label-theme">七六</div>
              <div class="external-event label label-success">Ally</div>
              <div class="external-event label label-info">Mary</div>
              <div class="external-event label label-warning">雅菁</div>
              <div class="external-event label label-danger">Paul</div>
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
 				console.log(data);
 				console.log(data.cwbdata.resources.resource.data.agrWeatherForecasts.weatherForecasts.location);
 				var north = data.cwbdata.resources.resource.data.agrWeatherForecasts.weatherForecasts.location[0];
 				console.log(north);
 				var place = north.locationName;
 				console.log(place);
 				var weather = north.weatherElements.Wx.daily[0].weather;
 				console.log(weather);
 				var maxT = north.weatherElements.MaxT.daily[0].temperature;
 				var mixT = north.weatherElements.MinT.daily[0].temperature;
 				var temper = mixT + "ºC - " + maxT + "ºC";
 				$("#temp").html(temper);
 				$("#location").html(place);
 				$("#weather").html(weather);
 				
 			}
 		})
 	})
 
 
 </script>
</body>

</html>
