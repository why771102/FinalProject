<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ticketEarn1</title>
<!-- table bootstrap -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<!-- timepicker -->
<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script> -->
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>

<body style="background-color: grey">
	<h2 style="text-align: center">票房營收總覽</h2>
	<form:form method='POST' modelAttribute="TicketSaleBean1"
		enctype="multipart/form-data">
		<div>
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
					<th>電影名稱</th>
					<th>場次數</th>
					<th>票卷總成本</th>
					<th>票券總利潤</th>
					<th>票券銷售總額</th>
					<th>商品總成本</th>
					<th>商品總利潤</th>
					<th>商品銷售總額</th>
					<th>營收小計</th>
					<th>hid</th>
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
	</form:form>
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