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


		<form method='POST' action="emp" >

					請輸入員工ID:	<input name="empId"  type='text' /><br>
					
						<input type='submit'/>
						<p>查無員工編號： ${empId}</p>

		</form>

</body>
</html>
