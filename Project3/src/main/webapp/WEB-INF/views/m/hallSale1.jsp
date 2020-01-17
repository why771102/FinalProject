<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<form:form method='POST' modelAttribute="hallSaleBean" enctype="multipart/form-data" >
	<div>
		電影類型： <select>
			<option>輔導級</option>
		</select> &nbsp; &nbsp; &nbsp;電影名稱 <select>
			<option>Java人生</option>
		</select>
		<div id="reportrange"
			style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 14%;">
			<i class="fa fa-calendar"></i>&nbsp; <span></span> <i
				class="fa fa-caret-down"></i>
		</div>
	</div>
	<br>
	<table id="example" class="display" style="width: 100%;">
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
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
				<td>Tiger Nixon</td>
				<td>System Architect</td>
				<td>Edinburgh</td>
				<td>61</td>
				<td>$320,800</td>
				<td>100</td>
				<td>P</td>
			</tr>
			<tr>
				<td></td>
				<td>Garrett Winters</td>
				<td>Accountant</td>
				<td>Tokyo</td>
				<td>63</td>
				<td>$170,750</td>
				<td>200</td>
				<td>Q</td>
			</tr>
			<tr>
				<td></td>
				<td>Ashton Cox</td>
				<td>Junior Technical Author</td>
				<td>San Francisco</td>
				<td>66</td>
				<td>$86,000</td>
				<td>300</td>
				<td>K</td>
			</tr>
			<tr>
				<td></td>
				<td>Cedric Kelly</td>
				<td>Senior Javascript Developer</td>
				<td>Edinburgh</td>
				<td>22</td>
				<td>$433,060</td>
				<td>400</td>
				<td>G</td>
			</tr>
			<tr>
				<td></td>
				<td>Airi Satou</td>
				<td>Accountant</td>
				<td>Tokyo</td>
				<td>33</td>
				<td>$162,700</td>
				<td>500</td>
				<td>Y</td>
			</tr>
			<tr>
				<td></td>
				<td>Brielle Williamson</td>
				<td>Integration Specialist</td>
				<td>New York</td>
				<td>61</td>
				<td>$372,000</td>
				<td>1000</td>
				<td>X</td>
			</tr>
			<tr>
				<td></td>
				<td>Herrod Chandler</td>
				<td>Sales Assistant</td>
				<td>San Francisco</td>
				<td>59</td>
				<td>$137,500</td>
				<td>700</td>
				<td>Z</td>
			</tr>
			<tr>
				<td></td>
				<td>Rhona Davidson</td>
				<td>Integration Specialist</td>
				<td>Tokyo</td>
				<td>55</td>
				<td>$327,900</td>
				<td>30</td>
				<td>A</td>
			</tr>
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
		function cb(start, end) {
			$('#reportrange span').html(
					start.format('YYYY / MM / DD') + ' - '
							+ end.format('YYYY / MM / DD'));
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
</script>
</html>