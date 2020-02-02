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
    <title>cineshow</title>
    <!-- google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css" type="text/css" />
    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="js/bootstrap.min.js"></script>
</head>

<body>
    <header>
        <!-- header -->
        <nav class="navbar navbar-default navbar-static-top my-navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed my-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="img/logo-1.png" class="logo-hdr" width="180">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse my-nav-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="index.html">home</a>
                        </li>
                        <li><a href="latest.html">即將上映</a>
                        </li>
                        <li><a href="latest.html">熱映中</a>
                        </li>
                        <li><a href="up-coming.html">購票</a>
                        </li>
                        <li><a href="conatct.html">contact</a>
                        </li>
                        <li><a href="products.html">周邊商品</a>
                        </li>
                        <li><a href="login-page.html">登入</a>
                        </li>
                        <li><a href="shopCart.html" style='padding:5px;'><img src="img/shoppingcart.png" alt="" srcset=""width='25' height='20'style='position:relative;'></a>
                        </li>
                        <li class="free-trial-btn"><a href="free-trail.html">free trial</a>
                            
                        </li>
                        <li>
                            <select>
                                <option>中文</option>
                                <option>ENG</option>
                            </select>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </header>
    <!-- header-->

    <!-- slider -->
    <section class="slider-sec">
        <section class="slider">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <div class="slide-inner slide-1">
                            <div class="overlay-slider"></div>
                            <div class="container">
                                <div class="row resp-row">
                                    <div class="col-sm-5 col-xs-6 pull-left">
                                        <div class="slide-con">
                                            <h5>Fast Online</h5>
                                            <h4>SEAT BOOKINGS<br> </h4>
                                            <a href="free-trail.html" class="slider-btn">BOOK NOW</a>
                                        </div>
                                    </div>
                                    <div class="col-sm-7 col-xs-6 pull-right">
                                        <div class="sd-left-img">
                                            <img src="" alt="" class="img-responsive">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="slide-inner slide-2">
                            <div class="overlay-slider"></div>
                            <div class="container">
                                <div class="row resp-row">
                                    <div class="col-sm-5 col-xs-6 pull-left">
                                        <div class="slide-con">
                                            <h5>Fast Online </h5>
                                            <h4>SEAT BOOKINGS</h4>
                                            <a href="free-trail.html" class="slider-btn">BOOK NOW</a>
                                        </div>
                                    </div>
                                    <div class="col-sm-7 col-xs-6 pull-right">
                                        <div class="sd-left-img">
                                            <img src="" alt="" class="img-responsive">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="slide-inner slide-3">
                            <div class="overlay-slider"></div>
                            <div class="container">
                                <div class="row resp-row">
                                    <div class="col-sm-5 col-xs-6 pull-left">
                                        <div class="slide-con">
                                            <h5>Fast Online </h5>
                                            <h4>SEAT BOOKINGS</h4>
                                            <a href="free-trail.html" class="slider-btn">BOOK NOW</a>
                                        </div>
                                    </div>
                                    <div class="col-sm-7 col-xs-6 pull-right">
                                        <div class="sd-left-img">
                                            <img src="" alt="" class="img-responsive">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>

                </ul>
            </div>
        </section>
    </section>
    <!-- slider-->

    <section class="grey-bar">
        <div class="container">
            <div class="row responsiv-div1">
                <div class="col-sm-4 col-xs-4">
                    <div class="serv-box">
                        <span>
                        	<img src="img/icon-1.png">
                        </span>
                        <h4>BOOKING SYSTEM</h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam </p>
                    </div>
                </div>
                <div class="col-sm-4 col-xs-4">
                    <div class="serv-box">
                        <span>
                        	<img src="img/icon-2.png">
                        </span>
                        <h4>MOVIES IMPORTER</h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam </p>
                    </div>
                </div>
                <div class="col-sm-4 col-xs-4">
                    <div class="serv-box">
                        <span>
                        	<img src="img/icon-3.png">
                        </span>
                        <h4>CINEMA LOCATIONS</h4>
                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam </p>
                    </div>
                </div>


            </div>
        </div>
    </section>



    <div class="ser-list">
        <div class="container">
            <div class="row">

                <div class="col-sm-4">
                    <ul class="nav nav-tabs list-items">
                        <li class="arrow_box active"><a data-toggle="tab" href="#1">Session Management</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#2">Reserved Seating</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#3">Clickable Sector Maps</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#4">Visual Mapping</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#5">Cinema Booking</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#6">Stadium Mapping</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#7">Seat Booking</a>
                        </li>
                        <li class="arrow_box"><a data-toggle="tab" href="#8">Others</a>
                        </li>
                    </ul>
                </div>

                <div class="col-sm-8">

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane fade active in" id="1">
                            <div class="tab-data-info">
                                <img src="img/tab-image.png">
                                <h5>Session Management</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat voluptas sit. 
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="2">
                            <div class="tab-data-info">
                                <img src="img/tab-image-1.jpg">
                                <h5>Reserved Seating</h5>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="3">
                            <div class="tab-data-info">
                                <img src="img/tab-image-2.jpg">
                                <h5>Clickable Sector Maps</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat voluptas sit.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="4">
                            <div class="tab-data-info">
                                <img src="img/tab-image-3.jpg">
                                <h5>Visual Mapping</h5>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="5">
                            <div class="tab-data-info">
                                <img src="img/tab-image-1.jpg">
                                <h5>Cinema Booking</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat voluptas sit.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="6">
                            <div class="tab-data-info">
                                <img src="img/tab-image-2.jpg">
                                <h5>Stadium Mapping</h5>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="7">
                            <div class="tab-data-info">
                                <img src="img/tab-image-3.jpg">
                                <h5>Seat Booking</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat voluptas sit.
                                </p>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="8">
                            <div class="tab-data-info">
                                <img src="img/tab-image.png">
                                <h5>Other</h5>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia.
                                </p>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>



    <section class="ticket-outer">
        <div class="container">
            <div class="ticket-sell">
                <div class="row clearfix">
                    <div class="col-sm-6 pull-left">
                        <div class="tc-con">
                            <h5>Take control of your </h5>
                            <h3>Ticket Selling</h3>
                            <ul class="list-unstyled">
                                <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore</li>
                                <li>Lorem ipsum dolor sit amet, consectetur</li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.</li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore</li>
                                <li>Lorem ipsum dolor sit amet, consectetur</li>
                            </ul>
                            <a href="free-trail.html" class="slider-btn slider-g-btn">lETS GET sTARTED</a>
                        </div>
                    </div>

                    <div class="col-sm-6 pull-right">
                        <div class="tc-girl">
                            <img src="img/tc-girl1.png">
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="question">
            <h3>Have any Questions in mind?</h3>
            <div class="row">
                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">1.</div>
                        <div class="qa-right pull-right">
                            <h4>What is Cineshow?</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vulputate, augue nec malesuada iaculis, mauris tortor tincidunt mi, non molestie odio dui quis sem. Etiam nec dui sed metus iaculis sagittis. Donec ullamcorper, augue nec mollis </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">2.</div>
                        <div class="qa-right pull-right">
                            <h4>Why use Cineshow?</h4>
                            <p>Maecenas viverra placerat arcu, ut elementum mauris. Aenean sed ligula at mi euismod rutrum. Curabitur at malesuada mauris, in commodo felis. Etiam in nisi ac orci blandit placerat nec sed ipsum. Phasellus consequat dolor ex, quis eleifend sem ultrices a. Phasellus et diam lectus. </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">3.</div>
                        <div class="qa-right pull-right">
                            <h4>Who uses Cineshow Cinema?</h4>
                            <p>Cras sed risus ultricies metus ultricies venenatis quis ac libero. Nunc sed auctor mi. Fusce eu nisi suscipit, ornare odio sit amet, iaculis velit. Donec a commodo mauris, eu egestas metus. </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">4.</div>
                        <div class="qa-right pull-right">
                            <h4>How much is Cineshow?</h4>
                            <p>Nunc arcu velit, cursus in dui ac, pharetra cursus libero. Duis eget malesuada orci, in lacinia nulla. Proin auctor mollis mi eu interdum. Phasellus vestibulum felis at auctor consequat.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">5.</div>
                        <div class="qa-right pull-right">
                            <h4>What do i need to start?</h4>
                            <p>Spendisse ipsum arcu, commodo et feugiat eu, pharetra in dui. Sed molestie imperdiet lectus, quis pulvinar erat pellentesque at. Integer consequat sem et mi elementum vehicula. In hac habitasse platea dictumst.</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6">
                    <div class="qa-in clearfix">
                        <div class="num-left pull-left">6.</div>
                        <div class="qa-right pull-right">
                            <h4>What if I need support?</h4>
                            <p>Aliquam faucibus nisi ut nisi hendrerit tincidunt. Cras in massa sodales, faucibus dui sed, molestie leo. Sed id est ultrices elit pharetra tempus quis vitae turpisras sed risus ultricies metus ultricies. </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <section class="dark-blue">
        <div class="container">
            <div class="ready">
                <h4>Book Your Tickets Now!</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor </p>
                <a href="free-trail.html" class="slider-btn slider-g-btn">lETS GET sTARTED</a>
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
    <!--footer-->

    <!-- scripts-->
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript">
     
        $(window).load(function() {
            $('.flexslider').flexslider({
                animation: "fade",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });
        });
    </script>


</body>
</html>