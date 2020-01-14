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

<title>Hall</title>

</head>
<body>


		<form:form method='POST' modelAttribute="hallBean" enctype="multipart/form-data" >
		
			<fieldset>

					HallID:	<form:input name="hallID" path="hallID" type='text' required="required"/><br>
<%-- 					noOfSeats:	<form:input name="noOfSeats" path="noOfSeats" type='text' required="required"/><br> --%>
					Price:		<form:input name="price" path="price" type='text' required="required"/><br>
					status:		<form:input name="status" path="hallStatus" type='text' required="required"/><br>

				
						<input type='submit' onclick="c()"/>
					
			</fieldset>
		</form:form>
		
		<script>
		function c(){
		console.log(document.getElementById("empName").value);
		}
		</script>
</body>
</html>
