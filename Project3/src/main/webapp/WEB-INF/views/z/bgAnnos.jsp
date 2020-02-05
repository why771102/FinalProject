<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
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
				<h1>公告清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table id="example" class="display"
			style="width: 100%; text-align: center;">
			<thead>
				<tr>
					<th style="width: 70px">公告編號</th>
					<th>公告標題</th>
					<th>開始時間</th>
					<th>結束時間</th>
					<th style="width: 70px">權重</th>
					<th style="width: 70px">公告狀態</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="insertHere">

			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		<table>
			<tr>
				<td>公告編號</td>
				<td>公告標題</td>
				<td>公告狀態</td>
				<td>開始時間</td>
				<td>結束時間</td>
				<td>權重</td>
				<td>操作</td>
			</tr>
			<c:forEach var="anno" items="${allAnnos}">
				<tr>
					<td>${anno.annoId}</td>
					<td>${anno.title}</td>
					<td>${anno.annoStatusBean.statusName}</td>
					<td>${fn:substring(anno.startTime, 0, 10)}</td>
					<td>${fn:substring(anno.endTime, 0, 10)}</td>
					<td>${anno.priority}</td>
					<td><a href="anno/update/${anno.annoId}">修改公告</a> <a
						href="anno/launch/${anno.annoId}">上架</a> <a
						href="anno/takeoff/${anno.annoId}">下架</a></td>
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
					url : "${pageContext.request.contextPath}/bgAnnosAjax",
					type : "POST",
					success : function(data) {
						dataTable.clear().draw();
						console.log(data);
						$.each(data, function(index, value) {
							dataTable.row.add([value.annoId, value.title, value.startTime.substring(0,16),  value.endTime.substring(0,16), value.priority, value.annoStatusBean.statusName, function(data, type,row) {
								var html = "<a href='anno/update/" + value.annoId + "'>修改公告</a>"
								html += " <a href='anno/launch/" + value.annoId + "'>上架</a>"
								html += " <a href='anno/takeoff/" + value.annoId + "'>下架</a>"
								return html}
								]).draw();
						})
						
					}
				})
				
				
				
				
			})
			
			
			
			
			
		});
	</script>
</body>
</html>
