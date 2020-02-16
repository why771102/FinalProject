<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Hello WebSocket</title>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>
<%-- <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script> --%>
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bg-style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">
<title>76影城</title>

</head>

<body>
<section id="container">
	<jsp:include page="bg-header.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>
	<!--header end-->
	<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
	<!--sidebar start-->
	<jsp:include page="bg-sidebar.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>
	<!--sidebar end-->
	<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">
			<!-- page start-->
			<div class="chat-room mt">
				<aside class="mid-side">
					<div class="chat-room-head">
						<h3>客服訊息</h3>
						<form class="form-inline pull-right position">
							<div class="form-group">
								<input type="text" id="name1" class="form-control"
									placeholder="輸入顯示名稱...">
								<button id="sendName" class="btn btn-default" type="submit">確認</button>
								<input type="button" id="close" class="btn btn-success"
									value="結案">
							</div>

						</form>
					</div>
					<div style="height: 393px; overflow-y: auto" id="div1">
						<c:forEach var="list" items="${content}">
							<c:choose>
								<c:when test="${empty list.name}">
									<div class="group-rom">
										<div class="first-part">用戶</div>
										<div class="second-part">${list.content }</div>
										<div class="third-part">${fn:substring(list.datetime, 5,16 )}</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="group-rom">
										<div class="first-part">${list.name }：</div>
										<div class="second-part">${list.content }</div>
										<div class="third-part">${fn:substring(list.datetime, 5,16 )}</div>
									</div>
								</c:otherwise>

							</c:choose>
						</c:forEach>
						<div id="greetings"></div>
						
					</div>
					<div style="background-color:#dcdada;padding:5px;">
						<div class="chat-txt">
							<input type="text" id="message" class="form-control"
								placeholder="在此輸入訊息...">
						</div>
						<button id="sendMessage" class="btn btn-default" type="submit">送出</button>
						<input type="button" id="oneKey" class="btn btn-default" value="一鍵輸入" >
						<input type="button" id="hello" class="btn btn-default" value="招呼語" >
					</div>
					
				</aside>
			</div>
			<!-- page end-->
		</section>
		<!-- /wrapper -->
	</section>
	<!-- /MAIN CONTENT -->
	<!--main content end-->
	<!--footer start-->
	<jsp:include page="bg-footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>
	<!--footer end-->
	</section>
	
	<script>
		var qId = location.pathname.split("/questionRep/")[1];
		var status = ${status};
		console.log("status = " + status);

		$(document).ready(function() {
			if (status == 1) { //未結案
				$("#close").removeClass();
				$("#close").addClass("btn btn-success");
				$("#close").val("結案");

			} else {
				$("#close").removeClass();
				$("#close").addClass("btn btn-danger");
				$("#close").val("已結案");

			}
			;
		})

		$("#close").click(function() {
			if (status == 1) {
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/closeQuestion",
					data : {questionId : qId},
					success : function(data) {

					},
					error : function(data) {
						$("#close").removeClass();
						$("#close").addClass("btn btn-danger");
						$("#close").val("已結案");
						status = 2;
					}
				})
			} else {
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/openQuestion",
					data : {questionId : qId},
					success : function(data) {
					},
					error : function(data) {
						$("#close").removeClass();
						$("#close").addClass("btn btn-success");
						$("#close").val("結案");
						status = 1;
					}
				})
			}

		});
		
		$("#oneKey").click(function() {
			$("#message").val("您好，已協助將您的訂票紀錄予以退費，如果還有其他問題，歡迎再透過客服聯繫我們，謝謝您的使用。");
		})
		
		$("#hello").click(function() {
			$("#message").val("歡迎使用76影城客服系統，敝姓李，很高興為您服務，請問有什麼需要協助的嗎？");
		})
	</script>
</body>
</html>
