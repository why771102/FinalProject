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

<title>包廳申請</title>

</head>
<body>


		<form:form method='POST' modelAttribute="hallOrderBean" enctype="multipart/form-data" >
		
			<fieldset>
						<form:input id="memberID" path="memberID" type='hidden'/><br>
					租借日期:<form:input id="name" path="name" type='date'/><br>
					租借起始時間:	<form:input id="name" path="name" type='text'/><br>
					租借結束時間:<form:input id="account" path="account" type='text' /><br>
					選擇影廳:<form:input id="password" path="password" type='text' /><br>
					包廳目的:<form:input id="gender" path="gender" type='text' /><br>
					原因詳述:<form:input id="uID" path="uID" type='text' /><br>
					預估包廳總金額:<form:input id="birth" path="birth" type='text' /><br>
					<input type='submit' value="送出申請"/>
					
			</fieldset>
		</form:form>
</body>
</html>
