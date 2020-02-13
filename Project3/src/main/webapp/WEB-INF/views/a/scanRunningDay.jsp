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
            <section class="wrapper">
            	<h1 style='padding: 10px 30px;    text-align: center;'>新增排片場次</h1>
                <div class="row mt">
                
                </div>
                    <!--  DATE PICKERS -->
                    
                    <div class="col-lg-12">
                        <div class="form-panel">
                        
                            <form id='runForm${run.runID}'action="${pageContext.request.contextPath}/movie/autoRun"method="post">
		
                        
                    
                            <!-- 輸入要得天數 -->
                              
                     


                     
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">排片起始日期:</label>
                                    <div class="col-sm-10">
                                        <input id='release'  name="release"  type="text"  value='' id='release' class="form-control"ｂ> 
                                        <span class="help-block">請輸入開始日期（格式樣板：2020-01-01)</span>
                                    </div>
                            </div>
                            
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">排片天數:</label>
                                    <div class="col-sm-10">
                                        <input  type='text' name="runningDay"   value=''id='runningDay' class="form-control">
                                        <span class="help-block">請輸入想要排幾天的片（單位：幾天)</span>
                                    </div>
                            </div>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">遞減函數值:</label>
                                    <div class="col-sm-10">
                                        <input  type='text' name="rate"   value=''id='rate' class="form-control">
                                        <span class="help-block">請輸入(0.9~0.1之間的數字)</span>
                                    </div>
                            </div>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">清場時間:</label>
                                    <div class="col-sm-10">
                                        <input  type='text' name="restTime"   value=''id='restTime' class="form-control">
                                        <span class="help-block">請場次之間的最少間格時間(分鐘)</span>
                                    </div>
                            </div>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">營業時間(open):</label>
                                    <div class="col-sm-10">
                                        <input  type='text' name="openTime"   value=''id='openTime' class="form-control">
                                        <span class="help-block">輸入影城開放時間(格式範例 09:00 二十四小時制)</span>
                                    </div>
                            </div>
                            <div  align="center" class="form-group">

                            <input  id='a'class="btn btn-theme" type="submit" onclick="formSubmit()"></input>
                        </div>
		
	                        </form>

                                <!-- /form-panel -->
                                 <button  id='b'class="btn btn-theme" type="" onclick="getValue()">一鍵輸入</button>
                        </div>
                        <!-- /col-lg-12 -->
                    </div>
                    <!-- /row -->



                    <!-- row -->
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



    <!-- javaScript placed at the end of the document so the pages load faster -->
    <script>
	//一鑑輸入
	function getValue(){
		alert("change");
		
		var release = document.getElementById("release");
		    release.value = "2020-02-15";
	
		var runningDay = document.getElementById("runningDay");
		    runningDay.value = "3";
		var rate = document.getElementById("rate");
		      rate .value = "0.90";
		var restTime = document.getElementById("restTime");
		    restTime.value = "10";
		var openTime = document.getElementById("openTime");
		     openTime.value = "09:00";
		
	}
	
    
    
    
          
        
            function formSubmit() {
             
              
            
         
              }
            </script>
    




</body>

</html>