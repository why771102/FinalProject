<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<td width="350"><p align="left" /> <a href='backstageindex'>後台主頁</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='movieIndex'>前台主頁</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='index'>舊版畫面</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='backstageindex'></a><BR>
			</td>
		</tr>

	</table>

<script>
cookieArray = document.cookie.split("; ");
console.log(cookieArray);
</script>
</body>
</html>