<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<div>
		<table>
		<tr>
			<td>員工編號</td>
			<td>員工姓名</td>
			<td>職位名稱</td>
			<td>員工信箱</td>
			<td>在職狀態</td>
			<td>就職日期</td>
			<td>離職日期</td>
		</tr>
			<c:forEach var="emp" items="${allEmps}">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.roleBean.roleName}</td>
			<td>${emp.email}</td>
			<td>${emp.empStatusBean.statusName}</td>
			<td>${fn:substring(emp.startDate,0,10)}</td>
			<td>${fn:substring(emp.endDate,0,10)}</td>
		</tr>
			</c:forEach>
		</table>
	</div>
	<!--footer start-->
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
	<script>
	$(document).ready(function() {
		var dataTable = $('#example').DataTable();
		$(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/empsAjax",
				type : "POST",
				success : function(data) {
					dataTable.clear().draw();
					console.log(data);
					$.each(data,function(index,value) {
						dataTable.row.add([
			value.empId, value.empName, value.roleBean.roleName, value.email, value.empStatusBean.statusName, value.startDate.substring(0,16),value.endDate.substring(0,16),value.priority,value.annoStatusBean.statusName,
			function(data,type,row) {
				var html = "<a href='anno/update/" + value.annoId + "'>修改公告</a>";
				html += " <a href='anno/launch/" + value.annoId + "'>上架</a>";
				html += " <a href='anno/takeoff/" + value.annoId + "'>下架</a>";
				return html;
				} 
				]).draw();
			})
		}
	})
})
});
	
	
	
	</script>
</body>
</html>
