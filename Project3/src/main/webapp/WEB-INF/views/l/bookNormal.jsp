<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="UTF-8">
<title>Tickets</title>
</head>
<body>
<section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>選擇電影票</h1>
            </div>
        </div>
  </section>
       	
				<table id="ticket">
				<tr>
				<td></td>
				<td>票種</td>
				<td>價格</td>
				<td>數量</td>
				<td >小計</td>
				</tr>
				<tr>
				<td></td>
				<td>優惠個人套票</td>
				<td>350</td>
				<td><div class="col-lg-10">
						<select id="discount" name="discount"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="discountTPrice">0</td>
				</tr>
				<tr>
				<td></td>
				<td>優惠雙人套票</td>
				<td>660</td>
				<td><div class="col-lg-10">
						<select id="discount2" name="discount2"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="discount2TPrice">0</td>
				</tr>
				<tr>
				<td></td>
				<td>銀行優惠票</td>
				<td>200</td>
				<td><div class="col-lg-10">
						<select id="bankticket" name="bankticket"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="bankticketTPrice">0</td>
				</tr>
				<tr>
				<td></td>
				<td>一般票</td>
				<td>270</td>
				<td><div class="col-lg-10">
						<select id="normal" name="normal"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="normalTPrice">0</td>
				</tr>
				</table>	
					
				
			<table id="Food">
				<tr>
				<td></td>
				<td>種類</td>
				<td>價格</td>
				<td>數量</td>
				<td>小計</td>
				</tr>
				<tr>
				<td></td>
				<td>熱狗</td>
				<td>120</td>
				<td><div class="col-lg-10">
						<select id="hotdog" name="hotdog"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="hotdogTPrice">0</td>
				</tr>
				<tr>
				<td></td>
				<td>吉拿棒</td>
				<td>100</td>
				<td><div class="col-lg-10">
						<select id="churro" name="churro"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="churroTPrice">0</td>
				</tr>
				<tr>
				<td></td>
				<td>炸雞+薯條</td>
				<td>200</td>
				<td><div class="col-lg-10">
						<select id="friedChicken" name="friedChicken"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="friedChickenTPrice">0</td>
				</tr>
				     </table>
	       <table id="drink">  
	       <tr>
				<td></td>
				<td>飲料</td>
				<td>價格</td>
				<td>數量</td>
				<td>小計</td>
			</tr>
			  <tr>
				<td></td>
				<td>大可樂</td>
				<td>70</td>
				<td><div class="col-lg-10">
						<select id="bigCoke" name="bigCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="bigCokeTPrice">0</td>
			</tr>
			  <tr>
				<td></td>
				<td>中可樂</td>
				<td>60</td>
				<td><div class="col-lg-10">
						<select id="normalCoke" name="normalCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="normalCokeTPrice">0</td>
			</tr>
			  <tr>
				<td></td>
				<td>小可樂</td>
				<td>54</td>
				<td><div class="col-lg-10">
						<select id="smallCoke" name="smallCoke"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="smallCokeTPrice">0</td>
			</tr>
			</table>
	      
			
			<table id="popcorn">  
	       <tr>
				<td></td>
				<td>爆米花</td>
				<td>價格</td>
				<td>數量</td>
				<td>小計</td>
			</tr>
			<tr>
				<td></td>
				<td>大爆米花</td>
				<td>140</td>
				<td><div class="col-lg-10">
						<select id="bigPopcorn"  name="bigPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="bigPopcornTPrice">0</td>
			</tr>	
			<tr>
				<td></td>
				<td>中爆米花</td>
				<td>130</td>
				<td><div class="col-lg-10">
						<select id="normalPopcorn"  name="normalPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="normalPopcornTPrice">0</td>
			</tr>
			<tr>
				<td></td>
				<td>小爆米花</td>
				<td>120</td>
				<td><div class="col-lg-10">
						<select id="smallPopcorn" name="smallPopcorn" 
						onchange="setCookie(this.name,this.selectedIndex);setCountPrice(this.name,this.selectedIndex)" 
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div></td>
				<td id="smallPopcornTPrice">0</td>
			</tr>	
			</table>	
		
<a href="reservedSeats/showSeats">繼續</a>
<div>購物清單
	<p id="discountPrice" style="display: none">0</p>
	<p id="discount2Price" style="display: none">0</p>
	<p id="bankticketPrice" style="display: none">0</p>
	<p id="normalPrice" style="display: none">0</p>
	<p id="hotdogPrice"style="display: none">0</p>
	<p id="churroPrice" style="display: none">0</p>
	<p id="friedChickenPrice" style="display: none">0</p>
	<p id="bigCokePrice" style="display: none">0</p>
	<p id="normalCokePrice" style="display: none">0</p>
	<p id="smallCokePrice" style="display: none">0</p>
	<p id="bigPopcornPrice" style="display: none">0</p>
	<p id="normalPopcornPrice" style="display: none">0</p>
	<p id="smallPopcornPrice" style="display: none">0</p>
	合計<p id="totalPrice" >0</p>
</div>
<script>
var expDays=7;
function setCookie(name,value){
	var exp = new Date();
	var cookieTimeToLive = exp.getTime() + (expDays * 24 * 60 * 60 * 1000)
	exp.setTime(cookieTimeToLive)
	document.cookie = name + "=" + escape(value) + "; expires=" + exp.toGMTString()
}

function setCountPrice(name,value){
	var price;
	if (name==="discount"){
		price=value*350
		document.getElementById("discountPrice").innerHTML="優惠個人套票X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("discountTPrice").innerHTML=parseInt(price);
			if(value==0)
				{document.getElementById("discountPrice").style.display="none";}
			else{
				document.getElementById("discountPrice").style.display="";
			}
	}
	
	if (name==="discount2"){
		price=value*660
		document.getElementById("discount2Price").innerHTML="優惠雙人套票X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("discount2TPrice").innerHTML=parseInt(price);
			if(value==0)
				{document.getElementById("discount2Price").style.display="none";}
			else{
				document.getElementById("discount2Price").style.display="";
			}
	}
	if (name==="bankticket"){
		price=value*200
		document.getElementById("bankticketPrice").innerHTML="銀行優惠票X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("bankticketTPrice").innerHTML=parseInt(price);
			if(value==0)
				{document.getElementById("bankticketPrice").style.display="none";}
			else{
				document.getElementById("bankticketPrice").style.display="";
			}	
	}
	if (name==="normal"){
		price=value*270
		document.getElementById("normalPrice").innerHTML="一般票X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("normalTPrice").innerHTML=parseInt(price);
			if(value==0)
				{document.getElementById("normalPrice").style.display="none";}
			else{
				document.getElementById("normalPrice").style.display="";
	}		
	}
	if (name==="hotdog"){
		price=value*120
		document.getElementById("hotdogPrice").innerHTML="熱食類熱狗X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("hotdogTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("hotdogPrice").style.display="none";}
			else{
		document.getElementById("hotdogPrice").style.display="";
		}	
	}
	if (name==="churro"){
		price=value*100
		document.getElementById("churroPrice").innerHTML="熱食類吉拿棒X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("churroTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("churroPrice").style.display="none";}
			else{
		document.getElementById("churroPrice").style.display="";
		}	
		}
	if (name==="friedChicken"){
		price=value*200
		document.getElementById("friedChickenPrice").innerHTML="熱食類炸雞+薯條X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("friedChickenTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("friedChickenPrice").style.display="none";}
			else{
		document.getElementById("friedChickenPrice").style.display="";
		}	
	
	}
	if (name==="bigCoke"){
		price=value*70
		document.getElementById("bigCokePrice").innerHTML="飲料類大可樂X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("bigCokeTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("bigCokePrice").style.display="none";}
			else{
		document.getElementById("bigCokePrice").style.display="";
		}	
	}
	if (name==="normalCoke"){
		price=value*60
		document.getElementById("normalCokePrice").innerHTML="飲料類中可樂X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("normalCokeTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("normalCokePrice").style.display="none";}
			else{
		document.getElementById("normalCokePrice").style.display="";
		}
	}
	if (name==="smallCoke"){
		price=value*54
		document.getElementById("smallCokePrice").innerHTML="飲料類小可樂X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("smallCokeTPrice").innerHTML=parseInt(price);
		if(value==0)
		{document.getElementById("smallCokePrice").style.display="none";}
			else{
		document.getElementById("smallCokePrice").style.display="";
		}
	}	
	if (name==="bigPopcorn"){
		price=value*140
		document.getElementById("bigPopcornPrice").innerHTML="爆米花類大爆米花X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("bigPopcornTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("bigPopcornPrice").style.display="none";}
			else{
		document.getElementById("bigPopcornPrice").style.display="";
	}	
	}
	if (name==="normalPopcorn"){
		price=value*130
		document.getElementById("normalPopcornPrice").innerHTML="爆米花類中爆米花X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("normalPopcornTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("normalPopcornPrice").style.display="none";}
			else{
		document.getElementById("normalPopcornPrice").style.display="";
	}
	}
	if (name==="smallPopcorn"){
		price=value*120
		document.getElementById("smallPopcornPrice").innerHTML="爆米花類小爆米花X"+parseInt(value)+"="+parseInt(price);
		document.getElementById("smallPopcornTPrice").innerHTML=parseInt(price);
			if(value==0)
		{document.getElementById("smallPopcornPrice").style.display="none";}
			else{
		document.getElementById("smallPopcornPrice").style.display="";
	}
	}
	var totalPrice;
	totalPrice=parseInt(document.getElementById("discountTPrice").innerHTML)+
			parseInt(document.getElementById("discount2TPrice").innerHTML)+
			parseInt(document.getElementById("bankticketTPrice").innerHTML)+
			parseInt(document.getElementById("normalTPrice").innerHTML)+
			parseInt(document.getElementById("hotdogTPrice").innerHTML)+
			parseInt(document.getElementById("churroTPrice").innerHTML)+
			parseInt(document.getElementById("friedChickenTPrice").innerHTML)+
			parseInt(document.getElementById("bigCokeTPrice").innerHTML)+
			parseInt(document.getElementById("normalCokeTPrice").innerHTML)+
			parseInt(document.getElementById("smallCokeTPrice").innerHTML)+
			parseInt(document.getElementById("bigPopcornTPrice").innerHTML)+
			parseInt(document.getElementById("normalPopcornTPrice").innerHTML)+
			parseInt(document.getElementById("smallPopcornTPrice").innerHTML)
	document.getElementById("totalPrice").innerHTML=parseInt(totalPrice);
}

</script>
</body>
</html>