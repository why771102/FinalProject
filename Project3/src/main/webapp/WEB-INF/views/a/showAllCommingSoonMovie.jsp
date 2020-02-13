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
       cursor: pointer;
    }
    .wrap {
                /*Flex屬性區*/
                display: flex;
                flex-flow: column nowrap;
                justify-content: center;
                align-items: center;
                /* border: solid 1px black;
                border-block-end-color: brown; */
                box-sizing: border-box;
            }
            
            .wrapRowStart {
                /*Flex屬性區*/
                display: flex;
                flex-flow: row nowrap;
                justify-content: flex-start;
                align-items: flex-start;
                /* border: solid 1px black;
                border-block-end-color: brown; */
                /* 撐開長寬 */
                width: 100%;
            
                /* border and padding in box */
                box-sizing: border-box;
            }
    

   body {
             font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
              margin: 0;
            }
    
                * {
              box-sizing: border-box;
            }
            
            img {
              vertical-align: middle;
            }
            
            /* Position the image container (needed to position the left and right arrows) */
            .container {
              position: relative;
            }
            
            /* Hide the images by default */
            .mySlides {
              display: none;
            }
            
            /* Add a pointer when hovering over the thumbnail images */
            .cursor {
              cursor: pointer;
            }
            
            /* Next & previous buttons */
            .prev,
            .next {
              cursor: pointer;
              position: absolute;
             top:210%;
              width: auto;
              padding: 16px;
              margin-top: -50px;
              color: white;
              font-weight: bold;
              font-size: 20px;
              border-radius: 0 3px 3px 0;
              user-select: none;
              -webkit-user-select: none;
            }
            
            /* Position the "next button" to the right */
            .next {
              right: 0;
              border-radius: 3px 0 0 3px;
            }
            
            /* On hover, add a black background color with a little bit see-through */
            .prev:hover,
            .next:hover {
              background-color: rgba(0, 0, 0, 0.8);
            }
            
            /* Number text (1/3 etc) */
            .numbertext {
              color: #f2f2f2;
              font-size: 12px;
              padding: 8px 12px;
              position: absolute;
              top: 0;
            }
            
            /* Container for image text */
            .caption-container {
              text-align: center;
              background-color: #222;
              padding: 2px 16px;
              color: white;
            }
            
            .row:after {
              content: "";
              display: table;
              clear: both;
            }
            
            /* Six columns side by side */
            .column {
              float: left;
              width: 16.66%;
            }
            
            /* Add a transparency effect for thumnbail images */
            .demo {
              opacity: 0.6;
            }
            
            .active,
            .demo:hover {
              opacity: 1;
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
     <section class="dark-blue banner-featured" style="margin-top:64px; padding-bottom:0px;">
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
				onclick='formsubmit(${run.runID})' style='margin:5% 0% 18% 0%;'>
				<div class="movie1">
					<div>
						<!--                         修改處from line 22 to 26 -->
					<img src='<c:url value='/getPicture/${run.movie.movieID}' />'
						width="70%" height="100%">
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

	<div id='createPage' style="margin:10% 0% 0% 0%;">
	<table  align='center'>
	<div align='center'>
		<tr>
			<td width='' id='pfirst_tr'><c:if test="${pageNo > 1}">
					<div id="pfirst" values='1' onclick='changePage(this.id)'>第一頁</div>
				</c:if></td>
			<td width='' id='pprev_tr'><c:if test="${pageNo > 1}">
					<div id="pprev" values="${pageNo-1} " onclick='changePage(this.id)'>
						<a style='cursor: pointer;'>上一頁</a>
					</div>
				</c:if></td>
			<td width='76' align='center'><c:if test="${pageNo != totalPages}">
					<div id="pnext" values='${pageNo+1} ' name='${pageNo+1}'
						onclick='changePage(this.id)'>
						<a style='cursor: pointer;'>下一頁</a>
					</div>
				</c:if></td>
			<td width='76' align='center'><c:if test="${pageNo != totalPages}">
					<div id="plast" values='${totalPages}'
						onclick='changePage(this.id)'>
						<a style='cursor: pointer;'>最末頁</a>
					</div>
				</c:if></td>
			
		</tr>

	</table>
	<p id='pageCount'align='center' style="margin:40px;">第${pageNo}頁 /共${totalPages}頁</p>
	</div>
	</div>

 <!-- movies page -->
 
      	
      	
      	
      
      </section>
		
    

    <!-- movies -->


       <!-- carousel -->
 <jsp:include page="carousel.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>
</header>
   <!-- carousel -->







   
   
   
   
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
// 		   console.log(document.getElementById(id).getAttribute("values"));
			var pageNoChange =document.getElementById(id).getAttribute("values"); 
			NowPage = pageNoChange;
			var pprev =document.getElementById(pprev);
			var pnext =document.getElementById(pnext);
			var plast =document.getElementById(plast);
			var count =document.getElementById(pageCount);
			var pfirst_tr =document.getElementById(pfirst_tr);
// 			alert("pageNoChange:"+pageNoChange);
			
	
		   
	   }
	   
	   
	   
	   
	   
/*	跳轉選指定電影page */
	   function formsubmit(run){
// 		  alert("formsubmit");
		  console.log(JSON.stringify(run));
// 		  console.log(run.movie.movieID );
		  document.getElementById("runForm"+run).submit()
   
	   }
	   
	   function formsubmit2(runID){
// 		   alert("formsubmit2");
		   console.log(runID);
		   document.getElementById("runForm"+runID).submit()
	   }
	   
	   
	   
	   /*ajax changePage */
		function changePage(id) {
			console.log(document.getElementById(id).getAttribute("values"));
			var page =document.getElementById(id).getAttribute("values");
			page =page.trim();
// 			alert("送出page:"+page);
			 
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
					
// 					alert("修改成功"+data);
//  			 	    document.getElementById("movie").remove();
 			 	  var divObj = document.getElementById("movie");
 			 	  var PageObj = document.getElementById("createPage");
 			 	      var a = data;
 			 	      console.log("data"+data);
 			 	     
//  			 	      location.reload();
// 				      divObj.innerHTML ="";
// 				      alert("修改成功"+data);
				      divObj.innerHTML="";
				      PageObj.innerHTML="";
// 				      $("#movie").append("<div>aaa</div>");
				      $("#movie").append(" <div class='container'>"+
			    	           "<div class='row movies-list' id='moviePlusHere'>"+"</div></div>"+"<br>");
			      //append Json
			      for(let i=0 ;i<a.length;i++){
			    	  
			    	  $("#moviePlusHere").append(
			    			  "<div id='"+a[i].runID+"' class='col-md-3 col-sm-4 col-xs-6'onclick='formsubmit2(this.id)' style='margin:5% 0% 18% 0%;' >"+
			    		  "<div class='movie1'>"+
							"<div>"+
                              //圖片
                               "<img src='<c:url value='/getPicture/"+a[i].movie.movieID+"' />'"+
           						"width='70%' height='100%>" +
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
		
		
			

		
		
	</script>
	
	    <!-- 輪播圖carousel -->
    <script>
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
              var dots = document.getElementsByClassName("demo");
              var captionText = document.getElementById("caption");
              if (n > slides.length) {slideIndex = 1}
              if (n < 1) {slideIndex = slides.length}
              for (i = 0; i < slides.length; i++) {
                  slides[i].style.display = "none";
              }
              for (i = 0; i < dots.length; i++) {
                  dots[i].className = dots[i].className.replace(" active", "");
              }
              slides[slideIndex-1].style.display = "block";
              dots[slideIndex-1].className += " active";
              captionText.innerHTML = dots[slideIndex-1].alt;
            }
            </script>
<!-- 輪播圖carousel -->
	
</body>
</html>

