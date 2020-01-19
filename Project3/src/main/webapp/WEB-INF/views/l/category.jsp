<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center">
		<h1>請依照類別來挑選產品:</h1>
		<c:forEach var="categoryID" items="${CategoryList}">
			<a href="products/${categoryID.categoryID}">${categoryID.categoryID}</a>
			<br>
		</c:forEach>
	</div>
</body>
</html>