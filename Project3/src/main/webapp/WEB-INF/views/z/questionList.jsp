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
				<h1>客服清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>客服編號</td>
			<td>狀態</td>
			<td></td>
		</tr>
			<c:forEach var="ques" items="${allQuestion}">
		<tr>
			<td>${ques.questionId}</td>
			<td>${ques.status}</td>
			<td><a href="question/${ques.questionId}">查看</a></td>
		</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<a href="question">新增詢問</a>
</body>
</html>
