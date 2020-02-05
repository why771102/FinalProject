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
	<h2>Receipt Details:</h2>
	<table>
		<tr>
			<td><b>Merchant:</b></td>
			<td>76影城</td>
		</tr>
		<tr>
			<td><b>Payer:</b></td>
			<td>${payer.firstName} ${payer.lastName}</td>		
		</tr>
		<tr>
			<td><b>Description:</b></td>
			<td>${transaction.description}</td>
		</tr>
		<tr>
			<td><b>Total:</b></td>
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