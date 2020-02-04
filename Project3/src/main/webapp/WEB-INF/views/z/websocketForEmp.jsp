<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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


</head>

<body>
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
		<section class="wrapper site-min-height">
			<!-- page start-->
			<div class="chat-room mt">
				<aside class="mid-side">
					<div class="chat-room-head">
						<h3>客服訊息</h3>
						<!-- 							<form class="form-inline pull-right position"> -->
						<!-- 								<div class="form-group"> -->
						<!-- 									<label for="connect">客服連線狀態</label> -->
						<!-- 									<button id="connect" class="btn btn-default" type="submit">連線</button> -->
						<!-- 									<button id="disconnect" class="btn btn-default" type="submit" -->
						<!-- 										disabled="disabled">切斷連線</button> -->
						<!-- 								</div> -->
						<!-- 							</form> -->
						<form class="form-inline pull-right position">
							<div class="form-group">
								<label for="name">顯示名稱</label> <input type="text" id="name"
									class="form-control" placeholder="輸入顯示名稱...">
							</div>
							<button id="sendName" class="btn btn-default" type="submit">確認</button>
						</form>
					</div>
					<c:forEach var="list" items="${content}">
						<c:choose>
							<c:when test="${empty list.name}">
								<div class="group-rom">
									<div class="first-part">用戶</div>
									<div class="second-part">${list.content }</div>
									<div class="third-part"></div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="group-rom">
									<div class="first-part">${list.name }</div>
									<div class="second-part">${list.content }</div>
									<div class="third-part"></div>
								</div>
							</c:otherwise>

						</c:choose>
					</c:forEach>
					<div id="greetings"></div>
					<div class="group-rom last-group">
						<div class="first-part odd"></div>
						<div class="second-part"></div>
						<div class="third-part"></div>
					</div>

					<footer>
						<div class="chat-txt">
							<input type="text" id="message" class="form-control"
								placeholder="在此輸入訊息...">
						</div>
						<button id="sendMessage" class="btn btn-default" type="submit">送出</button>
					</footer>
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
	<!-- js placed at the end of the document so the pages load faster -->
	<script
		src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="${pageContext.request.contextPath}/lib/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="${pageContext.request.contextPath}/lib/common-scripts.js"></script>
	<!--script for this page-->

</body>
</html>
