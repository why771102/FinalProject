<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<title>76影城</title>
</head>
<body>
<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
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
										<h4 class="mb">員工資料</h4>
										<form:form role="form" class="form-horizontal" method='POST'
											modelAttribute="annoBean" enctype="multipart/form-data">

											<div class="form-group">
												<label class="col-lg-2 control-label">員工編號：</label>
												<div class="col-lg-6">
													${emp.empId}
												</div>
											</div>


											<div class="form-group">
												<label class="col-lg-2 control-label">員工姓名：</label>
												<div class="col-lg-6">
													${emp.empName}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">員工信箱：</label>
												<div class="col-lg-6">
													${emp.email}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">職務名稱：</label>
												<div class="col-lg-10">
													${emp.roleBean.roleName}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">在職狀態：</label>
												<div class="col-lg-10">
													${emp.empStatusBean.statusName}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">就職日期：</label>
												<div class="col-lg-10">
													${emp.startDate}
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-lg-2 control-label">離職日期：</label>
												<div class="col-lg-10">
													${emp.endDate}
												</div>
											</div>

											<div class="form-group">
												<div class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme04" type="button" onclick="location.href='emp/update/${emp.empId}'">修改資料</button>
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
		

	
	</section>
	<!--footer start-->
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
</body>
</html>
