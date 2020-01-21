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
			<td>電影名稱</td>
			<td>場次時間</td>
			<td>票種</td>
			<td>張數</td>
			<td>座位代碼</td>
		</tr>
			
		<tr>
			<c:forEach var="mo" items="${molist}">
				<td>${mo.ordersID}</td>
				<td>${mo.memberBean.memberID}</td>
				<td>${mo.showTimeHistoryBean.run.movie.title}</td>
				<td>${mo.showTimeHistoryBean.playStartTime}</td>
			</c:forEach>
			
<%-- 			<c:forEach var="modetail" items="${modetaillist}"> --%>
<%-- 				<td>${modetail.productsBean.categoriesBean.categoryName}</td> --%>
<!-- 				<td id="ticketCount"></td> -->
<%-- 			</c:forEach> --%>
			
<%-- 			<c:forEach var="tb" items="${tblist}"> --%>
<%-- 				<td>${tb.SeatsBean.seatID}</td> --%>
<%-- 			</c:forEach> --%>
		</tr>
			
		</table>
	</div>
</body>
</html>
