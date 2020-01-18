<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>歷史訂單查詢結果</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>訂單編號</td>
			<td>會員編號</td>
			<td>場次時間</td>
			<td>座位代碼</td>
			<td>產品名稱</td>
			<td>總金額</td>
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
