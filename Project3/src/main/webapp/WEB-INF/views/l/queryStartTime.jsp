<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body> 
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>時間</h2>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>場次ID:${playStartTime.showTimeId}</h3>
				<p>廳別代碼 ${playStartTime.hall}</p>
				<p>排片ID: ${playStartTime.runID}</p>
				<p>播放日期時間: ${playStartTime.playStartTime}</p>
				<p>
					<a href="<spring:url value='/queryMovie' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>返回
					</a> 
								
				</p>
			</div>
		</div>
	</section>
</body>
</html>
