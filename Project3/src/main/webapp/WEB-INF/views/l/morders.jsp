<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Movies</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>電影上映清單</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
          <c:forEach var='Movie' items='${Movies}'>
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                    <div class="caption">
                        <p>
<%--                             <a href='/morders/${runid}' style='font-size: 16px;'>電影ID:${Movie.movieID}</a> --%>
                       		 <b  style='font-size: 16px;'>編號:${Movie.runID}</b>
                       		 
                        </p>
                       <p>
>
                       		 <a  href='/morders2' style='font-size: 16px;'>電影名稱:${Movie.movie.title}<span id="title"></span></a>
                       		 
                        </p>
                        <p>
>
                       		 <b  style='font-size: 16px;'>電影ID:<span id="movieid">${Movie.movie.movieID}</span></b>
                       		 
                        </p>
                        <p>
>
                       		 <b  style='font-size: 16px;'>實際播放天數:${Movie.onDate}</b>
                       		 
                        </p>
                        <p>
<%--                         <a href="<spring:url value='/product?id=${Movie.productID}' />" --%>
<!--     							class="btn btn-primary"> -->
<!--     							<span class="glyphicon-info-sigh glyphicon"></span>詳細資料 -->
<!--  							</a></p> -->
                   </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>

    
</body>
</html>
    