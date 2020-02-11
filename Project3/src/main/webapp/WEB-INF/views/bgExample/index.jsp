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
        <h3><i class="fa fa-angle-right"></i> 班表</h3>
        <!-- page start-->
        <div class="row mt">
          <aside class="col-lg-3 mt">
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
          <aside class="col-lg-9 mt">
            <section class="panel">
              <div class="panel-body">
                <div id="calendar" class="has-toolbar"></div>
              </div>
            </section>
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

 
 
 </script>
</body>

</html>
