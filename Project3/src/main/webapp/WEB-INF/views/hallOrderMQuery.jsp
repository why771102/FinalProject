<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">
<meta charset="UTF-8">
<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
</style>
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>您的包廳申請清單</h1>
			</div>
		</div>
	</section>
<!-- 	<hr -->
<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
	<div id="test">
		<table >
		<tr style="text-align: center">
			<td><b>包廳申請編號</b></td>
			<td><b>申請廳院</b></td>
			<td><b>申請起始時間</b></td>
			<td><b>申請結束時間</b></td>
			<td><b>申請總時數</b></td>
			<td><b>申請總金額</b></td>
			<td><b>包廳申請狀態</b></td>
			<td><b>包廳付款狀態</b></td>
		</tr>
			<c:forEach var="hoA" items="${allMHO}">
		<tr style="text-align: center">
			<td>${hoA.hallOrderNo}</td>
			<td>${hoA.hb.hallID}廳</td>
			<c:set var="startTime1" value="${hoA.startTime}"/>
			<c:set var="startTime2" value="${fn:substring(startTime1, 0, 16)}" />
			<td>${startTime2}</td>
			<c:set var="endTime1" value="${hoA.endTime}"/>
			<c:set var="endTime2" value="${fn:substring(endTime1, 0, 16)}" />
			<td>${endTime2}</td>
			<td>${hoA.orderHours}小時</td>
			<td>${hoA.hallSubtotal}元</td>
			<td>${hoA.hob.hallOrderStatus}</td> 
			<td>${hoA.psb.payStatus}</td> 
		</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
