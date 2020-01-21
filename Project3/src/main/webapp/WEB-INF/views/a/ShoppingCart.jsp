<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShoppingCart</title>
</head>
<body>
	<p>This is Shopping Cart</p>
	<p>${shoppingCart[0].discount}</p>
	<table>
	<c:forEach var="SC" items="${shoppingCart}">
		<tr>
			<td>${SC.discount}</td>
			<td>${SC.quantity}</td>
			<td>${SC.unitPrice}</td>
			<td>${SC.productsBean.productName}</td>
		</tr>
		<button id="delete" onclick="delete()">刪除</button>
	</c:forEach>
	</table>
	<script>
	
	</script>
</body>
</html>