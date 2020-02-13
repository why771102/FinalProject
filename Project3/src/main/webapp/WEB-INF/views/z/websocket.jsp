<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

<header>
		<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</header>

<section class="slider-sec" style="margin-top:100px;">
	<div id="main-content" class="container">
		<div class="row">
			<div class="col-md-12" style="height:500px;overflow-y:auto" id="div1">
				<table id="conversation" class="table table-striped">
					<thead>
						<tr>
							<th style="width:130px">名稱：</th>
							<th style="width:600px">內容：</th>
							<th>時間：</th>
						</tr>
					</thead>

					<c:forEach var="list" items="${content}">
						<c:choose>
							<c:when test="${empty list.name}">
								<tr>
									<td style="width:130px">你：</td>
									<td style="width:600px">${list.content }</td>
									<td>${fn:substring(list.datetime, 5,16 )}</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td style="width:130px">${list.name}</td>
									<td style="width:600px">${list.content}</td>
									<td>${fn:substring(list.datetime, 5,16 )}</td>
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
			<div>
				<form class="form-inline">
					<div class="form-group">
						<label for="name"></label> 
						<input type="text" id="message" class="form-control" placeholder="在此輸入訊息...">
							<button id="sendMessage" class="btn btn-default" type="submit">送出</button>
							<input id="oneKey" class="btn btn-default" type="button" value="一鍵輸入">
							<input id="message2" class="btn btn-default" type="button" value="一鍵訊息">
					</div>
				</form>
			</div>
		</div>
		
	</div>
	</section>
	
	<footer>
		<jsp:include page="../a/footer.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</footer>

	<script>
		var status = ${status};
	
		$(document).ready(function() {
			if(status == 2) {         //結案
				$("#message").attr("disabled", "disabled");
				$("#message").attr("placeholder", "此案件已結案");
			} else {
			
	
			};
		})
		
		$("#oneKey").click(function() {
			$("#message").val("好的，F123456789");
		})
		
		$("#message2").click(function() {
			$("#message").val("不好意思，想請問一下");
		})
		
		
	</script>


</body>
</html>
