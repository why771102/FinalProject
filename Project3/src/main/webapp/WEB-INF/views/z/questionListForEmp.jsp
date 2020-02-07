<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
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
	<title>76影城</title>
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
		
		
		
		
		<section id="main-content">
			<section class="wrapper">
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
					<table id="example" class="display table table-striped table-advance table-hover"
						style="width: 100%; text-align: center;">
						<thead>
							<tr>
								<th style="width: 90px">客服編號</th>
								<th>會員</th>
								<th>狀態</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
						<tfoot>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>

			</section>
		</section>

	
	<a href="question">新增詢問</a>
	<!--footer start-->
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
	<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function() {
			var dataTable = $('#example').DataTable(
					{language: {		
						"sLengthMenu": "顯示 _MENU_ 項結果",
						"sSearch": "搜索:",
						"sInfo": "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
						"oPaginate": {
					           "sFirst": "首頁",
					           "sPrevious": "上頁",
					           "sNext": "下頁",
					           "sLast": "最後頁"
					       }
					}});
			$(function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/questionListForEmpAjax",
					type : "POST",
					success : function(data) {
						dataTable.clear().draw();
						console.log(data);
						$.each(data,function(index,value) {
							dataTable.row.add([
				value.questionId, value.memberBean.name, value.questionStatusBean.statusName,
				function(data,type,row) {
					var html = "<a href='questionRep/" + value.questionId + "'>查看</a>";
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
