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

<title>AddMovie</title>

</head>
<body>


<div>
<a href='movie/show'> <div> <img class="mySlides P_Bimg" src="HTML/img/5.jpg" ><p>圖片A</p></div></a>


<img class="mySlides P_Bimg" src="HTML/img/6.jpg">
 <img class="mySlides P_Bimg" src="HTML/img/7.jpg" >
 <img class="mySlides P_Bimg" src="HTML/img/8.jpg" >

</div>
	  
	   
	   
		
	
		


		
		<script>
	
		function ThisMovie()
		  {
// 	   var movieID =${};	 
		  
		
//		var release = document.getElementById("release").value;
// 		var release = $("#release").val();
//      var expectedOffDate =$('#expectedOffDate').val();
//      var MustShowDay =$('#MustShowDay').val();
        
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/movie/show",
			data : {movieID: movieID, expectedOffDate: expectedOffDate, MustShowDay: MustShowDay},
			type : "POST",
			success : function() {
				alert("傳送成功");
				window.location.href = "${pageContext.request.contextPath}/index-a";
			}
		});
		  }
		</script>
</body>
</html>


