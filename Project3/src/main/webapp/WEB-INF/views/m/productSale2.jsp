<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>productSale2</title>
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
</head>

<body style="background-color: grey">
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	<h2 style="text-align: center">${productName}</h2>
		<div>
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
					<th>日期</th>
					<th>單價</th>
					<th>數量</th>
					<th>小計</th>
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
	<form id="submitExcel"
		action="${pageContext.request.contextPath}/productSaleDetail.xls"
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
				url : "${pageContext.request.contextPath}/product/sale/"+${productID},
				data : {
					start : start.format('YYYY-MM-DD'),
					end : end.format('YYYY-MM-DD')
				},
				type : "POST",
				success : function(productsaleDetail) {
// 					alert("新增成功!");
					console.log(productsaleDetail);
					window.productsaleDetail = productsaleDetail;
					editInfo(productsaleDetail);
					var dataTable = $("#example").DataTable();
					dataTable.clear().draw();

					$.each(productsaleDetail, function(index, value) {
						console.log(value);
						let qtyTotal = new Number(value.qtyTotal).toLocaleString("en-AU");
						let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
						dataTable.row.add(["",value.orderDate,value.price,qtyTotal,subtotal]).draw();
					});
					document.getElementById("submitExcel").innerHTML += "<input type='hidden' name='exportExcel1' value='"
						+ JSON.stringify(window.productsaleDetail) + "'>"
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

	//chart percentage and data
	function editInfo(productsaleDetail){
		var editData = [];
		var dateA = []
		
		for(let a = 0 ; a < (productsaleDetail).length ; a++){
// 			var productName = productsale[a].productName;
			var qtyTotal = productsaleDetail[a].qtyTotal;
			window.proName = productsaleDetail[a].productsBean.productName;
			var date = productsaleDetail[a].orderDate;
			window.d = date;
			dateA.push(date);
// 			var data = {
// 					data: qtyTotal, 
// 			};

			editData.push(qtyTotal);
		}
		window.dateA = dateA;
// 		console.log("#####" + window.dateA)
		window.qtyTotal = editData;
	
//chart

Highcharts.chart('container', {

  title: {
    text: window.proName
  },

  xAxis: {
//     tickInterval: 1,
//     type: 'logarithmic',
	name: window.dateA,
    categories: window.dateA
  },

  yAxis: {
      title: {text: '數量'}
//     type: 'logarithmic',
//     minorTickInterval: 0.1
  },

  tooltip: {
    headerFormat: '<b>{series.name}</b><br/>',
    pointFormat: window.d +', 數量:  {point.y}'
  },

  series: [{
	name: window.proName,
    data: window.qtyTotal,
//     pointStart: 0
  }]
});
//end of chart		
	}
</script>
</html>