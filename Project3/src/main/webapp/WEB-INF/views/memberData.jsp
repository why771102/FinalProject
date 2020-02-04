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
	
<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">

<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
</style>

<title>會員資料</title>
</head>
<body>
    <header>
       <jsp:include page="a/header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>會員資料</h2>
				<div class="login-form">
					<table>
						<form:form method='POST' modelAttribute="mData"
							enctype="multipart/form-data">

							<tr>
								<td>會員姓名：</td>
								<td><form:input id="name" path="name" type='text' /></td>
							</tr>
							<tr>
								<td>信箱：</td>
								<td><form:input id="email" path="email" type='text' /></td>
							</tr>
							<tr>
								<td>生日：</td>
								<td>${mData.birth}</td>
							</tr>
							<tr>
								<td>性別：</td>
								<td>${mData.gender}</td>
							</tr>
							<tr>
								<td>身分證字號：</td>
								<td>${mData.uID}</td>
							</tr>

							<tr>
								<td>連絡電話：</td>
								<td><form:input id="mobile" path="mobile" type='text' /></td>
							</tr>

							<tr>
								<td>住址：</td>
								<td><form:input id="address" path="address" type='text' /></td>
							</tr>
							<tr>
								<td><form:input id="memberID" path="memberID" type='hidden' /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="修改資料" class="inlog-btn" /></td>
							</tr>
						</form:form>
							<tr>
								<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/' />'" class="inlog-btn"/></td>
							</tr>
					</table>
				</div>
			</div>
		</div>
	</section>
	
	<!-- footer -->
    <footer class="footer">
        <div class="container">
            <div class="row responsiv-div2">
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>關於我們</h4>
                        <ul class="list-unstyled">
                            <li><a href="">公司簡介</a>
                            </li>
                            <li><a href="">企業理念</a>
                            </li>
                            <li><a href="">影廳介紹</a>
                            </li>
                            <li><a href="">電影院設備</a>
                            </li>
                            <li><a href="">相關設施</a>
                            </li>
                          

                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>其他項目</h4>
                        <ul class="list-unstyled">
                          
                            <li><a href="">線上周邊</a>
                            </li>
                            <li><a href="<c:url value='/hallOrder/apply' />">包場服務</a>
                            </li>
                            <li><a href="">餐飲服務</a>
                            </li>
                            <li><a href="">其他</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner contect-f">
                        <h4>聯絡我們</h4>
                        <ul class="list-unstyled">
                            <address>線上客服 <br> 12345 India</address>
                            <br>
                            <li>01 23 456 789</li>
                            <li class="f-link"><a href="">contact@cineshow.fr</a>
                            </li>
                            <br>

                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-xs-6">
                    <div class="f-inner">
                        <h4>告訴我們您的建議</h4>
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
                <h4> Copyrights 2020.01.26 | <a href="#">10.3.7</a></h4>
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
        <p>Created By: <a href= >Teamwork</a></p>
    </div>
    <!-- footer -->

</body>
</html>
