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
<title>票卷利潤總覽</title>
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
	<h2 style="text-align: center">票房營收總覽</h2>
		<div style="text-align: -webkit-right;">
			類型： ${genreSelection}
			<!-- 		&nbsp; &nbsp; &nbsp;電影名稱 <select> -->
			<!-- 			<option>Java人生</option> -->
			<!-- 		</select> -->
			<div id="reportrange"
				style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 20%;">
				<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
					class="fa fa-caret-down"></i>
			</div>
		</div>
		<br>
		<table id="example" class="display" style="width: 100%; text-align: center;">
			<thead>
				<tr>
					<th></th>
					<th style="text-align: center;">電影名稱</th>
					<th style="text-align: center;">場次數</th>
					<th style="text-align: center;">票卷總成本</th>
					<th style="text-align: center;">票券總利潤</th>
					<th style="text-align: center;">票券銷售總額</th>
					<th style="text-align: center;">商品總成本</th>
					<th style="text-align: center;">商品總利潤</th>
					<th style="text-align: center;">商品銷售總額</th>
					<th style="text-align: center;">營收小計</th>
					<th></th>
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
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</tfoot>
		</table>
	<form id="submitExcel"
		action="${pageContext.request.contextPath}/ticket/sale/ticketSale.xls"
		method="POST">
		<input type="submit" id="exportE" value="Export To Excel">
	</form>
</body>
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
		var start = moment().subtract(7, 'days');
		var end = moment();
		function cb(start, end, label) {
			$('#reportrange span').html(
					start.format('YYYY-MM-DD') + ' ~ '
							+ end.format('YYYY-MM-DD'));
			
			//傳送日期的值
			$.ajax({
				url : "${pageContext.request.contextPath}/ticket/earn",
				data : {
					start : start.format('YYYY-MM-DD'),
					end : end.format('YYYY-MM-DD'),
					genre : document.getElementById("genres").value
				},
				type : "POST",
				success : function(ticketEarn) {
// 					alert("新增成功!");
					
					var dataTable = $("#example").DataTable();
					dataTable.clear().draw();

					$.each(ticketEarn, function(index, value) {
						console.log(value);
						let ticketCost = new Number(value.ticketCost).toLocaleString("en-AU");
						let ticketEarn = new Number(value.ticketEarn).toLocaleString("en-AU");
						let ticketSaleTotal = new Number(value.ticketSaleTotal).toLocaleString("en-AU");
						let foodCost = new Number(value.foodCost).toLocaleString("en-AU");
						let foodEarn = new Number(value.foodEarn).toLocaleString("en-AU");
						let foodSaleTotal = new Number(value.foodSaleTotal).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						dataTable.row.add(["","<a href='${pageContext.request.contextPath}/ticket/earn/"+value.movieBean.movieID+"'>"+value.title+"</a>"
							,value.noPlayTimes,ticketCost,ticketEarn,ticketSaleTotal,foodCost,foodEarn,
							foodSaleTotal,subtotal,value.movieBean.genreBean.genreID]).draw();});
					dataTable.on('order.dt search.dt', function() {
						dataTable.column(0, {
							search : 'applied',
							order : 'applied'
						}).nodes().each(function(cell, i) {
							cell.innerHTML = i + 1;
						});
					}).draw();
// 					dataTable.column(8).visible(false);

					//傳送genre selection值
					$("#genres").change(function(){
						var dataTable = $("#example").DataTable({destroy: true});
						var gen = document.getElementById("genres").value;
						if(gen == '全部電影'){ 
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search('0|1|2|3|4', true, false).draw();
						}else if(gen == '其他') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search(0, true, false).draw(); 
						} else if (gen == '劇情') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search(1, true, false).draw();
						} else if (gen == '喜劇') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search(2, true, false).draw(); 
						}else if (gen == '愛情') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search(3, true, false).draw(); 
						} else if (gen == '恐怖懸疑') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 200, 
								"search": {regex: true}}).column(8).data().search(4, true, false).draw(); 
						}
						console.log("gen=>" + document.getElementById("genres").value);
										$.ajax({
											url : "${pageContext.request.contextPath}/ticket/earn",
											data : {
												start : start.format('YYYY-MM-DD'),
												end : end.format('YYYY-MM-DD'),
												genre : document.getElementById("genres").value
											},
											type : "POST",
														success : function(ticketEarn) {
															var dataTable = $("#example").DataTable({destroy: true});
															dataTable.clear().draw();
															$.each(ticketEarn, function(index, value) {
																console.log(value);
																let ticketCost = new Number(value.ticketCost).toLocaleString("en-AU");
																let ticketEarn = new Number(value.ticketEarn).toLocaleString("en-AU");
																let ticketSaleTotal = new Number(value.ticketSaleTotal).toLocaleString("en-AU");
																let foodCost = new Number(value.foodCost).toLocaleString("en-AU");
																let foodEarn = new Number(value.foodEarn).toLocaleString("en-AU");
																let foodSaleTotal = new Number(value.foodSaleTotal).toLocaleString("en-AU");
																let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
																dataTable.row.add(["","<a href='${pageContext.request.contextPath}/ticket/earn/"+value.movieBean.movieID+"'>"+value.title+"</a>"
																	,value.noPlayTimes,ticketCost,ticketEarn,ticketSaleTotal,foodCost,foodEarn,
																	foodSaleTotal,subtotal,value.movieBean.genreBean.genreID]).draw();});
															dataTable.on('order.dt search.dt', function() {
																dataTable.column(0, {
																	search : 'applied',
																	order : 'applied'
																}).nodes().each(function(cell, i) {
																	cell.innerHTML = i + 1;
																});
															}).draw();
// 															dataTable.column(8).visible(false);
														}
							});
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

	//傳送cate selection值
	function sendGen() {
		console.log("Gen =>" + document.getElementById("genres").value);
		$.ajax({
			url : "${pageContext.request.contextPath}/ticket/sale",
			data : {
				genre : document.getElementById("genres").value
			},
			type : "POST",
						success : function() {
							alert("傳送成功!");
						}
		});
	}

// 	function showInfo(ts) {
// 		for (var i = 0; i < ts.length; i++) {
// 			$('#insertHere')
// 					.append(
// 							'<tr><td></td><td><a href="${pageContext.request.contextPath}/ticket/earn/date" id="hallID">'
// 									+ ts[i].title
// 									+ '</a></td><td>'
// 									+ ts[i].noPlayTimes
// 									+ '</td><td>'
// 									+ ts[i].ticketCost
// 									+ '</td><td>'
// 									+ ts[i].ticketEarn
// 									+ '</td><td>'
// 									+ ts[i].ticketSaleTotal
// 									+ '</td><td>'
// 									+ ts[i].foodCos
// 									+ '</td><td>'
// 									+ ts[i].foodEarn
// 									+ '</td><td>'
// 									+ ts[i].foodSaleTotal
// 									+ '</td><td>'
// 									+ ts[i].subtotal + '</td></tr>');
// 		}
// 	};
</script>
</html>