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
<title>OrderID</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>請輸入OrderID</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
		<!--       三個地方要完全一樣 -->
		<form:form method='POST' modelAttribute="getOrderByID" class='form-horizontal'>
			<fieldset >
							
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for='getOrderByID'>
						OrderID </label>
					<div class="col-lg-10">
						 <form:input id="getOrderByID" path="getOrderByID" type='text'
							class='form:input-large'  />
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
    