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

<div id =father></div>
<div>
    <a href="">
     <div>
         <img src="" alt="">
         <p>${rb_list}</p>
         <p>上映日 2020-02-02</p>
     </div>
</a>
</div>

		<c:forEach var="rb" items="${rb_list}"> 
		<script>
		$(document).ready(function(){
			$("#father").prepend("<div> <a href=""><div><img src="" alt=""><p>${rb_list.movie.title}</p><p>上映日 2020-02-02</p></div></a></div>");
			})	
	   </script>
	   
	   </c:forEach>  
	   
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


