<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- title -->
    <title>Cineshow</title>
    <!-- google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" />
    <style>
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
             top:40%;
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
   
<!-- 輪播圖carousel -->
    <section class="gray-bnr feature-sec" style='background:black;'>
       <div class="wrapRowStart" style=' width: 100%; ' >
       
       
                 
                   
                <div class="wrap" >
              
                         <div class="mySlides ">
                         
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0006_圖層 3.jpg" style="width:100%; padding:0px 200px;">
                        </div>
                      
                        <div class="mySlides">
                       
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0000_圖層 10.jpg" style="width:100%; padding:0px 200px;">
                        </div>
                      
                        <div class="mySlides">
                         
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0004_圖層 4.jpg"style="width:100%; padding:0px 200px;">
                        </div>
                          
                        <div class="mySlides">
                          
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0003_圖層 7.jpg" style="width:100%; padding:0px 200px;">
                        </div>
                      
                        <div class="mySlides">
                         
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0002_圖層 8.jpg"  style="width:100%; padding:0px 200px;">
                        </div>
                          
                        <div class="mySlides">
                         
                          <img src="${pageContext.request.contextPath}/img/sliderIMG_0001_圖層 9.jpg"  style="width:100%; padding:0px 200px;">
                        </div>
                    </div>     
       <a class="prev" onclick="plusSlides(-1)">❮</a>                       
   <a class="next" onclick="plusSlides(1)">❯</a>

        </div>
    </section>
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
</body>
</html>