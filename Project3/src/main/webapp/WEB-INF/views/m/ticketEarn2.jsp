<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>票卷利潤細節</title>
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
<!-- timepicker -->
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
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
		<div style="text-align: -webkit-right;">
			<div id="reportrange"
				style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 230px;">
				<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
					class="fa fa-caret-down"></i>
			</div>
		</div>
		<br>
	<font size="2" face="Courier New">
		<table id="example" class="display" style="width: 100%; text-align: center; background:#eaeaea !important; box-shadow: none !important;">
			<thead style="background: #4ECDC4; color: white;">
				<tr>
					<th style="border-bottom: none;"></th>
					<th style="text-align: center;border-bottom: none;">日期</th>
					<th style="text-align: center;border-bottom: none;">場次數</th>
					<th style="text-align: center;border-bottom: none;">票卷總成本</th>
					<th style="text-align: center;border-bottom: none;">票券總利潤</th>
					<th style="text-align: center;border-bottom: none;">票券銷售總額</th>
					<th style="text-align: center;border-bottom: none;">商品總成本</th>
					<th style="text-align: center;border-bottom: none;">商品總利潤</th>
					<th style="text-align: center;border-bottom: none;">商品銷售總額</th>
					<th style="text-align: center;border-bottom: none;">營收小計</th>
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
<script>

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
				url : "${pageContext.request.contextPath}/ticket/earn/"+${movieID},
				data : {
					start : start.format('YYYY-MM-DD'),
					end : end.format('YYYY-MM-DD'),
				},
				type : "POST",
				success : function(ticketEarn) {
// 					alert("新增成功!");
					console.log(ticketEarn);

					var dataTable = $("#example").DataTable();
					dataTable.clear().draw();

					$.each(ticketEarn, function(index, value) {
						console.log(ticketEarn);
						let ticketCost = new Number(value.ticketCost).toLocaleString("en-AU");
						let ticketEarn1 = new Number(value.ticketEarn).toLocaleString("en-AU");
						let ticketSaleTotal = new Number(value.ticketSaleTotal).toLocaleString("en-AU");
						let foodCost = new Number(value.foodCost).toLocaleString("en-AU");
						let foodEarn = new Number(value.foodEarn).toLocaleString("en-AU");
						let foodSaleTotal = new Number(value.foodSaleTotal).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						dataTable.row.add(["",
							"<a href='${pageContext.request.contextPath}/ticket/"+value.movieBean.movieID+"/"+value.playMovieDate+"'>"+value.playMovieDate+"</a>"
							,value.noPlayTimes,ticketCost,ticketEarn1,ticketSaleTotal,foodCost,foodEarn,
							foodSaleTotal,subtotal]).draw();
					});
			}	
		});
		}
		console.log("pppp" + start.format('YYYY-MM-DD'));
		
		
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
</script>
</body>
</html>