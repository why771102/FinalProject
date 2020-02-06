<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ticketSale3</title>
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
<!-- chart -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style>
@import 'https://code.highcharts.com/css/highcharts.css';

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
	fill: #7cb5ec;
	stroke: #7cb5ec;
}

.highcharts-axis.highcharts-color-0 .highcharts-axis-line {
	stroke: #7cb5ec;
}

.highcharts-axis.highcharts-color-0 text {
	fill: #7cb5ec;
}

.highcharts-color-1 {
	fill: #90ed7d;
	stroke: #90ed7d;
}

.highcharts-axis.highcharts-color-1 .highcharts-axis-line {
	stroke: #90ed7d;
}

.highcharts-axis.highcharts-color-1 text {
	fill: #90ed7d;
}

.highcharts-yaxis .highcharts-axis-line {
	stroke-width: 2px;
}
</style>
</head>
<div id="container"
	style="min-width: 310px; height: 600px; max-width: 1000px; margin: 0 auto"></div>
<body style="background-color: grey">
	<h2 style="text-align: center">${title}</h2>
	<!-- 		<div> -->
	<!-- 			<div id="reportrange" -->
	<!-- 				style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 20%;"> -->
	<!-- 				<i class="fa fa-calendar"></i>&nbsp; <span></span> <i -->
	<!-- 					class="fa fa-caret-down"></i> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<br>
	<table id="example" class="display"
		style="width: 100%; text-align: center;">
		<thead>
			<tr>
				<th></th>
				<th>時段</th>
				<th>場次數</th>
				<th>總座位數</th>
				<th>售出座位數</th>
				<th>滿座率</th>
				<th>平均單筆消費</th>
				<th>票券銷售額</th>
				<th>商品銷售額</th>
				<th>營收時比</th>
				<th>銷售總金額</th>
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
				<th></th>
			</tr>
		</tfoot>
	</table>
	<form id="submitExcel"
		action="${pageContext.request.contextPath}/ticketSale/Date.xls"
		method="POST">
		<input type="submit" id="exportE" value="Export To Excel">
	</form>
</body>
<script>
(function($){
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
						url : "${pageContext.request.contextPath}/ticket/"+${movieID}+"/"+${date},
						data : {
						},
						type : "POST",
						success : function(ticketSale) {
							alert("新增成功!");
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
							
							dataTable.row.add(["",value.playMovieDate,
							value.noPlayTimes,hallSeats,hallSaleSeats,value.avgSeats,
							pricePerSeat,ticketSaleTotal,foodSaleTotal,
							earnPerHr,subtotal]).draw();
						});
						}
					});

			//chart percentage and data
			function editInfo(ticketSale){
				var editData = [];
				var ed = [];
				var pn = [];
				
				for(let a = 0 ; a < (ticketSale).length ; a++){
					window.tName = ticketSale[a].movieBean.productName;
					var playMovieDate = ticketSale[a].playMovieDate;
					var hallSaleSeats = ticketSale[a].hallSaleSeats;
					var avgSeats = ticketSale[a].avgSeats;
					
					pn.push(playMovieDate);
					
//		 			var data = {
//		 					data: hallSaleSeats, 
//		 			};
					ed.push(hallSaleSeats);
					editData.push(avgSeats);
					
				var dt = {data: editData, yAxis: avgSeats}
					window.dt = dt;
				}
				window.playMovieDate = pn;
				window.hallSaleSeats = ed;
				window.subtotalData = editData;
			
		//chart
		Highcharts.chart('container', {

		    chart: {
		        type: 'column',
		        styledMode: true
		    },

		    title: {
		        text: window.tName
		    },

		    yAxis: [{
		        className: 'highcharts-color-0',
		        title: {
		            text: '銷售數'
		        }
		    }, {
		        className: 'highcharts-color-1',
		        opposite: true,
		        title: {
		            text: '滿座率'
		        }
		    }],

		    plotOptions: {
		        column: {
		            borderRadius: 2
		        }
		    },
		    xAxis: {
		        categories: window.playMovieDate,crosshair: true},
		    series: [{name: '銷售數', data: window.hallSaleSeats}, {name: '滿座率', data: window.subtotalData,yAxis: 1}]
		});		
			}
		})(jQuery);

</script>
</html>