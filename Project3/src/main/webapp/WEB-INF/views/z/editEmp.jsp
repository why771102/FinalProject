<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<form:form method='POST' modelAttribute="empBean" enctype="multipart/form-data">
					<table>
					
						<tr>
							<td>員工編號：</td>
							<td>${empBean.empId}</td>
						</tr>
						<tr>
							<td>員工姓名：</td>
							<td><form:input name="empName" path="empName" type='text' /></td>
						</tr>
						<tr>
							<td>員工信箱：</td>
							<td><form:input name="email" path="email" type='text' /></td>
						</tr>
						<tr>
							<td>員工密碼：</td>
							<td><form:input name="password" path="password" type='text' /></td>
						</tr>
						<tr>
							<td>roleBean：</td>
							<td><form:input name="roleBean" path="roleBean" type='text' /></td>
						</tr>
						<tr>
							<td>roleBean.roleName：</td>
							<td><form:input name="roleBean.roleName" path="roleBean.roleName" type='text' /></td>
						</tr>
						<tr>
							<td>roleBean.roleId：</td>
							<td><form:input name="roleBean.roleId" path="roleBean.roleId" type='text' /></td>
						</tr>
						<tr>
							<td>職務名稱：</td>
							<td><form:select path="roleId" id="role">
									<form:options items="${roleList}" />
								</form:select></td>
						</tr>
						<tr>
							<td>在職狀態：</td>
							<td><form:select path="status" id="status">
									<form:options items="${empStatusList}" />
								</form:select></td>
						</tr>
						<tr>
							<td>就職日期：</td>
							<td><form:input name="startDate" path="startDate"
									type='text' /></td>
						</tr>

						<tr>
							<td>離職日期：</td>
							<td><form:input name="endDate" path="endDate" type='text' /></td>
						</tr>
					</table>
					<input type="submit" value="修改資料" />
				</form:form>
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
	<script>
		var roleId = "${empBean.roleBean.roleId}";
		
		var a = document.getElementById("role");
		for(i=0;i < a.length;i++) {
			console.log(a[i]);
			if(a[i].value == roleId) {
				a[i].selected = true;
			}
		}
		
		var status = "${empBean.empStatusBean.status}";
		
		var b = document.getElementById("status");
		for(i=0;i < b.length;i++) {
			if(b[i].value == status) {
				b[i].selected = true;
			}
		}
	
	
	</script>
</body>
</html>
