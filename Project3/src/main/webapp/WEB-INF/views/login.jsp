<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
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

<title>會員登入</title>

</head>
<body>
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>會員登入</h2>

				<div class="login-form">
					<table>
						<form:form method='POST' modelAttribute="memberBean"
							enctype="multipart/form-data">

							<fieldset>
								<tr>
									<td>帳號:</td>
									<td><form:input id="account" path="account" type='text' /></td>
								</tr>
								<tr>
									<td>密碼:</td>
									<td><form:input id="password" path="password" type='password' /></td>
								</tr>
								<td><form:input id="lastLogInTime" path="lastLogInTime"
										type='hidden' /></td>
								<tr>
									<td colspan="2"><input type='submit' value="確定" id="sumit1"  class="inlog-btn"/></td>
<%-- 									<td><a href="<c:url value='/views/register.jsp' />" class="inlog-btn" >註冊</a></td> --%>
								</tr>
							</fieldset>
						</form:form>
								<tr>
									<td colspan="2"><input type='button' value="現在註冊" onclick="javascript:location.href='<c:url value='/member/register' />'" class="inlog-btn"/></td>
								</tr>
					</table>
				</div>
			</div>
		</div>
	</section>

	<script>
		$("#sumit1").click(
				function() {
					var d = new Date();
					$("#lastLogInTime").val(
							d.getFullYear() + "-" + d.getMonth() + 1 + "-"
									+ d.getDate() + " " + d.getHours() + ":"
									+ d.getMinutes() + ":" + d.getSeconds()
									+ ".000");
				});
	</script>
</body>
</html>
