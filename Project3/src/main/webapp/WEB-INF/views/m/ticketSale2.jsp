<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>票卷銷售細節</title>
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
<style>
@import 'https://code.highcharts.com/css/highcharts.css';

.highcharts-background {
  fill: #F5F5F5;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}

/* Link the series colors to axis colors */
.highcharts-color-0 {
	fill: #191970;
	stroke: #191970;
}

.highcharts-axis.highcharts-color-0 .highcharts-axis-line {
	stroke: #191970;
}

.highcharts-axis.highcharts-color-0 text {
	fill: #191970;
	font-size: 18px;
}

.highcharts-color-1 {
	fill: #20B2AA;
	stroke: #20B2AA;
}

.highcharts-axis.highcharts-color-1 .highcharts-axis-line {
	stroke: #20B2AA;
}

.highcharts-axis.highcharts-color-1 text {
	fill: #20B2AA;
	font-size: 18px;
}

.highcharts-yaxis .highcharts-axis-line {
	stroke-width: 2px;
}
</style>
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
	<h2 style="text-align: center">${title}</h2>
	<br>
						<div id="container1"
							style="min-width: 310px; height: 500px; max-width: 1000px; margin: 0 auto"></div>
			<br>
		<div style="text-align: -webkit-right;">
			<div id="reportrange"
				style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 230px;;">
				<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
					class="fa fa-caret-down"></i>
			</div>
		</div>
		<br>
	<font size="2" face="Courier New" >
		<table id="example" class="display"
			style="width: 100%; text-align: center; background:#eaeaea !important; box-shadow: none !important;">
			<thead style="background: #4ECDC4; color: white;">
				<tr>
					<th style="border-bottom: none;"></th>
					<th style="text-align: center;border-bottom: none;">日期</th>
					<th style="text-align: center;border-bottom: none;">場次數</th>
					<th style="text-align: center;border-bottom: none;">總座位</th>
					<th style="text-align: center;border-bottom: none;">售出座位</th>
					<th style="text-align: center;border-bottom: none;">滿座率</th>
					<th style="text-align: center;border-bottom: none;">平均消費/單</th>
					<th style="text-align: center;border-bottom: none;">票銷售額</th>
					<th style="text-align: center;border-bottom: none;">商品銷售額</th>
					<th style="text-align: center;border-bottom: none;">營收時比</th>
					<th style="text-align: center;border-bottom: none;">銷售總額</th>
				</tr>
			</thead>
			<tbody id="insertHere">

			</tbody>
			<tfoot>
				<tr>
				</tr>
			</tfoot>
		</table></font>
<form id="submitExcel"
		action="${pageContext.request.contextPath}/ticketSaleDetail.xls"
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
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script>
(function($) {
	$(document).ready(function() {
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
	});

	// timepicker
	$(function() {
		var start = moment().subtract(6, 'days');
		var end = moment();
		function cb(start, end, label) {
			$('#reportrange span').html(
					start.format('YYYY-MM-DD') + ' ~ '
							+ end.format('YYYY-MM-DD'));
			//傳送日期的值
			$.ajax({
						url : "${pageContext.request.contextPath}/ticket/sale/"+${movieID},
						data : {
							start : start.format('YYYY-MM-DD'),
							end : end.format('YYYY-MM-DD')
						},
						type : "POST",
						success : function(ticketSale) {
// 							alert("新增成功!");
							editInfo(ticketSale);
							var dataTable = $("#example").DataTable();
							dataTable.clear().draw();
							$.each(ticketSale,function(index, value) {
							console.log(value);
							let hallSeats = new Number(value.hallSeats).toLocaleString("en-AU");
							let hallSaleSeats = new Number(value.hallSaleSeats).toLocaleString("en-AU");
							let pricePerSeat = new Number(value.pricePerSeat).toLocaleString("en-AU");
							let ticketSaleTotal = new Number(value.ticketSaleTotal).toLocaleString("en-AU");
							let foodSaleTotal = new Number(value.foodSaleTotal).toLocaleString("en-AU");
							let earnPerHr = new Number(value.earnPerHr).toLocaleString("en-AU");
							let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
							dataTable.row.add(["","<a href='${pageContext.request.contextPath}/ticketSale/"+value.movieBean.movieID+"/"+value.playMovieDate+"'>"+value.playMovieDate+"</a>",
							value.noPlayTimes,hallSeats,hallSaleSeats,value.avgSeats,
							pricePerSeat,ticketSaleTotal,foodSaleTotal,earnPerHr,subtotal]).draw();
						});
						}
					});
				}

		// MMMM D, YYYY
		$('#reportrange').daterangepicker(
				{
					startDate : start,
					endDate : end,
					ranges : {
						'Today' : [ moment(), moment() ],
						'Yesterday' : [ moment().subtract(1, 'days'),
								moment().subtract(1, 'days') ],
						'Last 7 Days' : [ moment().subtract(6, 'days'),
								moment() ],
						'Last 30 Days' : [ moment().subtract(29, 'days'),
								moment() ],
						'This Month' : [ moment().startOf('month'),
								moment().endOf('month') ],
						'Last Month' : [
								moment().subtract(1, 'month').startOf('month'),
								moment().subtract(1, 'month').endOf('month') ]
					}
				}, cb);
		cb(start, end);
	});
	
	//chart percentage and data
	function editInfo(ticketSale) {
		var editData = [];
		var ed = [];
		var pn = [];

		for (let a = 0; a < (ticketSale).length; a++) {
			window.tName = ticketSale[a].movieBean.productName;
			var date = ticketSale[a].playMovieDate;
			var hallSaleSeats = ticketSale[a].hallSaleSeats;
			var avgSeats = ticketSale[a].avgSeats;

			pn.push(date);

			// 			var data = {
			// 					data: hallSaleSeats, 
			// 			};
			ed.push(hallSaleSeats);
			editData.push(avgSeats);

			var dt = {
				data : editData,
				yAxis : avgSeats
			}
			window.dt = dt;
		}
		window.title = pn;
		window.hallSaleSeats = ed;
		window.subtotalData = editData;

		//chart
		Highcharts.chart('container1', {

			chart : {
				backgroundColor: '#FFF8DC',
				type : 'column',
				styledMode : true
			},

			title : {
				text : window.tName
			},

			yAxis : [ {
				className : 'highcharts-color-0',
				title : {
					text : '銷售數'
				}
			}, {
				className : 'highcharts-color-1',
				opposite : true,
				title : {
					text : '滿座率'
				}
			} ],

			plotOptions : {
				column : {
					borderRadius : 2
				}
			},
			xAxis : {
				categories : window.title,
				crosshair : true
			},
			series : [ {
				name : '銷售數',
				data : window.hallSaleSeats
			}, {
				name : '滿座率',
				data : window.subtotalData,
				yAxis : 1
			} ]
		});
	}
})(jQuery);
</script>
</body>
</html>