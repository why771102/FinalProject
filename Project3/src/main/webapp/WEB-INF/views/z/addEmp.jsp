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
			<td>員工名稱:</td>
			<td><form:input name="empName" path="empName" type='text' /></td>
		</tr>	
		<tr>
			<td>email:</td>	
			<td><form:input name="email" path="email" type='text' /></td>
		</tr>
		<tr>
			<td>密碼:</td>
			<td><form:input name="password" path="password" type='text' /></td>
		</tr>
		<tr>
			<td>在職狀態:</td>	
			<td><form:select path="status">
				<form:option value="-1">請選擇</form:option>
				<form:options items="${empStatusList}" />
				</form:select></td>
		</tr>
		<tr>
			<td>到職日期:</td>
			<td><form:input name="startDate" path="startDate" type='date' /></td>
		</tr>
		<tr>
			<td>離職日期:</td>	
			<td><form:input name="endDate" path="endDate" type='date' /></td>
		</tr>
		<tr>
			<td>職稱：</td>
			<td>
			<form:select path="roleId">
			<form:option value="-1">請選擇</form:option>
			<form:options items="${roleList}" />
			</form:select>
			</td>
		</tr>
		<tr>
			<td><input type='submit' /></td>
		</tr>

	</form:form>
</table>
</body>
</html>
