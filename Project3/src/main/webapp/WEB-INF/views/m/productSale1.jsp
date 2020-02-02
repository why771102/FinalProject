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
				<th>test</th>
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
							console.log(typeof (window.productsale));
							var dataTable = $("#example").DataTable();
							dataTable.clear().draw();

							$.each(productsale,function(index, value) {
												console.log(value);
												dataTable.row.add([
																		"",
																		"<a href='${pageContext.request.contextPath}/product/sale/"+value.productsBean.productID+"'>"
																				+ value.productName
																				+ "</a>",
																		value.price,
																		value.qtyTotal,
																		value.subtotal,
																		"<input type='hidden' value='"+value.categoriesBean+"'>" ]).draw();
											});
							// 					showInfo(data);
							// 					console.log(productsale);
							document.getElementById("submitExcel").innerHTML += "<input type='hidden' name='exportExcel' value='"
									+ JSON.stringify(window.productsale) + "'>"
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

	//傳送cate selection值
	$("#categoryNames").click(
			function() {
				console.log("cate=>"
						+ document.getElementById("categoryNames").value);
				// 		$.ajax({
				// 			url : "${pageContext.request.contextPath}/product/sale",
				// 			data : {
				// 				cate : document.getElementById("categoryNames").value
				// 			},
				// 			type : "POST",
				// 						success : function() {
				var dataTable = $("#example").DataTable();
				var cate = document.getElementById("categoryNames").value;
				if (cate == '套餐的餐點') {
					dataTable.search('雙人套票').search('個人套票').draw();
				} else if (cate == '餐點') {
					dataTable.search('大可樂').search('熱狗').search('小可樂').search(
							'吉拿棒').draw();
				} else if (cate == '周邊商品') {
					dataTable.search('Fiona').draw();
				}
				// 					alert("新增成功!");
				// 	 				window.location.href = "${pageContext.request.contextPath}/index-c";
				// 						}
				// 		});
			});

	// 	function sendpName() {
	// 		$.ajax({
	// 					url : "${pageContext.request.contextPath}/product/sale1",
	// 					data : {
	// 						productName : document.getElementById(x).innerText //要更動innerHTML!!
	// 					},
	// 					type : "Post",
	// 					success : function() {
	// 						alert("you click me!");
	// 						window.location.href = "${pageContext.request.contextPath}/product/sale/date";
	// 					}
	// 				});
	// 	}
	// 	console.log("pName =>" + document.getElementById("pName").value);

	//動態新增表格
	// 	function showInfo(pseb) {
	// 		var pn;
	// 		for(var i =0; i < pseb.length; i++){

	// 		$('#insertHere')
	// 				.append(
	// 						//動態新增的時候id要加i
	// 						'<tr><td></td><td><div id="pName'+ i +'" onclick="sendpName()">'
	// 						+ pseb[i].productName +
	// 						'</div></td><td>' + pseb[i].price +
	// 						'</td><td>' + pseb[i].qtyTotal +
	// 						'</td><td>' + pseb[i].subtotal + '</td></tr>');

	// 		pn = "pName"+i;
	// 		console.log(pn);
	// 		console.log('~~hello~~~');
	// 		console.log(document.getElementById(pn).innerText);
	// 		}

	// 		function sendpName() {
	// 			$.ajax({
	// 						url : "${pageContext.request.contextPath}/product/sale1",
	// 						data : {
	// 							productName : document.getElementById("pn").innerText //要更動innerHTML!!
	// 						},
	// 						type : "Post",
	// 						success : function() {
	// 							alert("you click me!");
	// 							window.location.href = "${pageContext.request.contextPath}/product/sale/date";
	// 						}
	// 					});
	// 		}

	// 	}
</script>
</html>