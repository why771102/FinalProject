<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">

<title>Products</title>
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
		<jsp:include page="bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<jsp:include page="bg-sidebar.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
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

							<div id="edit" class="tab-pane">
								<div class="row">
									<div class="col-lg-8 col-lg-offset-2 detailed">
										<h4 class="mb">修改密碼</h4>
										<form:form role="form" class="form-horizontal" method='POST'
											modelAttribute="empBean" enctype="multipart/form-data">


											<div class="form-group">
												<label class="col-lg-2 control-label">員工名稱:</label>
												<div class="col-lg-6">
													<form:input type="text" placeholder=" " id="password"
														class="form-control" path="empName"></form:input>
												</div>
											</div>


											<div class="form-group">
												<label class="col-lg-2 control-label">在職狀態:</label>
												<div class="col-lg-6">
													<form:select path="status">
														<form:option value="-1">請選擇</form:option>
														<form:options items="${empStatusList}" />
													</form:select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">到職日期:</label>
												<div class="col-lg-6">
													<form:input type="date" class="form-control"
														path="startDate"></form:input>
												</div>
											</div>


											<div class="form-group">
												<label class="col-lg-2 control-label">離職日期:</label>
												<div class="col-lg-6">
													<form:input type="date" class="form-control" path="endDate"></form:input>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">職稱：</label>
												<div class="col-lg-6">
													<form:select path="roleId">
														<form:option value="-1">請選擇</form:option>
														<form:options items="${roleList}" />
													</form:select>
												</div>
											</div>


											<div class="form-group">
												<div class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme" type="submit">送出</button>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</section>

		<jsp:include page="bg-footer.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
	</section>
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
	<!-- MAP SCRIPT - ALL CONFIGURATION IS PLACED HERE - VIEW OUR DOCUMENTATION FOR FURTHER INFORMATION -->
</body>
</html>
