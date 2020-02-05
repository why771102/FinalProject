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

<title>Anno</title>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
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
	<table>

		<form:form method='POST' modelAttribute="annoBean"
			enctype="multipart/form-data">

			<tr>
				<td>公告標題:</td>
				<td><form:input name="title" path="title" type='text' /></td>
			</tr>
			<tr>
				<td>公告內容:</td>
				<td><form:textarea cols="50" rows="5" name="content"
						path="content" type='textarea'></form:textarea>
					<script>
						CKEDITOR.replace('content', {
							width : 800
						});
					</script></td>
			</tr>
			<tr>
				<td>公告狀態:</td>
				<td><form:select path="status">
				<form:option value="-1">請選擇</form:option>
				<form:options items="${annoStatusList}" />
				</form:select></td>
			</tr>
			<tr>
				<td>開始時間:</td>
				<td><form:input name="startTime" path="startTime" type='datetime-local' /></td>
			</tr>
			<tr>
				<td>結束時間:</td>
				<td><form:input name="endTime" path="endTime" type='datetime-local' /></td>
			</tr>
			<tr>
				<td>權重:</td>
				<td><form:input name="priority" path="priority" type='text' /></td>
			</tr>
			<tr>
				<td><input type='submit' /></td>
			</tr>
		</form:form>
	</table>
<!--footer start-->
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
</body>
</html>
