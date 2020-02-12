<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>76影城</title>

    
<style>
div.shop_details, div.order_history {
    border: 2px solid rgb(227, 231, 220);
}
.VH_padding3 {
    padding: 3vh;
}
.wrapList {
    display: flex;
    flex-flow: column nowrap;
    justify-content: flex-start;
    align-items: flex-start;
    width: 100%;
    /* height: 100%; */
    box-sizing: border-box;
    padding: 0% 1% 1% 1%;
}

td.details-control {
    background: url('https://cdn.rawgit.com/DataTables/DataTables/6c7ada53ebc228ea9bc28b1b216e793b1825d188/examples/resources/details_open.png') no-repeat center center;
    cursor: pointer;
}
tr.shown td.details-control {
    background: url('https://cdn.rawgit.com/DataTables/DataTables/6c7ada53ebc228ea9bc28b1b216e793b1825d188/examples/resources/details_close.png') no-repeat center center;
}
</style>

</head>
<body>
<font size="2" face="Courier New" >
	<table id="example" class="display" style="width: 100%; text-align: center; background:#eaeaea !important; box-shadow: none !important;">
		<thead style="background: #C21010; color: white;">
			<tr>
				<th style="border-bottom: none;"></th>
				<th style="text-align: center;border-bottom: none">OrderID</th>
				<th style="text-align: center;border-bottom: none">Order Date</th>
				<th style="text-align: center;border-bottom: none">Total</th>
				<th style="text-align: center;border-bottom: none">Payment Status</th>
				<th style="text-align: center;border-bottom: none; display:none;">Product Name</th>
				<th style="text-align: center;border-bottom: none; display:none;">Quantity</th>
			</tr>
		</thead>
		<tbody id="insertHere">
		</tbody>
		<tfoot>
			<tr>
			</tr>
		</tfoot>
	</table></font>

<!-- 	<div class="login-inner"> -->
<!-- 		<h2>訂單內容</h2> -->
<!-- 		<div class="login-form"> -->
<!-- 			<div class="shop_details wrapList VH_padding3"> -->
<!-- 				<div class="end_gray_border wrapRowStart"> -->
<!-- 					<p class="text">Order Date</p> -->
<!-- 					<p class="text">Order No:</p> -->
<!-- 				</div> -->

<!-- 				<div class=" wrapList end_gray_border  "> -->
<!-- 					<div class="shop_products wrapRowBtw"> -->
<!-- 						<div class="wrapRowStart width60"> -->
<!-- 							<div id="prodimage"> -->
<!-- 								<img src="img/order_v2.png" alt=""> -->
<!-- 							</div> -->
<!-- 							<div id="prod_des">polka dot cat crop t-shirt: navy</div> -->
<!-- 						</div> -->
<!-- 						<div class="wrapRowStart shopping_detail"> -->
<!-- 							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div> -->
<!-- 							<div id="prod_price">NT$369</div> -->
<!-- 						</div> -->


<!-- 					</div> -->
<!-- 					<div class="shop_products wrapRowBtw"> -->
<!-- 						<div class="wrapRowStart width60"> -->
<!-- 							<div id="prodimage"> -->
<!-- 								<img src="img/order_v2.png" alt=""> -->
<!-- 							</div> -->
<!-- 							<div id="prod_des">polka dot cat crop t-shirt: natural</div> -->
<!-- 						</div> -->
<!-- 						<div class="wrapRowStart shopping_detail"> -->
<!-- 							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div> -->
<!-- 							<div id="prod_price">NT$369</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="shop_products wrapRowBtw"> -->
<!-- 						<div class="wrapRowStart width60"> -->
<!-- 							<div id="prodimage"> -->
<!-- 								<img src="img/order_v2.png" alt=""> -->
<!-- 							</div> -->
<!-- 							<div id="prod_des">polka dot cat crop t-shirt: pink</div> -->
<!-- 						</div> -->
<!-- 						<div class="wrapRowStart shopping_detail"> -->
<!-- 							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div> -->
<!-- 							<div id="prod_price">NT$369</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="shop_products wrapRowBtw"> -->
<!-- 						<div class="wrapRowStart width60"> -->
<!-- 							<div id="prodimage"> -->
<!-- 								<img src="img/order_v2.png" alt=""> -->
<!-- 							</div> -->
<!-- 							<div id="prod_des">polka dot cat crop t-shirt: white</div> -->
<!-- 						</div> -->
<!-- 						<div class="wrapRowStart shopping_detail"> -->
<!-- 							<div class=" VH_RL_padding4 " id="prod_quantity ">X 1</div> -->
<!-- 							<div id="prod_price">NT$369</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
<!-- 		</div> -->
<!-- 	</div> -->
	
	
<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
	console.log(${orders});
	var orders = ${orders};
	/* Formatting function for row details - modify as you need */
	function format ( d ) {
	    // `d` is the original data object for the row
	    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
	        '<tr>'+
	            '<td>productID:</td>'+
	            '<td>'+d.name+'</td>'+
	        '</tr>'+
	        '<tr>'+
	            '<td>Quantity:</td>'+
	            '<td>'+d.extn+'</td>'+
	        '</tr>'+
	    '</table>';
	}

	$(document).ready(function() {
// 	    	$.ajax({
// 				url : "${pageContext.request.contextPath}/showSCOrderDetails",
// 				type : "POST",
// 				success : function(data) {
// 					console.log(data);
// 					console.log(data[SCOrdersBean][sCOrderID]);
					var table = $('#example').DataTable({
// 						"columns": [
// 							{
// 			                "className":      'details-control',
// 			                "orderable":      false,
// 			                "data":           null,
// 			                "defaultContent": ''
// 			            	},
// 			            	{ "data": data[0][0].SCOrdersBean.sCOrderID },
// 			            	{ "data": data[0][0].SCOrdersBean.ordDate },
// 			            	{ "data": data[0][0].SCOrdersBean.ordDate },
// 			            	{ "data": data[0][0].SCOrdersBean.payStatusBean.payStatus }
// 			        	],
// 			        	"order": [[1, 'asc']]
						"columnDefs" : [ {
							"searchable" : false,
							"orderable" : false,
							"targets" : 0
						} ],
						"order" : [ [ 1, 'asc' ] ]
					});
// 		}
// 	    	});
	    	});
	    var dataTable = $("#example").DataTable();
// 		for(let orders = 0; orders < orders.length; orders++){
// 			for(let or)
// 			console.log(value);
// 			dataTable.row.add(["",orders.orderno,orders.SCOrdersBean.ordDate,orders.SCOrdersBean.total,orders.SCOrdersBean.payStatusBean.payStatus]).draw();
// 		}
	    $.each(orders, function(index, value) {
	    	var img = document.createElement("img");
	    	img.src = "${pageContext.request.contextPath}/details_open.png";
			console.log(value);
			console.log(value.length);
			for(let x = 0; x < value.length; x++){
				console.log("productname: " + value[x].productsBean.productName + " quantity: " + value[x].quantity);
// 				console.log();
			}
			console.log(value[0].SCOrdersBean.sCOrderID);
			console.log(value[0].SCOrdersBean.ordDate);
			console.log(value[0].SCOrdersBean.total);
			console.log(value[0].SCOrdersBean.payStatusBean.payStatus);
			dataTable.row.add(["+",value[0].SCOrdersBean.sCOrderID,value[0].SCOrdersBean.ordDate.substring(0, 16),value[0].SCOrdersBean.total,value[0].SCOrdersBean.payStatusBean.payStatus]).draw();
// 			dataTable.row.add("", [value[0].SCOrdersBean.sCOrderID,value[0].SCOrdersBean.ordDate,value[0].SCOrdersBean.total,value[0].SCOrdersBean.payStatusBean.payStatus]).draw();
		});
	    
	    // Add event listener for opening and closing details
	    $('#example tbody').on('click', 'td.details-control', function(){
	        var tr = $(this).closest('tr');
	        var row = table.row( tr );

	        if(row.child.isShown()){
	            // This row is already open - close it
	            row.child.hide();
	            tr.removeClass('shown');
	        } else {
	            // Open this row
	            row.child(format(row.data())).show();
	            tr.addClass('shown');
	        }
	    });

	    // Handle click on "Expand All" button
	    $('#btn-show-all-children').on('click', function(){
	        // Enumerate all rows
	        table.rows().every(function(){
	            // If row has details collapsed
	            if(!this.child.isShown()){
	                // Open this row
	                this.child(format(this.data())).show();
	                $(this.node()).addClass('shown');
	            }
	        });
	    });

	    // Handle click on "Collapse All" button
	    $('#btn-hide-all-children').on('click', function(){
	        // Enumerate all rows
	        table.rows().every(function(){
	            // If row has details expanded
	            if(this.child.isShown()){
	                // Collapse row details
	                this.child.hide();
	                $(this.node()).removeClass('shown');
	            }
	        });
	    });

	</script>
	
</body>
</html>