<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/img/favicon.png"
	rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/bg-style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">
	
<style>
/* 	header{ */
/* 		top:0; */
/* 	} */
/* 	footer{ */
/* 		bottom:0; */
/* 	} */
	
	table{
		margin-left:auto; 
		margin-right:auto;
		border:3px #cccccc solid;
	}
	
	tr{
		height:30px;
	}
	
</style>
</head>
<body>
<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header>
		<jsp:include page="z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		</header>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="z/bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>


		<!--sidebar end-->
		
<!-- 	<section> -->
<!-- 		<div> -->
<!-- 			<div style="text-align: center"> -->
<!-- 				<h1>會員資料</h1> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</section> -->
	
	
<!-- <hr -->
<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
	<section>
		<div>
			<div style="text-align: center">
				<h1>會員資料</h1>
			<div class="caption">
					<table>
							<tr>
								<td>會員姓名：</td>
								<td>${mb.name}</td>
							</tr>
							<tr>
								<td>帳號：</td>
								<td>${mb.account}</td>
							</tr>
							<tr>
								<td>信箱：</td>
								<td>${mb.email}</td>
							</tr>
							<tr>
								<td>生日：</td>
								<td>${mb.birth}</td>
							</tr>
							<tr>
								<td>性別：</td>
								<td>${mb.gender}</td>
							</tr>
							<tr>
								<td>身分證字號：</td>
								<td>${mb.uID}</td>
							</tr>

							<tr>
								<td>連絡電話：</td>
								<td>${mb.mobile}</td>
							</tr>

							<tr>
								<td>住址：</td>
								<td>${mb.address}</td>
							</tr>
<!-- 							<tr> -->
<%-- 								<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/' />'" class="inlog-btn"/></td> --%>
<!-- 							</tr> -->
					</table>
				</div>
			</div>
		</div>
	</section>
</section>
	<!--footer start-->
	<footer>
		<jsp:include page="z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
	</footer>
		<!--footer end-->
</body>
</html>
