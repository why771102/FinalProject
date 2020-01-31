<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.m.model.HallSaleBean, java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <% List<HallSaleBean> hsbList = (ArrayList<HallSaleBean>)request.getAttribute("HallSaleBeanList"); --%>
<%-- System.out.println(hsbList.get(0).getHallID());%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>hallSale1</title>
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
	<h2 style="text-align: center">包廳銷售總覽</h2>
	<div>
		<div id="timePicker"
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
				<th>廳名</th>
				<th>單價</th>
				<th>時數</th>
				<th>銷售總金額</th>
			</tr>
		</thead>
		<tbody id="insertHere">


			<!-- 				<tr> -->
			<!-- 					<td></td> -->
			<!-- 					<td><a -->
			<%-- 						href="${pageContext.request.contextPath}/hall/sale/date">Tiger --%>
			<!-- 							Nixo</a></td> -->
			<!-- 					<td>System Architect</td> -->
			<!-- 					<td>Edinburgh</td> -->
			<!-- 					<td>61</td> -->
			<!-- 				</tr> -->
		</tbody>
		<!-- 			<tfoot> -->
		<!-- 				<tr> -->
		<!-- 					<th></th> -->
		<!-- 					<th></th> -->
		<!-- 					<th></th> -->
		<!-- 					<th></th> -->
		<!-- 					<th></th> -->
		<!-- 				</tr> -->
		<!-- 			</tfoot> -->
	</table>
	<a href="<spring:url value="/hallSale.xls"/>" class="button info">Export
		To Excel</a>

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

			//動態新增表格
			// 		console.log("test=> " + ${HallSaleBeanList});
			// 		${HallSaleBeanList}.forEach(showInfo);

		});

		// timepicker => window load??
		// 		$(window).load(function() {
		$(function() {
			var start = moment().subtract(7, 'days');
			var end = moment();
			function cb(start, end, label) {
				$('#timePicker span').html(
						start.format('YYYY-MM-DD') + ' ~ '
								+ end.format('YYYY-MM-DD'));
				//傳送日期的值
				$.ajax({
					url : "${pageContext.request.contextPath}/hall/sale",
					data : {
						start : start.format('YYYY-MM-DD'),
						end : end.format('YYYY-MM-DD')
					},
					type : "POST",
					success : function(hall) {
						alert("搜尋成功!");

						var dataTable = $("#example").DataTable();
						dataTable.clear().draw();

						$.each(hall, function(index, value) {
							console.log(value);
							dataTable.row.add(["",value.hallID + "廳",value.price,value.orderHours,value.hallSubtotal]).draw();
						});

						// 						showInfo(data);
						console.log(hall);
					}
				});
			}
			console.log("hhhh" + start.format('YYYY-MM-DD'));

			// MMMM D, YYYY
			$('#timePicker').daterangepicker(
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
									moment().subtract(1, 'month').startOf(
											'month'),
									moment().subtract(1, 'month')
											.endOf('month') ]
						}
					}, cb);
			cb(start, end);
		});

		// 		function showInfo(hall) {
		// 			for(var i =0; i < hall.length; i++){
		// 			$('#insertHere')
		// 					.append(
		// 							'<tr><td></td><td><a href="${pageContext.request.contextPath}/hall/sale/date" id="hallID">'
		// 									+ hall[i].hallID
		// 									+ '廳'
		// 									+ '</a></td><td>'
		// 									+ hall[i].price
		// 									+ '</td><td>'
		// 									+ hall[i].orderHours
		// 									+ '</td><td>'
		// 									+ hall[i].hallSubtotal + '</td></tr>');
		// 			}
		// 		};

		// 	function (){
		// 	$.ajax({
		// 		url : "${pageContext.request.contextPath}/hall/sale",
		// 		type : "POST",
		// 		success : function(data) {
		// 			var hallSaleBean = JSON.parse(data[1]);
		// 			seatmain(seat, 1)
		// 			window.noOfTickets = parseInt(data[2]);
		// 			document.getElementById("numberOfTickets").innerText = window.noOfTickets;
		// 			document.getElementById("hallID").innerText = data[3] + "廳";
		// 			document.getElementById("movieTitle").innerText += data[4];
		// 			document.getElementById("date").innerText += data[5];
		// 		}
		// 	});
		// 	}
	</script>
</body>
</html>