<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
</head>
<body>
<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="../z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="../z/bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>


		<!--sidebar end-->
		<section id="main-content">
			<section class="wrapper">
				<section>
					<div>
						<div style="text-align: center">
							<h1>產品清單</h1>
						</div>
					</div>
				</section>
				<hr style="height: 1px; border: none; color: #333; background-color: #333;">
				<div class="content-panel">
					<table id="example" class="display table table-striped table-advance table-hover" style="width: 100%; text-align: center;">
						<thead>
							<tr>
								<td>訂單編號</td>
								<td>訂單時間</td>
								<td>會員名稱</td>
								<td>電影名稱</td>
								<td>詳細資料</td>
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
								<td></td>
							</tr>
						</tfoot>
					</table>
				</div>
	<!--footer start-->

			<jsp:include page="../z/bg-footer.jsp">
				<jsp:param name="e" value="1" />
				<jsp:param name="f" value="1" />
			</jsp:include>
		<!--footer end-->
		</section>
	</section>
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
				}}
		);
		$(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/OrdersAjax",
				data : {},
				type : "POST",
				success : function(data) {
// 					alert(data);
					dataTable.clear().draw();
					var data1=data;
					console.log("list:"+data1[0].ordersID);
					console.log("list:"+data1[0].OrderTime);
					console.log("list:"+data1[0].memberBean.name);
					console.log("list:"+data1[0].showTimeHistoryBean.run.movie.title);
					
					$.each(data1,function(index,value) {
 						dataTable.row.add([
 			value.ordersID, value.OrderTime,value.memberBean.name, value.showTimeHistoryBean.run.movie.title, 
 			function(data,type,row) {
				var html = "<form action='${pageContext.request.contextPath}/searchTicket/"+value.ordersID+"' method='POST'><input type='hidden' value='"+ value.ordersID +"' name='ordersID'/><input type='submit' value='詳細資料'/></form>";
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
