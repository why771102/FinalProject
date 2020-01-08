<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">

<title>Products</title>

</head>
<body>


		<form:form method='POST' modelAttribute="empBean" enctype="multipart/form-data" >

					empName:	<form:input name="empName" path="empName" type='text' /><br>
					roleId:		<form:input name="roleId" path="roleId" type='text' /><br>
					email:		<form:input name="email" path="email" type='text' /><br>
					password:	<form:input name="password" path="password" type='text' /><br>
					status:		<form:input name="status" path="status" type='text' /><br>
					startDate:	<form:input name="startDate" path="startDate" type='date' /><br>
					endDate:	<form:input name="endDate" path="endDate" type='date' /><br>

				
						<input type='submit'/>

		</form:form>

</body>
</html>
