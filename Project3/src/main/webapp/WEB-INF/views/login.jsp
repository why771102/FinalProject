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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">

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
									<td><form:input id="password" path="password" type='text' /></td>
								</tr>
								<td><form:input id="lastLogInTime" path="lastLogInTime"
										type='hidden' /></td>
								<tr>
									<td><input type='submit' vaiue="確定" id="sumit1"  class="inlog-btn"/></td>
									<td><input type='reset' vaiue="取消"  class="inlog-btn" /></td>
								</tr>
							</fieldset>
						</form:form>
					</table>
				</div>
			</div>
		</div>
	</section>

	<!-- 樣板 -->
	<!--     <section class="login-block"> -->
	<!--         <div class="container"> -->
	<!--             <div class="login-inner"> -->
	<!--                 <h2>Login Here</h2> -->
	<!--                 <div class="login-form"> -->
	<%--                     <form> --%>
	<!--                         <input type="text" name="nm" class="inp-fild" placeholder="Name"> -->
	<!--                         <input type="password" id="mail" name="mail" class="inp-fild" placeholder="Password"> -->
	<%--                     </form> --%>
	<!--                     <button class="inlog-btn">Login</button> -->
	<!--                     <h4><a href="#">Forgot Password</a></h4> -->
	<!--                     <h4>Dont have an account? <a href="#">Create New</a></h4> -->
	<!--                 </div> -->
	<!--             </div> -->
	<!--         </div> -->
	<!--     </section> -->

	<!-- 樣板 -->

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
