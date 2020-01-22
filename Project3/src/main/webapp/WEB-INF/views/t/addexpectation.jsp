<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<style type="text/css">
fieldset {
	border: 1px solid rgb(255, 232, 57);
	width: 400px;
	margin: auto;
}
</style>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<title>Expectation</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 style="text-align: center">新增期待度</h1>
		</div>
	</section>
	<hr style="height: 1px; border: none; color: #333; background-color: #333;">
	<section class="container">
		<!--       三個地方要完全一樣 -->
		<form:form method='POST' modelAttribute="ExpectationBean" class='form-horizontal'>
			<fieldset >
				
<!-- 				<div class="form-group"> -->
<!-- 					<label class='control-label col-lg-2 col-lg-2' for="movieID"> -->
<!-- 						電影ID</label> -->
<!-- 					<div class='col-lg-10'> -->
<%-- 						<form:select id="movieID" path="movieID" --%>
<%-- 							class='form:input-large' > --%>
<%-- 							<form:option value = "-1" label = "請挑選"/> --%>
<%-- 							<form:options items = "${movieList }"/> --%>
<%-- 						</form:select> --%>
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="form-group"> -->
<!-- 					<label class='control-label col-lg-2 col-lg-2' for="memberID"> -->
<!-- 						會員ID</label> -->
<!-- 					<div class='col-lg-10'> -->
<%-- 						<form:select id="memberID" path="memberID" --%>
<%-- 							class='form:input-large' > --%>
<%-- 							<form:option value = "-1" label = "請挑選"/> --%>
<%-- 							<form:options items = "${memberList }"/> --%>
<%-- 						</form:select> --%>
<!-- 					</div> -->
<!-- 				</div> -->
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for='expective'>
						期待度 </label>
					<div class="col-lg-10">
						 <form:radiobutton id="expective" path="expective" value="1" />期待
						<form:radiobutton id="expective" path="expective" value="0" />不期待
					</div>
				</div>
				<div class="form-group">
					<div class='col-lg-offset-2 col-lg-10'>
						<input id="btnAdd" type='submit' class='btn btn-primary'
							value="送出" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
