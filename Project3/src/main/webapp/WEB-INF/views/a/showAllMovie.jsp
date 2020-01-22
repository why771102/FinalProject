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

<title>ShowAllMovie</title>

</head>
<body>
<c:forEach var="movie" items="${mb_list}">
 <div class="col-md-3 col-sm-4 col-xs-6">
                    <div class="movie1">
                        <div>
                            <img src="img/feature8.jpg">
                        </div>
                        <div class="m-name">
                            <h3>${movie.title}</h3>
                            <h4>English, Hindi</h4>
                            <a href="" class="movie-btn1">Action</a>
                            <a href="" class="movie-btn1">Thriller</a>
                            <a href="" class="movie-btn1">Drama</a>
                        </div>
                    </div>
                    <a href="" class="book-now">BOOK NOW</a>
                </div>

<br>

<div id="paging">
</c:forEach >
<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="1">
  <tr>
    <td width='76'>
        <c:if test="${pageNo > 1}">
           <div id="pfirst">
              <a href="<c:url value='DisplayPageProducts?pageNo=1' />">第一頁</a>
           </div>
        </c:if>
     </td>
     <td width='76'>
        <c:if test="${pageNo > 1}">
           <div id="pprev">
              <a href="<c:url value='MoviesPageNo=${pageNo-1}' />">上一頁</a>
           </div>
        </c:if>  
     </td>
     <td width='76'>
            <c:if test="${pageNo != totalPages}">
                <div id="pnext">
                   <a href="<c:url value='MoviesPageNo=${pageNo+1}' />">下一頁</a>
                </div>
            </c:if>
     </td>  
     <td width='76'>
            <c:if test="${pageNo != totalPages}">
                <div id="plast">
                    <a href="<c:url value='MoviesPageNo=${totalPages}' />">最末頁</a>
                </div>
            </c:if>
     </td>
     <td width='176' align="center">
                      第${pageNo}頁 / 共${totalPages}頁
     </td>  
</tr>
</table>
</div>

		<script>

	   </script>
	   

	   
	   <script>
//		function ThisMovie()
//		  {
/* 
		  
		
//		var release = document.getElementById("release").value;
// 		var release = $("#release").val();
//      var expectedOffDate =$('#expectedOffDate').val();
//      var MustShowDay =$('#MustShowDay').val();
        
		
/* 		
		$.ajax({
			url : "${pageContext.request.contextPath}/movie/show",
			data : {movieID: movieID, expectedOffDate: expectedOffDate, MustShowDay: MustShowDay},
			type : "POST",
			success : function() {
				alert("傳送成功");
				window.location.href = "${pageContext.request.contextPath}/index-a";
			}
		});
		  } */
		</script>
</body>
</html>


