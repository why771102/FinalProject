<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>所有包廳申請</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>申請編號</td>
			<td>廳院</td>
			<td>起始時間</td>
			<td>結束時間</td>
			<td>包廳目的</td>
			<td>詳細申請內容</td>
			<td>申請總時數</td>
			<td>申請總金額</td>
			<td>聯絡人</td>
			<td>連絡電話</td>
			<td>電子郵件</td>
			<td>包廳申請狀態</td>
			<td>包廳付款狀態</td>
			<td>送出修改資料</td>
		</tr>
			
			<c:forEach var="AHO" items="${allEHO}">
			
		<tr>
		<form:form method='POST' modelAttribute="hallOrderBean" enctype="multipart/form-data" >
			
			<td><form:input id="hallOrderNo" path="hallOrderNo" value="${AHO.hallOrderNo}" type='text' readonly="true"/></td>
			
			<td><form:input id="hallID" path="hallID" value="${AHO.hb.hallID}" type='text' readonly="true"/></td>
			
			<td><form:input id="startTime" path="startTime" value="${AHO.startTime}" type='text' readonly="true"/></td>
			
			<td><form:input id="endTime" path="endTime" value="${AHO.endTime}" type='text' readonly="true"/></td>
			
			<td><form:input id="hallPurpose" path="hallPurpose" value="${AHO.hallPurpose}" type='text' readonly="true"/></td>
			
			<td><form:input id="hallPurposeDetail" path="hallPurposeDetail" value="${AHO.hallPurposeDetail}" type='text' readonly="true"/></td>
			
			<td><form:input id="orderHours" path="orderHours" value="${AHO.orderHours}" type='text' readonly="true"/></td>
			
			<td><form:input id="hallSubtotal" path="hallSubtotal" value="${AHO.hallSubtotal}" type='text' readonly="true"/></td>
			
			<td><form:input id="contactPerson" path="contactPerson" value="${AHO.contactPerson}" type='text' readonly="true"/></td>
			
			<td><form:input id="mobile" path="mobile" value="${AHO.mail}" type='text' readonly="true"/></td>
			
			<td><form:input id="mail" path="mail" value="${AHO.mobile}" type='text' readonly="true"/></td>
			
			<td><form:select path="hallOrderStatusNo" id="no">
				<form:option value="${AHO.hob.hallOrderStatusNo}">${AHO.hob.hallOrderStatus}</form:option>
				<form:options items="${hallOrderStatusList}" />
				</form:select></td>
			<td><form:select path="payStatusNo" id="payStatusNo">
				<form:option value="${AHO.psb.payStatusNO}">${AHO.psb.payStatus}</form:option>
				<form:options items="${payStatusList}" />
				</form:select></td>
	
			<td><input type='submit' value="修改" /></td>
			
			<td><form:input id="orderDate" path="orderDate" value="${AHO.orderDate}" type='hidden' readonly="true"/></td>
			
			<td><form:input id="memberID" path="memberID" value="${AHO.mb.memberID}" type='hidden' readonly="true"/></td>
			</form:form>
			<td><a href="<c:url value="/hallOrder/mail/${AHO.mobile}"/>">發送付款通知信</a></td>
		</tr>
			
			</c:forEach>

		</table>
	</div>
<script>


// var hallOrderStatusNo = "${AHO.hob.hallOrderStatusNo}";
// var a = $("#no option");

// console.log(a.val());

// 	for(i=0 ; i < a.length ; i++){
// 		console.log(a[i]);
// 		console.log(a[i].value);
// 		if(a[i].value == hallOrderStatusNo){
// 			a[i].attr("selected","true");
// 		}
// 	}
</script>
</body>
</html>
