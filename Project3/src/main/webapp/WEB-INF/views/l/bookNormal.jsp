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
        	<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						優惠個人套票 </label>
					<div class="col-lg-10">
						<select id="discount" name="discount"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						優惠雙人套票 </label>
					<div class="col-lg-10">
						<select id="discount2" name="discount2"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
      		 <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						銀行優惠票</label>
					<div class="col-lg-10">
						<select id="bankticket" name="bankticket"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
	          <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						一般票</label>
					<div class="col-lg-10">
						<select id="normal" name="normal"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
	         <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						熱食類熱狗</label>
					<div class="col-lg-10">
						<select id="hotdog" name="hotdog"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
	     		<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						熱食類吉拿棒 </label>
					<div class="col-lg-10">
						<select id="churro" name="churro"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
	    <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						熱食類炸雞+薯條</label>
					<div class="col-lg-10">
						<select id="friedChicken" name="friedChicken"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
			<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						飲料類大可樂</label>
					<div class="col-lg-10">
						<select id="bigCoke" name="bigCoke"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						飲料類中可樂</label>
					<div class="col-lg-10">
						<select id="normalCoke" name="normalCoke"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						飲料類小可樂</label>
					<div class="col-lg-10">
						<select id="smallCoke" name="smallCoke"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						爆米花類大爆米花</label>
					<div class="col-lg-10">
						<select id="bigPopcorn"  name="bigPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						爆米花類中爆米花</label>
					<div class="col-lg-10">
						<select id="normalPopcorn"  name="normalPopcorn"
							onchange="setCookie(this.name,this.selectedIndex);"
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						爆米花類小爆米花</label>
					<div class="col-lg-10">
						<select id="smallPopcorn" name="smallPopcorn" 
						onchange="setCookie(this.name,this.selectedIndex);" 
							class='form:input-large' >
							<option value = "0" >0</option>
							<option value = "1" >1</option>
							<option value = "2" >2</option>
							<option value = "3" >3</option>
							<option value = "4" >4</option>
						</select>
					</div>
				</div>
<a href="orderconfirm">繼續</a>
<script>
var expDays=7;
function setCookie(name,value){
	var exp = new Date();
	var cookieTimeToLive = exp.getTime() + (expDays * 24 * 60 * 60 * 1000)
	exp.setTime(cookieTimeToLive)
	document.cookie = name + "=" + escape(value) + "; expires=" + exp.toGMTString()
}
</script>
</body>
</html>