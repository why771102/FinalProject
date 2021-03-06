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
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>showTimeHitory</title>

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
<!-- Custom styles for jueryDataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">



<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
<!--  =============================CSS put Here============================== -->
<style>
div {
	margin-bottom: 10px;
	position: relative;
}

input[type="number"] {
	width: 100px;
}

input+span {
	padding-right: 30px;
}

input:invalid+span:after {
	position: absolute;
	content: '✖';
	padding-left: 5px;
}

input:valid+span:after {
	position: absolute;
	content: '✓';
	padding-left: 5px;
}
tbody>tr>td{
  padding-left:20px;
}

thead{
     background: #4ECDC4;
    color: white;
    font-size:18px;
    }
table{
       width: 100%;
    text-align: center;
}
</style>
<!--  =============================CSS put Here============================== -->
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
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">
			
				<div class="row mt">
					<div class="col-lg-12">
						<!-- <p>Place your content here.</p> -->
						<h1 style='    text-align: center;'>修改頁面</h1>

						<table id="table" class="display">
							

							<thead>
								<tr>
									<td>日期:</td>
									<td>廳:</td>
									<td>showID</td>
									<td>runID</td>
									<td>代號:</td>
									<td>電影名稱:</td>
									<td>片長:</td>
									<td>播出時間:</td>
									<td>權重:</td>


								</tr>
							</thead>
							<tbody id='table_tr'>

							</tbody>
						</table>

                        <div style=' ' align='center'>

						<div >
							<!--  	<input id='final' name='sth' type='hidden' value=''/>  -->
							<input class='btn btn-theme' id='aaa' type='button' style='margin:0px 30px 0px 0px;' onclick="formSubmit()" value='修改' />
						     <a href='${pageContext.request.contextPath}/insertReservedSeats'  style='margin:0px 30px 0px 0px;'><button class='btn btn-theme04'>確認</button></a>
						
						</div>
						

						</div>






						<!-- <p>Place your content here.</p> -->

					</div>
				</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>

	<!-- put Javascript  here-->

	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
	<script>
		//準備movie 有多少個陣列

		var hall = ${hall};
		//         console.log(hall);
		//        console.log(hall.length);

		var movie = ${runMovie};
		//         console.log(movie);
		//         console.log(movie.length);
		var movieTitle = "";
		for (let i = 0; i < movie.length; i++) {

			movieTitle += "<option value='" + i + "' selected=''>"
					+ movie[i].movie.title + "</option>"

		}

		var a = ${showTime};
		//         console.log(a[0].stID);
		console.log("a.length:" + a.length);//202?
		console.log("a:" + a);

		//分出包場和電影  往上append to Data table
		for (let i = 0; i < a.length; i++) {

			//包場
			if (a[i]["stID"] == "0") {
				console.log("包場" + a[i].stID);
				console.log("包場" + a[i].strDay);
				console.log("包場" + a[i].hall);
				console.log("包場" + a[i].runningTime);
				console.log("包場" + a[i].stID);
				console.log("包場" + a[i].stID);
				console.log("包場" + a[i].stID);
				$(document)
						.ready(
								function() {
									$("#table_tr")
											.append(
													" <tr id=tr" + i + ">"
															+ "<td id='strDay" + i + "'>"
															+ a[i].strDay
															+ "</td>"
															+ "<td id='hallID" + i + "'>"
															+ a[i].hall.hallID
															+ "</td>"
															+ "<td id='showTimeId" + i + "'>0</td>"
															+ "<td  id='runID" + i + "'>0</td>"
															+ "<td>"
															+ a[i].stID
															+ "</td>"
															+ "<td>"
															+ a[i].hob.hallPurpose
															+ "</td>"
															+ "<td><p id='runningTime" + i + "'>"
															+ a[i].runningTime
															+ "</p></td>"
															+ "<td id='time" + i + "'>"
															+ a[i].strTime

															+ "</td>"
															+ "<td>max</td>" +

															"</tr>");
								});

				//電影
			} else if (a[i]["stID"] == "1") {
				console.log("電影" + a[0].stID);

				$(document)
						.ready(
								function() {
									$("#table_tr")
											.append(
													" <tr id=tr" + i + ">"
															+ "<td id='strDay" + i + "'>"
															+ a[i].strDay
															+ "</td>"
															+ "<td id='hallID" + i + "'>"
															+ a[i].sthb.hall.hallID
															+ "</td>"
															+ "<td  id='showTimeId" + i + "'>"
															+ a[i].sthb.showTimeId
															+ "</td>"
															+ "<td id='runID" + i + "'>"
															+ a[i].sthb.run.runID
															+ "</td>"
															+ "<td>"
															+ a[i].stID
															+ "</td>"
															+ "<td>"
															+ "<select name='' id='title' onchange='change(this.value,"
															+ i
															+ ")' value='"
															+ i
															+ "'>"
															+ movieTitle
															+ "<option  selected='' disabled='' value='" + i + "'>"
															+ a[i].sthb.run.movie.title
															+ "</option>"
															+

															"</select>"
															+

															"</td>"
															+ "<td><p id='runningTime" + i + "'>"
															+ a[i].runningTime
															+ "</p></td>"
															+ "<td id='time" + i + "'>"
															+ "<input id='appt-time' type='time' name='appt-time'"
															+ "value='"
															+ a[i].strTime
															+ "'min='"
															+ a[i].strTime
															+ "' max='24:00' onchange='changeTime(this.value,"
															+ i
															+ ")'><span class='validity'></span>"

															+ "</td>"
															+ "<td id='price_time" + i + "'>"
															+ a[i].price_time
															+ "</td>" +

															"</tr>");
								});

			}

		}
		/*改變時間*/
		function changeTime(value, row) {
			//             console.log(value);

			var time_obj1 = document.getElementById("time" + row);
			var RTobj_1 = document.getElementById("runningTime" + row);
			var startTime2 = PlusTime(a[row].strDay,
					time_obj1.childNodes[0].value, RTobj_1.innerHTML, "time");
			let str = startTime2.split(":");
			console.log("change hour:" + str[0]);
			console.log("change minute:" + str[1]);
			console.log("runtime:" + RTobj_1.innerHTML);

			if (str[0] > 2 && str[0] < 9) {
				console.log("加自己時間超過2:00");
				time_obj1.childNodes[0].max = "00:00";
			} else {
				time_obj1.childNodes[0].max = "24:00";
			}
       //改變相同廳改變時間的下排時間
			/* alert(value); */
			change_sameHall_otherMovie_time(value, row);

		}

		/*改變電影*/
		function change(value, row) {
			var row = row;
			//             alert(value + " " + row + " ");

			var runTime = "runningTime" + row.toString();
			//             console.log(runTime);
			var time_obj1 = document.getElementById("time" + row);
			var RTobj = document.getElementById("runningTime" + row);
			var PTobj = document.getElementById("price_time" + row);
			var Runobj = document.getElementById("runID" + row);

			RTobj.innerHTML = "";
			RTobj.innerHTML = movie[value].movie.runningTime; //change runningTime
			PTobj.innerHTML = movie[value].movie.expectedProfit;
			Runobj.innerHTML = movie[value].runID; //change runID
			// 檢查自己時間是否在2:00以內
			var startTime2 = PlusTime(a[row].strDay,
					time_obj1.childNodes[0].value, RTobj.innerHTML, "time");
			let str = startTime2.split(":");
			console.log("change hour:" + str[0]);
			console.log("change minute:" + str[1]);
			console.log("runtime:" + RTobj.innerHTML);
			if (str[0] > 2 && str[0] < 9) {
				console.log("加自己時間超過2:00");
				time_obj1.childNodes[0].max = "00:00";
			} else {
				time_obj1.childNodes[0].max = "24:00";
			}

			//
			//重新設定同一排自己的時間(自己的時間不變 ,要變後面排的時間)
			var time_obj0 = document.getElementById("time" + row);
			//             time_obj0.removeChild(time_obj0.childNodes[0]);
			//hallID一樣才能改
			change_sameHall_otherMovie_time(value, row);

		}

		//改變相同廳 其他電影的時間
		function change_sameHall_otherMovie_time(value, row) {
			for (let i = (row + 1); i < (a.length); i++) {

				var time_obj1 = document.getElementById("time" + i);
				var RTobj_1 = document.getElementById("runningTime" + i);
				var time_obj2 = document.getElementById("time" + (i - 1)); //改變的那個
				var RTobj_2 = document.getElementById("runningTime" + (i - 1));
				//           	 console.log("hallID_1:"+a[row].sthb.hall.hallID);
				//           	 console.log("hallID_2:"+a[i].sthb.hall.hallID);
				if (a[row].sthb.hall.hallID == a[i].sthb.hall.hallID) {
					//  time_obj1.removeChild(time_obj1.childNodes[0]);
					//               	console.log("time:"+time_obj2.childNodes[0].value);
					//               	console.log("runningTime:"+RTobj_2.innerHTML);
					var startTime2 = PlusTime(a[i - 1].strDay,
							time_obj2.childNodes[0].value, RTobj_2.innerHTML,
							"time");
					console.log("stTime2:" + startTime2);//15:02
					let str = startTime2.split(":");
					console.log("hour:" + str[0]);
					console.log("minute:" + str[1]);
					console.log("runtime:" + RTobj_1.innerHTML);
					var day_obj1 = document.getElementById("strDay" + i);
					if (str[0] < 2) {

						if (((RTobj_1.innerHTML) + str[1] / 60) * 1 + (str[0])
								* 1 >= 2) {
							alert("時間錯誤!")
							change_sameHall_AllTimeMax(value, row);

						} else {
							var startDate = PlusTime(a[i - 1].strDay,
									time_obj2.childNodes[0].value,
									RTobj_2.innerHTML, "date");
							console.log("changeday:" + startDate);
							day_obj1.innerHTML = startDate;
							time_obj1.childNodes[0].max = "02:00";

						}

					} else if (str[0] >= 2 && str[0] < 9) {
						alert("時間錯誤!")
						break;
					} else {
						day_obj1.innerHTML = a[i - 1].strDay;
						time_obj1.childNodes[0].max = "24:00";
					}

					time_obj1.childNodes[0].value = startTime2;
					time_obj1.childNodes[0].min = startTime2;

				}

			}

		}

		//  改變同廳接下來其他電影的時間 change_sameHall_AllTimeMax(value,row);
		function change_sameHall_AllTimeMax(value, row) {
			for (let i = (row + 1); i < (a.length); i++) {

				var time_obj1 = document.getElementById("time" + i);
				var RTobj_1 = document.getElementById("runningTime" + i);
				var time_obj2 = document.getElementById("time" + (i - 1)); //改變的那個
				var RTobj_2 = document.getElementById("runningTime" + (i - 1));
				//	           	 console.log("hallID_1:"+a[row].sthb.hall.hallID);
				//	           	 console.log("hallID_2:"+a[i].sthb.hall.hallID);
				if (a[row].sthb.hall.hallID == a[i].sthb.hall.hallID) {
					time_obj1.childNodes[0].max = "00:00";
				}

			}
		}

		//處理時間左邊補0
		function paddingLeft(str, lenght) {
			str = str.toString();
			console.log("lenght" + str.lenght)
			console.log("lenght" + str)
			if (str.length >= lenght)
				return str;
			else
				return paddingLeft("0" + str, lenght);
		}
		//時間的加減
		function PlusTime(day, startTime, plusTime, diffType) {
			//             alert("in plus");
			var open_Time1 = new Date(day + " " + startTime);
			//             console.log("ssss" + open_Time1);
			open_Time1.setTime(open_Time1.setMinutes(open_Time1.getMinutes()
					+ (plusTime) * 1 + 10));
			//             console.log("ssss2" + open_Time1);
			//             console.log("ssss" + open_Time1.getDate());
			var type = "";
			switch (diffType) {
			case "time":
				if (open_Time1.getHours() < 10) {

				}
				type = paddingLeft(open_Time1.getHours(), 2) + ":"
						+ paddingLeft(open_Time1.getMinutes(), 2);
				break;
			case "date":
				type = open_Time1.getFullYear() + "-"
						+ paddingLeft(open_Time1.getMonth() + 1, 2) + "-"
						+ paddingLeft(open_Time1.getDate(), 2);
				break;

			}
			return type;
		}

		function formSubmit() {
			var updateData = [];

			for (let i = 0; i < a.length; i++) {
				console.log(i);
				var showTimeId = document.getElementById("showTimeId" + i).innerHTML;
				var runID = document.getElementById("runID" + i).innerHTML;
				var hallID = document.getElementById("hallID" + i).innerHTML;
				var strDay = document.getElementById("strDay" + i).innerHTML;
				var time = document.getElementById("time" + i).childNodes[0].value;
				var playStartTime = strDay + " " + time;
				//                 console.log("確認show: " + showTimeId);
				//                 console.log("確認run: " + runID);
				//                 console.log("確認hall: " + hallID);
				//                 console.log("確認day: " + strDay);
				//                 console.log("確認時間: " + time);
				//                 console.log("確認時間: " + playStartTime);
				//                 console.log("確認時間: "+strDay);

				var update = {
					"showTimeId" : showTimeId,
					"playStartTime" : playStartTime,
					"hallID" : hallID,
					"runID" : runID,
				};
				//updateData[i] = update;
				updateData.push(update);
			}
			//                       var updateShowTime=JSON.stringify(updateData);
			//             console.log(JSON.stringify(updateData));
			//                       $("#table_tr").append("<input id='final' name='sth' type='hidden' value='"+updateShowTime+"'/> ");
			//                  document.getElementById("final").value = JSON.stringify(updateData);
			//                  console.log("final"+document.getElementById("final").value);
			//                  document.getElementById("myform").submit();

			$.ajax({
				url : "${pageContext.request.contextPath}/update/check",
				data : {
					"updateShowTime" : JSON.stringify(updateData)
				},
				type : "POST",
				//cache:false,
				//dataType: 'json',
				error : function(data) {
					//                 	console.log(data);
					//                     console.log(JSON.stringify(updateData));
				},
				success : function(data) {
					alert("修改成功");
					//                     window.location.href = "${pageContext.request.contextPath}/index-a";
				},
			});

		}

		$(document).ready(function() {
			$("#table").dataTable({
				paging : false
			});
		});
	</script>


	<!-- put Javascript  here-->
</body>

</html>