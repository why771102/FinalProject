<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Hello WebSocket</title>
<link href="${pageContext.request.contextPath}/js/main.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="${pageContext.request.contextPath}/js/appForMem.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
</head>

<body>
	<div id="main-content" class="container">
		<div class="row">
			<div class="col-md-12">
				<table id="conversation" class="table table-striped">
					<thead>
						<tr>
							<th>訊息：</th>
						</tr>
					</thead>

					<c:forEach var="list" items="${content}">
						<c:choose>
							<c:when test="${empty list.name}">
								<tr>
									<td>你：</td>
									<td>${list.content }</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${list.name}：</td>
									<td>${list.content}</td>
								</tr>
							</c:otherwise>

						</c:choose>
					</c:forEach>
					<tbody id="greetings">
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<form class="form-inline">
					<div class="form-group">
						<label for="name"></label> 
						<input type="text" id="message" class="form-control" placeholder="在此輸入訊息...">
							<button id="sendMessage" class="btn btn-default" type="submit">送出</button>
					</div>
					
				</form>
			</div>
		</div>
		
	</div>

	<script>
		var status = ${status};
	
		$(document).ready(function() {
			if(status == 2) {         //結案
				$("#message").attr("disabled", "disabled");
				$("#message").attr("placeholder", "此案件已結案");
			} else {
			
	
			};
		})
	</script>


</body>
</html>
