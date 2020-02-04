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

	<table>
		<form:form method='POST' modelAttribute="empBean"
			enctype="multipart/form-data">
			<tr>
				<td><form:input path="empId" type='text' /></td>
			</tr>
			<tr>
				<td><form:input path="EmpStatusBean.status" type='text' /></td>
			</tr>
			
			<tr>
				<td><form:input path="roleBean.roleId" type='text' /></td>
			</tr>
			<tr>
				<td>密碼:</td>
				<td><form:input id="password" name="password" path="pwd"
						type='text' /></td>
			</tr>
			<tr>
				<td>確認密碼:</td>
				<td><input id="confirm" type='text' /></td>
			</tr>

			<tr>
				<td><input type='submit' /></td>
			</tr>

		</form:form>
	</table>
</body>
</html>
