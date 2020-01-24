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
          <c:forEach var='MovieID' items='${AllMovies}'>
            <div class="col-sm-6 col-md-3" style="width: 200px; height: 100px">
                <div class="thumbnail" style="width: 200px; height: 100px">
                    <div class="caption">
                       
                       <p>
                       		 <a  href='queryStartTime/${MovieID.runID}'>電影名稱:${MovieID.movie.title}</a>
                     		
							
							
                       </p>
                       <p>
                       		 <b  >RUNID:${MovieID.runID}</b>
                     	</p>
                        <p>
                       		 <b  >電影分類:${MovieID.movie.movieRatingBean.movieRatingID}</b>
                     	</p>
						
                   </div>
                </div>
            </div>
        </c:forEach>
        </div>
         </section>
<script>
$("#sumit1").click(function(){
	var d = new Date();
	$("#NowTime").val(d.getFullYear() + "-" + d.getMonth()+1 + "-" + d.getDate() + " " + d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+".000");
});
</script>
</body>
</html>
    