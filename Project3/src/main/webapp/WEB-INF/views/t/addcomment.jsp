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
<title>Comments</title>
</head>
<body>
	<section>
		<div class="container">
			<h1 style="text-align: center">新增留言</h1>
		</div>
	</section>
	<hr style="height: 1px; border: none; color: #333; background-color: #333;">
	<section class="container">
		<!--       三個地方要完全一樣 -->
		<form:form method='POST' modelAttribute="commentBean" class='form-horizontal'>
			<fieldset >
				
				<div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="movieID">
						電影ID</label>
					<div class='col-lg-10'>
						<form:select id="movieID" path="movieID"
							class='form:input-large' >
							<form:option value = "-1" label = "請挑選"/>
							<form:options items = "${movieList }"/>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="memberID">
						會員ID</label>
					<div class='col-lg-10'>
						<form:select id="memberID" path="memberID"
							class='form:input-large' >
							<form:option value = "-1" label = "請挑選"/>
							<form:options items = "${memberList }"/>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for='watched'>
						已觀賞 </label>
					<div class="col-lg-10">
						 <form:input id="watched" path="watched" type='text'
							class='form:input-large' />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"  for='grade'>
						評分 </label>
					<div class="col-lg-10">
						<form:input id="grade" path="grade" type='text'
							class='form:input-large' />
					</div>
				</div>
				<div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="commentContent">
						短評 </label>
					<div class='col-lg-10'>
						<form:input id="commentContent" path="commentContent" type='text'
							class='form:input-large' />
					</div>
				</div>
				<div class="form-group">
					<label class='control-label col-lg-2 col-lg-2' for="commentTime">
						 </label>
					<div class='col-lg-10'>
						<form:input id="commentTime" path="commentTime" type='hidden'
							class='form:input-large' />
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
	<script>
$("#btnAdd").click(function(){
	var d = new Date();
	$("#commentTime").val(d.getFullYear() + "-" + d.getMonth()+1 + "-" + d.getDate() + " " + d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+".000");
});
</script>
</body>
</html>
