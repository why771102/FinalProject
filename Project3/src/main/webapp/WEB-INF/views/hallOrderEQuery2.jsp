<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
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
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i>所有包廳申請
			</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="content-panel" style="width:2000px">
						<table class="table">
							<thead>
								<tr>
									<th>申請編號</th>
									<th>廳院</th>
									<th>起始時間</th>
									<th>結束時間</th>
									<th>包廳目的</th>
									<th>詳細申請內容</th>
									<th>總時數</th>
									<th>總金額</th>
									<th>聯絡人</th>
									<th>連絡電話</th>
									<th>電子郵件</th>
									<th>申請狀態</th>
									<th>付款狀態</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="AHO" items="${allEHO}">

									<tr>
										<form:form method='POST' modelAttribute="hallOrderBean"
											enctype="multipart/form-data">

											<td><form:input id="hallOrderNo" path="hallOrderNo"
													value="${AHO.hallOrderNo}" size="8" type='text' readonly="true" /></td>

											<td><form:input id="hallID" path="hallID"
													value="${AHO.hb.hallID}" size="4" type='text' readonly="true" /></td>

											<td><form:input id="startTime" path="startTime"
													value="${AHO.startTime}" type='text' readonly="true" /></td>

											<td><form:input id="endTime" path="endTime"
													value="${AHO.endTime}" type='text' readonly="true" /></td>

											<td><form:input id="hallPurpose" path="hallPurpose"
													value="${AHO.hallPurpose}" size="8" type='text' readonly="true" /></td>

											<td><form:input id="hallPurposeDetail"
													path="hallPurposeDetail" value="${AHO.hallPurposeDetail}"
													type='text' readonly="true" /></td>

											<td><form:input id="orderHours" path="orderHours"
													value="${AHO.orderHours}" size="6" type='text' readonly="true" /></td>

											<td><form:input id="hallSubtotal" path="hallSubtotal"
													value="${AHO.hallSubtotal}" size="7" type='text' readonly="true" /></td>

											<td><form:input id="contactPerson" path="contactPerson"
													value="${AHO.contactPerson}" size="6" type='text' readonly="true" /></td>

											<td><form:input id="mobile" path="mobile"
													value="${AHO.mobile}" size="11" type='text' readonly="true" /></td>

											<td><form:input id="mail" path="mail"
													value="${AHO.mail}" type='text' readonly="true" /></td>

											<td><form:select path="hallOrderStatusNo" id="no">
													<form:option value="${AHO.hob.hallOrderStatusNo}">${AHO.hob.hallOrderStatus}</form:option>
													<form:options items="${hallOrderStatusList}" />
												</form:select></td>
											<td><form:select path="payStatusNo" id="payStatusNo">
													<form:option value="${AHO.psb.payStatusNO}">${AHO.psb.payStatus}</form:option>
													<form:options items="${payStatusList}" />
												</form:select></td>

											<td><input type='submit' value="修改" /></td>

											<td><form:input id="orderDate" path="orderDate"
													value="${AHO.orderDate}" type='hidden' readonly="true" /></td>

											<td><form:input id="memberID" path="memberID"
													value="${AHO.mb.memberID}" type='hidden' readonly="true" /></td>
										</form:form>

										<td><input type='button' value="發送付款通知信"
											onclick="javascript:location.href='<c:url value="/hallOrder/mail/${AHO.hallOrderNo}"/>'"
											class="inlog-btn" /></td>
										<%-- 			<td><a href="<c:url value="/hallOrder/mail/${AHO.hallOrderNo}"/>">發送付款通知信</a></td> --%>
									</tr>

								</c:forEach>
							</tbody>
						</table>
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

	<script>
		// var hallOrderStatusNo = "${AHO.hob.hallOrderStatusNo}";
		// var a = $("#no option");

		// console.log(a.val());

		// 	for(i=0 ; i < a.length ; i++){
		// 		console.log(a[i]);
		// 		console.log(a[i].value);
		// 		if(a[i].value == hallOrderStatusNo){
		// 			a[i].attr("selected","true");
		// 		}
		// 	}
	</script>
</body>
</html>
