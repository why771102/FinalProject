<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>產品利潤總覽</title>
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
	<h2 style="text-align: center">產品營利總覽</h2>
		<div  style="text-align: -webkit-right;">
			類型： ${cateSelection}
			<br>
			<div id="reportrange"
				style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 200px;">
				<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
					class="fa fa-caret-down"></i>
			</div>
		</div>
		<br>
		<font size="2" face="Courier New" >
		<table id="example" class="display" style="width: 100%; text-align: center; background:#eaeaea !important; box-shadow: none !important;">
			<thead  style="background: #4ECDC4; color: white;">
				<tr>
					<th style="border-bottom: none;"></th>
					<th  style="text-align: center;border-bottom: none;">產品名稱</th>
					<th  style="text-align: center;border-bottom: none;">單價</th>
					<th  style="text-align: center;border-bottom: none;">數量</th>
					<th  style="text-align: center;border-bottom: none;">成本</th>
					<th  style="text-align: center;border-bottom: none;">利潤</th>
					<th  style="text-align: center;border-bottom: none;">銷售總額</th>
					<th  style="text-align: center;border-bottom: none;">利潤總額</th>
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
		action="${pageContext.request.contextPath}/product/earn/productEarn.xls"
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
		var dataTable = $('#example').DataTable({
			"columnDefs" : [ {
				"searchable" : false,
				"orderable" : false,
				"targets" : 0
			} ],
			"order" : [ [ 1, 'asc' ] ],
		});

		dataTable.on('order.dt search.dt', function() {
			dataTable.column(0, {
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
				url : "${pageContext.request.contextPath}/product/earn",
				data : {
					start : start.format('YYYY-MM-DD'),
					end : end.format('YYYY-MM-DD')
				},
				type : "POST",
				success : function(productearn) {
// 					alert("新增成功!");
					
					var dataTable = $("#example").DataTable({destroy: true});
					dataTable.clear().draw();

					$.each(productearn, function(index, value) {
						console.log(value);
						let price = new Number(value.price).toLocaleString("en-AU");
						let qtyTotal = new Number(value.qtyTotal).toLocaleString("en-AU");
						let cost = new Number(value.cost).toLocaleString("en-AU");
						let earn = new Number(value.earn).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						let earnSubtotal = new Number(value.earnSubtotal).toLocaleString("en-AU");
						dataTable.row.add(["","<a href='${pageContext.request.contextPath}/product/earn/"+value.productsBean.productID+"'>"+value.productName+"</a>",
							price, qtyTotal, cost, earn, subtotal, earnSubtotal]).draw();});
					
					dataTable.on('order.dt search.dt', function() {
						dataTable.column(0, {
							search : 'applied',
							order : 'applied'
						}).nodes().each(function(cell, i) {
							cell.innerHTML = i + 1;
						});
					}).draw();
					//傳送cate selection值
					$("#categoryNames").change(function(){
						var dataTable = $("#example").DataTable({destroy: true});
						var cate = document.getElementById("categoryNames").value;
						
						if(cate == '餐點總覽'){ 
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("大可樂|中可樂|小可樂|熱狗|吉拿棒|炸雞+薯條|大爆米花|中爆米花|小爆米花|雙人套票|個人套票", true, false).draw();
						}else if(cate == '套餐的餐點') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("雙人套票|個人套票", true, false).draw(); 
						} else if (cate == '餐點') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("大可樂|中可樂|小可樂|熱狗|吉拿棒|炸雞+薯條|大爆米花|中爆米花|小爆米花", true, false).draw();
						} else if (cate == '公仔') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("冰雪奇緣GSC黏土人艾莎|鋼鐵人公仔MK3磁浮版(金屬色版)|死侍系列大頭公仔", true, false).draw(); 
						} else if (cate == '衣服') {
						$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
							"search": {regex: true}}).column(1).search("星際大戰T恤", true, false).draw(); 
						} else if (cate == '爆米花桶') {
						$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
						"search": {regex: true}}).column(1).search("爆米花桶", true, false).draw(); 
						} else if (cate == '杯子餐具') {
						$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
						"search": {regex: true}}).column(1).search("搖搖杯|餐具|水杯|杯墊", true, false).draw(); 
						} else if (cate == '娃娃') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("絨毛玩偶", true, false).draw(); 
						}else if (cate == '電影海報') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("海報", true, false).draw(); 
						} else if (cate == '電子產品') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("隨身碟|傳輸線", true, false).draw(); 
						} else if(cate == '其他'){
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(1).search("小提包", true, false).draw(); 
						}
						console.log("cate=>" + document.getElementById("categoryNames").value);
										
									$.ajax({
											url : "${pageContext.request.contextPath}/product/earn",
											data : {
												start : start.format('YYYY-MM-DD'),
												end : end.format('YYYY-MM-DD'),
												cate : document.getElementById("categoryNames").value
											},
											type : "POST",
														success : function(productearn) {
															var dataTable = $("#example").DataTable({destroy: true,});
															dataTable.clear().draw();
															$.each(productearn,function(index, value) {
																				console.log(value);
																				let price = new Number(value.price).toLocaleString("en-AU");
																				let qtyTotal = new Number(value.qtyTotal).toLocaleString("en-AU");
																				let cost = new Number(value.cost).toLocaleString("en-AU");
																				let earn = new Number(value.earn).toLocaleString("en-AU");
																				let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
																				let earnSubtotal = new Number(value.earnSubtotal).toLocaleString("en-AU");
																				dataTable.row.add(["",
																				"<a href='${pageContext.request.contextPath}/product/earn/"+value.productsBean.productID+"'>"
																				+ value.productName+ "</a>",
																				price, qtyTotal, cost, earn, subtotal, earnSubtotal]).draw();
																			});
															dataTable.on('order.dt search.dt', function() {
																dataTable.column(0, {
																	search : 'applied',
																	order : 'applied'
																}).nodes().each(function(cell, i) {
																	cell.innerHTML = i + 1;
																});
															}).draw();
														}
							});
	});
				}
			});
		}
		console.log("ssss" + start.format('YYYY-MM-DD'));
		console.log("eeee" + end.format('YYYY-MM-DD'));

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
		console.log("start" + start.format('YYYY-MM-DD'));
		console.log("end" + end.format('YYYY-MM-DD'));
		console.log("reportrange=>" + $('#reportrange span').text());
	});
</script>
</body>
</html>