<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	
<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">

<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
</style>

<title>會員資料</title>
</head>
<body>
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>會員資料</h2>
				<div class="login-form">
					<table>
							<tr>
								<td>會員姓名：</td>
								<td>${mb.name}</td>
							</tr>
							<tr>
								<td>帳號：</td>
								<td>${mb.account}</td>
							</tr>
							<tr>
								<td>信箱：</td>
								<td>${mb.email}</td>
							</tr>
							<tr>
								<td>生日：</td>
								<td>${mb.birth}</td>
							</tr>
							<tr>
								<td>性別：</td>
								<td>${mb.gender}</td>
							</tr>
							<tr>
								<td>身分證字號：</td>
								<td>${mb.uID}</td>
							</tr>

							<tr>
								<td>連絡電話：</td>
								<td>${mb.mobile}</td>
							</tr>

							<tr>
								<td>住址：</td>
								<td>${mb.address}</td>
							</tr>
							<tr>
								<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/' />'" class="inlog-btn"/></td>
							</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
	


</body>
</html>
