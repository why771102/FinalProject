<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Comments</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>短評清單</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
          <c:forEach var='comment' items='${Comments}'>
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                    <div class="caption">
                        <p>
                            <b style='font-size: 16px;'>電影ID:${comment.movieBean.movieID}</b>
                        </p>
                        <p>會員ID:${comment.memberBean.memberID}</p>
                        <p>評分等級:${comment.grade}</p>
                        <p>已觀賞:${comment.watched}</p>
                        <p>短評內文:${comment.commentContent}</p>
                        <p>時間:${comment.commentTime}</p>
                        <p>
                        <a href="<spring:url value='/comments/report?id=${comment.commentID}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>檢舉
 							</a></p>
 						<a href="<spring:url value='/comments/report?id=${comment.commentID}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>檢舉
 							</a></p>
 						<a href="<spring:url value='/comments/report?id=${comment.commentID}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>檢舉
 							</a></p>
                        <a href="<spring:url value='/onecomment?id=${comment.commentID}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>詳細資料
 							</a></p>
 						<a href="<spring:url value='/comments/report?id=${comment.commentID}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>檢舉
 							</a></p>
                   </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>
</body>
</html>
    