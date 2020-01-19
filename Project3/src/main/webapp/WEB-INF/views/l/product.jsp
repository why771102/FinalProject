<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body> 
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>產品資料</h2>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>產品ID:${Product.productID}</h3>
				<p>分類: ${Product.category.categoryID}</p>
				<p>單價: ${Product.unitPrice}</p>
				<p>產品名稱: ${Product.productName}</p>
				<p>產品庫存: ${Product.unitStock}</p>
				<p>
					<strong>商品成本: </strong> <span class='label label-warning'>
						${Product.cost} </span>
				</p>
				<p>
					<a href="<spring:url value='/products' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>返回
					</a> 
					<a href="<spring:url value='/update/products/${Product.productID}' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>修改
					</a> 
					
				</p>
			</div>
		</div>
	</section>
</body>
</html>
