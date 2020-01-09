<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">

<title>Anno</title>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
</head>
<body>
	<table>

		<form:form method='POST' modelAttribute="annoBean"
			enctype="multipart/form-data">

			<tr>
				<td>公告標題:</td>
				<td><form:input name="title" path="title" type='text' /></td>
			</tr>
			<tr>
				<td>公告內容:</td>
				<td><form:textarea cols="50" rows="5" name="content"
						path="content" type='textarea'></form:textarea>
					<script>
						CKEDITOR.replace('content', {
							width : 600
						});
					</script></td>
			</tr>
			<tr>
				<td>公告狀態:</td>
				<td><form:input name="status" path="status" type='text' /></td>
			</tr>
			<tr>
				<td>開始時間:</td>
				<td><form:input name="startTime" path="startTime" type='date' /></td>
			</tr>
			<tr>
				<td>結束時間:</td>
				<td><form:input name="endTime" path="endTime" type='date' /></td>
			</tr>
			<tr>
				<td>權重:</td>
				<td><form:input name="priority" path="priority" type='text' /></td>
			</tr>
			<tr>
				<td><input type='submit' /></td>
			</tr>
		</form:form>
	</table>

</body>
</html>
