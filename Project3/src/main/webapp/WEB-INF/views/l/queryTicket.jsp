<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body> 
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>產品資料</h2>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>訂單ID:${getOrderByID.OrderID}</h3>
				<p>產品ID: ${getOrderByID.ticketStatus}</p>
				<p>訂單成立時間: ${getOrderByID.OrderTime}</p>
				<p>場次ID: ${getOrderByID.showTimeHistoryBean.showTimeID}</p>
				<p>會員編號: ${getOrderByID.memberBean.memberID}</p>
				<p>領票時間: ${getOrderByID.ticketTime}</p>
				<p>員工ID: ${getOrderByID.empBean.empID}</p>
				
				<p>
					<a href="<spring:url value='/' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>返回
					</a> 
					<a href="<spring:url value='/updateTicket/${getOrderByID.OrderID}' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>修改
					</a> 
					
				</p>
			</div>
		</div>
	</section>
</body>
</html>
