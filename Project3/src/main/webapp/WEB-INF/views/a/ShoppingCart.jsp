<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShoppingCart</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<p>This is Shopping Cart</p>
	<table>
<%-- 	<% int product = 0; %> --%>
	<c:forEach var="SC" items="${shoppingCart}">
		<tr>
			<td>${SC.discount}</td>
			<td>${SC.quantity}</td>
			<td>${SC.unitPrice}</td>
			<td>${SC.productsBean.productName}</td>
		</tr>
		<button id="delete" onclick="del(${SC.SCOrdersBean.sCOrderID}, ${SC.productsBean.productID})">刪除</button>
<%-- 		<% product++; %> --%>
	</c:forEach>
	</table>
	
	<script>
	var sc = ${shoppingCart};
	console.log(sc);
	 function del(orderID, productID){
		 console.log(orderID, productID);
		 $.ajax({
				url : "${pageContext.request.contextPath}/deleteProduct",
				data : {orderID: orderID, productID: productID},
				type : "POST",
				success : function() {
					alert("傳送成功");
					window.location.href = "${pageContext.request.contextPath}/index-a";
				}
			});
	 }
	</script>
</body>
</html>