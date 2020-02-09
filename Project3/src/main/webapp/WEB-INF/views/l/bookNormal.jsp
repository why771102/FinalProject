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

table {
	width: 100%;
	display: inline-block;
}
.all{
text-align:center;

}

.test {
	font-size: 40px;
	width: 60%;
	display: inline-block;
	text-align: center;
	padding-top: 15px;
}

.ticket-img {
	width: 30%;
	display: inline-block;
}

.ticket-name {
	font-size: 20px;
	width: 30%;
	display: inline-block;
	vertical-align: top;
	text-align: left;
}

.ticket-price {
	font-size: 20px;
	width: 10%;
	display: inline-block;
	vertical-align: top;
	
}

.ticket-qty {
	font-size: 20px;
	width: 10%;
	display: inline-block;
	vertical-align: top;
}

.ticket-count {
	font-size: 20px;
	width: 15%;
	display: inline-block;
	vertical-align: top;
}

.foods {
	font-size: 20px;
	width: 10%;
	display: inline-block;
}

.foodsss {
	text-align: left;
}

.F-content {
	width: 30%;
	display: inline-block;
	BORDER: 1PX SOLID #e4e4e3;
}

}
.F-imgs {
	width: 100%;
}

.F-imgs img {
	width: 180px;
    height: 180px;
}

.F-name {
	font-size: 19px;
	text-align: left;
}
.F-price1 {
	text-decoration:line-through;
	font-size: 17px;
	text-align: left;
	width: 20%;
	display: inline-block;
}

.F-price {
	font-size: 17px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: red;
    font-weight: bold;
}

.F-qty {
	font-size: 17px;
	display: inline-block;
	width: 17%;
}

.D-content {
	width: 30%;
	display: inline-block;
	BORDER: 1PX SOLID #e4e4e3;
}

}
.D-imgs {
	width: 100%;
}

.D-imgs img {
	width: 180px;
    height: 180px;
}

.D-name {
	font-size: 19px;
	text-align: left;
}
.D-price1 {
	text-decoration:line-through;
	font-size: 17px;
	text-align: left;
	width: 20%;
	display: inline-block;
}

.D-price {
	font-size: 17px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: red;
    font-weight: bold;
}

.D-qty {
	font-size: 17px;
	display: inline-block;
	width: 17%;
}

.P-content {
	width: 30%;
	display: inline-block;
	BORDER: 1PX SOLID #e4e4e3;
}

}
.P-imgs {
	width: 100%;
}

.P-imgs img {
	width: 180px;
    height: 180px;
}

.P-name {
	font-size: 19px;
	text-align: left;
}

.P-price1 {
	text-decoration:line-through;
	font-size: 17px;
	text-align: left;
	width: 20%;
	display: inline-block;
}
.P-price {
	font-size: 17px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: red;
    font-weight: bold;
	
}

.P-qty {
	font-size: 17px;
	display: inline-block;
	width: 17%;
}

.list {
	font-size: 20px;
	width: 16%;
	display: inline-block;
	position: fixed;
	top: 215px;
	right: 1px;
	text-align: left;
	background: #337ab7;
    padding: 50px;
    color: white;
    font-weight: bold;
    border-radius: 20px;
}

.next {
	font-size: 20px;
	width: 16%;
	display: inline-block;
	position: relative;
	bottom: 50px;
	float: right;
	right: 50px;
}

.next input {
	background: #7fa8cc;
	border: 0;
	padding: 5px 60px;
	border-radius: 10px;
	color: white;
	font-weight: bold;
	letter-spacing: 7px
}

#Food {
	width: 65%;
	text-align: center;
	padding-bottom: 15px;
}

#drink {
	width: 65%;
	text-align: center;
}

#popcorn {
	width: 65%;
	text-align: center;
}

.activeme {
	display: none;
	margin: 0;
}

.active {
	display: inline-block;
	margin: 0;
}

.products-area {
	width: 100%;
	display: inline-block;
	text-align: center
}

/* 	.ticket-img{ */
/* 	background-image: url("img/feature10.jpg"); */
/* 	background-position: center; */
/* 	background-size: 100%; */
/* 	background-repeat: no-repeat; */
/* 	height: 1 */

/* 	} */
</style>
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
				<h3 class="font">選擇電影票及餐飲</h3>
			</div>
		</div>
	</section>
	<div class="all" >
		<div id="ticket" class="test">
			<div>
				<div class="ticket-img"></div>
				<div class="ticket-name">票種</div>
				<div class="ticket-price">價格</div>
				<div class="ticket-qty">數量</div>
				<div class="ticket-count">小計</div>
			</div>
			<hr>
			<div>

				<div class="ticket-img">
					<img src="img/discountTicket.png">
				</div>
				<div class="ticket-name">
					優惠個人套票<br>內容：1張電影票+1份中杯爆米花+1杯中杯可樂
				</div>
				<div class="ticket-price">350</div>
				<div class="ticket-qty">
					<select id="discount" name="discount"
						onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
						class='form:input-large'>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div id="discountTPrice" class="ticket-count">0</div>
			</div>
			<hr>

			<div>
				<div class="ticket-img">
					<img src="img/discountTicket2.png">
				</div>
				<div class="ticket-name">
					優惠雙人套票<br>內容：2張電影票+2份中杯爆米花+2杯中杯可樂
				</div>
				<div class="ticket-price">660</div>
				<div class="ticket-qty">
					<select id="discount2" name="discount2"
						onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
						class='form:input-large'>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div id="discount2TPrice" class="ticket-count">0</div>
			</div>
			<hr>

			<div>
				<div class="ticket-img">
					<img src="img/discountTicket.png">
				</div>
				<div class="ticket-name">
					銀行優惠票<br>凡持此銀行信用卡即可享有此優惠
				</div>
				<div class="ticket-price">200</div>
				<div class="ticket-qty">
					<select id="bankticket" name="bankticket"
						onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
						class='form:input-large'>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div id="bankticketTPrice" class="ticket-count">0</div>
			</div>
			<hr>

			<div>
				<div class="ticket-img">
					<img src="img/discountTicket.png">
				</div>
				<div class="ticket-name">一般票</div>
				<div class="ticket-price">270</div>
				<div class="ticket-qty">
					<select id="normal" name="normal"
						onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
						class='form:input-large'>
						<option value="0">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div id="normalTPrice" class="ticket-count">0</div>
			</div>
		</div>
		<hr>
		<div class="test">選擇餐飲</div>
		<div class="test foodsss">
			<div class="foods" id="foodCat">熟食類</div>
			<div class="foods" id="drinkCat">飲料類</div>
			<div class="foods" id="popcornCat">爆米花</div>
		</div>
		<div class="products-area">
			<div class="activeme active" id="Food">
				<div class="F-content">
					<div class="F-imgs">
						<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/hotdog.png">
					</div>
					<div class="F-name">熱狗</div>
					<div>
						<div class="F-price1">$120</div>$<div class="F-price">120</div>
						<div class="F-qty">
							<select id="hotdog" name="hotdog"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div id="hotdogTPrice" style="display: none;">0</div>
					</div>
				</div>

				<div class="F-content">
					<div class="F-imgs">
							<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/churro.png">
					</div>
					<div class="F-name">吉拿棒</div>
					<div>
						<div class="F-price1">$100</div>$<div class="F-price">100</div>
						<div class="F-qty">
							<select id="churro" name="churro"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div id="churroTPrice" style="display: none;">0</div>
					</div>
				</div>

				<div class="F-content">
					<div class="F-imgs">
							<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/flied.png">
					</div>
					<div class="F-name">炸雞+薯條</div>
					<div>
						<div class="F-price1">$200</div>$<div class="F-price">200</div>
						<div class="F-qty">
							<select id="friedChicken" name="friedChicken"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div id="friedChickenTPrice" style="display: none;">0</div>
					</div>
				</div>
			</div>

			<div class="activeme" id="drink">
				<div class="D-content">
					<div class="D-imgs">
								<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/coke.png">
					</div>
					<div class="D-name">大可樂</div>
					<div class="D-price1">$70</div>$<div class="D-price">70</div>
					<div class="D-qty">
						<select id="bigCoke" name="bigCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="bigCokeTPrice" style="display: none;">0</div>
				</div>

				<div class="D-content">
					<div class="D-imgs">
							<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/coke.png">
					</div>
					<div class="D-name">中可樂</div>
					<div class="D-price1">$60</div>$<div class="D-price">60</div>
					<div class="D-qty">
						<select id="normalCoke" name="normalCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="normalCokeTPrice" style="display: none;">0</div>
				</div>

				<div class="D-content">
					<div class="D-imgs">
								<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/coke.png">
					</div>
					<div class="D-name">小可樂</div>
					<div class="D-price1">$54</div>$<div class="D-price">54</div>
					<div class="D-qty">
						<select id="smallCoke" name="smallCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="smallCokeTPrice" style="display: none;">0</div>
				</div>
			</div>

			<div class="activeme" id="popcorn">
				<div class="P-content">
					<div class="P-imgs">
							<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/popcorn.png">
					</div>
					<div class="P-name">大爆米花</div>
				<div class="P-price1">$140</div>$<div class="P-price">140</div>
					<div class="P-qty">
						<select id="bigPopcorn" name="bigPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="bigPopcornTPrice" style="display: none;">0</div>
				</div>

				<div class="P-content">
					<div class="P-imgs">
							<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/popcorn.png">
					</div>
					<div class="P-name">中爆米花</div>
				<div class="P-price1">$130</div>$<div class="P-price">130</div>
					<div class="P-qty">
						<select id="normalPopcorn" name="normalPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="normalPopcornTPrice" style="display: none;">0</div>
				</div>

				<div class="P-content">
					<div class="P-imgs">
						<div style="padding: 5px 10px;display: inline-block;background:red;position: relative;color:#09afdf;border: 1px solid #09afdf;background-color: white;right: 5px;top: 5px">10%OFF</div>
						<img src="img/popcorn.png">
					</div>
					<div class="P-name">小爆米花</div>
					<div class="P-price1">$120</div>$<div class="P-price">120</div>
					<div class="P-qty">
						<select id="smallPopcorn" name="smallPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large'>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="smallPopcornTPrice" style="display: none;">0</div>
				</div>
			</div>
		</div>


		<div class="next">
			<input type="button" value="下頁"
				onclick="location.href='reservedSeats/showSeats'">
		</div>
		<div class="list">
			購物清單
			<p id="discountPrice" style="display: none">0</p>
			<p id="discount2Price" style="display: none">0</p>
			<p id="bankticketPrice" style="display: none">0</p>
			<p id="normalPrice" style="display: none">0</p>
			<p id="hotdogPrice" style="display: none">0</p>
			<p id="churroPrice" style="display: none">0</p>
			<p id="friedChickenPrice" style="display: none">0</p>
			<p id="bigCokePrice" style="display: none">0</p>
			<p id="normalCokePrice" style="display: none">0</p>
			<p id="smallCokePrice" style="display: none">0</p>
			<p id="bigPopcornPrice" style="display: none">0</p>
			<p id="normalPopcornPrice" style="display: none">0</p>
			<p id="smallPopcornPrice" style="display: none">0</p>
			合計
			<p id="totalPrice">0</p>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="../a/footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>

	<!-- footer -->
	<script>
		$("#foodCat").click(function() {
			$(".activeme").removeClass("active");
			$("#Food").addClass("active");
		});
		$("#drinkCat").click(function() {
			$(".activeme").removeClass("active");
			$("#drink").addClass("active");

		});
		$("#popcornCat").click(function() {
			$(".activeme").removeClass("active");
			$("#popcorn").addClass("active");

		});

		var expDays = 7;
		function setCookie(name, value) {
			var exp = new Date();
			var cookieTimeToLive = exp.getTime()
					+ (expDays * 24 * 60 * 60 * 1000)
			exp.setTime(cookieTimeToLive)
			document.cookie = name + "=" + escape(value) + "; expires="
					+ exp.toGMTString()
		}

		function setCountPrice(name, value) {
			var price;
			if (name === "discount") {
				price = value * 350
				document.getElementById("discountPrice").innerHTML = "優惠個人套票X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("discountTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("discountPrice").style.display = "none";
				} else {
					document.getElementById("discountPrice").style.display = "";
				}
			}

			if (name === "discount2") {
				price = value * 660
				document.getElementById("discount2Price").innerHTML = "優惠雙人套票X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("discount2TPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("discount2Price").style.display = "none";
				} else {
					document.getElementById("discount2Price").style.display = "";
				}
			}
			if (name === "bankticket") {
				price = value * 200
				document.getElementById("bankticketPrice").innerHTML = "銀行優惠票X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("bankticketTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("bankticketPrice").style.display = "none";
				} else {
					document.getElementById("bankticketPrice").style.display = "";
				}
			}
			if (name === "normal") {
				price = value * 270
				document.getElementById("normalPrice").innerHTML = "一般票X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("normalTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("normalPrice").style.display = "none";
				} else {
					document.getElementById("normalPrice").style.display = "";
				}
			}
			if (name === "hotdog") {
				price = value * 120
				document.getElementById("hotdogPrice").innerHTML = "熱食類熱狗X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("hotdogTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("hotdogPrice").style.display = "none";
				} else {
					document.getElementById("hotdogPrice").style.display = "";
				}
			}
			if (name === "churro") {
				price = value * 100
				document.getElementById("churroPrice").innerHTML = "熱食類吉拿棒X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("churroTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("churroPrice").style.display = "none";
				} else {
					document.getElementById("churroPrice").style.display = "";
				}
			}
			if (name === "friedChicken") {
				price = value * 200
				document.getElementById("friedChickenPrice").innerHTML = "熱食類炸雞+薯條X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("friedChickenTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("friedChickenPrice").style.display = "none";
				} else {
					document.getElementById("friedChickenPrice").style.display = "";
				}

			}
			if (name === "bigCoke") {
				price = value * 70
				document.getElementById("bigCokePrice").innerHTML = "飲料類大可樂X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("bigCokeTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("bigCokePrice").style.display = "none";
				} else {
					document.getElementById("bigCokePrice").style.display = "";
				}
			}
			if (name === "normalCoke") {
				price = value * 60
				document.getElementById("normalCokePrice").innerHTML = "飲料類中可樂X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("normalCokeTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("normalCokePrice").style.display = "none";
				} else {
					document.getElementById("normalCokePrice").style.display = "";
				}
			}
			if (name === "smallCoke") {
				price = value * 54
				document.getElementById("smallCokePrice").innerHTML = "飲料類小可樂X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("smallCokeTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("smallCokePrice").style.display = "none";
				} else {
					document.getElementById("smallCokePrice").style.display = "";
				}
			}
			if (name === "bigPopcorn") {
				price = value * 140
				document.getElementById("bigPopcornPrice").innerHTML = "爆米花類大爆米花X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("bigPopcornTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("bigPopcornPrice").style.display = "none";
				} else {
					document.getElementById("bigPopcornPrice").style.display = "";
				}
			}
			if (name === "normalPopcorn") {
				price = value * 130
				document.getElementById("normalPopcornPrice").innerHTML = "爆米花類中爆米花X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("normalPopcornTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("normalPopcornPrice").style.display = "none";
				} else {
					document.getElementById("normalPopcornPrice").style.display = "";
				}
			}
			if (name === "smallPopcorn") {
				price = value * 120
				document.getElementById("smallPopcornPrice").innerHTML = "爆米花類小爆米花X"
						+ parseInt(value) + "=" + parseInt(price);
				document.getElementById("smallPopcornTPrice").innerHTML = parseInt(price);
				if (value == 0) {
					document.getElementById("smallPopcornPrice").style.display = "none";
				} else {
					document.getElementById("smallPopcornPrice").style.display = "";
				}
			}
			var totalPrice;
			totalPrice = parseInt(document.getElementById("discountTPrice").innerHTML)
					+ parseInt(document.getElementById("discount2TPrice").innerHTML)
					+ parseInt(document.getElementById("bankticketTPrice").innerHTML)
					+ parseInt(document.getElementById("normalTPrice").innerHTML)
					+ parseInt(document.getElementById("hotdogTPrice").innerHTML)
					+ parseInt(document.getElementById("churroTPrice").innerHTML)
					+ parseInt(document.getElementById("friedChickenTPrice").innerHTML)
					+ parseInt(document.getElementById("bigCokeTPrice").innerHTML)
					+ parseInt(document.getElementById("normalCokeTPrice").innerHTML)
					+ parseInt(document.getElementById("smallCokeTPrice").innerHTML)
					+ parseInt(document.getElementById("bigPopcornTPrice").innerHTML)
					+ parseInt(document.getElementById("normalPopcornTPrice").innerHTML)
					+ parseInt(document.getElementById("smallPopcornTPrice").innerHTML)
			document.getElementById("totalPrice").innerHTML = parseInt(totalPrice);
		}
	</script>
</body>
</html>