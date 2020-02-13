<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<!-- title -->
<title>Cineshow</title>
<!-- google fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,900'
	rel='stylesheet' type='text/css'>
<!-- stylesheets -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/flexslider.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/style.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/responsive.css'
	type='text/css' />
<style>
.alls {
	text-align: center;
	font-size: 20px;
	
}

.all {
	width: 50%;
	display: inline-block;
	text-align: center;
	margin-top: 100px;
	margin-bottom: 100px;
}
.depiction{
	margin-bottom: 40px;
	    font-size: 30px;
}
.name {
	display: inline-block;
	width: 35%;
	text-align: left;
	vertical-align: top;
}

.value {
	display: inline-block;
	width: 55%;
	text-align: right;
}

.next {
	font-size: 20px;
	width: 50%;
	display: inline-block;
	position: relative;
	margin-top: 30px;
}

.next input {
	background: #7fa8cc;
	border: 0;
	padding: 5px 60px;
	border-radius: 10px;
	color: white;
	font-weight: bold;
	letter-spacing: 7px}
#count{
font-weight: bold;
}
#countvalue{
font-weight: bold;
}
#way{
font-weight: bold;
}
#wayvalue{
font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>

	</header>
	<section class="ticket-outer banner-featured">
		<div class="container">
			<div class="ticket-sell">
				<h3 class="font">付款成功</h3>
			</div>
		</div>
	</section>
	<div class="alls">
		<div class="all">
			<div class="depiction">您已交易成功，以下為交易資訊</div>
			<div class="detail">
				<div class="name">項目</div>
				<div class="value">
					<div class="list">
						<p id="discount" style="display: none">0</p>
						<p id="discount2" style="display: none">0</p>
						<p id="bankticket" style="display: none">0</p>
						<p id="normal" style="display: none">0</p>
						<p id="hotdog" style="display: none">0</p>
						<p id="churro" style="display: none">0</p>
						<p id="friedChicken" style="display: none">0</p>
						<p id="bigCoke" style="display: none">0</p>
						<p id="normalCoke" style="display: none">0</p>
						<p id="smallCoke" style="display: none">0</p>
						<p id="bigPopcorn" style="display: none">0</p>
						<p id="normalPopcorn" style="display: none">0</p>
						<p id="smallPopcorn" style="display: none">0</p>
					</div>
				</div>
				<div class="name" id="count">金額</div>
				<div class="value" id="countvalue"><p id="totalPrice">0</p></div>
				<div class="name" id="way">付款方式</div>
				<div class="value" id="wayvalue">線上信用卡</div>

				<div class="next">
					<input type="button" value="回首頁"
						
						onclick="location.href='${pageContext.request.contextPath}/movieIndex';eraseCookie(name)"
						
						>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="../a/footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>

	<!-- footer -->
	<script>
		
	function createCookie(name, value, days, path) {
		  if (days) {
		    var date = new Date();
		    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
		    var expires = "; expires=" + date.toGMTString();
		  }
		  else var expires = "";
		  document.cookie = name + "=" + value + expires + "; path=/";
		}
		
		//刪除
		function eraseCookie(name) {
		   createCookie("discount", "", -1,"/");
		   createCookie("discount2", "", -1,"/");
		   createCookie("bankticket", "", -1,"/");
		   createCookie("normal", "", -1,"/");
		   createCookie("hotdog", "", -1,"/");
		   createCookie("churro", "", -1,"/");
		   createCookie("friedChicken", "", -1,"/");
		   createCookie("bigCoke", "", -1,"/");
		   createCookie("normalCoke", "", -1,"/");
		   createCookie("smallCoke", "", -1,"/");
		   createCookie("bigPopcorn", "", -1,"/");
		   createCookie("normalPopcorn", "", -1,"/");
		   createCookie("smallPopcorn", "", -1,"/");
		   createCookie("showtimeId", "", -1,"/");
		  	   
		}
		
// 		function clearAllCookie() {
// 			var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
// 			if (keys) {
// 				for (var i = keys.length; i--;)
// 					document.cookie = keys[i] + '=0;expires='
// 							+ new Date(0).toUTCString();
// 			}
// 		}
		
		function getCookie(cname) {
			var name = cname + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i].trim();
				if (c.indexOf(name) == 0)
					return c.substring(name.length, c.length);
			}
			return "";
		}
	
		if (getCookie("discount") > 0) {
			document.getElementById("discount").innerHTML = "優惠票個人套票X"+getCookie("discount");
			document.getElementById("discount").style.display = "";
			}
		
		if (getCookie("discount2") > 0) {
			document.getElementById("discount2").innerHTML = "優惠票雙人套票X"+getCookie("discount2");
			document.getElementById("discount2").style.display = "";
			}
		
		if (getCookie("bankticket") > 0) {
			document.getElementById("bankticket").innerHTML = "銀行優惠票X"+getCookie("bankticket");
			document.getElementById("bankticket").style.display = "";
			}
		
		if (getCookie("normal") > 0) {
			document.getElementById("normal").innerHTML = "普通票X"+getCookie("normal");
			document.getElementById("normal").style.display = "";
			}
			
		if (getCookie("hotdog") > 0) {
			document.getElementById("hotdog").innerHTML = "熱狗X"+getCookie("hotdog");
			document.getElementById("hotdog").style.display = "";
			}
		
		if (getCookie("churro") > 0) {
			document.getElementById("churro").innerHTML = "吉拿棒X"+getCookie("churro");
			document.getElementById("churro").style.display = "";}
		
		if (getCookie("friedChicken") > 0) {
			document.getElementById("friedChicken").innerHTML = "炸雞+薯條X"+getCookie("friedChicken");
			document.getElementById("friedChicken").style.display = "";}
		
		if (getCookie("bigCoke") > 0) {
			document.getElementById("bigCoke").innerHTML = "大可樂X"+getCookie("bigCoke");
			document.getElementById("bigCoke").style.display = "";}

		if (getCookie("normalCoke") > 0) {
			document.getElementById("normalCoke").innerHTML = "中可樂X"+getCookie("normalCoke");
			document.getElementById("normalCoke").style.display = "";}
		
		if (getCookie("smallCoke") > 0) {
			document.getElementById("smallCoke").innerHTML = "小可樂X"+getCookie("smallCoke");
			document.getElementById("smallCoke").style.display = "";}
		
		if (getCookie("bigPopcorn") > 0) {
			document.getElementById("bigPopcorn").innerHTML = "大爆米花X"+getCookie("bigPopcorn");
			document.getElementById("bigPopcorn").style.display = "";}
			
		if (getCookie("normalPopcorn") > 0) {
			document.getElementById("normalPopcorn").innerHTML = "中爆米花X"+getCookie("normalPopcorn");
			document.getElementById("normalPopcorn").style.display = "";}
		
		if (getCookie("smallPopcorn") > 0) {
			document.getElementById("smallPopcorn").innerHTML = "小爆米花X"+getCookie("smallPopcorn");
			document.getElementById("smallPopcorn").style.display = "";}
		
		document.getElementById("totalPrice").innerHTML =370*getCookie("discount")
														+700*getCookie("discount2")
														+220*getCookie("bankticket")
														+290*getCookie("normal")
														+108*getCookie("hotdog")
														+90*getCookie("churro")
														+180*getCookie("friedChicken")
														+63*getCookie("bigCoke")
														+54*getCookie("normalCoke")
														+49*getCookie("smallCoke")
														+126*getCookie("bigPopcorn")
														+117*getCookie("normalPopcorn")
														+108*getCookie("smallPopcorn")+"元";
		
		
		
		
		
		
		
		
		
		
	</script>
</body>
</html>