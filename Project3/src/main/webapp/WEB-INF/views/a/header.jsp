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
    body{
    	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
    }
    
    .navbar-default .navbar-nav > li.free-trial-btn {
    	margin-left: 13px;
	}
    </style>
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
                    <a class="navbar-brand" href="<c:url value='/movieIndex'/>"><img src="<c:url value='/img/logo-1.png'/>" class="logo-hdr" width="180">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse my-nav-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="<c:url value='/movieIndex'/>">home</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/commingSoon/All/movie1">即將上映</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/AllMovie/show">熱映中</a>
                        </li>
                        <li><a href="up-coming.html">購票</a>
                        </li>
                        <li><a href="conatct.html">contact</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/showAllProducts">周邊商品</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/getShoppingCart" style='padding:5px;'><img src="${pageContext.request.contextPath}/img/shoppingcart.png" alt="" srcset=""width='25' height='20'style='position:relative;'></a>
                        </li>
                        <li class="free-trial-btn btn222" id="login"><a href="<c:url value='/member/login' />">登入</a></li>
                        <li class="btn222" id="register"><a href="<c:url value='/member/register' />">註冊</a></li>
                        <li class="btn222" id="memberCenter"><a href="<c:url value='/memberCenter' />">會員中心</a></li>
                        <li class="free-trial-btn btn222" id="logout"><a href="<c:url value='/member/logout' />">登出</a></li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </header>
    <!-- header-->

   
    <script>
    cookieArray = document.cookie.split("; ");
	console.log(cookieArray);

	for (i = 0; i < cookieArray.length; i++) {
			memberIDArrays = cookieArray[i].split("=");
			console.log(memberIDArrays);
			if (memberIDArrays[0] == "memberID" && memberIDArrays[1] == "" || cookieArray.length == 1 || cookieArray.length == 0) {
// 				$("#name").text("訪客");
				$("#memberCenter").hide();
				$("#logout").hide();
			}else{
// 				for (i = 0; i < cookieArray.length; i++) {
// 				nameArrays = cookieArray[i].split("=");
// 				console.log(nameArrays);
// 				if (nameArrays[0] == "name") {
// 				$("#name").text(nameArrays[1]);
// 				}
// 			}
				$("#register").hide();
				$("#login").hide();
		}
	}
    </script>
</body>
</html>