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

<title>包廳申請</title>

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
                        <li class="free-trial-btn"><a href="<c:url value='/member/logout' />">登出</a>
                            
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
				<h2>包廳申請</h2>
				<div class="login-form">
					<table>

						<form:form method='POST' modelAttribute="hallOrderBean"
							enctype="multipart/form-data">

							<fieldset>

								<tr>
									<td>租借日期:</td>
									<td><form:input id="date" path="orderDate" type='date' /></td>
								</tr>

								<tr>
									<td>租借起始時間:</td>
									<td><form:select id="startTime" path="startTime">
											<form:option value="-1">請選擇</form:option>
											<form:option value="09:00">09:00</form:option>
											<form:option value="10:00">10:00</form:option>
											<form:option value="11:00">11:00</form:option>
											<form:option value="12:00">12:00</form:option>
											<form:option value="13:00">13:00</form:option>
											<form:option value="14:00">14:00</form:option>
											<form:option value="15:00">15:00</form:option>
											<form:option value="16:00">16:00</form:option>
											<form:option value="17:00">17:00</form:option>
											<form:option value="18:00">18:00</form:option>
											<form:option value="19:00">19:00</form:option>
											<form:option value="20:00">20:00</form:option>
											<form:option value="21:00">21:00</form:option>
											<form:option value="22:00">22:00</form:option>
											<form:option value="23:00">23:00</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>租借結束時間:</td>
									<td><form:select id="endTime" path="endTime">
											<form:option value="-1">請選擇</form:option>
											<form:option value="09:00">09:00</form:option>
											<form:option value="10:00">10:00</form:option>
											<form:option value="11:00">11:00</form:option>
											<form:option value="12:00">12:00</form:option>
											<form:option value="13:00">13:00</form:option>
											<form:option value="14:00">14:00</form:option>
											<form:option value="15:00">15:00</form:option>
											<form:option value="16:00">16:00</form:option>
											<form:option value="17:00">17:00</form:option>
											<form:option value="18:00">18:00</form:option>
											<form:option value="19:00">19:00</form:option>
											<form:option value="20:00">20:00</form:option>
											<form:option value="21:00">21:00</form:option>
											<form:option value="22:00">22:00</form:option>
											<form:option value="23:00">23:00</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>選擇影廳:</td>
									<td><form:select path="hallID" id="hallID">
											<form:option value="-1">
									請選擇
								</form:option>
											<form:options items="${hallList}" />
										</form:select></td>
								</tr>
								<tr>
									<td>包廳總時數:</td>
									<td><form:input id="orderHours" path="orderHours"
											type='text' readonly="true" /></td>
								</tr>
								<tr>
									<td>包廳目的:</td>
									<td><form:select id="hallPurpose" path="hallPurpose">
											<form:option value="-1">請選擇</form:option>
											<form:option value="求婚">求婚</form:option>
											<form:option value="企業包場">企業包場</form:option>
											<form:option value="片商活動">片商活動</form:option>
											<form:option value="其他">其他</form:option>
										</form:select></td>
								</tr>
								<tr>
									<td>原因詳述:</td>
									<td><form:textarea cols="30" rows="5"
											name="hallPurposeDetail" path="hallPurposeDetail"
											type='textarea'></form:textarea></td>
								</tr>
								<tr>
									<td>預估包廳總金額:</td>
									<td><form:input id="hallSubtotal" path="hallSubtotal"
											type='text' readonly="true" /></td>
								</tr>
								<tr>
									<td>連絡人:</td>
									<td><form:input id="contactPerson" path="contactPerson"
											type='text' /></td>
								</tr>
								<tr>
									<td>連絡電話:</td>
									<td><form:input id="mobile" path="mobile" type='text' /></td>
								</tr>
								<tr>
									<td>電子郵件:</td>
									<td><form:input id="mail" path="mail" type='text' /></td>
								</tr>
								<tr>
									<td><form:input id="hallOrderStatusNo"
											path="hallOrderStatusNo" value="0" type='hidden' /></td>
								</tr>
								<tr>
									<td><form:input id="payStatusNo" path="payStatusNo"
											value="0" type='hidden' /></td>
								</tr>
								<tr>
									<td colspan="2"><input type='submit' value="送出申請" class="inlog-btn" /></td>
<%-- 									<td><a href="<c:url value='/'/>" class="inlog-btn" >回首頁</a></td> --%>
								</tr>
							</fieldset>
						</form:form>
								<tr>
									<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/'/>'" class="inlog-btn"/></td>
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
                            <li><a href="">包場服務</a>
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
		var s;
		var e;
		var h;

		$("#startTime").change(function() {
			s = $("#startTime").val().substring(0, 2);
			$("#endTime").change(function() {
				e = $("#endTime").val().substring(0, 2);
				$("#hallID").change(function() {
					h = $("#hallID").val();
					if (s != null && e != null && h != null) {
						var s2 = parseInt(s);
						var e2 = parseInt(e);
						var hours = e2 - s2;
						var price;
						if (h == "A" || h == "B" || h == "C" || h == "D") {
							price = parseInt("80000");
						} else {
							price = parseInt("40000");
						}
						var st = (hours) * price;
						if (hours <= 0) {
							alert("時間輸入有誤!請重新輸入");
							$("#orderHours").val("時間輸入有誤");
							$("#hallSubtotal").val("0");
						} else {
							$("#orderHours").val(hours);
							$("#hallSubtotal").val(st);
						}
					}
				});
				if (s != null && e != null && h != null) {
					var s2 = parseInt(s);
					var e2 = parseInt(e);
					var hours = e2 - s2;
					var price;
					if (h == "A" || h == "B" || h == "C" || h == "D") {
						price = parseInt("80000");
					} else {
						price = parseInt("40000");
					}
					var st = (hours) * price;
					if (hours <= 0) {
						alert("時間輸入有誤!請重新輸入");
						$("#orderHours").val("時間輸入有誤");
						$("#hallSubtotal").val("0");
					} else {
						$("#orderHours").val(hours);
						$("#hallSubtotal").val(st);
					}
				}
			});
			if (s != null && e != null && h != null) {
				var s2 = parseInt(s);
				var e2 = parseInt(e);
				var hours = e2 - s2;
				var price;
				if (h == "A" || h == "B" || h == "C" || h == "D") {
					price = parseInt("80000");
				} else {
					price = parseInt("40000");
				}
				var st = (hours) * price;
				if (hours <= 0) {
					alert("時間輸入有誤!請重新輸入");
					$("#orderHours").val("時間輸入有誤");
					$("#hallSubtotal").val("0");
				} else {
					$("#orderHours").val(hours);
					$("#hallSubtotal").val(st);
				}
			}

		});
	</script>
</body>
</html>
