<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<form:form method='POST' modelAttribute="mData" enctype="multipart/form-data" >
				
					<tr>
						<td>會員姓名：</td>
						<td><form:input id="name" path="name" type='text' /></td>
					</tr>
					<tr>
						<td>信箱：</td>
						<td><form:input id="email" path="email" type='text' /></td>
					</tr>
					<tr>
						<td>生日：</td>
						<td>${mData.birth}</td>
					</tr>
					<tr>
						<td>性別：</td>
						<td>${mData.gender}</td>
					</tr>
					<tr>
						<td>身分證字號：</td>
						<td>${mData.uID}</td>
					</tr>
					
					<tr>
						<td>連絡電話：</td>
						<td><form:input id="mobile" path="mobile" type='text' /></td>
					</tr>

					<tr>
						<td>住址：</td>
						<td><form:input id="address" path="address" type='text' /></td>
					</tr>
					<tr>
						<td><form:input id="memberID" path="memberID" type='hidden' /></td>
					</tr>
					<tr>
						<td><input type="submit" value="修改資料" /></td>
						<td><a href="<c:url value='/' />">回首頁</a></td>
					</tr>
					</form:form>
				</table>
				
			</div>
		</div>
	</section>
</body>
</html>
