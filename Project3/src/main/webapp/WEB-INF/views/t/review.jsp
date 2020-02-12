<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-color: #c5c5c5">
<head>
<meta charset="UTF-8">
<title>Paypal付款前確認</title>
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

	<!-- 		<div> -->
	<!-- 			<img src="img/LifterLMS-PayPal-Extension.png" /> -->
	<!-- 		</div> -->
	<div align="center"
		style="width: 600px; margin-top: 100px; border: 1px solid #cdcdcd; padding: 50px 40px 50px 40px; margin-left: auto; margin-right: auto; background-color: white">
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
					<td>${transaction.amount.total}NTD</td>
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
						style="font-size: 20px; background-color: #ffffff; border-color: #000000"
						value="確定付款" /></td>
					<td><a href='movieIndex' type="button" class='btn btn-primary'
						style="font-size: 20px; background-color: #ffffff; border-color: #000000; border: 2px solid black; text-decoration: none; color: black; padding: 2px 6px 3px 6px">取消交易</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>