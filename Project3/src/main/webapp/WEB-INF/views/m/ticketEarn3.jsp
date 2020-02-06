<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ticketEarn3</title>
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
	<h2 style="text-align: center">${title}</h2>
<!-- 	<div> -->
<!-- 		<div id="reportrange" -->
<!-- 			style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 20%;"> -->
<!-- 			<i class="fa fa-calendar"></i>&nbsp; <span></span> <i -->
<!-- 				class="fa fa-caret-down"></i> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<br>
	<table id="example" class="display"
		style="width: 100%; text-align: center;">
		<thead>
			<tr>
				<th></th>
				<th>時段</th>
				<th>場次數</th>
				<th>票卷總成本</th>
				<th>票券總利潤</th>
				<th>票券銷售總額</th>
				<th>商品總成本</th>
				<th>商品總利潤</th>
				<th>商品銷售總額</th>
				<th>營收小計</th>
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
				<th></th>
			</tr>
		</tfoot>
	</table>
	<form id="submitExcel"
		action="${pageContext.request.contextPath}/ticketSale/Date.xls"
		method="POST">
		<input type="submit" id="exportE" value="Export To Excel">
	</form>
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
			
			//傳送日期的值
			$.ajax({
				url : "${pageContext.request.contextPath}/ticketSale/"+${movieID}+"/"+${date},
				data : {
				},
				type : "POST",
				success : function(ticketEarnDate) {
// 					alert("新增成功!");
					console.log(ticketEarnDate);
					
					var dataTable = $("#example").DataTable();
					dataTable.clear().draw();

					$.each(ticketEarnDate, function(index, value) {
						console.log(value);
						let ticketCost = new Number(value.ticketCost).toLocaleString("en-AU");
						let ticketEarn1 = new Number(value.ticketEarn).toLocaleString("en-AU");
						let ticketSaleTotal = new Number(value.ticketSaleTotal).toLocaleString("en-AU");
						let foodCost = new Number(value.foodCost).toLocaleString("en-AU");
						let foodEarn = new Number(value.foodEarn).toLocaleString("en-AU");
						let foodSaleTotal = new Number(value.foodSaleTotal).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						dataTable.row.add(["",value.playMovieDate
							,value.noPlayTimes,ticketCost,ticketEarn1,ticketSaleTotal,foodCost,foodEarn,
							foodSaleTotal,subtotal]).draw();
					});
			}	
		});
</script>
</html>