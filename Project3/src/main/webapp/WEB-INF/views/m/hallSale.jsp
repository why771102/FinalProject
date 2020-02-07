<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>76影城</title>
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">
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

<!-- table bootstrap -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<!-- <script type="text/javascript" -->
<!-- 	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> -->
<!-- timepicker -->
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<!-- <script type="text/javascript" -->
<!-- 	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->

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
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row mt">
					<div class="col-lg-12">
						<!-- <p>Place your content here.</p> -->
						<h2 style="text-align: center">包廳銷售總覽</h2>
						<br>
						<!-- chart -->
						<div id="container1"
							style="height: 430px; max-width: 600px; margin: 0 auto"></div>
						<br>
						<!-- timpicker -->
						<div
							style="text-align: -webkit-right;">
							<div id="timePicker"
								style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 16%;">
								<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
									class="fa fa-caret-down"></i>
							</div>
						</div>
						<br>
						<div class="content-panel">
							<table id="example"
								class="display table table-striped table-advance table-hover"
								style="width: 100%; text-align: center;">
								<thead>
									<tr>
										<th style="text-align: center;">123</th>
										<th style="text-align: center;">廳名</th>
										<th style="text-align: center;">單價</th>
										<th style="text-align: center;">時數</th>
										<th style="text-align: center;">銷售總金額</th>
									</tr>
								</thead>
								<tbody id="insertHere">
								</tbody>
								<tfoot>
									<tr>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</tfoot>
							</table>
							</div>
							<br>
							<form id="submitExcel"
								action="${pageContext.request.contextPath}/hale/sale/hallSale.xls"
								method="POST">
								<input type="submit" id="exportE" value="Export To Excel">
							</form>
						</div>
					</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<!-- chart -->
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>

	<script>
		(function($) {
			$(document)
					.ready(
							function() {

								var t = $('#example').DataTable({
									"columnDefs" : [ {
										"searchable" : false,
										"orderable" : false,
										"targets" : 0
									} ],
									"order" : [ [ 1, 'asc' ] ]
								});

								t.on('order.dt search.dt', function() {
									t.column(0, {
										search : 'applied',
										order : 'applied'
									}).nodes().each(function(cell, i) {
										cell.innerHTML = i + 1;
									});
								}).draw();

								// timepicker
								$(function() {
									var start = moment().subtract(7, 'days');
									var end = moment();
									function cb(start, end, label) {
										$('#timePicker span')
												.html(
														start
																.format(' YYYY-MM-DD ')
																+ ' ~ '
																+ end
																		.format(' YYYY-MM-DD '));
										window.start = start
												.format('YYYY-MM-DD');
										window.end = end.format('YYYY-MM-DD');
										//傳送日期的值
										$
												.ajax({
													url : "${pageContext.request.contextPath}/hall/sale",
													data : {
														start : start
																.format('YYYY-MM-DD'),
														end : end
																.format('YYYY-MM-DD')
													},
													type : "POST",
													success : function(hall) {
														// 																			alert("搜尋成功!");
														var dataTable = $(
																"#example")
																.DataTable();
														dataTable.clear()
																.draw();
														editInfo(hall); //chart function
														$
																.each(
																		hall,
																		function(
																				index,
																				value) {
																			console
																					.log(value);
																			let price = new Number(
																					value.price)
																					.toLocaleString("en-AU");
																			let subtotal = new Number(
																					value.hallSubtotal)
																					.toLocaleString("en-AU");
																			dataTable.row
																					.add(
																							[
																									"",
																									value.hallID
																											+ "廳",
																									price,
																									value.orderHours,
																									subtotal ])
																					.draw();
																		});
														
														console.log(hall);
														//				 		console.log("hhhh" + start.format('YYYY-MM-DD'));
													}
												});
									}

									// MMMM D, YYYY
									$('#timePicker')
											.daterangepicker(
													{
														startDate : start,
														endDate : end,
														ranges : {
															'Today' : [
																	moment(),
																	moment() ],
															'Yesterday' : [
																	moment()
																			.subtract(
																					1,
																					'days'),
																	moment()
																			.subtract(
																					1,
																					'days') ],
															'Last 7 Days' : [
																	moment()
																			.subtract(
																					6,
																					'days'),
																	moment() ],
															'Last 30 Days' : [
																	moment()
																			.subtract(
																					29,
																					'days'),
																	moment() ],
															'This Month' : [
																	moment()
																			.startOf(
																					'month'),
																	moment()
																			.endOf(
																					'month') ],
															'Last Month' : [
																	moment()
																			.subtract(
																					1,
																					'month')
																			.startOf(
																					'month'),
																	moment()
																			.subtract(
																					1,
																					'month')
																			.endOf(
																					'month') ]
														}
													}, cb);
									cb(start, end);
								});
							});

			// 		$(document).ready(function() {
			//chart percentage and data
			function editInfo(hall) {
				var editData = [];
				for (let a = 0; a < (hall).length; a++) {
					var hallID = hall[a].hallID;
					var subtotal = Math
							.round((hall[a].hallSubtotal / hall[a].subtotal) * 100);

					var data = {
						name : hallID + "廳",
						y : subtotal
					};
					editData.push(data);
				}
				window.hallData = editData;

				//chart
				// Make monochrome colors
				var pieColors = (function() {
					var colors = [], base = Highcharts.getOptions().colors[0], i;
					for (i = 0; i < 10; i += 1) {
						// Start out with a darkened base color (negative brighten), and end
						// up with a much brighter color
						colors.push(Highcharts.Color(base)
								.brighten((i - 3) / 7).get());
					}
					return colors;
				}());

				// Build the chart
				Highcharts
						.chart(
								'container1',
								{
									chart : {
										plotBackgroundColor : null,
										plotBorderWidth : null,
										plotShadow : false,
										type : 'pie'
									},
									title : {
										text :
										// 																"<h1>包廳銷售總覽</h1>"
										// 																	+ '<br>'+
										window.start + " 到 " + window.end + ""
									},
									tooltip : {
										pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
									},
									plotOptions : {
										pie : {
											allowPointSelect : true,
											cursor : 'pointer',
											colors : pieColors,
											dataLabels : {
												enabled : true,
												format : '<b>{point.name}</b><br>{point.percentage:.1f} %',
												distance : -50,
												filter : {
													property : 'percentage',
													operator : '>',
													value : 4
												}
											}
										}
									},
									series : [ {
										// 		        name: 'Share',
										data : window.hallData
									} ]
								});
			}
			//end of chart
		})(jQuery);
	</script>


</body>

</html>