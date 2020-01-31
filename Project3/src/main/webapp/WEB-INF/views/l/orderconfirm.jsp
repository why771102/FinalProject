<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>OrderConfirm</title>
</head>
<body>
	<section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>確認</h1>
            </div>
        </div>
    </section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			 <p><b style='font-size: 16px;'>您要看的電影名稱為:${queryStartTime.run.movie.title}</b> </p>
        	</div>
        	<div class="col-md-5">
			 <p><b style='font-size: 16px;'>您要看的電影時間為:${queryStartTime.playStartTime}</b> </p>
        	</div>
        	<div class="col-md-5">
			 <p><b style='font-size: 16px;'>您要看的電影廳為:${queryStartTime.hall.hallID}</b> </p>
        	</div>
		</div>
	</section>
<div>您購買的商品為:<p id="discount"></p>
				<p id="discount2"></p>
				<p id="bankticket"></p>	
				<p id="normal"></p>
				<p id="hotdog"></p>
				<p id="churro"></p>
				<p id="friedChicken"></p>
				<p id="bigCoke"></p>
				<p id="normalCoke"></p>
				<p id="smallCoke"></p>
				<p id="bigPopcorn"></p>
				<p id="normalPopcorn"></p>
				<p id="smallPopcorn"></p>
				訂票手續費
	
</div>
    
<div>分級 名稱</div>
<a href="orderconfirmOK">確認</a>
<div>購買資訊 會員 非會員</div>
</body>
<script>
function getCookie(cname){
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) 
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}
if(getCookie("discount")>0){
document.getElementById("discount").innerHTML ="優惠票個人套票:" + getCookie("discount") ;}
if(getCookie("discount2")>0){
document.getElementById("discount2").innerHTML ="優惠票雙人套票:" + getCookie("discount2") ;}
if(getCookie("bankticket")>0){
document.getElementById("bankticket").innerHTML ="銀行優惠票:" + getCookie("bankticket") ;}
if(getCookie("normal")>0){
document.getElementById("normal").innerHTML ="一般票:" + getCookie("normal");}
if(getCookie("hotdog")>0){
document.getElementById("hotdog").innerHTML ="熱狗:" + getCookie("hotdog");}
if(getCookie("churro")>0){
document.getElementById("churro").innerHTML ="吉拿棒:" + getCookie("churro") ;}
if(getCookie("friedChicken")>0){
document.getElementById("friedChicken").innerHTML ="炸雞+薯條:" + getCookie("friedChicken") ;}
if(getCookie("bigCoke")>0){
document.getElementById("bigCoke").innerHTML ="大可樂:" + getCookie("bigCoke") ;}
if(getCookie("normalCoke")>0){
document.getElementById("normalCoke").innerHTML ="大可樂:" + getCookie("normalCoke") ;}
if(getCookie("smallCoke")>0){
document.getElementById("smallCoke").innerHTML ="中可樂:" + getCookie("smallCoke") ;}
if(getCookie("bigPopcorn")>0){
document.getElementById("bigPopcorn").innerHTML ="小爆米花:" + getCookie("bigPopcorn") ;}
if(getCookie("normalPopcorn")>0){
document.getElementById("normalPopcorn").innerHTML ="中爆米花:" + getCookie("normalPopcorn") ;}
if(getCookie("smallPopcorn")>0){
document.getElementById("smallPopcorn").innerHTML ="小爆米花:" + getCookie("smallPopcorn") ;}

</script>
</html>