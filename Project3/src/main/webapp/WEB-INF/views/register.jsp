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
	span{
		color:red;
	}
 	tr{ 
 		height:30;
 	} 
</style>

<title>會員註冊</title>

</head>
<body>
    <header>
       <jsp:include page="a/header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>註冊會員</h2>

				<div class="login-form">
					<table>
						<form:form method='POST' modelAttribute="memberBean"
							enctype="multipart/form-data">

							<fieldset>
								<tr>
									<td>姓名:</td>
									<td><form:input id="name" path="name" type='text' /><br>
										<form:errors path="name" cssClass="error" /></td>

								</tr>
								<tr>
									<td>帳號:</td>
									<td><form:input id="account" path="account" type='text' />
									<br>(至少八個字元)
									<br><span class="notice">${errorMsgMap.accountExistError}</span>
									<form:errors path="account" cssClass="error" /></td>
										
								</tr>
								<tr>
									<td>密碼:</td>
									<td><form:input id="password" path="password" type='password' />
									<br>(至少八個字元)
									<br><form:errors path="password" cssClass="error" /></td>
								</tr>
								<tr>
									<td>確認密碼:</td>
									<td><form:input id="checkPassword" path="checkPassword" type='password' /><br>
										<form:errors path="checkPassword" cssClass="error" /><span>${errorMsgMap.checkPasswordError}</span></td>
								</tr>
								<tr>
									<td>性別:</td>
									<td><form:radiobutton path="gender" value="男性" />男性 
										<form:radiobutton path="gender" value="女性" id="female" />女性 
										<form:radiobutton path="gender" value="其他" />其他
									</td>
								</tr>
								<tr>
									<td>身分證字號:</td>
									<td><form:input id="uID" path="uID" type='text' />
									<br><span>${errorMsgMap.uIDtExistError}</span>
										<form:errors path="uID" cssClass="error" /></td>
								</tr>
								<tr>
									<td>出生年月日:</td>
									<td><form:input id="birth" path="birth" type='date' /><br>
										<form:errors path="birth" cssClass="error" /></td>
								</tr>
								<tr>
									<td>聯絡電話:</td>
									<td><form:input id="mobile" path="mobile" type='text' /><br>
										<form:errors path="mobile" cssClass="error" /></td>
								</tr>
								<tr>
									<td>email:</td>
									<td><form:input id="email" path="email" type='text' /><br>
										<form:errors path="email" cssClass="error" /></td>
								</tr>
								<tr>
									<td>住址:</td>
									<td><form:input id="address" path="address" type='text' /><br>
										<form:errors path="address" cssClass="error" /></td>
								</tr>
								<tr>
									<td><form:input id="registerTime" path="registerTime"
											value="" type='hidden' /></td>
								</tr>
								<tr>
									<td colspan="2"><input type='submit' id="sumit1" class="inlog-btn" /></td>
								</tr>
							</fieldset>
						</form:form>
								<tr>
									<td colspan="2"><input type='button' value="一鍵輸入" id="sumit2" class="inlog-btn" /></td>
								</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!-- footer -->
    <footer>

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->
	<script>
		
		$("#sumit1").click(
				function() {
					var d = new Date();
					$("#registerTime").val(
							d.getFullYear() + "-" + (parseInt(d.getMonth()) + 1 ) + "-"
									+ d.getDate() + " " + d.getHours() + ":"
									+ d.getMinutes() + ":" + d.getSeconds()
									+ ".000");
				});
		
		$("#sumit2").click(function(){
			$("#name").val("李艾莉");
			$("#account").val("allyli1234");
			$("#password").val("allyli1234");
			$("#checkPassword").val("allyli1234");
			$("#female").prop("checked", true);
			$("#uID").val("B123456789");
			$("#birth").val("1990-02-02");
			$("#mobile").val("0918362789");
			$("#email").val("allyli1234@gmail.com");
			$("#address").val("台北市大安區復興南路一段390號15樓");
		});

	</script>
</body>
</html>
