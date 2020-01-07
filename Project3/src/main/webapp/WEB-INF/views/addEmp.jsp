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

						<form:input id="empName" path="empName" type='text'/>
					
						<form:input id="roleId" path="roleId" type='text' />
						<form:input id="email" path="email" type='text' />
						<form:input id="password" path="password" type='text' />
						<form:input id="status" path="status" type='text' />
						<form:input id="startDate" path="startDate" type='text' />
						<form:input id="endDate" path="endDate" type='text' />

				
						<input type='submit'/>
					
			</fieldset>
		</form:form>
</body>
</html>
