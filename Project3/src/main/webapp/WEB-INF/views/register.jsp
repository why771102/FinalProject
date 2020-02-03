<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
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
	span{
		color:red;
	}
</style>

<title>會員註冊</title>

</head>
<body>
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
                    <a class="navbar-brand" href="<c:url value='/' />"><img src="../img/logo-1.png" class="logo-hdr" width="180">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse my-nav-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="<c:url value='/' />">home</a>
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
                        <li><a href="shopCart.html" style='padding:5px;'><img src="../img/shoppingcart.png" alt="" srcset=""width='25' height='20'style='position:relative;'></a>
                        </li>
                        <li class="free-trial-btn"><a href="<c:url value='/member/login' />">登入</a>
                            
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
    </header>
    <!-- header-->
	<section class="login-block">
		<div class="container">
			<div class="login-inner">
				<h2>註冊會員</h2>

				<div class="login-form">
					<table>
						<form:form method='POST' modelAttribute="memberBean"
							enctype="multipart/form-data">

							<fieldset>
								<tr>
									<td>姓名:</td>
									<td><form:input id="name" path="name" type='text' /><br>
										<form:errors path="name" cssClass="error" /></td>

								</tr>
								<tr>
									<td>帳號:</td>
									<td><form:input id="account" path="account" type='text' />
									<br>(至少八個字元)
									<br><span class="notice">${errorMsgMap.accountExistError}</span>
									<form:errors path="account" cssClass="error" /></td>
										
								</tr>
								<tr>
									<td>密碼:</td>
									<td><form:input id="password" path="password" type='password' />
									<br>(至少八個字元)
									<br><form:errors path="password" cssClass="error" /></td>
								</tr>
								<tr>
									<td>確認密碼:</td>
									<td><form:input id="checkPassword" path="checkPassword" type='password' /><br>
										<form:errors path="checkPassword" cssClass="error" /><span>${errorMsgMap.checkPasswordError}</span></td>
								</tr>
								<tr>
									<td>性別:</td>
									<td><form:radiobutton path="gender" value="男性" />男性 
										<form:radiobutton path="gender" value="女性" />女性 
										<form:radiobutton path="gender" value="其他" />其他
									</td>
								</tr>
								<tr>
									<td>身分證字號:</td>
									<td><form:input id="uID" path="uID" type='text' />
									<br><span>${errorMsgMap.uIDtExistError}</span>
										<form:errors path="uID" cssClass="error" /></td>
								</tr>
								<tr>
									<td>出生年月日:</td>
									<td><form:input id="birth" path="birth" type='date' /><br>
										<form:errors path="birth" cssClass="error" /></td>
								</tr>
								<tr>
									<td>聯絡電話:</td>
									<td><form:input id="mobile" path="mobile" type='text' /><br>
										<form:errors path="mobile" cssClass="error" /></td>
								</tr>
								<tr>
									<td>email:</td>
									<td><form:input id="email" path="email" type='text' /><br>
										<form:errors path="email" cssClass="error" /></td>
								</tr>
								<tr>
									<td>住址:</td>
									<td><form:input id="address" path="address" type='text' /><br>
										<form:errors path="address" cssClass="error" /></td>
								</tr>
								<tr>
									<td><form:input id="registerTime" path="registerTime"
											value="" type='hidden' /></td>
								</tr>
								<tr>
									<td colspan="2"><input type='submit' id="sumit1" class="inlog-btn" /></td>
								</tr>
							</fieldset>
						</form:form>
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
	<script>
		
		$("#sumit1").click(
				function() {
					var d = new Date();
					$("#registerTime").val(
							d.getFullYear() + "-" + (parseInt(d.getMonth()) + 1 ) + "-"
									+ d.getDate() + " " + d.getHours() + ":"
									+ d.getMinutes() + ":" + d.getSeconds()
									+ ".000");
				});

	</script>
</body>
</html>
