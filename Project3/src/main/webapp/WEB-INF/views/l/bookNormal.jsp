<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Tickets</title>
</head>
<style>
table {
	width: 100%;
	display: inline-block;
}

.test {
	width: 65%;
	display: inline-block;
 	text-align: center;  
}

.ticket-img {
	width: 30%;
	display: inline-block;
}

.ticket-name {
	width: 30%;
	display: inline-block;
	vertical-align:top;
}

.ticket-price {
	width: 10%;
	display: inline-block;
	vertical-align:top;
}

.ticket-qty {
	width: 10%;
	display: inline-block;
	vertical-align:top;
}

.ticket-count {
	width: 15%;
	display: inline-block;
	vertical-align:top;
}

.foods {
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
	width: 100%;
}

.F-name {
	text-align: left;
}

.F-price {
	text-align: left;
	width: 80%;
	display: inline-block;
}

.F-qty {
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
	width: 100%;
}

.D-name {
	text-align: left;
}

.D-price {
	text-align: left;
	width: 80%;
	display: inline-block;
}

.D-qty {
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
	width: 100%;
}

.P-name {
	text-align: left;
}

.P-price {
	text-align: left;
	width: 80%;
	display: inline-block;
}

.P-qty {
	display: inline-block;
	width: 17%;
}
.list{
    width: 16%;
    display: inline-block;
    position: absolute;
    top: 50px;
    right: 50px;
}
#Food{
width: 65%;
	
 	text-align: center;  }
#drink{
width: 65%;
	
 	text-align: center;  }
#popcorn{
width: 65%;
	
 	text-align: center;  }
.active{
display: block;
}    
  .activeme{    
  display:none; }  
 
</style>
<body>
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h1>選擇電影票</h1>
			</div>
		</div>
	</section>
	<div style="text-align: center">
		<div id="ticket" class="test">
			<div>
				<div class="ticket-img">圖片</div>
				<div class="ticket-name">票種</div>
				<div class="ticket-price">價格</div>
				<div class="ticket-qty">數量</div>
				<div class="ticket-count">小計</div>
			</div>

			<div>
			
				<div class="ticket-img"><img src="img/feature10.jpg"></div>
				<div class="ticket-name">優惠個人套票</div>
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

			<div>
				<div class="ticket-img"><img src="img/feature1.jpg"></div>
				<div class="ticket-name">優惠雙人套票</div>
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

			<div>
				<div class="ticket-img"><img src="img/feature3.jpg"></div>
				<div class="ticket-name">銀行優惠票</div>
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

			<div>
				<div class="ticket-img"><img src="img/feature4.jpg"></div>
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
		<div class="test">選擇餐飲</div>
		<div class="test foodsss">
			<div class="foods" id="foodCat">熟食類</div>
			<div class="foods"id="drinkCat">飲料類</div>
			<div class="foods" id="popcornCat">爆米花</div>
		</div>
		<div class="activeme active" id="Food" >   
			<div class="F-content">
				<div class="F-imgs">
					<img src="img/feature10.jpg">
				</div>
				<!-- 				<div>價格</div> -->
				<!-- 				<div>數量</div> -->
				<!-- 				<div>小計</div> -->
				<div class="F-name">熱狗</div>
				<div>
					<div class="F-price">120</div>
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
					<!-- 				<div id="hotdogTPrice">0</div> -->
				</div>
			</div>

			<div class="F-content">
				<div class="F-imgs">
					<img src="img/feature9.jpg">
				</div>
				<div class="F-name">吉拿棒</div>
				<div>
					<div class="F-price">100</div>
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
				</div>
			</div>

			<div class="F-content">
				<div class="F-imgs">
					<img src="img/feature8.jpg">
				</div>
				<div class="F-name">炸雞+薯條</div>
				<div>
					<div class="F-price">200</div>
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
				</div>
			</div>
		</div>

		<div  class="activeme" id="drink">
			<div class="D-content">
				<div class="D-imgs">
					<img src="img/feature7.jpg">
				</div>
				<div class="D-name">大可樂</div>
				<div class="D-price">70</div>
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
			</div>

			<div class="D-content">
				<div class="D-imgs">
					<img src="img/feature6.jpg">
				</div>
				<div class="D-name">中可樂</div>
				<div class="D-price">60</div>
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
			</div>

			<div class="D-content">
				<div class="D-imgs">
					<img src="img/feature5.jpg">
				</div>
				<div class="D-name">小可樂</div>
				<div class="D-price">54</div>
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
			</div>
		</div>

		<div  class="activeme" id="popcorn">
			<div class="P-content">
				<div class="P-imgs">
					<img src="img/feature4.jpg">
				</div>
				<div class="P-name">大爆米花</div>
				<div class="P-price">140</div>
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
			</div>
			
				<div class="P-content">
					<div class="P-imgs">
						<img src="img/feature2.jpg">
					</div>
					<div class="P-name">中爆米花</div>
					<div class="P-price">130</div>
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
				</div>
			
					<div class="P-content">
						<div class="P-imgs">
							<img src="img/feature1.jpg">
						</div>
						<div class="P-name">小爆米花</div>
						<div class="P-price">120</div>
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
					</div>
				</div>
			
		
			<hr><a href="reservedSeats/showSeats">繼續</a>
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
		<script>
			$("#foodCat").click(function(){
				$(".activeme").removeClass("active");
				$("#Food").addClass("active");  
			});
			$("#drinkCat").click(function(){
				$(".activeme").removeClass("active");
				$("#drink").addClass("active");

			});  
			$("#popcornCat").click(function(){
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
						+ parseInt(document
								.getElementById("friedChickenTPrice").innerHTML)
						+ parseInt(document.getElementById("bigCokeTPrice").innerHTML)
						+ parseInt(document.getElementById("normalCokeTPrice").innerHTML)
						+ parseInt(document.getElementById("smallCokeTPrice").innerHTML)
						+ parseInt(document.getElementById("bigPopcornTPrice").innerHTML)
						+ parseInt(document
								.getElementById("normalPopcornTPrice").innerHTML)
						+ parseInt(document
								.getElementById("smallPopcornTPrice").innerHTML)
				document.getElementById("totalPrice").innerHTML = parseInt(totalPrice);
			}
		</script>
</body>
</html>