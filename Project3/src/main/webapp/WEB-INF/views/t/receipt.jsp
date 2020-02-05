<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
	table { border: 0; }
	table td { padding: 5px; }
</style>
</head>
<body>
<div align="center">
	<h1>Payment Done. Thank you for purchasing our products</h1>
	<br/>
	<h2>付款明細:</h2>
	<table>
		<tr>
			<td><b>商家:</b></td>
			<td>76影城</td>
		</tr>
		<tr>
			<td><b>購買人:</b></td>
			<td>${payer.lastName} ${payer.firstName}</td>		
		</tr>
		<tr>
			<td><b>商品:</b></td>
			<td>${transaction.description}</td>
		</tr>
		<tr>
			<td><b>總額:</b></td>
			<td>${transaction.amount.total} NTD</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<a href='tohome'>回到首頁</a> -->
<!-- 		</tr>						 -->		
	</table>
	<br> <a href="<c:url value='/' />">回首頁</a>
</div>
</body>
</html>