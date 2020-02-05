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
<title>Dashio - Bootstrap Admin Template</title>

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
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/seat-charts.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.seat-charts.js"></script>
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
	/* 	margin-top: 150px; */
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

div.seatCharts-seat.available {
	background-color: #B9DEA0;
}

div.seatCharts-seat.available.normal-seats {
	/* 	background: url(vip.png); */
	background-color: #3a78c3;
}

div.seatCharts-seat.available.handicap-seats {
	/* 	background: url(vip.png); */
	background-color: #b9ca1c;
}

div.seatCharts-seat.aisle {
	background-color: white;
	border: lightgrey solid 1px;
}

div.seatCharts-seat.available.out-of-order {
	/* 	background: url(vip.png); */
	background-color: #cc1212;
}

/* div.seatCharts-seat.seatCharts-cell.out-of-order { */
/* 	/* 	background: url(vip.png); */
/* 	background-color: #cc1212; */
/* } */
div.seatCharts-seat.focused {
	background-color: #76B474;
}

div.seatCharts-seat.selected {
	background-color: #E6CAC4;
}

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
	padding-left: 340px;
	position: absolute;
	bottom: 447px;
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
	margin: 10px 174px;
	font-size: 14px;
}

#selected-seats {
	max-height: 90px;
	overflow-y: scroll;
	overflow-x: none;
	width: 170px;
}

.h1, h1 {
	font-size: 36px;
	text-align: center;
	margin-left: -6px;
	margin-top: -52px;
}
</style>
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>DASH<span>IO</span></b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="index.html#"> <i
							class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
					</a>
						<ul class="dropdown-menu extended tasks-bar">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 4 pending tasks</p>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Dashio Admin Panel</div>
										<div class="percent">40%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Database Update</div>
										<div class="percent">60%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Product Development</div>
										<div class="percent">80%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
											style="width: 80%">
											<span class="sr-only">80% Complete</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Payments Sent</div>
										<div class="percent">70%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="70" aria-valuemin="0"
											aria-valuemax="100" style="width: 70%">
											<span class="sr-only">70% Complete (Important)</span>
										</div>
									</div>
							</a></li>
							<li class="external"><a href="#">See All Tasks</a></li>
						</ul></li>
					<!-- settings end -->
					<!-- inbox dropdown start-->
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 5 new messages</p>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="img/ui-zac.jpg"></span> <span class="subject">
										<span class="from">Zac Snider</span> <span class="time">Just
											now</span>
								</span> <span class="message"> Hi mate, how is everything? </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="img/ui-divya.jpg"></span> <span
									class="subject"> <span class="from">Divya Manian</span>
										<span class="time">40 mins.</span>
								</span> <span class="message"> Hi, I need your help with this. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="img/ui-danro.jpg"></span> <span
									class="subject"> <span class="from">Dan Rogers</span> <span
										class="time">2 hrs.</span>
								</span> <span class="message"> Love your new Dashboard. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar" src="img/ui-sherman.jpg"></span> <span
									class="subject"> <span class="from">Dj Sherman</span> <span
										class="time">4 hrs.</span>
								</span> <span class="message"> Please, answer asap. </span>
							</a></li>
							<li><a href="index.html#">See all messages</a></li>
						</ul></li>
					<!-- inbox dropdown end -->
					<!-- notification dropdown start-->
					<li id="header_notification_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-bell-o"></i> <span class="badge bg-warning">7</span>
					</a>
						<ul class="dropdown-menu extended notification">
							<div class="notify-arrow notify-arrow-yellow"></div>
							<li>
								<p class="yellow">You have 7 new notifications</p>
							</li>
							<li><a href="index.html#"> <span
									class="label label-danger"><i class="fa fa-bolt"></i></span>
									Server Overloaded. <span class="small italic">4 mins.</span>
							</a></li>
							<li><a href="index.html#"> <span
									class="label label-warning"><i class="fa fa-bell"></i></span>
									Memory #2 Not Responding. <span class="small italic">30
										mins.</span>
							</a></li>
							<li><a href="index.html#"> <span
									class="label label-danger"><i class="fa fa-bolt"></i></span>
									Disk Space Reached 85%. <span class="small italic">2
										hrs.</span>
							</a></li>
							<li><a href="index.html#"> <span
									class="label label-success"><i class="fa fa-plus"></i></span>
									New User Registered. <span class="small italic">3 hrs.</span>
							</a></li>
							<li><a href="index.html#">See all notifications</a></li>
						</ul></li>
					<!-- notification dropdown end -->
				</ul>
				<!--  notification end -->
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="login.html">Logout</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<a href="profile.html"><img src="img/ui-sam.jpg"
							class="img-circle" width="80"></a>
					</p>
					<h5 class="centered">Sam Soffes</h5>
					<li class="mt"><a href="index.html"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>UI Elements</span>
					</a>
						<ul class="sub">
							<li><a href="general.html">General</a></li>
							<li><a href="buttons.html">Buttons</a></li>
							<li><a href="panels.html">Panels</a></li>
							<li><a href="font_awesome.html">Font Awesome</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Components</span>
					</a>
						<ul class="sub">
							<li><a href="grids.html">Grids</a></li>
							<li><a href="calendar.html">Calendar</a></li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="todo_list.html">Todo List</a></li>
							<li><a href="dropzone.html">Dropzone File Upload</a></li>
							<li><a href="inline_editor.html">Inline Editor</a></li>
							<li><a href="file_upload.html">Multiple File Upload</a></li>
						</ul></li>
					<li class="sub-menu"><a class="active" href="javascript:;">
							<i class="fa fa-book"></i> <span>Extra Pages</span>
					</a>
						<ul class="sub">
							<li class="active"><a href="blank.html">Blank Page</a></li>
							<li><a href="login.html">Login</a></li>
							<li><a href="lock_screen.html">Lock Screen</a></li>
							<li><a href="profile.html">Profile</a></li>
							<li><a href="invoice.html">Invoice</a></li>
							<li><a href="pricing_table.html">Pricing Table</a></li>
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="404.html">404 Error</a></li>
							<li><a href="500.html">500 Error</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>Forms</span>
					</a>
						<ul class="sub">
							<li><a href="form_component.html">Form Components</a></li>
							<li><a href="advanced_form_components.html">Advanced
									Components</a></li>
							<li><a href="form_validation.html">Form Validation</a></li>
							<li><a href="contactform.html">Contact Form</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>Data Tables</span>
					</a>
						<ul class="sub">
							<li><a href="basic_table.html">Basic Table</a></li>
							<li><a href="responsive_table.html">Responsive Table</a></li>
							<li><a href="advanced_table.html">Advanced Table</a></li>
						</ul></li>
					<li><a href="inbox.html"> <i class="fa fa-envelope"></i> <span>Mail
						</span> <span class="label label-theme pull-right mail-info">2</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class=" fa fa-bar-chart-o"></i> <span>Charts</span>
					</a>
						<ul class="sub">
							<li><a href="morris.html">Morris</a></li>
							<li><a href="chartjs.html">Chartjs</a></li>
							<li><a href="flot_chart.html">Flot Charts</a></li>
							<li><a href="xchart.html">xChart</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-comments-o"></i> <span>Chat Room</span>
					</a>
						<ul class="sub">
							<li><a href="lobby.html">Lobby</a></li>
							<li><a href="chat_room.html"> Chat Room</a></li>
						</ul></li>
					<li><a href="google_maps.html"> <i
							class="fa fa-map-marker"></i> <span>Google Maps </span>
					</a></li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
				<div class="row mt">
					<div class="col-lg-12">
						<p>
							<!-- movie seats start -->
						<div id="legend"></div>
						<div class="wrapper">
							<div class="container">
								<h1>廳院管理</h1>
								<div>選擇廳: ${hallID} 廳</div>
								<div id="seat-map">
									<div class='front-indicator'>Screen</div>
								</div>
								<div class="booking-details">
									<button class="checkout-button btn btn-round btn-primary" id="checkout"
										onclick="changeStatus()">確認&raquo;</button>
									<div id="closebutton"></div>
									<div>
										<a href='${pageContext.request.contextPath}/index-c'>index</a>
									</div>
								</div>

							</div>


						</div>

						</p>

					</div>
				</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
				</p>
				<div class="credits">
					<!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
					Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
				</div>
				<a href="blank.html#" class="go-top"> <i class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery-ui-1.9.2.custom.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery.ui.touch-punch.min.js"></script>
	<script class="include" type="text/javascript"
		src="${pageContext.request.contextPath}/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="${pageContext.request.contextPath}/lib/common-scripts.js"></script>
	<!--script for this page-->
	<script>
		//Has to do with showing seats
		//The alphabets of the columns
		function getEN() {
			var arr = [];
			for (var i = 65; i < 91; i++) {
				arr.push(String.fromCharCode(i));
			}
			return arr;
		}

		//showing the seating chart through calling controller using ajax
		function showSeats() {
			$('.seatCharts-row').remove();
			$('.seatCharts-legendItem').remove();
			$('#seat-map,#seat-map *').unbind().removeData();
			var hallID = document.getElementById("hallID").value;
			$.ajax({
				url : "${pageContext.request.contextPath}/seats/showSeats",
				data : {
					hallID : hallID
				},
				type : "POST",
				success : function(data) {
					var seat = JSON.parse(data[1]);
					seatmain(seat, 1)
					document.getElementById("closebutton").innerHTML = data[2];
				}
			});
		}

		//main seating chart jquery
		function seatmain(map1, flag) {

			var $cart = $('#selected-seats'), $counter = $('#counter'), $total = $('#total'), sc = $(
					'#seat-map')
					.seatCharts(
							{
								map : map1,

								seats : {
									f : {
										price : 100,
										classes : 'normal-seats', //your custom CSS class
										category : 'Normal'
									},
									e : {
										price : 40,
										classes : 'handicap-seats', //your custom CSS class
										category : 'Handicap Seats'
									},
									_ : {
										classes : 'seatCharts-space',
										category : 'Aisle'
									},
									o : {
										classes : 'out-of-order',
										category : 'Out Of Order'
									}

								},
								naming : {
									top : false,
									rows : getEN(),
									// getLabel: function (character, rows, columns) {
									// 	return firstSeatLabel++;
									// },
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
											// 										[ 'f', 'unavailable', 'Already Booked' ],
											[ 'o', 'available', 'Out Of Order' ],
											[ '_', 'seatCharts-space', 'Aisle' ] ]
								},
								click : function() {
									if (this.status() == 'available') {
										//let's create a new <li> which we'll add to the cart items
										$(
												'<li>'
														+ this.data().category
														+ ' Seat # '
														+ this.settings.id
														+ ': <b>$'
														+ this.data().price
														+ '</b> <a href="#" class="cancel-cart-item">[取消]</a></li>')
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
										$counter
												.text(sc.find('selected').length + 1);
										$total.text(recalculateTotal(sc)
												+ this.data().price);

										return 'selected';
									} else if (this.status() == 'selected') {
										//update the counter
										$counter
												.text(sc.find('selected').length - 1);
										//and total
										$total.text(recalculateTotal(sc)
												- this.data().price);

										//remove the item from our cart
										$('#cart-item-' + this.settings.id)
												.remove();

										//seat has been vacated
										return 'available';
									} else if (this.status() == 'unavailable') {
										//seat has been already booked
										return 'unavailable';
									} else {
										return this.style();
									}
								}
							});
			//this will handle "[cancel]" link clicks
			$('#selected-seats').on('click', '.cancel-cart-item', function() {
				//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
				sc.get($(this).parents('li:first').data('seatId')).click();
			});

			//let's pretend some seats have already been booked
			if (flag == 2) {
				sc.get(map1).status('out-of-order');
				// 			sc.get(map1).status('seatCharts-space');

				$('.normal-seats').on('click', '.seatCharts-space', function() {
					sc.get($(this).parents('li:first').data('seatId')).click();
				});
			}
		}

		//按下確認後所執行的function
		function changeStatus() {
			//SELECTED SEATS
			if (confirm("確認修改座位嗎?")) {
				var flag2 = 2;
				var selectedSeats = document
						.getElementsByClassName("seatCharts-seat seatCharts-cell selected");
				var SseatArray = [];
				var Sseatobj = {};
				for (var i = 0; i < selectedSeats.length; i++) {
					if (selectedSeats[i].id != "") {
						Sseatobj = selectedSeats[i].id
						SseatArray.push(Sseatobj);
					}

				}
				console.log("This is selected seats: " + SseatArray);
				seatmain(SseatArray, flag2);
				var hallID = document.getElementById("hallID").value;
				console.log(hallID);
				var unavailable = JSON.stringify(SseatArray);
				$
						.ajax({
							url : "${pageContext.request.contextPath}/seats/updateSeats",
							data : {
								seats : unavailable,
								hallID : hallID
							},
							type : "POST",
							success : function() {
								alert("修改" + hallID + "廳" + unavailable
										+ "座位成功!");
								location.reload();
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
			} else {

			}
		}

		//刪除此廳
		function updateHallStatus() {
			var hallID = document.getElementById("hallID").value;
			var hallStatus = document.getElementById("updateHallStatus").value;
			console.log(hallStatus);
			if (confirm("確認關閉此廳嗎?")) {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/hall/updateHallStatus",
							data : {
								hallID : hallID,
								hallStatus : hallStatus
							},
							type : "POST",
							success : function() {
								alert("更改成功");
								location.reload();
							}
						});
			} else {
				//取消關閉此廳的選項
			}
		}

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