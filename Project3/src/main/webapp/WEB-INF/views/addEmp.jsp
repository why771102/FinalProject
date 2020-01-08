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

<title>Products</title>

</head>
<body>


		<form:form method='POST' modelAttribute="empBean" enctype="multipart/form-data" >
		
			<fieldset>

					empName:	<form:input id="empName" path="empName" type='text'/><br>
					roleId:		<form:input id="roleId" path="roleId" type='text' /><br>
					email:		<form:input id="email" path="email" type='text' /><br>
					password:	<form:input id="password" path="password" type='text' /><br>
					status:		<form:input id="status" path="status" type='text' /><br>
					startDate:	<form:input id="startDate" path="startDate" type='text' /><br>
					endDate:	<form:input id="endDate" path="endDate" type='text' /><br>

				
						<input type='submit'/>
					
			</fieldset>
		</form:form>
</body>
</html>
