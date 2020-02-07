<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	
		<section>
			<div>
				<div style="text-align: center">
					<h1>公告清單</h1>
				</div>
			</div>
		</section>
		<hr
			style="height: 1px; border: none; color: #333; background-color: #333;">
		<div>

			<c:forEach var="anno" items="${allAnnos}">
				<div>
					<h4><a href="">${anno.title} ${fn:substring(anno.startTime, 0 ,10)}</a></h4>
					
				</div>
				<hr>
			</c:forEach>

		</div>

		
</body>
</html>
