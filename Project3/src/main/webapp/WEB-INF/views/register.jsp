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

<title>會員註冊</title>

</head>
<body>


		<form:form method='POST' modelAttribute="MeberBean" enctype="multipart/form-data" >
		
			<fieldset>

					name:	<form:input id="name" path="name" type='text'/><br>
					account:	<form:input id="account" path="account" type='text' /><br>
					password:	<form:input id="password" path="password" type='text' /><br>
					gender:	<form:input id="gender" path="gender" type='text' /><br>
					uID:		<form:input id="uID" path="uID" type='text' /><br>
					birth:	<form:input id="birth" path="birth" type='text' /><br>
					mobile:	<form:input id="mobile" path="mobile" type='text' /><br>
					email:	<form:input id="email" path="email" type='text' /><br>
					address:	<form:input id="address" path="address" type='text' /><br>
					registerTime:	<form:input id="registerTime" path="registerTime" type='text' /><br>
					lastLogInTime:	<form:input id="lastLogInTime" path="lastLogInTime" type='text' /><br>

				
						<input type='submit'/>
					
			</fieldset>
		</form:form>
</body>
</html>
