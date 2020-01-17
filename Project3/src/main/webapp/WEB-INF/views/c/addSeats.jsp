<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Seat Charts</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/seat-charts.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.seat-charts.js"></script>
<style>
body {
	font-family: 'Roboto', sans-serif;
	background-color: #fafafa;
}

a {
	color: #b71a4c;
}

.front-indicator {
	width: auto;
	margin: auto;
	background-color: #f6f6f6;
	color: #adadad;
	text-align: center;
	padding: 3px;
	border-radius: 5px;
}

.wrapper {
	width: 100%;
	text-align: center;
	margin-top: 150px;
}

.container {
	margin: 0 auto;
	width: 500px;
	text-align: left;
}

.booking-details {
	float: left;
	text-align: left;
	margin-left: 35px;
	font-size: 12px;
	position: relative;
	height: 401px;
}

.booking-details h2 {
	margin: 25px 0 20px 0;
	font-size: 17px;
}

.booking-details h3 {
	margin: 5px 5px 0 0;
	font-size: 14px;
}

div.seatCharts-cell {
	color: #182C4E;
	height: 25px;
	width: 25px;
	line-height: 25px;
}

div.seatCharts-seat {
	color: #FFFFFF;
	cursor: pointer;
}

div.seatCharts-row {
	height: 35px;
	display: flex;
	align-items: center;
	justify-content: center;
}

div.seatCharts-seat.normal-seats {
	background-color: #3a78c3;
}

div.seatCharts-seat.handicap-seats {
	/* 	background: url(vip.png); */
	background-color: #b9ca1c;
}

div.seatCharts-seat.aisle {
	background-color: white;
}

div.seatCharts-seat.focused {
	background-color: #76B474;
}

/* div.seatCharts-seat.selected { */
/* 	background-color: #E6CAC4; */
/* } */

div.seatCharts-seat.unavailable {
	background-color: #472B34;
}

div.seatCharts-container {
	/* border-right: 1px dotted #adadad; */
	/* width: 200px; */
	padding: 20px;
	/* float: left; */
}

div.seatCharts-legend {
	padding-left: 0px;
	position: absolute;
	bottom: 16px;
}

ul.seatCharts-legendList {
	padding-left: 0px;
}

span.seatCharts-legendDescription {
	margin-left: 5px;
	line-height: 30px;
}

.checkout-button {
	display: block;
	margin: 10px 0;
	font-size: 14px;
}

#selected-seats {
	max-height: 90px;
	overflow-y: scroll;
	overflow-x: none;
	width: 170px;
}

div#legend>div.seatCharts-seat.seatCharts-cell.selected {
			background-color: black;
		}

/* Pop up modal */
/* The Modal (background) */
.modal {
	display: none;
	/* Hidden by default */
	position: fixed;
	/* Stay in place */
	z-index: 1;
	/* Sit on top */
	padding-top: 100px;
	/* Location of the box */
	left: 0;
	top: 0;
	width: 100%;
	/* Full width */
	height: 100%;
	/* Full height */
	overflow: auto;
	/* Enable scroll if needed */
	background-color: rgb(0, 0, 0);
	/* Fallback color */
	background-color: rgba(0, 0, 0, 0.4);
	/* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: #fefefe;
	margin: auto;
	padding: 0;
	border: 1px solid #888;
	width: 80%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 0.4s;
	animation-name: animatetop;
	animation-duration: 0.4s
}

/* Add Animation */
@
-webkit-keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: white;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	padding: 2px 16px;
	background-color: #1113a8;
	color: white;
}

.modal-body {
	padding: 2px 16px;
}

.modal-footer {
	padding: 2px 16px;
	background-color: #5cb85c;
	color: white;
}

/* End of Pop up Modal style */
</style>
</head>
<body>
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h2>Create Movie Theatre Seatings</h2>
			</div>
			<div class="modal-body">
				<!-- 			hall name: <input type="text" id="hallName"><br> -->
				columns: <input type="text" id="col"><br> rows: <input
					type="text" id="rows"><br>
				<button class="seatNumber" id="seatNoConfirm"
					onclick="changeSeat(document.getElementById('col').value, document.getElementById('rows').value)">確認</button>
			</div>
		</div>

	</div>
	<div class="wrapper">
		<div class="container">
			<!-- <div>
			hall name: <input type="text" id="hallName">
			columns: <input type="text" id="col">
			rows: <input type="text" id="rows">
			<button class="seatNumber"
				onclick="changeSeat(document.getElementById('col').value, document.getElementById('rows').value)">Confirm</button>
		</div> -->
			<h1>Create Movie Theatre Seatings</h1>
			<div>${param.hallID}廳</div>
			<div id="seat-map">
				<div class='front-indicator'>Screen</div>
			</div>
			<div class="booking-details">
				<h2>Booking Details</h2>
				<h3>
					Selected Seats (<span id="counter">0</span>):
				</h3>
				<ul id="selected-seats">
				</ul>
				Total: <b>$<span id="total">0</span></b>

			</div>

		</div>
		<button class="checkout-button" id="checkout" onclick="changeStatus()">確認&raquo;</button>
		<button class="checkout-button" id="re-select" id="refresh"
			data-toggle="modal" data-target="#myModal">重新選擇座位 &raquo;</button>
		<div id="legend"></div>
		<a href='${pageContext.request.contextPath}/index-c'>index</a>
	</div>

	<script>
		//Modal
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the button that opens the modal
		var btn = document.getElementById("re-select");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		var seatNumber = document.getElementById("seatNumber");

		// When webpage loads, open the modal 
		window.onload = function() {
			modal.style.display = "block";
		}

		// When the user clicks the button, open the modal 
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}

		//End of Modal

		function getEN() {
			var arr = [];
			for (var i = 65; i < 91; i++) {
				arr.push(String.fromCharCode(i));
			}
			return arr;
		}

		function changeSeat(column, row) {
			$('.seatCharts-row').remove();
			$('.seatCharts-legendItem').remove();
			$('#seat-map,#seat-map *').unbind().removeData();
			var flag1 = 1;
			var map = [];
			for (let x = 0; x < column; x++) {
				var f = 'f'.repeat(row);
				map.push(f);
			}
			// if($("#seat-map").children().length!=0){
			// 	$("#seat-map").empty();
			// }
			seatmain(map, flag1);
			modal.style.display = "none";

		}

		// 	var firstSeatLabel = 1;

		// $(document).ready(function () {
		function seatmain(map1, flag) {

			var $cart = $('#selected-seats'), $counter = $('#counter'), $total = $('#total'), sc = $(
					'#seat-map')
					.seatCharts(
							{
								map : map1,

								seats : {
									f : {
										price : 270,
										classes : 'normal-seats', //your custom CSS class
										category : 'Normal'
									},
									e : {
										price : 270,
										classes : 'handicap-seats', //your custom CSS class
										category : 'Handicap Seats'
									},
									_ : {
										classes : 'aisle',
										category : 'Aisle'
									}
								// 								o : {
								// 									classes : 'out-of-order',
								// 									category : 'Out Of Order'
								// 								}

								},
								naming : {
									top : false,
									rows : getEN(),
									// 								getLabel: function (character, rows, columns) {
									// 									return firstSeatLabel++;

									// 								},
									getId : function(character, rows, columns) {
										return rows + '_' + columns;
									}

								},
								legend : {
									node : $('#legend'),
									items : [
											[ 'f', 'available', 'Normal' ],
											[ 'e', 'available',
													'Handicap Seats' ],
											// [ 'f', 'unavailable', 'Already Booked' ],
											// [ 'o', 'out-of-order', 'Out Of Order' ],
											[ '_', 'available', 'Aisle' ] ]
								},
								click : function() {
									//console.log(window.status);
									//console.log(this.settings.$node);
									console.log("this.status" + this.status);
									if (this.status() == 'available') {
										console.log("status= " + window.status);
										//let's create a new <li> which we'll add to the cart items
										$(
												'<li>'
														+ this.data().category
														+ ' Seat # '
														+ this.settings.id
														+ ': <b>$'
														+ this.data().price
														+ '</b> <a href="#" class="cancel-cart-item">[取消]</a></li>')
												.attr(
														'id',
														'cart-item-'
																+ this.settings.id)
												.data('seatId',
														this.settings.id)
												.appendTo($cart);

										/*
										 * Lets update the counter and total
										 *
										 * .find function will not find the current seat, because it will change its stauts only after return
										 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
										 */
										this.settings.$node
												.removeClass("normal-seats");
										this.settings.$node
												.removeClass("handicap-seats");
										this.settings.$node
												.removeClass("aisle");
										$counter
												.text(sc.find('selected').length + 1);
										$total.text(recalculateTotal(sc)
												+ this.data().price);
										if (status == "handicap") {
											console
													.log("this is handicap==seatCharts-space");
											return 'handicap-seats selected';
										} else if (status == "aisle") {
											return 'aisle selected';
										} else if (status == "normal") {
											return 'normal-seats selected';
										}
									} else if (!this.settings.$node
											.hasClass('selected')) {
										console.log("DOUBLE CLICK!!");
										console.log(status);
										this.settings.$node
												.removeClass("normal-seats");
										this.settings.$node
												.removeClass("handicap-seats");
										this.settings.$node
												.removeClass("aisle");
										// this.settings.$node.removeClass("selected");
										if (status == "normal") {
											this.settings.$node
													.addClass('normal-seats selected');
										} else if (status == "aisle") {
											// this.removeClass(this.status);
											this.settings.$node
													.addClass('aisle selected');
										} else if (status == "handicap") {
											// this.removeClass(this.status);
											this.settings.$node
													.addClass('handicap-seats selected');
										}
									} else if (this.settings.$node
											.hasClass('selected')) {
										this.settings.$node
												.removeClass("normal-seats selected");
										this.settings.$node
												.removeClass("handicap-seats selected");
										this.settings.$node
												.removeClass("aisle selected");
										// this.settings.$node.removeClass("selected");
										console.log("THIS IS SELECTED");
										console.log(this.settings.$node);
										//seat has been vacated
										if (status == "normal") {
											return ('normal-seats selected');
										} else if (status == "aisle") {
											// this.removeClass(this.status);
											console.log(this.settings.$node);
											return 'aisle selected';
										} else if (status == "handicap") {
											// this.removeClass(this.status);
											return 'handicap-seats selected';
										}

									} else {
										return this.style();
									}
								}
							});

			//add document.getElementsByClassName into typesOfSeats everything runs smoothly
			var NS = document.getElementById("legend").getElementsByClassName(
					"seatCharts-seat seatCharts-cell available normal-seats")[0];
			var HS = document.getElementById("legend").getElementsByClassName(
					"seatCharts-seat seatCharts-cell handicap-seats")[0];
			var A = document.getElementById("legend").getElementsByClassName(
					"seatCharts-seat seatCharts-cell aisle")[0];
			// console.log(document.getElementsByClassName("seatCharts-seat seatCharts-cell available first-class"));

			$(NS).click(function() {
				if ($(HS).hasClass("selected")) {
					$(HS).removeClass("selected")
				}
				if ($(A).hasClass("selected")) {
					$(A).removeClass("selected")
				}
				if ($(NS).hasClass("selected")) {
					$(NS).removeClass("selected");
				} else {
					$(NS).addClass("selected");
					window.status = "normal";
					// sc.get(this).status('normal-seats');
				}
				console.log("normal");
			})

			$(HS).click(function() {
				if ($(NS).hasClass("selected")) {
					$(NS).removeClass("selected")
				}
				if ($(A).hasClass("selected")) {
					$(A).removeClass("selected")
				}
				if ($(HS).hasClass("selected")) {
					$(HS).removeClass("selected");
				} else {
					$(HS).addClass("selected");
					window.status = "handicap";
					// changeStatus("handicap");
					// sc.get(this).status('handicap');
				}
				console.log("handicap");
			})

			$(A).click(function() {
				if ($(NS).hasClass("selected")) {
					$(NS).removeClass("selected")
				}
				if ($(HS).hasClass("selected")) {
					$(HS).removeClass("selected")
				}
				if ($(A).hasClass("selected")) {
					$(A).removeClass("selected");
				} else {
					$(A).addClass("selected");
					window.status = "aisle";
					// changeStatus("handicap");
					// sc.get(this).status('handicap');
				}
				console.log("aisle");
			})
		}
		// });

		// function changeStatus() {
		// 	var needtosubmit = document.getElementsByClassName("seatCharts-seat seatCharts-cell");
		// 	var seatArray = [];
		// 	var seatobj = {};
		// 	for (var i = 0; i < needtosubmit.length; i++) {
		// 		if (needtosubmit[i].id != "") {
		// 			seatobj = { id: needtosubmit[i].id,
		// 					available: needtosubmit[i].classList[2] }
		// 			seatArray.push(seatobj);
		// 		}
		// 	}

		// 	console.log(seatArray);
		// 	//AJAX return seatArray
		// }

		function changeStatus() {
			//SELECTED SEATS
			var flag2 = 2;
			var selectedNormalSeats = document
					.getElementsByClassName("seatCharts-seat seatCharts-cell normal-seats");
			var selectedHandicapSeats = document
					.getElementsByClassName("seatCharts-seat seatCharts-cell handicap-seats");
			var NseatArray = [];
			var Nseatobj = {};
			var HseatArray = [];
			var Hseatobj = {};
			console.log(selectedNormalSeats.length);
			for (let sNS = 0; sNS < selectedNormalSeats.length; sNS++) {
				if (selectedNormalSeats[sNS].id != "") {
					Nseatobj = selectedNormalSeats[sNS].id

					NseatArray.push(Nseatobj);

				}
			}
			for (let sHS = 0; sHS < selectedHandicapSeats.length; sHS++) {
				if (selectedHandicapSeats[sHS].id != "") {
					Hseatobj = selectedHandicapSeats[sHS].id
					HseatArray.push(Hseatobj);
				}

			}
			console.log("These are selected normal-seats: " + NseatArray);
			console.log("These are selected handicap seats: " + HseatArray);
			var hallID = '${param.hallID}';
// 			var availSeats = returnArray();

			var normalSeats = JSON.stringify(NseatArray);
			var handicapSeats = JSON.stringify(HseatArray);
			var rowNum = document.getElementById('rows').value;
			var colNum = document.getElementById('col').value;
			// 		var aisle={aisle:JSON.stringify(SseatArray)};
			$
					.ajax({
						url : "${pageContext.request.contextPath}/seats/addSeats",
						data : {
							normalSeats : normalSeats,
							handicapSeats : handicapSeats,
							hallID : hallID,
							rowNum : rowNum,
							colNum : colNum,
							noOfSeats : selectedNormalSeats.length+selectedHandicapSeats.length
						},
						type : "POST",
						success : function() {
							alert("新增成功!");
							window.location.href = "${pageContext.request.contextPath}/index-c";
						}
					});
			//USE WHEN YOU WANT TO ADD DIFFERENT TYPE OF SEATS
			// var seats = document.getElementsByClassName("seatCharts-seat seatCharts-cell available");
			// var seatArray = [];
			// var seatobj = {};
			// for (var i = 0; i < seats.length; i++) {
			// 	if (seats[i].id != "") {
			// 		seatobj = { id: seats[i].id,
			// 				available: seats[i].classList[2] }
			// 		seatArray.push(seatobj);
			// 	}
			// }

			// console.log(seatArray);
			//AJAX return seatArray
		}

// 		function returnArray() {
// 			//ONLY RECORDS AVAILABLE SEATS
// 			// 		console.log(firstSeatLabel);

// 			var AseatArray = [];
// 			var Aseatobj = {};
// 			for (var i = 0; i < availableSeats.length; i++) {
// 				if (availableSeats[i].id != "") {
// 					Aseatobj = availableSeats[i].id
// 					AseatArray.push(Aseatobj);
// 				}
// 			}
// 			console.log("This is available seats: " + AseatArray);
// 			return AseatArray;
// 			//AJAX return seatArray

// 		}

		function recalculateTotal(sc) {
			var total = 0;

			//basically find every selected seat and sum its price
			sc.find('selected').each(function() {
				total += this.data().price;
			});

			return total;
		}
	</script>
</body>

</html>
