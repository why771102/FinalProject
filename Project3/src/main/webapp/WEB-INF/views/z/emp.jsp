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
</head>
<body>
<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>


		<!--sidebar end-->
	<section>
		<div>
			<div style="text-align: center">
				<h1>員工清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<section>
		<div>
			<div class="caption">
				<table>
					<tr>
						<td>員工編號：</td>
						<td>${emp.empId}</td>
					</tr>
					<tr>
						<td>員工姓名：</td>
						<td>${emp.empName}</td>
					</tr>
					<tr>
						<td>員工信箱：</td>
						<td>${emp.email}</td>
					</tr>
					<tr>
						<td>員工密碼：</td>
						<td>${emp.password}</td>
					</tr>
					<tr>
						<td>職務名稱：</td>
						<td>${emp.roleBean.roleName}</td>
					</tr>
					<tr>
						<td>在職狀態：</td>
						<td>${emp.empStatusBean.statusName}</td>
					</tr>
					<tr>
						<td>就職日期：</td>
						<td>${emp.startDate}</td>
					</tr>

					<tr>
						<td>離職日期：</td>
						<td>${emp.endDate}</td>
					</tr>
				</table>
				<a href="emp/update/${emp.empId}">修改資料</a>
			</div>
		</div>
	</section>
	<!--footer start-->
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
</body>
</html>
