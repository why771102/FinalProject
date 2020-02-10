<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>76影城</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/backstagestyle.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">

<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->

<!-- THIS IS SEATS HEADER -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Seat Charts</title>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/seat-charts.css">
<style>
body {
	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
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
	/*         margin-top: 150px; */
}

.container {
    text-align: -webkit-center;
	margin: 0 auto;
	width: 500px;
/* 	text-align: left; */
}

.booking-details {
/* 	float: left; */
/* 	margin-left: 155px; */
/* 	font-size: 12px; */
/* 	position: relative; */
/* 	flex-flow: row nowrap; */
/* 	justify-content: center; */
/* 	align-items: center; */
/* 	flex-flow: row nowrap; */
/* 	font-size: 12px; */
/* 	text-align: -webkit-center; */
	font-size: 12px;
    position: relative;
    height: 401px;
    text-align: -webkit-center;
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
	border: lightgrey solid 1px;
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
	margin-left: 25%;
	padding: 20px;
	/* float: left; */
}

div.seatCharts-legend {
	padding-left: 7%;
	position: absolute;
	bottom: 42%;
	text-align-last: justify;
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
	margin: 20px 32px;
	font-size: 14px;
	justify-content: center;
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
	width: 50%;
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
.wrapRowStart {
	/*Flex屬性區*/
	display: flex;
	flex-flow: row nowrap;
	justify-content: flex-start;
	align-items: flex-start;
	/* border: solid 1px black;
                border-block-end-color: brown; */
	/* 撐開長寬 */
	width: 100%;
	height: 100%;
	/* border and padding in box */
	box-sizing: border-box;
}

.h1, h1 {
	font-size: 36px;
	text-align: center;
	margin-left: 102px;
	margin-top: -52px;
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
	background-color: #4ECDC4;
	color: white;
}

.modal-body {
	padding: 12px 0px;
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
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="../z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="../z/bg-sidebar.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<!-- <h3><i class="fa fa-angle-right"></i> Blank Page</h3> -->
				<div class="row mt">
					<div class="col-lg-12">

						<!-- movie seats start -->
						<p>
						<div id="myModal" class="modal">

							<!-- Modal content -->
							<div class="modal-content">
								<div class="modal-header">
									<span class="close">&times;</span>
									<h2>新增場地</h2>
								</div>
								<div class="modal-body">
									<!-- 			hall name: <input type="text" id="hallName"><br> -->
									<div style="display: inline;">
									<div>
										HallID:<select id="hallID" style="margin-left: 9px; margin-bottom: 8px;">
										<option value="default" selected="" disabled="">請選擇</option>
										<c:forEach var="hall" items="${availableHallID}">
											<option value="${hall}">${hall}</option>
										</c:forEach>
										</select>
								
									</div>
									<div>
										Price:<input id="price" name="price" type='text'
											required="required" style="margin-left: 15px; margin-bottom: 5px;"/>
										
										</div>
										<div>
											column: <input type="text" id="col"><br>
										</div>
										<div>
											row: <input type="text" id="rows"
												style="margin-left: 21px; margin-top: 7px;"><br>
										</div>
										<button class="seatNumber btn btn-round btn-primary" id="seatNoConfirm"
											onclick="changeSeat(document.getElementById('col').value, document.getElementById('rows').value)"
											style="margin-top: 8px;">確認</button>
									</div>
								</div>
							</div>

						</div>
						<!-- Modal content end-->
						
						<div class="wrapper">
							<div class="container">
								<h1>廳院新增</h1>
								
								<div id="hall"
									style="margin-left: -2px; font-size: 17px; margin-bottom: -12px;">
									</div>
								<div class="wrapRowStart">
									<div id="legend"></div>
									<div id="seat-map">

										<div class='front-indicator'>Screen</div>
									</div>
								</div>
								<div class="booking-details">
									<button class="checkout-button btn btn-round btn-success" id="checkout"
										onclick="changeStatus()" style="display: flex;">確認&raquo;</button>
									<button class="checkout-button btn btn-round btn-danger" id="re-select" id="refresh"
										data-toggle="modal" data-target="#myModal" style="display: flex;">重新設定&raquo;</button>
								</div>

							</div>
						</div>

						<!-- movie seats end -->
					</div>
				</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>

		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
<!-- 	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> -->
<script
	src="${pageContext.request.contextPath}/js/jquery.seat-charts.js"></script>

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
			document.getElementsByClassName("modal-backdrop in")[0].style.display = "none";
			document.getElementById('hall').innerText = document.getElementById('hallID').value + " 廳";
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
											[ 'f', 'available', '標準座' ],
											[ 'e', 'available',
													'輪椅座' ],
											// [ 'f', 'unavailable', 'Already Booked' ],
											// [ 'o', 'out-of-order', 'Out Of Order' ],
											[ '_', 'available', '走道' ] ]
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
			var aisle = document
					.getElementsByClassName("seatCharts-seat seatCharts-cell aisle").length - 1;
			console.log("aisle" + aisle);
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
			var hallID = $('#hallID').val();
			// 			var availSeats = returnArray();

			var normalSeats = JSON.stringify(NseatArray);
			var handicapSeats = JSON.stringify(HseatArray);
			var rowNum = document.getElementById('rows').value;
			var colNum = document.getElementById('col').value;
			var noOfSeats = (rowNum * colNum) - aisle;
			console.log(noOfSeats);
			// 		var aisle={aisle:JSON.stringify(SseatArray)};
				$.ajax({
						url : "${pageContext.request.contextPath}/seats/addSeats",
						data : {
							normalSeats : normalSeats,
							handicapSeats : handicapSeats,
							hallID : hallID,
							price : $('#price').val(),
							rowNum : rowNum,
							colNum : colNum,
							noOfSeats : noOfSeats
						},
						type : "POST",
						success : function() {
							alert("新增成功!");
							window.location.href = "${pageContext.request.contextPath}/backstageindex";
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