<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<title>會員註冊</title>

</head>
<body>

<table>
		<form:form method='POST' modelAttribute="memberBean" enctype="multipart/form-data" >
		
			<fieldset>
				<tr>
					<td>姓名:</td>
					<td><form:input id="name" path="name" type='text' /><br>
					<form:errors path="name" cssClass="error"/></td>
					
				</tr>
				<tr>
					<td>帳號:</td>
					<td><form:input id="account" path="account" type='text'  /><span class="notice">${errorMsgMap.accountExistError}</span><br>
					<form:errors path="account" cssClass="error"/></td>
				</tr>
				<tr>
					<td>密碼:</td>
					<td><form:input id="password" path="password" type='text' /><br>
					<form:errors path="password" cssClass="error"/></td>
				</tr>
				<tr>
					<td>性別:</td>
					<td><form:radiobutton path="gender" value="男性" />男性
						<form:radiobutton path="gender" value="女性" />女性
						<form:radiobutton path="gender" value="其他" />其他</td>
				</tr>
				<tr>
					<td>身分證字號:</td>
					<td><form:input id="uID" path="uID" type='text'  /><span>${errorMsgMap.uIDtExistError}</span><br>
					<form:errors path="uID" cssClass="error"/></td>
				</tr>
				<tr>
					<td>出生年月日:</td>
					<td><form:input id="birth" path="birth" type='date'  /><br>
					<form:errors path="birth" cssClass="error"/></td>
				</tr>
				<tr>
					<td>聯絡電話:</td>
					<td><form:input id="mobile" path="mobile" type='text' /><br>
					<form:errors path="mobile" cssClass="error"/></td>
				</tr>
				<tr>
					<td>email:</td>
					<td><form:input id="email" path="email" type='text'  /><br>
					<form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td>住址:</td>
					<td><form:input id="address" path="address" type='text'  /><br>
					<form:errors path="address" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:input id="registerTime" path="registerTime" value="" type='hidden' /></td>
				</tr>
				<tr>
					<td><input type='submit' id="sumit1"/></td>
				</tr>
			</fieldset>
		</form:form>
</table>
<script>
$("#sumit1").click(function(){
	var d = new Date();
	$("#registerTime").val(d.getFullYear() + "-" + d.getMonth()+1 + "-" + d.getDate() + " " + d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+".000");
});

// $(document).ready(function(){
// 	var d = new Date();
// 	$("#registerTime").val(d.getFullYear() + "-" + d.getMonth()+1 + "-" + d.getDate() + " " + d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+".000");
// });

</script>
</body>
</html>
