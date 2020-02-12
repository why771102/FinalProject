<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css"
	type="text/css">
</head>
<body>
	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='products'>查詢所有產品</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='queryCategoriesID'>查詢所有類別</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
		
			<td width="350"><p align="left" /> <a href='products/add'>新增產品資料</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			
			<td width="350"><p align="left" /><a href="queryMovie">查詢上映電影</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='inputOrderID'>輸入訂單ID來修改資料</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			
			<td width="350"><p align="left" /><a href="fakeTicket">不是真的資料製造機</a><BR>
			</td>
		</tr>
		<tr height="52" bgcolor="lightblue" align="center">
			
			<td width="350"><p align="left" /><a href="orderconfirmOK">最後畫面捷徑</a><BR>
			</td>
		</tr>
<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!-- 			<td width="350"><p align="left" /> <a href='member/register'>註冊會員(范)</a><BR> -->
<!-- 			</td> -->
<!-- 			<td width="350"><p align="left" /> <a href='products/add'>新增產品資料</a><BR> -->
<!-- 			</td> -->
<!-- 		</tr> -->

<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!-- 			<td width="350"><p align="left" /> <a href='forwardDemo'>RedirectView: -->
<!-- 					forwardDemo</a><br></td> -->
<!-- 			<td width="350"><p align="left" /> <a href='redirectDemo'>RedirectView: -->
<!-- 					redirectDemo</a><br></td> -->
<!-- 		</tr> -->
	</table>

</body>
</html>