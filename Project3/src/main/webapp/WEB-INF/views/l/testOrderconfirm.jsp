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
.orders{
	text-align: left;
    padding-bottom: 15px;
    background-color: rgba(128, 128, 128, 0.34);
    width: 70%;
    margin-left: 17%;
    margin-bottom: 30px;
    padding-left: 80px;
    padding-right: 80px;
}
.movie{
    width: 100%;
 	display: inline-block;
  	padding-top: 15px;
}
.order{    
    padding-bottom: 15px;
	font-size: 23px;
    text-align: -webkit-match-parent;
}

.moviename{
font-weight: 500;
font-size: 30px;
text-align: left;
display: inline-block;
width: 79%;
}
.movieinfo{
text-align: right;
display: inline-block;
width: 19%;
}


.name {
	display: inline-block;
	width: 45%;
	padding-left: 40px;
}

.price {
	text-align: right;
	display: inline-block;
	width: 21%;

}

.qty {
	display: inline-block;
	text-align: right;
	width: 12%;

}
.ordercontent{
background-color: #eaeaea;
color: black;
}
.count {
	
	display: inline-block;
	text-align: right;
	width: 15%;
}
#handling{
font-weight:bold;
}
#totalPrice{
font-weight:bold;
}
#totalPrice1{
font-weight:bold;
}
.nextadjust{
text-align: center;
}
.next {
	font-size: 20px;
	width: 16%;
	display: inline-block;
/* 	position: relative; */
	bottom: 50px;
/* 	float: right; */
	right: 50px;
}

.next input {
	background: #7fa8cc;
	border: 0;
	padding: 25px 60px;
	border-radius: 20px;
	color: white;
	font-weight: bold;
	letter-spacing: 7px;
    font-size: larger;
}
.width80{
width: 80%;
}
.width20{
width: 19%;
}

</style>
<body>
	<header>
		<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>

	</header>
	<section class="ticket-outer banner-featured" style="background:black;">
		<div class="container">
			<div class="ticket-sell" style="padding-top: 76px;">
				<h3 class="font">確認訂單</h3>
			</div>
		</div>
	</section>
<div class="orders" >
	<div class="movies">
		<div class="movie">
			<div class="moviename">電影名稱:${movie}</div>
			<div class="movieinfo">
				<div class="movietime" style="font-size: 16px;">${playtime}</div>
				<div class="moviehall" style="font-size: 18px;">${hallID}廳</div>
				<div class="movieseat" style="font-size: 18px;">電影座位:${seats}</div>
			</div>
		</div>
	</div>


	<div class="order">
		<div class="ordercontent">
			<div class="name">商品</div>
			<div class="price">價格</div>
			<div class="qty">數量</div>
			<div class="count">合計</div>
		</div>
	
		<c:forEach items="${disountTicket}" var="product">
		<div class="discountcontent" id="hide${product.productID}">
			<div class="name"><p id="${product.productID}">${product.productName}</p></div>
			<div class="price"><p id="price${product.productID}">${product.unitPrice*2}</p></div>
			<div class="qty"><p id="qty${product.productID}">0</p></div>
			<div class="count"><p id="count${product.productID}">0</p></div>
		</div>
		</c:forEach>
		<c:forEach items="${ticket}" var="product">
		<div class="discountcontent" id="hide${product.productID}">
			<div class="name"><p id="${product.productID}">${product.productName}</p></div>
			<div class="price"><p id="price${product.productID}">${product.unitPrice}</p></div>
			<div class="qty"><p id="qty${product.productID}">0</p></div>
			<div class="count"><p id="count${product.productID}">0</p></div>
		</div>
		</c:forEach>
		<c:forEach items="${food}" var="product">
		<div class="discountcontent" id="hide${product.productID}">
			<div class="name"><p id="${product.productID}">${product.productName}</p></div>
			<div class="price"><p id="price${product.productID}">${product.unitPrice}</p></div>
			<div class="qty"><p id="qty${product.productID}">0</p></div>
			<div class="count"><p id="count${product.productID}">0</p></div>
		</div>
		</c:forEach>
		<c:forEach items="${drink}" var="product">
		<div class="discountcontent" id="hide${product.productID}">
			<div class="name"><p id="${product.productID}">${product.productName}</p></div>
			<div class="price"><p id="price${product.productID}">${product.unitPrice}</p></div>
			<div class="qty"><p id="qty${product.productID}">0</p></div>
			<div class="count"><p id="count${product.productID}">0</p></div>
		</div>
		</c:forEach>
		<c:forEach items="${popcorn}" var="product">
		<div class="discountcontent" id="hide${product.productID}">
			<div class="name"><p id="${product.productID}">${product.productName}</p></div>
			<div class="price"><p id="price${product.productID}">${product.unitPrice}</p></div>
			<div class="qty"><p id="qty${product.productID}">0</p></div>
			<div class="count"><p id="count${product.productID}">0</p></div>
		</div>
		</c:forEach>
		
		<div>
			<div class="name" id="handling">訂票手續費</div>
			<div class="price"></div>
			<div class="qty"></div>
			<div class="count"><p id="Handling" ></p></div>
		</div>
	
		<div>
			<div class="name" id="totalprice">總額</div>
			<div class="price"></div>
			<div class="qty"></div>
			<div class="count"><p id="totalPrice"></p></div>
		</div>
		
		<div class="width80">
			<div class="nextadjust">
			<div class="next">
				<div>
				<form action="${pageContext.request.contextPath}/testOrderConfirmOK" method="post">
				<input type="hidden" id="totalPrice2" name="total" value="120" />
				<input type="submit" value="信用卡付款"> 
				</form>
				</div>
 			</div>
 				
<%--  				<form action="${pageContext.request.contextPath}/authorize_payment" method="post"> --%>
<!-- 				<input type="hidden" id="totalPrice2" name="total" value="120" />		 -->

<!-- 				<button  type="submit">信用卡付款</button> -->
<%-- 				</form> --%>
 		 	</div>
		</div>
		<div class="width20">
		</div>
	</div>
	
	</div>

	

</body>
	<!-- footer -->
	<jsp:include page="../a/footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>

	<!-- footer -->
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {
	if (typeof(Storage) !== "undefined") {
		  // Code for localStorage/sessionStorage.
		  sessionStorage.setItem("seats", "${seats}");
		} else {
	  	// Sorry! No Web Storage support..
		}
	});
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
	
	for(var x=0;x<=20;x++){
		try{
			document.getElementById("qty"+x).innerHTM;
			document.getElementById("count"+x).innerHTM;
		}catch(e){
			continue;
		}
		if(getCookie(x)>0){
		document.getElementById("qty"+x).innerHTML=getCookie(x);
		document.getElementById("hide"+x).style.display = "";
		}else{
			document.getElementById("hide"+x).style.display = "none";
		}
		
		document.getElementById("count"+x).innerHTML=document.getElementById("price"+x).innerHTML*getCookie(x);
		
	}
	
	document.getElementById("Handling").innerHTML=(parseInt(document.getElementById("qty13").innerHTML)+
	(parseInt(document.getElementById("qty15").innerHTML))*2+
	parseInt(document.getElementById("qty3").innerHTML)+
	parseInt(document.getElementById("qty1").innerHTML))*20;
		
	var sum=0;
	for(var x=0;x<=20;x++){
		try{
			document.getElementById("count"+x).innerHTML;
		}catch(e){
			continue;
		}
		var price=document.getElementById("count"+x).innerHTML;
		sum=sum+parseInt(price);
	}
	document.getElementById("totalPrice").innerHTML=sum+parseInt(document.getElementById("Handling").innerHTML)

</script>
</html>