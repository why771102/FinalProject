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
			<td width="350"><p align="left" /> <a href='getMovieIDaddexpect'>填寫期待度</a><BR></td>
			<td width="350"><p align="left" /> <a href='getMovieIDforexpect'>查詢個別電影期待度</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='getMovieID'>查詢個別電影的留言</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='paypal'>測試paypal</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='getMovieIDforadd'>新增留言</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='findAllReportComment'>檢視被檢舉留言</a><BR>
			</td>
		</tr>
		
<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!-- 			<td width="350"><p align="left" />  -->
<!-- 				<a href='member/register'>註冊會員(范)</a><BR> -->
<!-- 			</td> -->
<!-- 			<td width="350"><p align="left" /> -->
<!-- 				<a href='products/add'>新增產品資料</a><BR> -->
<!-- 			</td> -->
<!-- 		</tr> -->
		
<!-- 		<tr height="52" bgcolor="lightblue" align="center"> -->
<!--     		<td width="350"><p align="left" />  -->
<!--     			<a href='forwardDemo'>RedirectView: forwardDemo</a><br>  -->
<!--     		</td> -->
<!-- 		    <td width="350"><p align="left" /> -->
<!-- 		    	<a href='redirectDemo'>RedirectView: redirectDemo</a><br> -->
<!--     		</td> -->
<!-- 		</tr> -->
	</table>

</body>
</html>