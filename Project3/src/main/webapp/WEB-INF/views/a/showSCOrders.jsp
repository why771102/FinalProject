<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>76影城</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
 integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
 crossorigin="anonymous"></script>
    
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
	<section>
		<div>
			<div style="text-align: center">
				<h1>購物車訂單</h1>
			</div>
		</div>
	</section>
<font size="2" face="Courier New" >
	<table id="example" class="display" style="width: 100%; text-align: center; background:#eaeaea !important; box-shadow: none !important;">
		<thead style="background: #C21010; color: white;">
			<tr>
				<th style="border-bottom: none;"></th>
				<th style="text-align: center;border-bottom: none">訂單ID</th>
				<th style="text-align: center;border-bottom: none">訂單日期</th>
				<th style="text-align: center;border-bottom: none">總價</th>
				<th style="text-align: center;border-bottom: none">付款狀態</th>
			</tr>
		</thead>
		<tbody id="insertHere">
		</tbody>
		<tfoot>
			<tr>
			</tr>
		</tfoot>
	</table></font>

	

<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
	console.log(${orders});
	var orders = ${orders};
	/* Formatting function for row details - modify as you need */
	function format ( d ) {
		console.log(d);
		console.log(typeof(d[1]));
	    // `d` is the original data object for the row
	    window.childtable = "<table cellpadding='5' cellspacing='0' border='0' style='padding-left:50px;'>";
	    for(let order = 0; order < orders.length; order++){

	    	if(d[1] == orders[order][0].SCOrdersBean.sCOrderID){
	    		console.log("true");
	    		for(let products = 0; products < orders[order].length; products++){
	    			console.log(orders[order][products].productsBean.productName);
	    			
	    			window.childtable +='<tr>'+
	            		'<td>商品名稱:</td>'+
	            		'<td>'+orders[order][products].productsBean.productName+'</td>'+
	        		'</tr>'+
	        		'<tr>'+
	           	 	'<td>購買數量:</td>'+
	            	'<td>'+orders[order][products].quantity+'</td>'+
	        	'</tr>'+
	        	'<tr>'+
            	'<td>單價:</td>'+
            	'<td>NT$'+orders[order][products].productsBean.unitPrice+'</td>'+
        		'</tr>'

	    		}
	    	}
	    }
	    window.childtable+='</table>';
	    console.log(window.childtable);
	    return window.childtable;

	    	}
	    
	

	$(document).ready(function() {
					var table = $('#example').DataTable({
						"columnDefs" : [ {
							"searchable" : false,
							"orderable" : false,
							"className":      'details-control',
							"targets" : 0
						} ],
						"order" : [ [ 1, 'asc' ] ]
					});

	    	});
	    var dataTable = $("#example").DataTable();

	    $.each(orders, function(index, value) {
			console.log(value);
			console.log(value.length);
			for(let x = 0; x < value.length; x++){
				console.log("productname: " + value[x].productsBean.productName + " quantity: " + value[x].quantity);
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
	        var row = dataTable.row( tr );

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