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
    <header>
        <!-- header -->
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">aaaaaa</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="img/logo.png" class="logo-hdr" width="180">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html">home</a>
                        </li>
                        <li class="active"><a href="features.html">latest movies</a>
                        </li>
                        <li><a href="pricing.html">pricing</a>
                        </li>
                        <li><a href="up-coming.html">Up coming</a>
                        </li>
                        <li><a href="conatct.html">contact</a>
                        </li>
                        <li><a href="login-page.html">login </a>
                        </li>
                        <li class="free-trial-btn"><a href="free-trail.html">free trial</a>
                        </li>
                        <li>
                            <select>
                                <option>ENG</option>
                                <option>FR</option>
                            </select>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
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
    <footer class="footer">
        <div class="container">
            <div class="row responsiv-div2">
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>About</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Lorem Ipsum</a>
                            </li>
                            <li><a href="">Dolor Sit</a>
                            </li>
                            <li><a href="">Lorem Ipsum</a>
                            </li>
                            <li><a href="">Dolor Sit</a>
                            </li>
                            <li><a href="">Sit Amet</a>
                            </li>
                            <li><a href="">Ipsum Dolor</a>
                            </li>

                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>Other</h4>
                        <ul class="list-unstyled">
                            <li><a href="">Lorem Ipsum</a>
                            </li>
                            <li><a href="">Sit Amet</a>
                            </li>
                            <li><a href="">Dolor Sit</a>
                            </li>
                            <li><a href="">Ipsum Dolor</a>
                            </li>
                            <li><a href="">Lorem Ipsum</a>
                            </li>
                            <li><a href="">Dolor Sit</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner contect-f">
                        <h4>Contact</h4>
                        <ul class="list-unstyled">
                            <address>123 Lorem Ipsum <br> 12345 India</address>
                            <br>
                            <li>01 23 456 789</li>
                            <li class="f-link"><a href="">contact@cineshow.fr</a>
                            </li>
                            <br>
                            <li>01 23 456 789</li>
                            <li class="f-link"><a href="">sales@cineshow.fr</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>Email Alerts</h4>
                        <div class="form">
                            <form>
                                <input type="text" name="nm" class="inp-fild" placeholder="Name">
                                <input type="text" id="mail" name="mail" class="inp-fild" placeholder="Email Address">
                            </form>
                            <button class="footer-btn">Send</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer-line">
                <div class="im-inner">
                    <span></span>
                    <a href="index.html"><img src="img/logo.png" class="ftr-logo" width="200">
                    </a><span></span>
                </div>
                <h4> Copyrights 2016 | <a href="#">Terms of use</a></h4>
                <div class="right-icon">
                    <ul class="list-inline">
                        <li class="fb"><a href="#"><i class="fb fa fa-facebook"></i></a>
                        </li>
                        <li class="twitter"><a href="#"><i class="twitter fa fa-twitter"></i></a>
                        </li>
                        <li class="google"><a href="#"><i class="google fa fa-google-plus"></i></a>
                        </li>
                        <li class="youtube"><a href="#"><i class="youtube fa fa-youtube-play"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
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