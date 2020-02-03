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
			<td width="350"><p align="left" /> <a href='movie/add'>新增movie</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='movie/autoRun'>排片</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='AllMovie/show'>查看所有上映電影</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='movieIndex'>電影院主頁</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='Allrunning/add'>新增running by movieData</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='showAllProducts'>顯示全部商品頁面</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='getShoppingCart'>購物車測試</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='oldShowTimeHistory'>查看排片的歷史紀錄</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='commingSoon/All/movie'>準備要上映電影</a><br>
    		</td>
		</tr>
	</table>

</body>
</html>