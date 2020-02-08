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
	<header>
		<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</header>
 <div class="container">
	<section>
		<div class="buy-block">
			<div style="text-align: center">
				<h1>${annoBean.title}</h1>
			</div>
		</div>
	</section>
	<h4>${fn:substring(annoBean.startTime,0,10)}</h4>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<div>
			<div>${annoBean.content}</div>

		</div>
		<hr>


	</div>
</div>
	<footer>
		<jsp:include page="../a/footer.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</footer>


</body>
</html>
