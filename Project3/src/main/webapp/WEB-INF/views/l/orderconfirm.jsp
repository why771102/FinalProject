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
text-align: center;
padding-bottom: 15px;
}
.movie{
width: 45%;
 display: inline-block;
  padding-top: 15px;
}
.order{    
width: 45%;
 display: inline-block;
 text-align: left;
 padding-top: 15px;
 font-size: 20px;
}

.moviename{
font-weight:bold;
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
	
}

.price {
	text-align: right;
	display: inline-block;
	width: 20%;

}

.qty {
	display: inline-block;
	text-align: right;
	width: 10%;

}
.ordercontent{
background-color: #eaeaea;
}
.count {
	
	display: inline-block;
	text-align: right;
	width: 10%;
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
	<section class="ticket-outer banner-featured">
		<div class="container">
			<div class="ticket-sell">
				<h3 class="font">確認訂單</h3>
			</div>
		</div>
	</section>
<div class="orders" >
	<div class="movies">
		<div class="movie">
			<div class="moviename">電影名稱:${queryStartTime.run.movie.title}</div>
			<div class="movieinfo">
				<div class="movietime">${queryStartTime.playStartTime}</div>
				<div class="moviehall">電影廳:${queryStartTime.hall.hallID}</div>
				<div class="movieseat">電影座位:</div>
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
	
		<div class="discountcontent" id="hidediscount">
			<div class="name"><p id="discount"></p></div>
			<div class="price"><p id="discountprice"></p></div>
			<div class="qty"><p id="discountqty">0</p></div>
			<div class="count"><p id="discountcount">0</p></div>
		</div>
	
		<div class="discount2content" id="hidediscount2">
			<div class="name"><p id="discount2"></p></div>
			<div class="price"><p id="discount2price"></p></div>
			<div class="qty"><p id="discount2qty">0</p></div>
			<div class="count"><p id="discount2count">0</p></div>
		</div>

		<div class="bankticketcontent" id="hidebankticket">
			<div class="name"><p id="bankticket"></p></div>
			<div class="price"><p id="bankticketprice"></p></div>
			<div class="qty"><p id="bankticketqty">0</p></div>
			<div class="count"><p id="bankticketcount">0</p></div>
		</div>
	
		<div class="normalcontent" id="hidenormal">
			<div class="name"><p id="normal"></p></div>
			<div class="price"><p id="normalprice"></p></div>
			<div class="qty"><p id="normalqty">0</p></div>
			<div class="count"><p id="normalcount">0</p></div>
		</div>
	
		<div class="hotdogcontent" id="hidehotdog">
			<div class="name"><p id="hotdog"></p></div>
			<div class="price"><p id="hotdogprice"></p></div>
			<div class="qty"><p id="hotdogqty">0</p></div>
			<div class="count"><p id="hotdogcount">0</p></div>
		</div>
	
		<div class="churrocontent" id="hidechurro">
			<div class="name"><p id="churro"></p></div>
			<div class="price"><p id="churroprice"></p></div>
			<div class="qty"><p id="churroqty">0</p></div>
			<div class="count"><p id="churrocount">0</p></div>
		</div>

		<div class="friedChickencontent" id="hidefriedChicken">
			<div class="name"><p id="friedChicken"></p></div>
			<div class="price"><p id="friedChickenprice"></p></div>
			<div class="qty"><p id="friedChickenqty">0</p></div>
			<div class="count"><p id="friedChickencount">0</p></div>
		</div>

		<div class="bigCokecontent" id="hidebigCoke">
			<div class="name"><p id="bigCoke"></p></div>
			<div class="price"><p id="bigCokeprice"></p></div>
			<div class="qty"><p id="bigCokeqty">0</p></div>
			<div class="count"><p id="bigCokecount">0</p></div>
		</div>
	
		<div class="normalCokecontent" id="hidenormalCoke">
			<div class="name"><p id="normalCoke"></p></div>
			<div class="price"><p id="normalCokeprice"></p></div>
			<div class="qty"><p id="normalCokeqty">0</p></div>
			<div class="count"><p id="normalCokecount">0</p></div>
		</div>
	
		<div class="smallCokecontent" id="hidesmallCoke">
			<div class="name"><p id="smallCoke"></p></div>
			<div class="price"><p id="smallCokeprice"></p></div>
			<div class="qty"><p id="smallCokeqty">0</p></div>
			<div class="count"><p id="smallCokecount">0</p></div>
		</div>
	
		<div class="bigPopcorncontent" id="hidebigPopcorn">
			<div class="name"><p id="bigPopcorn"></p></div>
			<div class="price"><p id="bigPopcornprice"></p></div>
			<div class="qty"><p id="bigPopcornqty">0</p></div>
			<div class="count"><p id="bigPopcorncount" >0</p></div>
		</div>
	
		<div class="normalPopcorncontent" id="hidenormalPopcorn">
			<div class="name"><p id="normalPopcorn"></p></div>
			<div class="price"><p id="normalPopcornprice"></p></div>
			<div class="qty"><p id="normalPopcornqty">0</p></div>
			<div class="count"><p id="normalPopcorncount" >0</p></div>
		</div>

		<div class="smallPopcorncontent" id="hidesmallPopcorn">
			<div class="name"><p id="smallPopcorn"></p></div>
			<div class="price"><p id="smallPopcornprice"></p></div>
			<div class="qty"><p id="smallPopcornqty">0</p></div>
			<div class="count"><p id="smallPopcorncount" >0</p></div>
		</div>
	
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
				<input type="button" value="信用卡付款"
				onclick="location.href='orderconfirmOK'"> 
 			</div>
 		
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

<script>
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


	if(document.getElementById("discountqty").innerHTML==0){
		document.getElementById("hidediscount").style.display = "none";}
		
	
	if (getCookie("discount") > 0) {
		document.getElementById("discount").innerHTML = "優惠票個人套票";
		document.getElementById("discountprice").innerHTML =350	;
		document.getElementById("discountqty").innerHTML =getCookie("discount")	;
		document.getElementById("discountcount").innerHTML=document.getElementById("discountprice").innerHTML
							*document.getElementById("discountqty").innerHTML;
		document.getElementById("hidediscount").style.display = "";
	}
	
	if(document.getElementById("discount2qty").innerHTML==0){
		document.getElementById("hidediscount2").style.display = "none";}
	
	if (getCookie("discount2") > 0) {
		document.getElementById("discount2").innerHTML = "優惠票雙人套票";
		document.getElementById("discount2price").innerHTML =660	;
		document.getElementById("discount2qty").innerHTML =getCookie("discount2")	;
		document.getElementById("discount2count").innerHTML=document.getElementById("discount2price").innerHTML
							*document.getElementById("discount2qty").innerHTML;
		document.getElementById("hidediscount2").style.display = "";
	}
	
	if(document.getElementById("bankticketqty").innerHTML==0){
		document.getElementById("hidebankticket").style.display = "none";}
		
	if (getCookie("bankticket") > 0) {
		document.getElementById("bankticket").innerHTML = "銀行優惠票";
		document.getElementById("bankticketprice").innerHTML =200	;
		document.getElementById("bankticketqty").innerHTML =getCookie("bankticket")	;
		document.getElementById("bankticketcount").innerHTML=document.getElementById("bankticketprice").innerHTML
							*document.getElementById("bankticketqty").innerHTML;
		document.getElementById("hidebankticket").style.display = "";
	}
	
	if(document.getElementById("normalqty").innerHTML==0){
		document.getElementById("hidenormal").style.display = "none";}

	if (getCookie("normal") > 0) {
		document.getElementById("normal").innerHTML = "普通票";
		document.getElementById("normalprice").innerHTML =270	;
		document.getElementById("normalqty").innerHTML =getCookie("normal")	;
		document.getElementById("normalcount").innerHTML=document.getElementById("normalprice").innerHTML
								*document.getElementById("normalqty").innerHTML;
		document.getElementById("hidenormal").style.display = "";
	}
	
	if(document.getElementById("hotdogqty").innerHTML==0){
		document.getElementById("hidehotdog").style.display = "none";}
	
	if (getCookie("hotdog") > 0) {
		document.getElementById("hotdog").innerHTML = "熱狗";
		document.getElementById("hotdogprice").innerHTML =108	;
		document.getElementById("hotdogqty").innerHTML =getCookie("hotdog")	;
		document.getElementById("hotdogcount").innerHTML=document.getElementById("hotdogprice").innerHTML
								*document.getElementById("hotdogqty").innerHTML;
		document.getElementById("hidehotdog").style.display = "";
	}
	
	if(document.getElementById("churroqty").innerHTML==0){
		document.getElementById("hidechurro").style.display = "none";}
	
	if (getCookie("churro") > 0) {
		document.getElementById("churro").innerHTML = "吉拿棒";
		document.getElementById("churroprice").innerHTML =90	;
		document.getElementById("churroqty").innerHTML =getCookie("churro")	;
		document.getElementById("churrocount").innerHTML=document.getElementById("churroprice").innerHTML
								*document.getElementById("churroqty").innerHTML;
		document.getElementById("hidechurro").style.display = "";
	}
	
	if(document.getElementById("friedChickenqty").innerHTML==0){
		document.getElementById("hidefriedChicken").style.display = "none";}

	if (getCookie("friedChicken") > 0) {
		document.getElementById("friedChicken").innerHTML = "炸雞+薯條"
		document.getElementById("friedChickenprice").innerHTML =180	;
		document.getElementById("friedChickenqty").innerHTML =getCookie("friedChicken")	;
		document.getElementById("friedChickencount").innerHTML=document.getElementById("friedChickenprice").innerHTML
								*document.getElementById("friedChickenqty").innerHTML;
		document.getElementById("hidefriedChicken").style.display = "";
	}
	
	if(document.getElementById("bigCokeqty").innerHTML==0){
		document.getElementById("hidebigCoke").style.display = "none";}

	if (getCookie("bigCoke") > 0) {
		document.getElementById("bigCoke").innerHTML = "大可樂"
		document.getElementById("bigCokeprice").innerHTML =63	;
		document.getElementById("bigCokeqty").innerHTML =getCookie("bigCoke")	;
		document.getElementById("bigCokecount").innerHTML=document.getElementById("bigCokeprice").innerHTML
									*document.getElementById("bigCokeqty").innerHTML;
		document.getElementById("hidebigCoke").style.display = "";
	}
	
	if(document.getElementById("normalCokeqty").innerHTML==0){
		document.getElementById("hidenormalCoke").style.display = "none";}

	if (getCookie("normalCoke") > 0) {
		document.getElementById("normalCoke").innerHTML = "中可樂"
		document.getElementById("normalCokeprice").innerHTML =54	;
		document.getElementById("normalCokeqty").innerHTML =getCookie("normalCoke")	;
		document.getElementById("normalCokecount").innerHTML=document.getElementById("normalCokeprice").innerHTML
										*document.getElementById("normalCokeqty").innerHTML;
		document.getElementById("hidenormalCoke").style.display = "";
	}
	
	if(document.getElementById("smallCokeqty").innerHTML==0){
		document.getElementById("hidesmallCoke").style.display = "none";}

	if (getCookie("smallCoke") > 0) {
		document.getElementById("smallCoke").innerHTML = "小可樂"
		document.getElementById("smallCokeprice").innerHTML =49	;
		document.getElementById("smallCokeqty").innerHTML =getCookie("smallCoke")	;
		document.getElementById("smallCokecount").innerHTML=document.getElementById("smallCokeprice").innerHTML
										*document.getElementById("smallCokeqty").innerHTML;
		document.getElementById("hidesmallCoke").style.display = "";
	}
	
	if(document.getElementById("bigPopcornqty").innerHTML==0){
		document.getElementById("hidebigPopcorn").style.display = "none";}

	if (getCookie("bigPopcorn") > 0) {
		document.getElementById("bigPopcorn").innerHTML = "大爆米花"
		document.getElementById("bigPopcornprice").innerHTML =126	;
		document.getElementById("bigPopcornqty").innerHTML =getCookie("bigPopcorn")	;
		document.getElementById("bigPopcorncount").innerHTML=document.getElementById("bigPopcornprice").innerHTML
										*document.getElementById("bigPopcornqty").innerHTML;
		document.getElementById("hidebigPopcorn").style.display = "";
	}
	
	if(document.getElementById("normalPopcornqty").innerHTML==0){
		document.getElementById("hidenormalPopcorn").style.display = "none";}

	if (getCookie("normalPopcorn") > 0) {
		document.getElementById("normalPopcorn").innerHTML = "中爆米花"
		document.getElementById("normalPopcornprice").innerHTML =117	;
		document.getElementById("normalPopcornqty").innerHTML =getCookie("normalPopcorn")	;
		document.getElementById("normalPopcorncount").innerHTML=document.getElementById("normalPopcornprice").innerHTML
										*document.getElementById("normalPopcornqty").innerHTML;
		document.getElementById("hidenormalPopcorn").style.display = "";
	}
	
	if(document.getElementById("smallPopcornqty").innerHTML==0){
		document.getElementById("hidesmallPopcorn").style.display = "none";}

	if (getCookie("smallPopcorn") > 0) {
		document.getElementById("smallPopcorn").innerHTML = "小爆米花"
		document.getElementById("smallPopcornprice").innerHTML =108	;
		document.getElementById("smallPopcornqty").innerHTML =getCookie("smallPopcorn")	;
		document.getElementById("smallPopcorncount").innerHTML=document.getElementById("smallPopcornprice").innerHTML
										*document.getElementById("smallPopcornqty").innerHTML;
		document.getElementById("hidesmallPopcorn").style.display = "";
	}
	
	document.getElementById("Handling").innerHTML =
		20*(getCookie("discount"))+
		40*(getCookie("discount2"))+
		20*(getCookie("bankticket"))+
		20*(getCookie("normal"));
	
	var totalPrice;
	totalPrice=	parseInt(document.getElementById("discountcount").innerHTML)+
		parseInt(document.getElementById("discount2count").innerHTML)+
		parseInt(document.getElementById("bankticketcount").innerHTML)+
		parseInt(document.getElementById("normalcount").innerHTML)+
		parseInt(document.getElementById("hotdogcount").innerHTML)+
		parseInt(document.getElementById("churrocount").innerHTML)+
		parseInt(document.getElementById("friedChickencount").innerHTML)+
		parseInt(document.getElementById("bigCokecount").innerHTML)+
		parseInt(document.getElementById("normalCokecount").innerHTML)+
		parseInt(document.getElementById("smallCokecount").innerHTML)+
		parseInt(document.getElementById("bigPopcorncount").innerHTML)+
		parseInt(document.getElementById("normalPopcorncount").innerHTML)+
		parseInt(document.getElementById("smallPopcorncount").innerHTML)+
		parseInt(document.getElementById("Handling").innerHTML);
	document.getElementById("totalPrice").innerHTML =parseInt(totalPrice);

	
		      

</script>
</html>