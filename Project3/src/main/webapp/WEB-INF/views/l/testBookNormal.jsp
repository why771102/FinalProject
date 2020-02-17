<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

.all {
	text-align: center;
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
	cursor: pointer;
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
	text-decoration: line-through;
	font-size: 15px;
	text-align: left;
	width: 10%;
	display: inline-block;
	float: left;
}

.F-price2 {
	font-size: 20px;
	text-align: left;
	width: 3%;
	display: inline-block;
	float: left;
	color: #990000;
}

.F-price {
	font-size: 20px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: #990000;
	font-weight: bold;
	float: left;
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
	text-decoration: line-through;
	font-size: 15px;
	text-align: left;
	width: 8%;
	display: inline-block;
	float: left;
}

.D-price2 {
	font-size: 20px;
	text-align: left;
	width: 3%;
	display: inline-block;
	float: left;
	color: #990000;
}

.D-price {
	font-size: 20px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: #990000;
	font-weight: bold;
	float: left;
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
	text-decoration: line-through;
	font-size: 15px;
	text-align: left;
	width: 10%;
	display: inline-block;
	float: left;
}

.P-price2 {
	font-size: 20px;
	text-align: left;
	width: 3%;
	display: inline-block;
	float: left;
	color: #990000;
}

.P-price {
	font-size: 20px;
	text-align: left;
	width: 50%;
	display: inline-block;
	color: #990000;
	font-weight: bold;
	float: left;
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
	bottom: 86px;
	float: right;
	right: 50px;
	z-index: 1;
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
	padding-bottom: 50px;
}

#drink {
	width: 65%;
	text-align: center;
	padding-bottom: 50px;
}

#popcorn {
	width: 65%;
	text-align: center;
	padding-bottom: 50px;
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
	<div class="all">
		<div id="ticket" class="test">
			<div>
				<div class="ticket-img"></div>
				<div class="ticket-name">票種</div>
				<div class="ticket-price">價格</div>
				<div class="ticket-qty">數量</div>
				<div class="ticket-count">小計</div>
			</div>
			<hr>
			<c:forEach items="${disountTicket}" var="product">
				<div>
					<div class="ticket-img">
						<img src="img/discountTicket.png">
						<%-- 						<img src="<c:url value='/products/${product.productsBean.productID}' />"> --%>
					</div>
					<div class="ticket-name" >
						<div id="tname${product.productID}">${product.productName}</div>
						內容：${product.productDescription}
					</div>
					<div class="ticket-price" id="tprice${product.productID}" >${product.unitPrice*2}</div>
					<div class="ticket-qty">
						<select id="${product.productID}"
							name="${product.productID}"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex);Total()"
							class='form:input-large' >
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="ttotal${product.productID}" class="ticket-count">0</div>
				</div>
				<hr>
			</c:forEach>
			<c:forEach items="${ticket}" var="product">
				<div>
					<div class="ticket-img">
						<img src="img/discountTicket.png">
						<%-- 						<img src="<c:url value='/products/${product.productsBean.productID}' />"> --%>
					</div>
					<div class="ticket-name" >
						<div id="tname${product.productID}">${product.productName}</div>
						內容：${product.productDescription}
					</div>
					<div class="ticket-price" id="tprice${product.productID}" >${product.unitPrice}</div>
					<div class="ticket-qty">
						<select id="${product.productID}"
							name="${product.productID}"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex);Total()"
							class='form:input-large' >
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
					<div id="ttotal${product.productID}" class="ticket-count">0</div>
				</div>
				<hr>
			</c:forEach>
		</div>
		

		<div class="test">選擇餐飲</div>
		<div class="test foodsss">
			<div class="foods" id="foodCat">熟食類</div>
			<div class="foods" id="drinkCat">飲料類</div>
			<div class="foods" id="popcornCat">爆米花</div>
		</div>
		<div class="products-area">
			<div class="activeme active" id="Food">
				<c:forEach items="${food}" var="product">
					<div class="F-content">
						<div class="F-imgs">
							<div
								style="padding: 5px 10px; display: inline-block; background: red; position: relative; color: #09afdf; border: 1px solid #09afdf; background-color: white; right: 5px; top: 5px">10%OFF</div>
							<img src="img/hotdog.png">
						</div>
						<div class="F-name" id="tname${product.productID}">${product.productName}</div>
						<div class="F-price1">$${product.unitPrice}</div>
						<div class="F-price2">$</div>
						<div class="F-price" id="tprice${product.productID}"><fmt:formatNumber type="number" value="${product.unitPrice*(0.9)}" maxFractionDigits="0"/></div>
						<div class="F-qty">
							<select id="${product.productID}"
								name="${product.productID}"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex);Total()"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div id="ttotal${product.productID}" style="display: none;">0</div>
					</div>
				</c:forEach>

			</div>
			<div class="activeme" id="drink">

				<c:forEach items="${drink}" var="product">
					<div class="D-content">
						<div class="D-imgs">
							<div
								style="padding: 5px 10px; display: inline-block; background: red; position: relative; color: #09afdf; border: 1px solid #09afdf; background-color: white; right: 5px; top: 5px">10%OFF</div>
							<img src="img/coke.png">
						</div>
						<div class="D-name" id="tname${product.productID}">${product.productName}</div>
						<div class="D-price1">$${product.unitPrice}</div>
						<div class="D-price2">$</div>
						<div class="D-price" id="tprice${product.productID}"><fmt:formatNumber type="number" value="${product.unitPrice*(0.9)}" maxFractionDigits="0"/></div>
						<div class="D-qty">
							<select id="${product.productID}"
								name="${product.productID}"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex);Total()"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</div>
						<div id="ttotal${product.productID}" style="display: none;">0</div>
					</div>
				</c:forEach>
			</div>
			<div class="activeme" id="popcorn">
				<c:forEach items="${popcorn}" var="product">
					<div class="P-content">
						<div class="P-imgs">
							<div
								style="padding: 5px 10px; display: inline-block; background: red; position: relative; color: #09afdf; border: 1px solid #09afdf; background-color: white; right: 5px; top: 5px">10%OFF</div>
							<img src="img/popcorn.png">
						</div>
						<div class="P-name" id="tname${product.productID}">${product.productName}</div>
						<div class="P-price1">$${product.unitPrice}</div>
						<div class="P-price2">$</div>
						<div class="P-price" id="tprice${product.productID}"><fmt:formatNumber type="number" value="${product.unitPrice*(0.9)}" maxFractionDigits="0"/></div>
						<div class="P-qty">
							<select id="${product.productID}"
								name="${product.productID}"
								onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex);Total()"
								class='form:input-large'>
								<option value="0">0</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>	
								<option value="4">4</option>
							</select>
						</div>
						<div id="ttotal${product.productID}" style="display: none;">0</div>
					</div>
				</c:forEach>

			</div>
		</div>


		<div class="next">
			<input type="button" value="下頁"
					onclick="location.href='testOrderConfirm'"> 
<!-- 				onclick="location.href='reservedSeats/showSeats'"> -->
			 
			
		</div>
		<div class="list">
			購物清單
			<c:forEach items="${disountTicket}" var="product">
			<p id="nameDatail${product.productID}" style="display: none">0</p>
			</c:forEach>
			<c:forEach items="${ticket}" var="product">
			<p id="nameDatail${product.productID}" style="display: none">0</p>
			</c:forEach>
			<c:forEach items="${food}" var="product">
			<p id="nameDatail${product.productID}" style="display: none">0</p>
			</c:forEach>
			<c:forEach items="${drink}" var="product">
			<p id="nameDatail${product.productID}" style="display: none">0</p>
			</c:forEach>
			<c:forEach items="${popcorn}" var="product">
			<p id="nameDatail${product.productID}" style="display: none">0</p>
			</c:forEach>
			
			
			
			
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

		var expDays = 1;
		function setCookie(name, value, days, path) {
			var exp = new Date();
			var cookieTimeToLive = exp.getTime()
					+ (expDays * 24 * 60 * 60 * 1000)
			exp.setTime(cookieTimeToLive)

			var expires = "; expires=" + exp.toGMTString();

			document.cookie = name + "=" + escape(value) + expires + "; path=/";

		}
		
		function setCountPrice(name, value) {
										//value qty
			var tprice = $("#tprice" + name).text(); //price 
			var ttotal = value * tprice;
			$("#ttotal" + name).text(ttotal);
			
			var x = $("#tname" + name).html()+"X"+ value; 
			$("#nameDatail"+name).text(x);	
			if(value>0){
				$("#nameDatail"+name).text(x).css("display",""); 
				}else{
					$("#nameDatail"+name).text(x).css("display","none");
				}
			     
// 			 $(".list").append(" <p>" + $("#tname" + name).html() + "X"+ value +"</p>");
			
		}      
		
	
		  
		
		function Total(){
			var sum=0;
			
			for(var x=1;x<=20;x++){
				try{
					document.getElementById("ttotal"+x).innerHTML;
				}catch(e){
					continue;
				}
			
			var price=document.getElementById("ttotal"+x).innerHTML;
			sum=sum+parseInt(price);
			}
			$("#totalPrice").text(sum);	
		}
		
		
		
	</script>
</body>
</html>