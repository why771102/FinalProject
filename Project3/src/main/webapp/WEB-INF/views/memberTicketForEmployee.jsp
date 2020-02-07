<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/img/favicon.png"
	rel="icon">
<link href="${pageContext.request.contextPath}/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/bg-style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">

<style>
table {
	margin-left: auto;
	margin-right: auto;
}

tr{
	text-align: center;
}

td{
	width:100px;
}
</style>
</head>
<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="z/bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>
		<!--sidebar end-->


		<section id="main-content">
			<section class="wrapper site-min-height">
				<div class="row mt">
					<!-- /row -->
				</div>
				<!-- /col-lg-12 -->
				<div class="col-lg-12 mt">
					<div class="row content-panel">
						<!-- /panel-heading -->
						<div class="panel-body">
							<!--///////////////////////////////////////////////////////-->
							<div id="edit" class="tab-pane">
								<div class="row">
									<div class="col-lg-8 col-lg-offset-2 detailed">
										<h4 class="mb">歷史訂票查詢結果</h4>

										<div id="test">
											<table>
												<tr>
													<td>訂單編號</td>
													<td>會員編號</td>
													<td>電影名稱</td>
													<td>場次時間</td>
													<td>票種</td>
													<td>張數</td>
													<td>座位代碼</td>
												</tr>

												<tr>
													<c:forEach var="mo" items="${molist}">
														<td>${mo.ordersID}</td>
														<td>${mo.memberBean.memberID}</td>
														<td>${mo.showTimeHistoryBean.run.movie.title}</td>
														<c:set var="playTime1"
															value="${mo.showTimeHistoryBean.playStartTime}" />
														<c:set var="playTime2"
															value="${fn:substring(playTime1, 0, 16)}" />
														<td>${playTime2}</td>
													</c:forEach>


													<c:forEach var="modetail" items="${modetaillist}">
														<td>${modetail.productsBean.productName}</td>
														<td>${modetail.quantity}</td>
													</c:forEach>
													
													<td>
													<c:forEach var="tb" items="${tblist}">
														${tb.seatsBean.seatID}
													</c:forEach>
													</td>
												</tr>

											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>
		<!--footer start-->
		<jsp:include page="z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
</body>
</html>
