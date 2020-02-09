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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<title>Expectation</title>
</head>
<body>



	<!--       三個地方要完全一樣 -->
	<form:form method='POST' modelAttribute="ExpectationBean"
		action="${pageContext.request.contextPath}/expectation/add/${run.runID}"
		class='form-horizontal'>
		<fieldset style = "border : 0">
			<div class="expect" style='padding: 30px;text-align:left'>
				<label class="control-label col-lg-2 col-lg-2" for='expective'>
				</label>
				<div>
					<h3>期待這部電影嗎</h3>
					<p class="col-lg-10" style = "display:inline-block">
						<form:radiobutton id="expective" path="expective" value="1" />
						期待
						<form:radiobutton id="expective" path="expective" value="0" />
						不期待
					</p>
					<form:errors path="expective" cssClass="error" />
					<p class='enter' style="padding: 10px 0px 0px 0px ;display:inline-block">
						<input id="btnAdd" type='submit' class='btn btn-primary'
							value="送出" />
					</p>
				</div>
			</div>
<!-- 			<div class="form-group"> -->
				
<!-- 			</div> -->
		</fieldset>
	</form:form>
</body>
</html>
