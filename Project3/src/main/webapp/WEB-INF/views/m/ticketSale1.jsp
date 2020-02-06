<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>ticketSale1</title>
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
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
    padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
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

<body style="background-color: grey">
	<div id="container"
		style="min-width: 310px; height: 800px; max-width: 1800px; margin: 0 auto"></div>
<!-- <figure class="highcharts-figure"> -->
<!-- <div id="c" style="width: 100%; display:flex;  justify-content: center;align-items: center;"> -->
<!--     <div id="container" style="width: 49%;"></div> -->
<!--         <div id="test" style="width: 2%;"></div> -->
<!--     <div id="container1" style="width:49%;"></div> -->
<!-- </div> -->
<!-- </figure> -->
	<br>
	<h2 style="text-align: center">票房銷售總覽</h2>
	<div>
		類型： ${genreSelection}
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
				<th>總座位數</th>
				<th>售出座位數</th>
				<th>平均滿座率</th>
				<th>平均單筆消費</th>
				<th>銷售總金額</th>
				<th>hidden</th>
			</tr>
		</thead>
		<tbody  id="insertHere">

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
(function($){
	$(document).ready(function() {
		var t = $('#example').DataTable({
			"columnDefs" : [ {
				"searchable" : false,
				"orderable" : false,
				"targets" : 0,
			} ],
			"order" : [ [ 1, 'asc' ] ],
		});

		t.on('order.dt search.dt', function() {
			t.column(0, {
				search : 'applied',
				order : 'applied'
			}).nodes().each(function(cell, i) {
				cell.innerHTML = i + 1;
			});
		}).draw();
// 		t.column(8).visible(false);
	});

	// timepicker
	$(function() {
		var start = moment().subtract(7, 'days');
		var end = moment();
		function cb(start, end, label) {
			$('#reportrange span').html(
					start.format('YYYY-MM-DD') + ' ~ '
					+ end.format('YYYY-MM-DD'));
			window.start = start.format('YYYY-MM-DD');
			window.end = end.format('YYYY-MM-DD');
			//傳送日期的值
			$.ajax({
				url : "${pageContext.request.contextPath}/ticket/sale",
				data : {
					start : start.format('YYYY-MM-DD'),
					end : end.format('YYYY-MM-DD'),
					genre : document.getElementById("genres").value
				},
				type : "POST",
				success : function(ticketSale) {
					alert("新增成功!");
					
					var dataTable = $("#example").DataTable({destroy: true});
					dataTable.clear().draw();
					editInfo(ticketSale);
					$.each(ticketSale, function(index, value) {
						console.log(value);
						let hallSeats = new Number(value.hallSeats).toLocaleString("en-AU");
						let hallSaleSeats = new Number(value.hallSaleSeats).toLocaleString("en-AU");
						let pricePerSeat = new Number(value.pricePerSeat).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						dataTable.row.add(["","<a href='${pageContext.request.contextPath}/ticket/sale/"+value.movieBean.movieID+"'>"+value.title+"</a>"
							,value.noPlayTimes,hallSeats,hallSaleSeats,
							value.avgSeats,pricePerSeat,subtotal,value.movieBean.genreBean.genreID]).draw();});
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
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("0|1|2|3|4", true, false).draw();
						}else if(gen == '其他') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("0", true, false).draw(); 
						} else if (gen == '劇情') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("1", true, false).draw();
						} else if (gen == '喜劇') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("2", true, false).draw(); 
						}else if (gen == '愛情') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("3", true, false).draw(); 
						} else if (gen == '恐怖懸疑') {
							$('#example').DataTable({destroy: true,"iDisplayLength": 100, 
								"search": {regex: true}}).column(8).data().search("4", true, false).draw(); 
						}
						console.log("gen=>" + document.getElementById("genres").value);
										$.ajax({
											url : "${pageContext.request.contextPath}/ticket/sale",
											data : {
												start : start.format('YYYY-MM-DD'),
												end : end.format('YYYY-MM-DD'),
												genre : document.getElementById("genres").value
											},
											type : "POST",
														success : function(ticketSale) {
															var dataTable = $("#example").DataTable({destroy: true});
															dataTable.clear().draw();
															editInfo(ticketSale);
															$.each(ticketSale,function(index, value) {
																				console.log(value);
																				let hallSeats = new Number(value.hallSeats).toLocaleString("en-AU");
																				let hallSaleSeats = new Number(value.hallSaleSeats).toLocaleString("en-AU");
																				let pricePerSeat = new Number(value.pricePerSeat).toLocaleString("en-AU");
																				let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
																				dataTable.row.add(["","<a href='${pageContext.request.contextPath}/ticket/sale/"+value.movieBean.movieID+"'>"+value.title+"</a>"
																					,value.noPlayTimes,hallSeats,hallSaleSeats,
																					value.avgSeats,pricePerSeat,subtotal,value.movieBean.genreBean.genreID]).draw();
																			});
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
	
	//chart percentage and data
	function editInfo(ticketSale){
		var editData = [];
		var ed = [];
		var pn = [];
		
		for(let a = 0 ; a < (ticketSale).length ; a++){
			var title = ticketSale[a].title;
			var hallSaleSeats = ticketSale[a].hallSaleSeats;
			var avgSeats = ticketSale[a].avgSeats;
			
			pn.push(title);
			
// 			var data = {
// 					data: hallSaleSeats, 
// 			};
			ed.push(hallSaleSeats);
			editData.push(avgSeats);
			
		var dt = {data: editData, yAxis: avgSeats}
			window.dt = dt;
		}
		window.title = pn;
		window.hallSaleSeats = ed;
		window.subtotalData = editData;
	
//chart
Highcharts.chart('container', {

    chart: {
        type: 'column',
        styledMode: true
    },

    title: {
        text: "各電影銷售數與滿座率"+'<br>'+ window.start + " 到 " + window.end +""
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
        categories: window.title,crosshair: true},
    series: [{name: '銷售數', data: window.hallSaleSeats}, {name: '滿座率', data: window.subtotalData,yAxis: 1}]
});	

// //second pic
// Highcharts.chart('container', {

//     chart: {
//         type: 'column',
//         styledMode: true
//     },

//     title: {
//         text: "各產品銷售數量與總額"+'<br>'+ window.start + " 到 " + window.end +""
//     },

//     yAxis: [{
//         className: 'highcharts-color-0',
//         title: {
//             text: '數量'
//         }
//     }, {
//         className: 'highcharts-color-1',
//         opposite: true,
//         title: {
//             text: '銷售總額'
//         }
//     }],

//     plotOptions: {
//         column: {
//             borderRadius: 2
//         }
//     },
//     xAxis: {
//         categories: window.title,crosshair: true},
//     series: [{name: '數量', data: window.hallSaleSeats}, {name: '銷售總額', data: window.subtotalData,yAxis: 1}]
// });	
//end of chart		
	}
})(jQuery);
</script>
</html>