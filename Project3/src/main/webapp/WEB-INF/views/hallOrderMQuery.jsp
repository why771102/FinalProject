<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<!-- stylesheets -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/flexslider.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>包廳申請清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>包廳申請編號</td>
			<td>申請廳院</td>
			<td>申請起始時間</td>
			<td>申請結束時間</td>
			<td>申請總時數</td>
			<td>申請總金額</td>
			<td>包廳申請狀態</td>
			<td>包廳付款狀態</td>
		</tr>
			<c:forEach var="hoA" items="${allMHO}">
		<tr>
			<td>${hoA.hallOrderNo}</td>
			<td>${hoA.hb.hallID}</td>
			<td>${hoA.startTime}</td>
			<td>${hoA.endTime}</td>
			<td>${hoA.orderHours}</td>
			<td>${hoA.hallSubtotal}</td>
			<td>${hoA.hob.hallOrderStatus}</td> 
			<td>${hoA.psb.payStatus}</td> 
		</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
