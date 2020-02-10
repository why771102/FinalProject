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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	 
<title>ShowCommingSoonMovie</title>
  <!-- google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" />
   
  
<style>

  img:hover{
       opacity:0.6;
    }
* {box-sizing: border-box}
body {font-family: Verdana, sans-serif; margin:0}
.mySlides {display: none}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 0s; 
  animation-name: fade;
   animation-duration: 1.5s; 
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}

</style>
</head>
<body>
 <header>
        <!-- header -->
 <jsp:include page="header.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>
</header>
  <!-- header -->
   <!-- banner -->
    <section class="ticket-outer banner-featured" style="margin-top:64px;">
        <div class="container">
            <div class="ticket-sell">
                <h3 class="font"> 即將上映</h3>
            </div>
        </div>
    </section>
    <!-- banner -->
    <!-- movies -->

	
	<section class="grey-bar">
	<div id='movie'> <!-- 最外 -->
        <div class="container">
            <div class="row movies-list">
	
		<c:forEach var="run" items="${rb_page_list}">
			<div class="col-md-3 col-sm-4 col-xs-6"
				onclick='formsubmit(${run.runID})' style='margin:40px 0px;'>
				<div class="movie1">
					<div>
						<!--                         修改處from line 22 to 26 -->
					<img src='<c:url value='/getPicture/${run.movie.movieID}' />'
						width="70%" height="70%">
					</div>
					<div class="m-name">
						<h3>${run.movie.title}</h3>
						<h4>${run.movie.genreBean.genre}</h4>
						<h4>${run.movie.movieRatingBean.rating}</h4>
						
					</div>
				</div>
				<form id='runForm${run.runID}'
					action="${pageContext.request.contextPath}/show/this/movie/commingSoon"
					method="post">

					<input name='runID' type='hidden' value='${run.runID}'>

				</form>
			
			</div>
      </c:forEach>
    
      	  </div>
      </div>
      	  	</div><!-- id =movie最外 -->
      	<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->

	 <!-- movies page -->

	<div id='createPage' style="margin:40px;">
	<table  align='center'>
	<div align='center'>
		<tr>
			<td width='' id='pfirst_tr'><c:if test="${pageNo > 1}">
					<div id="pfirst" values='1' onclick='changePage(this.id)'>第一頁</div>
				</c:if></td>
			<td width='' id='pprev_tr'><c:if test="${pageNo > 1}">
					<div id="pprev" values="${pageNo-1} " onclick='changePage(this.id)'>
						<a>上一頁</a>
					</div>
				</c:if></td>
			<td width='76' align='center'><c:if test="${pageNo != totalPages}">
					<div id="pnext" values='${pageNo+1} ' name='${pageNo+1}'
						onclick='changePage(this.id)'>
						<a>下一頁</a>
					</div>
				</c:if></td>
			<td width='76' align='center'><c:if test="${pageNo != totalPages}">
					<div id="plast" values='${totalPages}'
						onclick='changePage(this.id)'>
						<a>最末頁</a>
					</div>
				</c:if></td>
			
		</tr>

	</table>
	<p id='pageCount'align='center' style="margin:40px;">第${pageNo}頁 /共${totalPages}頁</p>
	</div>
	</div>

 <!-- movies page -->
 
      	
      	
      	
      
      </section>
			<br>
    

    <!-- movies -->

	
  <!--section-->
    <section class="gray-bnr feature-sec">
        <div class="container">
  <div class="container mt-3">

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="${pageContext.request.contextPath}/img/shoppingcart.png" style="width:100%">
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="${pageContext.request.contextPath}/img/shoppingcart.png" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="${pageContext.request.contextPath}/img/shoppingcart.png" style="width:100%">
  <div class="text">Caption Three</div>
</div>

<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>

</div>
  
        </div>
    </section>
  
    <!--section-->
  <!--section-->
  <section class="dark-blue">
        <div class="container">
            <div class="ready">
                <h4>Book Your Tickets Now !</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</p>
                <a href="free-trail.html" class="slider-btn">lETS GET sTARTED</a>
            </div>
        </div>
    </section>
  
  
   <!--section-->
   
   
   
   
   
     <!--footer-->
     <jsp:include page="footer.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>

  <!--footer-->

	<script>
       var b=${rb_list};
// 	   var a=${rb_page_list};
	   var page =${pageNo};
	   var total =${totalPages};
	   console.log(page);
	   console.log(total);
	   var NowPage =1;
	   
	   
	   
	   /*	換下面頁數 */
	   function changPageNum (id){
		   console.log(document.getElementById(id).getAttribute("values"));
			var pageNoChange =document.getElementById(id).getAttribute("values"); 
			NowPage = pageNoChange;
			var pprev =document.getElementById(pprev);
			var pnext =document.getElementById(pnext);
			var plast =document.getElementById(plast);
			var count =document.getElementById(pageCount);
			var pfirst_tr =document.getElementById(pfirst_tr);
			alert("pageNoChange:"+pageNoChange);
			
	
		   
	   }
	   
	   
	   
	   
	   
/*	跳轉選指定電影page */
	   function formsubmit(run){
		  alert("formsubmit");
		  console.log(JSON.stringify(run));
// 		  console.log(run.movie.movieID );
		  document.getElementById("runForm"+run).submit()
   
	   }
	   
	   function formsubmit2(runID){
		   alert("formsubmit2");
		   console.log(runID);
		   document.getElementById("runForm"+runID).submit()
	   }
	   
	   
	   
	   /*ajax changePage */
		function changePage(id) {
			console.log(document.getElementById(id).getAttribute("values"));
			var page =document.getElementById(id).getAttribute("values");
			page =page.trim();
			alert("送出page:"+page);
			 
// 			location.replace("${pageContext.request.contextPath}/commingSoon/All/movie"+page);
//             var url2="${pageContext.request.contextPath}/commingSoon/All/movie"+page;
//             console.log(url2);
// 			$.ajax({
// 						url : url2,
// 						type : "Get",
// 						success : function() {
// 							alert("傳送成功-更新頁數");

// 						}
// 					});
		//	changPageNum (id);
			
			$.ajax({
				url : "${pageContext.request.contextPath}/commingSoon/change/page",
				data : {"page":page},
				type : "POST",
				error: function(){alert("失敗");   },
				success : function(data) {
					
					alert("修改成功"+data);
//  			 	    document.getElementById("movie").remove();
 			 	  var divObj = document.getElementById("movie");
 			 	  var PageObj = document.getElementById("createPage");
 			 	      var a = data;
 			 	      console.log("data"+data);
 			 	     
//  			 	      location.reload();
// 				      divObj.innerHTML ="";
				      alert("修改成功"+data);
				      divObj.innerHTML="";
				      PageObj.innerHTML="";
// 				      $("#movie").append("<div>aaa</div>");
				      $("#movie").append(" <div class='container'>"+
			    	           "<div class='row movies-list' id='moviePlusHere'>"+"</div></div>"+"<br>");
			      //append Json
			      for(let i=0 ;i<a.length;i++){
			    	  
			    	  $("#moviePlusHere").append(
			    			  "<div id='"+a[i].runID+"' class='col-md-3 col-sm-4 col-xs-6'onclick='formsubmit2(this.id)' style='margin:40px 0px;' >"+
			    		  "<div class='movie1'>"+
							"<div>"+
                              //圖片
                               "<img src='<c:url value='/getPicture/"+a[i].movie.movieID+"' />'"+
           						"width='70%' height='70%>" +
							"</div>"+
							"<div class='m-name'>"+
								"<h3>"+a[i].movie.title+"</h3>"+
								"<h4>"+a[i].movie.genreBean.genre+"</h4>"+
								"<a href='' class='movie-btn1'>"+a[i].movie.movieRatingBean.rating+"</a> <a href=''class='movie-btn1'>"+
								"	Thriller</a> <a href='' class='movie-btn1'>Drama</a>"+
							"</div>"+
						"</div>"+
						"<form id='runForm"+a[i].runID+"'action='${pageContext.request.contextPath}/show/this/movie' method='post'>"+
   			       "<input name='runID' type='hidden' value='"+a[i].runID+"'>"+
						"</form>"+
						"<a href='' class='book-now'>[電影訂票]</a>"+
					"</div>");
			    	  
			      }
			      
			      
			     
			      // append create page
			      $("#createPage").append(
			    		  "<table  align='center'>"+
			    		   " <tr>"+
			    		        "<td width='76' id='pfirst_tr'>"+
			    		                "<div id='pfirst'  values='1' onclick='changePage(this.id)'>"+
			    		         " <a>第一頁</a></div>"+
			    		         "  </td>"+
			    		       " <td width='76'>"+
			    		               " <div id='pprev' values='"+(page*1-1)+"' onclick='changePage(this.id)' >"+
			    		                " <a>上一頁</a>"+
			    		               " </div>"+
			    		          " </td>"+
			    		        "<td width='76'>"+
			    		                "<div id='pnext' values='"+(page*1+1)+"' onclick='changePage(this.id)' >"+
			    		                    " <a>下一頁</a>"+
			    		               " </div>"+
			    		           " </td>"+
			    		        "<td width='76'>"+
			    		               " <div id='plast'  values='"+total+"' onclick='changePage(this.id)' >"+
			    		                     "<a>最末頁</a>"+
			    		                "</div>"+
			    		           "</td>"+
			    		       
			    		   " </tr>"+
			    		   
			    		"</table>"  +
			    		   "<p align='center' id='pageCount'>第"+page+"頁 / 共"+total+"頁</p>"
			      
			      );
				      //調整出現
				      if(page == "1"){
				    	  var oneObj = document.getElementById("pfirst");
		 			 	  var pprev = document.getElementById("pprev");
				    	  oneObj.innerHTML="";
				    	  pprev.innerHTML="";
				      }else if(page == total){
				    	  var pnext = document.getElementById("pnext");
				    	  pnext.innerHTML="";
				      }
				      
				      
				    
				    
				}
				   

			});
		}
		
		
			
	//倫波圖Slideshow / Carousel
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace("active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += "active";
}
		
		
	</script>
</body>
</html>

