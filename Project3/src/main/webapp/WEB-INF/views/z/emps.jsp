<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>員工清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>員工編號</td>
			<td>員工姓名</td>
			<td>員工信箱</td>
			<td>員工密碼</td>
			<td>在職狀態</td>
			<td>就職日期</td>
			<td>離職日期</td>
		</tr>
			<c:forEach var="emp" items="${allEmps}">
		<tr>
			<td>${emp.empId}</td>
			<td>${emp.empName}</td>
			<td>${emp.email}</td>
			<td>${emp.password}</td>
			<td>${emp.status}</td>
			<td>${emp.startDate}</td>
			<td>${emp.endDate}</td>
		</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
