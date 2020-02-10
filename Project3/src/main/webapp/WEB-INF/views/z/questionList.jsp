<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- title -->
<title>76影城</title>
<!-- google fonts -->

<link href='https://fonts.googleapis.com/css?family=Lato:400,300,900'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!-- stylesheets -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/flexslider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/responsive.css"
	type="text/css" />
<!-- scripts -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script defer
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<style>
body {
	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
}

html {
	scroll-behavior: smooth;
}

.navbar-default .navbar-nav>li.free-trial-btn {
	margin-left: 13px;
}

header {
	position: fixed;
	width: 100%;
	display: block;
	top: 0;
	transition: top 0.3s;
}
</style>

</head>
<body>
	<header>
		<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</header>




	<section class="contact-sec">
		<div class="container">

			<div class="buy-txt">
				<h1>線上客服</h1>

			</div>

			<div class="row">
				<div class="contact-outer clearfix">
					<div class="col-sm-8 col-xs-8">

						<div class="contact-block">
							<p>服務時間：每日 09:00 ~ 22:00</p>
							<table style="border: 1px solid black;width:100%;">
								<tr class="price-top">
									<td>客服編號</td>
									<td>狀態</td>
									<td></td>
								</tr>
								<c:forEach var="ques" items="${allQuestion}">
									<tr>
										<td>${ques.questionId}</td>
										<td>${ques.questionStatusBean.statusName}</td>
										<td><a href="question/${ques.questionId}">查看</a></td>
									</tr>
								</c:forEach>
							</table>
							<br>
							<br>
							<br>
							<div style="margin-left:0px">
								<a href="question"><button class="snd-msg" type="button">開啟新客服</button></a>
							</div>

						</div>


					</div>
					<div class=" col-sm-4 col-xs-4">
						<div class="call-block">
							<p>服務範圍： 購票相關問題、購物相關問題、帳號異常處理、退票等相關作業。</p>

							<p>請勿傳遞詐欺、誹謗、侮辱、猥褻、騷擾或其他違法之訊息，本服務有權利終止非服務範圍內之訊息傳遞。</p>
							<p>請詳閱 <span style="color:red">個人資料蒐集告知條款暨隱私權保護政策</span>，若繼續使用本服務，則視為已知悉本公司個資法定告知事項及上述之服務要求。</p>
						</div>

					</div>
				</div>

			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="../a/footer.jsp">
			<jsp:param name="a" value="1" />
		</jsp:include>
	</footer>
</body>
</html>
