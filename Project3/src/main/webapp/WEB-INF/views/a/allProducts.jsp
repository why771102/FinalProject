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
    
    	#image img{
    		border-radius: 25px 25px 0px 0px;
    	}
    	img:hover{
    		opacity: 0.6;
    	}
		#cateName a:hover {
  			color: red;
		}
		
		.movie1{
			border-radius: 25px;
		}
		
		.like-btn {
  			position: absolute;
 			bottom: 27px;
 			right: 16px;
  			background: url('${pageContext.request.contextPath}/img/twitter-heart.png');
  			width: 60px;
  			height: 60px;
  			background-size: 2900%;
  			background-repeat: no-repeat;
		}
		.like-btn:hover{
			cursor: pointer;
		}
		.is-active {
  			animation-name: animate;
 			animation-duration: .8s;
  			animation-iteration-count: 1;
  			animation-timing-function: steps(28);
  			animation-fill-mode: forwards;
		}
		
		@keyframes animate {
  			0%   { background-position: left;  }
 			50%  { background-position: right; }
  			100% { background-position: right; }
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
    <section class="ticket-outer banner-featured" style="margin-top:64px;"> 
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
                        <div class="buttons"><span class="like-btn"></span></div>
                    </div>
                        
                        <div>
                            <br>
                        </div>
                </div>
                </c:forEach>
    </div>
    </div>
</section>
    <section class="dark-blue">
		<div class="container">
			<div class="ready">
				<h4>現在就立刻購買！</h4>
				<p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
				<a href="<c:url value='/movieIndex#booknow'/>" class="slider-btn">前往購票</a>
			</div>
		</div>
	</section>

    
   <!-- footer -->
    <footer>

       <jsp:include page="footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       


    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="js/bootstrap.min.js"></script>
<script>
$('.like-btn').on('click', function() {
	   $(this).toggleClass('is-active');
	});
</script>

</body>
</html>