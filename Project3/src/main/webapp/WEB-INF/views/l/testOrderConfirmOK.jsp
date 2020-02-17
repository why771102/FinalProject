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
						<c:forEach items="${disountTicket}" var="product">
							<p id="${product.productID}" style="display: none">${product.productName}</p>
							<p id="price${product.productID}" style="display: none">${product.unitPrice*2}</p>
						</c:forEach>
						<c:forEach items="${ticket}" var="product">
							<p id="${product.productID}" style="display: none">${product.productName}</p>
							<p id="price${product.productID}" style="display: none">${product.unitPrice}</p>
						</c:forEach>
						<c:forEach items="${food}" var="product">
							<p id="${product.productID}" style="display: none">${product.productName}</p>
							<p id="price${product.productID}" style="display: none">${product.unitPrice}</p>
						</c:forEach>
						<c:forEach items="${drink}" var="product">
							<p id="${product.productID}" style="display: none">${product.productName}</p>
							<p id="price${product.productID}" style="display: none">${product.unitPrice}</p>
						</c:forEach>
						<c:forEach items="${popcorn}" var="product">
							<p id="${product.productID}" style="display: none">${product.productName}</p>
							<p id="price${product.productID}" style="display: none">${product.unitPrice}</p>
						</c:forEach>
					</div>
				</div>
				<div class="name" id="count">手續費</div>
				<div class="value" id="Hand"><b id="Handling">0</b></div>
				<div class="name" id="count">金額</div>
				<div class="value" id="countvalue"><p id="totalPrice">0</p></div>
				<hr>
				<div class="name" id="count">總額</div>
				<div class="value" ><b id="countTotal">0</b></div>
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
		   createCookie("13", "", -1,"/");
		   createCookie("15", "", -1,"/");
		   createCookie("3", "", -1,"/");
		   createCookie("1", "", -1,"/");
		   createCookie("4", "", -1,"/");
		   createCookie("5", "", -1,"/");
		   createCookie("6", "", -1,"/");
		   createCookie("7", "", -1,"/");
		   createCookie("8", "", -1,"/");
		   createCookie("9", "", -1,"/");
		   createCookie("10", "", -1,"/");
		   createCookie("11", "", -1,"/");
		   createCookie("12", "", -1,"/");
		   createCookie("showtimeId", "", -1,"/");
		  	   
		}
		
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
		var total=0;
		
		document.getElementById("Handling").innerHTML=parseInt(getCookie("1")*20)+parseInt(getCookie("3")*20)
		+parseInt(getCookie("13")*20)+parseInt(getCookie("15")*40);
		
		for(var x=1;x<=20;x++){
			try{document.getElementById("price"+x).innerHTML;
			getCookie(x.toString());
			}catch(e){
				continue;}
			if (getCookie(x.toString()) > 0) {
				document.getElementById(x.toString()).style.display = "";
			}
			console.log(getCookie(x.toString()));
			sum=(document.getElementById("price"+x).innerHTML)*getCookie(x.toString());
			
			
			total=total+sum;
			document.getElementById("totalPrice").innerHTML=total;
		}
		document.getElementById("countTotal").innerHTML=parseInt(document.getElementById("totalPrice").innerHTML)+parseInt(document.getElementById("Handling").innerHTML)+"元"
		
		
		
		
		
		
		
		
		
		
		
	</script>
</body>
</html>