<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>包廳申請</title>

</head>
<body>

<table>
<%-- 						<form:input id="memberID" path="memberID" type='hidden'/><br> --%>
		<form:form method='POST' modelAttribute="hallOrderBean" enctype="multipart/form-data" >
		
			<fieldset>
			
				<tr>
					<td>租借日期:</td>
					<td><form:input id="date" path="orderDate" type='date'/></td>
				</tr>
				
				<tr>
					<td>租借起始時間:</td>
					<td><form:select id="startTime" path="startTime">
								<form:option value="-1">請選擇</form:option>
								<form:option value="09:00" >09:00</form:option>
								<form:option value="10:00" >10:00</form:option>
								<form:option value="11:00" >11:00</form:option>
								<form:option value="12:00" >12:00</form:option>
								<form:option value="13:00" >13:00</form:option>
								<form:option value="14:00" >14:00</form:option>
								<form:option value="15:00" >15:00</form:option>
								<form:option value="16:00" >16:00</form:option>
								<form:option value="17:00" >17:00</form:option>
								<form:option value="18:00" >18:00</form:option>
								<form:option value="19:00" >19:00</form:option>
								<form:option value="20:00" >20:00</form:option>
								<form:option value="21:00" >21:00</form:option>
								<form:option value="22:00" >22:00</form:option>
								<form:option value="23:00" >23:00</form:option>
						</form:select></td>		
				</tr>
				<tr>
					<td>租借結束時間:</td>
						<td><form:select id="endTime" path="endTime">
								<form:option value="-1">請選擇</form:option>
								<form:option value="09:00" >09:00</form:option>
								<form:option value="10:00" >10:00</form:option>
								<form:option value="11:00" >11:00</form:option>
								<form:option value="12:00" >12:00</form:option>
								<form:option value="13:00" >13:00</form:option>
								<form:option value="14:00" >14:00</form:option>
								<form:option value="15:00" >15:00</form:option>
								<form:option value="16:00" >16:00</form:option>
								<form:option value="17:00" >17:00</form:option>
								<form:option value="18:00" >18:00</form:option>
								<form:option value="19:00" >19:00</form:option>
								<form:option value="20:00" >20:00</form:option>
								<form:option value="21:00" >21:00</form:option>
								<form:option value="22:00" >22:00</form:option>
								<form:option value="23:00" >23:00</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>包廳總時數:</td>
					<td><form:input id="orderHours" path="orderHours" type='text'  readonly="true"/></td>
				</tr>
				<tr>
					<td>選擇影廳:</td>
					<td><form:select path="hallID">
								<form:option value="-1">
									請選擇
								</form:option>
								<form:options items="${hallList}"/>
							</form:select></td>
				</tr>
				<tr>
					<td>包廳目的:</td>
					<td><form:select id="hallPurpose" path="hallPurpose">
								<form:option value="-1">請選擇</form:option>
								<form:option value="求婚" >求婚</form:option>
								<form:option value="企業包場" >企業包場</form:option>
								<form:option value="片商活動" >片商活動</form:option>
								<form:option value="其他" >其他</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>原因詳述:</td>
					<td><form:textarea cols="50" rows="5" name="hallPurposeDetail" 
										path="hallPurposeDetail" type='textarea'></form:textarea></td>
				</tr>
				<tr>
					<td>預估包廳總金額:</td>
					<td><form:input id="hallSubtotal" path="hallSubtotal" type='text' readonly="true"/></td>
				</tr>
				<tr>
					<td><form:input id="hallOrderStatusNo" path="hallOrderStatusNo" value="0" type='hidden' /></td>
				</tr>
				<tr>
					<td><form:input id="payStatusNo" path="payStatusNo" value="0" type='hidden' /></td>
				</tr>
				<tr>
					<td><input type='submit' value="送出申請"/></td>
				</tr>
			</fieldset>
		</form:form>
</table>
<script>
var s;
var e;

$("#startTime").change(function(){
	s = $("#startTime").val().substring(0,2);
	$("#endTime").change(function(){
		e = $("#endTime").val().substring(0,2);
		if(s!=null && e!=null){
			var s2 = parseInt(s);
			var e2 = parseInt(e);
			var hours = e2-s2;
			var st = (hours)*10000;
			if(hours<=0){
				alert("時間輸入有誤!請重新輸入");
				$("#orderHours").val("時間輸入有誤");
				$("#hallSubtotal").val("0");
			}else{
				$("#orderHours").val(hours);
				$("#hallSubtotal").val(st);
			}
		}
	});
	if(s!=null && e!=null){
		var s2 = parseInt(s);
		var e2 = parseInt(e);
		var hours = e2-s2;
		var st = (hours)*10000;
		if(hours<=0){
			alert("時間輸入有誤!請重新輸入");
			$("#orderHours").val("時間輸入有誤");
			$("#hallSubtotal").val("0");
		}else{
			$("#orderHours").val(hours);
			$("#hallSubtotal").val(st);
		}
	}
});









</script>
</body>
</html>
