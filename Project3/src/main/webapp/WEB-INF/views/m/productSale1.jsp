<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>productSale1</title>
<!-- table bootstrap -->
<link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<!-- timepicker -->
<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script> -->
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
<!-- chart -->
<!--   <base href="https://www.highcharts.com/demo/styled-mode-column/grid-light" /> -->
<!--   <link rel="stylesheet" href="/samples/highcharts/demo/styled-mode-column/demo.css" type="text/css" /> -->
<!--   <!-- <link rel="stylesheet" href="/joomla/media/templates/highsoft_2015/css/bootstrap.min.css" type="text/css" /> -->
<!--   <script src="https://code.highcharts.com/highcharts.js"></script> -->
<!--   <script src="https://code.highcharts.com/modules/exporting.js"></script> -->
<!--   <script src="//code.highcharts.com/themes/grid-light.js"></script>  -->
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
		style="min-width: 310px; height: 800px; max-width: 1500px; margin: 0 auto"></div>
<!-- <figure class="highcharts-figure"> -->
<!--     <div id="container"></div> -->
<!-- </figure> -->
	<h2 style="text-align: center">產品銷售總覽</h2>
	<div>
		類型： ${cateSelection}
		<div id="reportrange"
			style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 20%;">
			<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
				class="fa fa-caret-down"></i>
		</div>
	</div>
	<br>
	<table id="example" class="display"
		style="width: 100%; text-align: center;">
		<thead>
			<tr>
				<th></th>
				<th>產品名稱</th>
				<th>單價</th>
				<th>數量</th>
				<th>總金額</th>
				<!-- 				<th>test</th> -->
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
		action="${pageContext.request.contextPath}/product/sale/productSale.xls"
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
// 			    destroy: true,
			} ],
			"order" : [ [ 1, 'asc' ] ],
// 		    paging: false,
// 		    searching:false,
// 		   	retrieve: true,
		   	destroy: true
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
		jQuery.noConflict();
		function cb(start, end, label) {
			$('#reportrange span').html(
					start.format('YYYY-MM-DD') + ' ~ '
							+ end.format('YYYY-MM-DD'));
			window.start = start.format('YYYY-MM-DD');
			window.end = end.format('YYYY-MM-DD');
			//傳送日期的值
			$.ajax({
						url : "${pageContext.request.contextPath}/product/sale",
						data : {
							start : start.format('YYYY-MM-DD'),
							end : end.format('YYYY-MM-DD'),
							cate : document.getElementById("categoryNames").value
						},
						type : "POST",
						success : function(productsale) {
							alert("新增成功!");
							window.productsale = productsale;
							editInfo(productsale);
							console.log(typeof (window.productsale));
							var dataTable = $("#example").DataTable({destroy: true});
							dataTable.clear().draw();

							$.each(productsale,function(index, value) {
												console.log(value);
												let price = new Number(value.price).toLocaleString("en-AU");
												let qtyTotal = new Number(value.qtyTotal).toLocaleString("en-AU");
												let subtotal = new Number(value.subtotal).toLocaleString("en-AU");
												dataTable.row.add([
																		"",
																		"<a href='${pageContext.request.contextPath}/product/sale/"+value.productsBean.productID+"'>"
																				+ value.productName
																				+ "</a>",
																		price,
																		qtyTotal,
																		subtotal]).draw(); });
// 							"<input type='hidden'>"+value.categoriesBean.categoryID+"'</input>'"
							// 					showInfo(data);
							// 					console.log(productsale);
							document.getElementById("submitExcel").innerHTML += "<input type='hidden' name='exportExcel' value='"
									+ JSON.stringify(window.productsale) + "'>" //datatable content

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
//												console.log("check here~~~"+ typeof({"iDisplayLength": 100, 
//													"search": {regex: true}}).column(1).search("雙人套票|個人套票", true, false).draw());
//												window.productsale = {regex: true}}).column(1).search("雙人套票|個人套票", true, false).draw();
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
															url : "${pageContext.request.contextPath}/product/sale",
															data : {
																start : start.format('YYYY-MM-DD'),
																end : end.format('YYYY-MM-DD'),
																cate : document.getElementById("categoryNames").value
															},
															type : "POST",
																		success : function(productsale) {
																			var dataTable = $("#example").DataTable({destroy: true});
																			dataTable.clear().draw();
																			editInfo(productsale);
																			$.each(productsale,function(index, value) {
																								console.log(value);
																								dataTable.row.add(["",
																								"<a href='${pageContext.request.contextPath}/product/sale/"+value.productsBean.productID+"'>"
																								+ value.productName+ "</a>",
																								value.price,value.qtyTotal,value.subtotal]).draw();
																							});
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



// 	function editInfo(productsale){
// 		var editData = [];
// 		for(let a = 0 ; a < (hall).length ; a++){
// 			var hallID = hall[a].hallID;
// 			var subtotal = Math.round((hall[a].hallSubtotal / hall[a].subtotal) * 100);

// 		var data = {
// 				name: hallID + "廳", 
// 				y: subtotal
// 		};
// 		editData.push(data);
// 		}
// 		window.hallData = editData;

			//chart percentage and data
			function editInfo(productsale){
				var editData = [];
				var ed = [];
				var pn = [];
// 				for(let b = 0 ; b < (productsale).length ; b++){

// 					ed.push(data);
// 				}
// 				window.qtyData = ed;
				
// 				[{data: [1, 3, 2, 4]}, {data: [324, 124, 547, 221] , yAxis: 1}]
// 				[{ name: 'Chrome', y: 61.41 }]
// {data: [324, 124, 547, 221],yAxis: 1}
				for(let a = 0 ; a < (productsale).length ; a++){
					var productName = productsale[a].productName;
					var subtotal = productsale[a].subtotal;
					var qtyTotal = productsale[a].qtyTotal;
					
					pn.push(productName);
					
					var data = {
							data: qtyTotal, 
					};
					ed.push(qtyTotal);
					editData.push(subtotal);
					
				var dt = {data: editData, yAxis: subtotal}
					window.dt = dt;
				}
				window.productName = pn;
				window.qtyData = ed;
				window.subtotalData = editData;
			
		//chart

Highcharts.chart('container', {

    chart: {
        type: 'column',
        styledMode: true
    },

    title: {
        text: "各產品銷售數量與總額"+'<br>'+ window.start + " 到 " + window.end +""
    },

    yAxis: [{
        className: 'highcharts-color-0',
        title: {
            text: '數量'
        }
    }, {
        className: 'highcharts-color-1',
        opposite: true,
        title: {
            text: '銷售總額'
        }
    }],

    plotOptions: {
        column: {
            borderRadius: 2
        }
    },
    xAxis: {
        categories: window.productName,crosshair: true},
    series: [{name: '數量', data: window.qtyData}, {name: '銷售總額', data: window.subtotalData,yAxis: 1}]
});	
		//end of chart		
			}
})(jQuery);

</script>
</html>