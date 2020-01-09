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
				<h1>會員資料</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<section>
		<div>
			<div class="caption">
				<table>
					<tr>
						<td>會員姓名：</td>
						<td>${emp.empName}</td>
					</tr>
					<tr>
						<td>信箱：</td>
						<td>${emp.email}</td>
					</tr>
					<tr>
						<td>生日：</td>
						<td>${emp.password}</td>
					</tr>
					<tr>
						<td>性別：</td>
						<td>${emp.status}</td>
					</tr>
					<tr>
						<td>身分證字號：</td>
						<td>${emp.startDate}</td>
					</tr>
					
					<tr>
						<td>連絡電話：</td>
						<td>${emp.startDate}</td>
					</tr>

					<tr>
						<td>住址：</td>
						<td>${emp.endDate}</td>
					</tr>
				</table>
				<input type="button" value="修改資料" />
			</div>
		</div>
	</section>
</body>
</html>
