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
</head>
<body>
<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="../z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="../z/bg-header.jsp">
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
										<h4 class="mb">修改產品</h4>
										<form:form role="form" class="form-horizontal" method='POST'
											modelAttribute="annoBean" enctype="multipart/form-data">

											<div class="form-group">
												<label class="col-lg-2 control-label">產品編號：</label>
												<div class="col-lg-6">
													${Products.productID}
												</div>
											</div>


											<div class="form-group">
												<label class="col-lg-2 control-label">產品名稱:</label>
												<div class="col-lg-6">
													${Products.productName}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">產品價格:</label>
												<div class="col-lg-6">
													${Products.categoriesBean.categoryName}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">在庫數量：</label>
												<div class="col-lg-6">
													${Products.unitStock}
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">產品成本：</label>
												<div class="col-lg-10">
													${Products.cost}
												</div>
											</div>


											<div class="form-group">
												<div class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme04" type="button" onclick="location.href='update/products/${Products.productID}'">修改資料</button>
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
		
		
		
	
	<!--footer start-->
		<jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
</body>
</html>
