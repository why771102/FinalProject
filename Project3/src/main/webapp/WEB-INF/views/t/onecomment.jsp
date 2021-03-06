<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Comment</title>
</head>
<body> 
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>留言</h2>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>電影ID:${CommentBean.movieBean.title}</h3>
				<p>會員ID: ${CommentBean.memberBean.account}</p>
				<p>
					<strong>評分等級: </strong> <span class='label label-warning'>
						${CommentBean.grade} </span>
				</p>				
				<p>已觀賞: ${CommentBean.watched}</p>
				<p>短評內文: ${CommentBean.commentContent}</p>
				<p>時間: ${CommentBean.commentTime}</p>
				<p>
					<a href="<spring:url value='/findAllComment' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>返回
					</a> 
					<a href="<spring:url value='/update/comment/${CommentBean.commentID}' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>修改
					</a> 
					<a href="<spring:url value='/comments/delete/${CommentBean.commentID}' />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span>刪除
					</a> 
					
				</p>
			</div>
		</div>
	</section>
</body>
</html>
