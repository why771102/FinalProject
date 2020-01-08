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


		<form:form method='POST' action="emp" >

					請輸入員工ID:	<form:input name="empId" path="empId" type='text' /><br>
					
						<input type='submit'/>

		</form:form>

</body>
</html>
