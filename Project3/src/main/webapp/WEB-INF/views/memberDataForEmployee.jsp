<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
										<h4 class="mb">會員資料</h4>
									<div class="form-horizontal" >
										<div class="form-group">
											<label class="col-lg-2 control-label">會員姓名：</label>
											<div class="col-lg-6">
											${mb.name}
											</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">帳號：</label>
											<div class="col-lg-6">
											${mb.account}
											</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">信箱：</label>
											<div class="col-lg-6">
											${mb.email}
											</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">生日：</label>
											<div class="col-lg-6">${mb.birth}</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">性別：</label>
											<div class="col-lg-6">${mb.gender}</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">身分證字號：</label>
											<div class="col-lg-6">${mb.uID}</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">連絡電話：</label>
											<div class="col-lg-6">${mb.mobile}</div>
										</div>
										<div class="form-group">
											<label class="col-lg-2 control-label">地址：</label>
											<div class="col-lg-6">${mb.address}</div>
										</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>




		<!-- 					<table> -->
		<!-- 							<tr> -->
		<!-- 								<td>會員姓名：</td> -->
		<%-- 								<td>${mb.name}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<!-- 								<td>帳號：</td> -->
		<%-- 								<td>${mb.account}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<!-- 								<td>信箱：</td> -->
		<%-- 								<td>${mb.email}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<!-- 								<td>生日：</td> -->
		<%-- 								<td>${mb.birth}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<!-- 								<td>性別：</td> -->
		<%-- 								<td>${mb.gender}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<!-- 								<td>身分證字號：</td> -->
		<%-- 								<td>${mb.uID}</td> --%>
		<!-- 							</tr> -->

		<!-- 							<tr> -->
		<!-- 								<td>連絡電話：</td> -->
		<%-- 								<td>${mb.mobile}</td> --%>
		<!-- 							</tr> -->

		<!-- 							<tr> -->
		<!-- 								<td>住址：</td> -->
		<%-- 								<td>${mb.address}</td> --%>
		<!-- 							</tr> -->
		<!-- 							<tr> -->
		<%-- 								<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/' />'" class="inlog-btn"/></td> --%>
		<!-- 							</tr> -->
		<!-- 					</table> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
		<!-- 	</section> -->
		<!-- </section> -->
		<!--footer start-->
	<!--footer start-->
		<jsp:include page="z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
</body>
</html>
