<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mary's Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body style="background-color: grey">
	<h1 style="text-align: center">Mary's Page</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='ticket/sale'>Ticket銷售 p1</a><BR></td>
			<td width="350"><p align="left" /> <a href='product/sale'>Product銷售 p1</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='emp/add'>Ticket銷售 p2</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='searchEmp'>Product銷售 p2</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='queryByCategory'>Ticket銷售 p3</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='products/add'>Product利潤 p1</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='member/register'>Ticket利潤 p1</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='products/add'>Product利潤 p2</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='forwardDemo'>Ticket利潤 p2</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='hall/sale'>包廳銷售 p1</a><br>
    		</td>
		</tr>
				<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='forwardDemo'>Ticket利潤 p3</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='redirectDemo'>包廳銷售 p2</a><br>
    		</td>
		</tr>
	</table>

</body>
</html>