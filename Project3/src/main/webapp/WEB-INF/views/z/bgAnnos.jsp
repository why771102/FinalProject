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
				<h3>
					<i class="fa fa-angle-right"></i> Basic Table Examples
				</h3>

				<div class="row mt">
					<div class="col-md-12">
						<div class="content-panel">
							<table class="table table-striped table-advance table-hover">
								<h4>
									<i class="fa fa-angle-right"></i> Advanced Table
								</h4>
								<hr>
								<thead>
									<tr>
										<th><i class="fa fa-bullhorn"></i> Company</th>
										<th class="hidden-phone"><i class="fa fa-question-circle"></i>
											Descrition</th>
										<th><i class="fa fa-bookmark"></i> Profit</th>
										<th><i class=" fa fa-edit"></i> Status</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><a href="basic_table.html#">Company Ltd</a></td>
										<td class="hidden-phone">Lorem Ipsum dolor</td>
										<td>12000.00$</td>
										<td><span class="label label-info label-mini">Due</span></td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
									<tr>
										<td><a href="basic_table.html#"> Dashio co </a></td>
										<td class="hidden-phone">Lorem Ipsum dolor</td>
										<td>17900.00$</td>
										<td><span class="label label-warning label-mini">Due</span></td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
									<tr>
										<td><a href="basic_table.html#"> Another Co </a></td>
										<td class="hidden-phone">Lorem Ipsum dolor</td>
										<td>14400.00$</td>
										<td><span class="label label-success label-mini">Paid</span></td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
									<tr>
										<td><a href="basic_table.html#">Dashio ext</a></td>
										<td class="hidden-phone">Lorem Ipsum dolor</td>
										<td>22000.50$</td>
										<td><span class="label label-success label-mini">Paid</span></td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
									<tr>
										<td><a href="basic_table.html#">Total Ltd</a></td>
										<td class="hidden-phone">Lorem Ipsum dolor</td>
										<td>12120.00$</td>
										<td><span class="label label-warning label-mini">Due</span></td>
										<td>
											<button class="btn btn-success btn-xs">
												<i class="fa fa-check"></i>
											</button>
											<button class="btn btn-primary btn-xs">
												<i class="fa fa-pencil"></i>
											</button>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /content-panel -->
					</div>
					<!-- /col-md-12 -->
				</div>




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
								<th style="width: 90px">公告編號</th>
								<th>公告標題</th>
								<th>開始時間</th>
								<th>結束時間</th>
								<th style="width: 70px">權重</th>
								<th style="width: 90px">公告狀態</th>
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
				</div>

			</section>
		</section>


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
			var dataTable = $('#example').DataTable();
			$(function() {
				$.ajax({
					url : "${pageContext.request.contextPath}/bgAnnosAjax",
					type : "POST",
					success : function(data) {
						dataTable.clear().draw();
						console.log(data);
						$.each(data,function(index,value) {
							dataTable.row.add([
				value.annoId,value.title,value.startTime.substring(0,16),value.endTime.substring(0,16),value.priority,value.annoStatusBean.statusName,
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
