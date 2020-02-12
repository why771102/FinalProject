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

<button id="btn-show-all-children" type="button">Expand All</button>
<button id="btn-hide-all-children" type="button">Collapse All</button>
<hr>
<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
				    <th></th>
            <th>OrderID</th>
            <th>Order Date</th>
            <th>Total</th>
            <th>Payment Status</th>
        </tr>
    </thead>
    <tbody id="insertHere"></tbody>
    <tfoot>
        <tr>
				    <th></th>
            <th>OrderID</th>
            <th>Order Date</th>
            <th>Total</th>
            <th>Payment Status</th>
        </tr>
    </tfoot>
</table>

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
	
	

	<script>
console.log(${orders});
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
	    var table = $('#example').DataTable({
// 	        'ajax': 'https://api.myjson.com/bins/16lp6',
	        'columns': [
	            {
	                'className':      'details-control',
	                'orderable':      false,
	                'data':           null,
	                'defaultContent': ''
	            },
	            { 'data': 'OrderID' },
	            { 'data': 'Order Date' },
	            { 'data': 'Total' },
	            { 'data': 'Payment Status' }
	        ],
	        'order': [[1, 'asc']]
	    } );

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
	});
	</script>
	
</body>
</html>