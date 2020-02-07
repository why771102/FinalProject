<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>76影城</title>
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
										<h4 class="mb">員工資料修改</h4>
										<form:form role="form" class="form-horizontal" method='POST'
											modelAttribute="empBean" enctype="multipart/form-data">

											<div class="form-group">
												<label class="col-lg-2 control-label">員工編號：</label>
												<div class="col-lg-6">
													${empBean.empId}
												</div>
											</div>


											<div class="form-group">
												<label class="col-lg-2 control-label">員工姓名：</label>
												<div class="col-lg-6">
													<form:input name="empName" path="empName" type='text'  class="form-control" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">員工信箱：</label>
												<div class="col-lg-6">
													<form:input name="email" path="email" type='text'  class="form-control" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">員工密碼：</label>
												<div class="col-lg-6">
													<form:input name="password" path="password" type='text'  hidden="hidden"/>
													<input type="button" value="重置密碼" class="btn btn-theme"/>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">職務名稱：</label>
												<div class="col-lg-10">
													<form:select path="roleId" id="role">
														<form:options items="${roleList}" />
													</form:select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">在職狀態：</label>
												<div class="col-lg-10">
													<form:select path="status" id="status">
														<form:options items="${empStatusList}" />
													</form:select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-lg-2 control-label">就職日期：</label>
												<div class="col-lg-10">
													<form:input name="startDate" path="startDate" type='date'  class="form-control"/>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-lg-2 control-label">離職日期：</label>
												<div class="col-lg-10">
													<form:input name="endDate" path="endDate" type='date'  class="form-control"/>
												</div>
											</div>
											

											<div class="form-group">
												<div class="col-lg-offset-2 col-lg-10">
													<button class="btn btn-theme" type="submit">儲存</button>
													<button class="btn btn-theme04" type="button" onclick="location.href='../bgAnnos'">取消</button>
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
		<jsp:include page="bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
		<!--footer end-->
	</section>
	<script>
		var roleId = "${empBean.roleBean.roleId}";
		
		var a = document.getElementById("role");
		for(i=0;i < a.length;i++) {
			console.log(a[i]);
			if(a[i].value == roleId) {
				a[i].selected = true;
			}
		}
		
		var status = "${empBean.empStatusBean.status}";
		
		var b = document.getElementById("status");
		for(i=0;i < b.length;i++) {
			if(b[i].value == status) {
				b[i].selected = true;
			}
		}
	
	
	</script>
</body>
</html>
