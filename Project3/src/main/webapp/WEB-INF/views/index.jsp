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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>

	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='index-z'>76 測試區</a><BR></td>
			<td width="350"><p align="left" /> <a href='index-a'>Ally 測試區</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='index-c'>雅菁 測試區</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='index-l'>致緯 測試區</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='index-m'>Mary 測試區</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='index-p'>家宏 測試區</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='index-t'>偉民 測試區</a><BR>
			</td>
			<td width="350"><p align="left" /> <a href='backstageindex'>後臺主頁</a><BR>
			</td>
		</tr>
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='qrcode'>QRCODE</a><BR>
			<input type="button" id="qrcode11" value="QRCODE">
			</td>
			<td width="350"><p align="left" /> <a href='backstageindex'>後臺主頁</a>
			<div id="divid">
			</div>
			
			</td>
		</tr>

	</table>

<script>
cookieArray = document.cookie.split("; ");
console.log(cookieArray);

$("#qrcode11").click(function() {
	$("#divid").append("<img alt='TEST' id='qrid' src=''>");
	$("#qrid").attr("src","/Project3/qrcode");
	
// 	$.ajax({
// 		url : "qrcode",
// 		type : "GET",
// 		success: function(data) {
// 			alert("SUCCESS");
// 			console.log(data);
// 		},
// 		error : function(data) {
// 			alert("ERROR");
// 		}
		
// 	})
})
</script>
</body>
</html>