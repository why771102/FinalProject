<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='123'>Hello
					Spring MVC</a><BR></td>
			<td width="350"><p align="left" /> <a href='products'>查詢產品資料</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='products'>查詢所有產品資料</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='update/stock'>更新多筆產品的庫存數量</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='queryByCategory'>分類查詢</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='products/add'>新增產品資料</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='forwardDemo'>RedirectView: forwardDemo</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='redirectDemo'>RedirectView: redirectDemo</a><br>
    		</td>
		</tr>
	</table>

</body>
</html>