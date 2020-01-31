<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>電影列表</title>
</head>
<body>
	<div style="text-align: center">
		<h1>請選擇movieID:</h1>
		<c:forEach var="movie" items="${movieIDList}">
			<a href="comments/add/${movie.movieID}">${movie.title}</a>
			<br>
		</c:forEach>
	</div>
</body>
</html>