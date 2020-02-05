<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- title -->
    <title>Cineshow</title>
    <!-- google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/flexslider.css" type="text/css"/>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <link rel="stylesheet" href="css/responsive.css" type="text/css" />
    <style>
    
    	img:hover{
    		opacity: 0.6;
    	}
		#cateName a:hover {
  			color: red;
		}
    </style>
</head>

<body>
    <!-- header -->
	<header>
       <jsp:include page="header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
	<!-- header -->

    <!-- banner -->
    <section class="ticket-outer banner-featured">
        <div class="container">
            <div class="ticket-sell">
                <h3 class="font">- - 電影周邊 - -</h3>
            </div>
        </div>
    </section>
    <!-- banner -->

    <section class="grey-bar">
        <div class="container">
            <div class="row movies-list" id="movies-list">
 
            <c:forEach items="${product}" var="pd">
                <div class="col-md-3 col-sm-4 col-xs-6">
                        
                    <div class="movie1">
                    
                        <div id="image">
                        <a href="<c:url value='/categoryProducts/${pd.categoriesBean.categoryID}' />">
                            <img src="<c:url value='/products/${pd.productID}' />">
 						</a>
                        </div>
                   
                        <div class="m-name" id="cateName">
                        <a href="<c:url value='/categoryProducts/${pd.categoriesBean.categoryID}' />">
                            <h3>${pd.categoriesBean.categoryName}</h3>    
                        </a>                       
                        </div>
                        
                    </div>
                        
                        <div>
                            <br>
                        </div>
                </div>
                </c:forEach>

    <section class="gray-bnr feature-sec">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="ipad-bg">
                        <img src="img/ipad-bg.png">
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="ex-feature">
                        <h6>Cineshow</h6>
                        <h1>features</h1>
                        <ul>
                            <li>Sed ut perspiciatis </li>
                            <li>Sed ut perspiciatis unde omnis iste natus error</li>
                            <li>Sed ut perspiciatis unde omnis iste natus error</li>
                            <li>Lorem ipsum dolor sit amet consectetur</li>
                            <li>Sed ut perspiciatis unde omnis iste natus</li>
                            <li>Sed ut perspiciatis unde omnis iste natus</li>
                            <li>Lorem ipsum dolor sit amet</li>
                            <li>Sed ut perspiciatis unde omnis </li>
                            <li>Lorem ipsum dolor sit amet consectetur</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="dark-blue">
        <div class="container">
            <div class="ready">
                <h4>Book Your Tickets Now !</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor</p>
                <a href="free-trail.html" class="slider-btn">lETS GET sTARTED</a>
            </div>
        </div>
    </section>

    
   <!-- footer -->
    <footer>

       <jsp:include page="footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->
     <div class="premium-tagline">
        <p>Created By: <a href="https://www.premium-themes.co/" target="_blank">Premium Themes</a></p>
    </div>
    <!-- footer -->

    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="js/bootstrap.min.js"></script>
<script>

</script>

</body>
</html>