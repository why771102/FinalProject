<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta http-equiv="refresh" content="3;url=http://localhost:8080/Project3/movieIndex" />
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">
<meta charset="UTF-8">
<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
	
	#test{
		height:300px;
	}
	
	footer{
		bottom:0;
	}
	
	#successful{
		margin-top:70px;
	}
	
	
</style>
</head>
<body>
    <header>
       <jsp:include page="a/header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
    <!-- header-->
	<section>
		<div id="successful">
			<div style="text-align: center">
				<h1>註冊成功!</h1>
			</div>
		</div>
	</section>
<!-- 	<hr -->
<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
	<div style="text-align: center; height:300px;">
		<h2>3秒後將自動跳轉回首頁...</h2>
		<h3><a href="<c:url value='/movieIndex'/>">或直接回首頁觀看更多電影資訊</a></h3>
	</div>
	<!-- footer -->
    <footer>

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->
</body>
</html>
