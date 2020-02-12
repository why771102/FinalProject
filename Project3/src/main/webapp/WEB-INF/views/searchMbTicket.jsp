<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<script src="https://code.jquery.com/jquery-1.12.4.min.js"
 integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
 crossorigin="anonymous"></script>

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

<title>Products</title>

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
										<h4 class="mb">查詢會員訂票紀錄</h4>
		


		<form:form method='POST' action="../memberTicketForEmployee" >
<div class="form-group">
						<label class="col-lg-2 control-label">請輸入會員身份證字號: </label>
						<div class="col-lg-6">

					<input name="uID"  type='text' id='inputSide' class="form-control"/><br>
					</div>
					</div>
						
					<input type='submit'/>
					<p style="color:red">${message}${empId}</p>

		</form:form>
					<input type='button' id='oneInput' value='一鍵輸入'/>
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

<script>
	$('#oneInput').click(function(){
		$('#inputSide').val("M129118970");
	});
</script>
</body>
</html>
