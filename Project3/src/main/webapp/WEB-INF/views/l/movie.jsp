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
                       		 <a  href='queryStartTimes/${MovieID.runID}'>電影名稱:${MovieID.movie.title}</a>
                     		
							
							
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
<!--           <section class="container"> -->
<!--        		 <div class="row"> -->
<!--  			<b>choose a name</b> -->
<!--  			<select id ="show"></select> -->
 			
<!--        		 </div> -->
<!--          </section> -->

      
<script>
$(document).ready(function()
{
	var title = document.getElementById("MovieID.movie.title").value;
	$.ajax({  
    url: "${pageContext.request.contextPath}/quicklyQueryMovie",
    data : {title: title},
    type : "POST",
    success:function(data){  
         showNames(data);
         }
	});
	
	function showNames(data){
		var txt="";
		for(i in names)
			txt+="<option value='"+names[i]+"'>" +names[i]+"</option>";
			 $("#show").append(txt);
	};
}
</script>
</body>
</html>
    