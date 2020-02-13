<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html style="background-color: #c5c5c5">
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<title>Paypal付款前確認</title>
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,900'
	rel='stylesheet' type='text/css'>
<!-- stylesheets -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/flexslider.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/style.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/responsive.css'
	type='text/css' />
<style type="text/css">
table {
	border: 0;
}

table td {
	padding: 5px;
}
</style>
</head>
<body>
	<header>
		<!-- header -->
		<jsp:include page="header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
	</header>

	<!-- 		<div> -->
	<!-- 			<img src="img/LifterLMS-PayPal-Extension.png" /> -->
	<!-- 		</div> -->
	<div align="center"
		style="width: 600px; margin-top: 100px; margin-bottom: 100px; border: 1px solid #cdcdcd; padding: 50px 40px 50px 40px; margin-left: auto; margin-right: auto; background-color: white">
		<div>
			<img src="img/LifterLMS-PayPal-Extension.png" style="width: 550px" />
		</div>
		<!-- 			<h1 style="font-size: 35px">付款前確認</h1> -->
		<form action="execute_payment" method="post">
			<table style="font-size: 20px">
				<tr>
					<td colspan="2" style="font-size: 25px"><b>賣家資訊:</b></td>

					<td><input type="hidden" name="paymentId"
						value="${param.paymentId}" /> <input type="hidden" name="PayerID"
						value="${param.PayerID}" /></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>商家:</td>
					<td>${transaction.description}</td>
				</tr>
				<!-- 		<tr> -->
				<!-- 			<td>Subtotal:</td> -->
				<%-- 			<td>${transaction.amount.details.subtotal} USD</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Shipping:</td> -->
				<%-- 			<td>${transaction.amount.details.shipping} USD</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Tax:</td> -->
				<%-- 			<td>${transaction.amount.details.tax} USD</td> --%>
				<!-- 		</tr> -->
				<tr>
					<td>總額:</td>
					<td>NT &nbsp ${transaction.amount.total}</td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td colspan="2" style="font-size: 25px"><b>買家資訊:</b></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>姓名:</td>
					<td>${payer.lastName}${payer.firstName}</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>${payer.email}</td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
				<!-- 		<tr> -->
				<!-- 			<td colspan="2"><b>Shipping Address:</b></td> -->
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Recipient Name:</td> -->
				<%-- 			<td>${shippingAddress.recipientName}</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Line 1:</td> -->
				<%-- 			<td>${shippingAddress.line1}</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>City:</td> -->
				<%-- 			<td>${shippingAddress.city}</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>State:</td> -->
				<%-- 			<td>${shippingAddress.state}</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Country Code:</td> -->
				<%-- 			<td>${shippingAddress.countryCode}</td> --%>
				<!-- 		</tr> -->
				<!-- 		<tr> -->
				<!-- 			<td>Postal Code:</td> -->
				<%-- 			<td>${shippingAddress.postalCode}</td> --%>
				<!-- 		</tr> -->

			</table>
			<table>
				<tr>
					<td colspan="2" align="center" style="font-size: 20px"><input
						type="submit" class='btn btn-primary'
						style="font-size: 20px; background-color: #ffffff; border-color: #000000;color: #000;"
						value="確定付款" /></td>
					<td><a href='movieIndex' type="button" class='btn btn-primary'
						style="font-size: 20px; background-color: #ffffff; border-color: #000000; border: 1px solid black; text-decoration: none; color: black; padding: 6px 12px 6px 12px">取消交易</a></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>
</body>
</html>