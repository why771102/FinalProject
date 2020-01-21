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
          <c:forEach var='MovieId' items='${AllMovies}'>
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                    <div class="caption">
                       
                       <p>
                       		 <a  href='morders/${runID}'>電影名稱:${MovieId.title}</a>
                       </p>
<!--                        <p> -->
<!-- > -->
<%-- 						<b  style='font-size: 16px;'>廳別代碼:${MovieId.hall.hallID}</b> --%>
<%-- <%--                        		 <a  href='queryShowTimeID' value='/morders?id=${Movie.runID}' style='font-size: 16px;'>電影名稱:${Movie.movie.title}<span id="title"></span></a> --%> 
                       		 
<!--                         </p> -->
                       
<!--                         <p> -->
<!-- > -->
<%--                        		 <b  style='font-size: 16px;'>播放日期時間:${MovieId.playStartTime}</b> --%>
                       		 
<!--                         </p> -->
<!--                         <p> -->
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
    