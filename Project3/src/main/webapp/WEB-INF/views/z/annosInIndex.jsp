<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- title -->
    <title>76影城</title>
    <!-- google fonts -->
    
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" />
    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <style>
    body{
    	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
    }
    
    html {
  		scroll-behavior: smooth;
	}
	
	.navbar-default .navbar-nav > li.free-trial-btn {
    	margin-left: 13px;
	}
	
	header{
		position: fixed;
    	width: 100%;
    	display: block;
    	top: 0;
    	transition: top 0.3s;
	}
    </style>

</head>
<body>
<!-- <div class="ser-list"> -->
        <div class="container">
        <h3 style="text-align:center;color:#333333;font-size:36px;font-weight:700;margin-top:40px">公告</h3>
            <div class="row">

                <div class="col-sm-4" style="width: 116%;margin-bottom:50px">
                    <ul class="nav nav-tabs list-items">
                    <c:forEach var="anno" items="${annoList}">
                        <li class="arrow_box" style="text-align: left;"><a href="anno/${anno.annoId }">&emsp; ${anno.title}</a>
                        </li>
                       </c:forEach> 
                    </ul>
                    <ul>
                    </ul>
                    <a href="annos">更多公告</a>
                </div>

            </div>
        </div>

</body>
</html>
