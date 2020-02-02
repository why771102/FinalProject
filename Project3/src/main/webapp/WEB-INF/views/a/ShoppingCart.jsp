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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css" type="text/css" />
    <style>
        /* CSS reset */
        body,
        div,
        dl,
        dt,
        dd,
        ul,
        ol,
        li,
        h1,
        h2,
        h3,
        h4,
        h5,
        h6,
        pre,
        form,
        fieldset,
        input,
        textarea,
        p,
        blockquote,
        th,
        td {
            margin: 0;
            padding: 0;
        }

        html,
        /* 這邊做初始化設定 全部字體為正黑體  並且字體大小以百分比控制  */
        body {
            margin: 0;
            padding: 0;
            font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
            font-size: 100%;
        }


        /* warp 如何對齊 系列 */

        /* 排版垂直column置中 */
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

        /* 排版垂直column向左 */
        .wrapStart {
            /*Flex屬性區*/
            display: flex;
            flex-flow: column nowrap;
            justify-content: flex-start;
            align-items: flex-start;
            /* border: solid 1px black;
                border-block-end-color: brown; */
            /* 撐開長寬 */
            /* width: 100%; */
            height: 100%;
            /* border and padding in box */
            box-sizing: border-box;
        }

        /* 排版一列row 向左 */
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
            height: 100%;
            /* border and padding in box */
            box-sizing: border-box;
        }


        /* 排版同列row 置中 */
        .wrapRow {
            display: flex;
            flex-flow: row nowrap;
            justify-content: center;
            align-items: center;
        }

        /* in article have padding */
        .wrapList {
            /*Flex屬性區*/
            display: flex;
            flex-flow: column nowrap;
            justify-content: flex-start;
            align-items: flex-start;
            /* border: solid 1px black;
                border-block-end-color: brown; */
            /* 撐開長寬 */
            width: 100%;
            /* height: 100%; */
            /* border and padding in box */
            box-sizing: border-box;
            padding: 1% ;
        }

        /* warp 如何對齊 系列 */

        /* 按鈕 選單系列  */

        select {
            /* background-color: #fc6d6d; */
            color: black;
            padding: 0.5% 4%;
            width: 100%;
            height: 4vh;
            border: solid rgb(34, 34, 34) 1px;
            font-size: 100%;
            /* box-shadow: 0 5px 25px rgba(0, 0, 0, 0.2); */
            -webkit-appearance: button;
            appearance: button;
            outline: none;
            text-align: center;
            border-radius: 5px;
        }

        label {
            width: 100%;
        }


        /* 按鈕 選單系列 */

        #bg {
            width: 100%;
            height: 100%;
        }

        /*  跟header 網頭 有關系列 */
        #head {
            width: 100%;
            height: 90px;
            padding: 10px 0px;
        }

        /*  跟header 網頭 有關系列 */

        #cartShopList {
            width: 90%;
            height: 100%;
        }

        #chooseAll {
            display: flex;
            flex-flow: row nowrap;
            justify-content: center;
            align-items: flex-start;
            width: 100%;
            height: 10%;

        }


        /* 中間內文 */
        #content {
            display: flex;
            flex-flow: row nowrap;
            justify-content: center;
            align-items: flex-start;
            width: 100%;
        }

        /* 中間內文 的左邊 還有 右邊 */
        #product_left {
            width: 50%;
            height: 100%;
        }

        #product_right {
            width: 50%;
            height: 100%;
            padding: 0% 3% 2%;

        }

        /* 跟img 有關系列 */
        #pictureBG {
            /* background-color: #d8d8d8; */
            width: 100%;
            height: 75%;
        }



        .Simg {
            width: 20%;
            height: 50%;
            background-color: #949393;
            padding: 1% 1%;
        }

        /* 跟img 有關系列 */


        /* foot 網頁最底層有關  */
        #footBG {
            background-color: #d8d8d8;
            width: 100%;
            height: 400px;
        }

        /* foot  */

        /* 文字相關大小*/
        p.BTital {
            color: black;
            text-align: left;
            font-size: 4.5vh;
            font-weight: bold;

        }

        p.tital {
            color: black;
            text-align: left;
            font-size: 4vh;
            font-weight: bold;
            width: 100%;
        }

        p.STital {
            color: black;
            text-align: left;
            font-size: 3vh;
            width: 100%;
        }

        p.text {
            color: black;
            text-align: left;
            font-size: 2vh;
            width: 100%;
        }

        /* 文字相關大小*/

        /* map 相關設定 */
        .map {
            width: 100%;
            height: 60vh;
            background-color: cadetblue;
        }

        /* map 相關設定 */


        /*＝＝＝＝＝＝＝新增加的＝＝＝＝＝＝＝＝＝ */

        .Bimg {
            width: 100%;
            height: 80%;
            background-color: #949393;
        }

        div.submitButton {
            /* 送出按鈕 */
            margin: 0px 0px 0px;
            border: none;
            border-radius: 5px;
            background-color: #C21010;
            width: 100%;
            height: 100%;
            color: white;
            font-size: 2.5vh;
            text-align: center;
            padding: 1%;
        }


        .gray_border {
            border-block-end: rgb(179, 179, 179) solid 1px;
        }

        .star_border {
            border-block-start: rgb(179, 179, 179) solid 1px;
        }

        .fullwidth {
            width: 100%;
        }

        .halfwidth {
            width: 50%;
        }
        
        div.deleteProduct{
        	cursor: pointer;
        }
        div.deleteProduct:hover{
        	opacity: 0.6;
        }
    </style>
</head>

<body>
    <header>
        <!-- header -->
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><img src="img/logo-1.png" class="logo-hdr" width="180">
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
 
    <section class="dark-blue">
            <div class="container">
                <div class="ready">
                    <h4>現在就立刻購買！</h4>
                    <p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
                    <a href="free-trail.html" class="slider-btn">前往購票</a>
                </div>
            </div>
        </section>
    <!-- banner -->


    <!-- article -->
    <div class="wrap" style="width: 100%; padding: 5% 5%; ">

        <!-- top  -->
        <div class="wrap gray_border" id="chooseAll" style="display:none; padding: 1%;">
            <input type="checkbox"> <label for=""> 全部選取</label>
        </div>
         <!-- top  -->
         <!-- content  -->
         <div class="wrap" style="width:75%;">
            <!-- all -->
            <div class="wrap fullwidth ">

                <!-- product   -->
                <div class="wrapStart fullwidth"
                    style='border: solid #eeeeef; border-radius: 1%; border-bottom: none;'>
                    <div class="wrapList fullwidth" style="border-bottom: solid #eeeeef; background-color: #e5e5e6; ">
                        <p class="" style='padding:5px;'> 購買的商品</p>
                    </div>
                <!--one block  -->
					<c:forEach items="${shoppingCart}" var="product">
                  <div class="wrapRow fullwidth" style='border-bottom: solid #eeeeef; box-sizing: border-box;'>
                        <!--left  -->
                        <div class="wrapRow " style="width:45%; margin:3% 3%;">
                            <img src="<c:url value='/products/${product.productsBean.productID}' />" style="width:50%; height:50%;" alt="">
                        </div>
                        <!--left  -->
                        <!--right  -->
                        <div class="wrapStart " style='width:45%; margin:5% 5%   '>
                            <div style='margin:5% 0% 2.5% 0%' >商品名稱： ${product.productsBean.productName}</div>
                            <div style='margin:2.5% 0%'>商品數量：
                            <select name="productQuantity" id='productQuantity${product.productsBean.productID}' onchange='selectClick(this)'>
                            	<option value="${product.quantity}" selected="" disabled="">${product.quantity}</option>
                            	<c:forEach begin='1' end='${product.productsBean.unitStock}' var="qty">
                            		<option value="${qty}">${qty}</option>
                            	</c:forEach>
                            </select>
                            </div>
                            
                            <div style='margin:2.5% 0%' id="unitPrice${product.productsBean.productID}">價格：NT$ ${product.productsBean.unitPrice}</div>

                            <div style='padding:2.5% 0% 5% 0%; border-top: solid #eeeeef; width: 100%' id="subT${product.productsBean.productID}">商品小記：NT$ ${product.quantity*product.productsBean.unitPrice} </div>
                        </div>
                        <!--right  -->
                        <!--delete  -->
                        <div class="wrapRow" style='width:10%;'>

                            <div class="deleteProduct" style="margin:1%;" id="delete${product.productsBean.productID}">X</div>
                        </div>
                        <!--delete  -->

                    </div>
					</c:forEach>
                <!--one block  -->
                
                <!--one block  -->
<!--                    <div class="wrapRow fullwidth" style='border-bottom: solid #eeeeef; box-sizing: border-box;'> -->

<!--                         left  -->
<!--                         <div class="wrapRow " style="width:45%; margin:3% 3%;"> -->
<!--                             <img src="img/feature1.jpg" style="width:50%; height:50%;" alt=""> -->
<!--                         </div> -->
<!--                         left  -->
<!--                         right  -->
<!--                         <div class="wrapStart " style='width:45%; margin:5% 5%   '> -->
<!--                             <div style='margin:5% 0% 2.5% 0%'>商品名稱：貓貓貓</div> -->
<!--                             <div style='margin:2.5% 0%'>商品數量：2</div> -->
<!--                             <div style='margin:2.5% 0%' >商品樣式：A</div> -->
<!--                             <div style='margin:5% 0%; border-top: solid #eeeeef; width: 100%'>商品小記：200</div> -->
<!--                         </div> -->
<!--                         right  -->
<!--                         delete  -->
<!--                         <div class="wrapRow" style='width:10%;'> -->

<!--                             <div style="margin:1%;">x</div> -->
<!--                         </div> -->
<!--                         delete  -->

<!--                     </div> -->
                <!--one block  -->

                </div>
                <!-- product   -->
                <br>


                <!-- 結帳明細   -->
                <div class="wrapStart fullwidth "
                    style='border: solid #eeeeef; border-radius: 1%; border-bottom: none; height:100%; '>
                    <div class="wrapList fullwidth"
                        style="border-bottom: solid #eeeeef; background-color: #e5e5e6;">
                        <p class="" style='padding:5px;'> 請選擇付款方式</p>
                    </div>
                    <!--one block  -->
                    <div class="wrapRow fullwidth" style='border-bottom: solid #eeeeef; box-sizing: border-box;'>

                        <!--left  -->
                        <div div class="wrapStart halfwidth" style='margin:5%; '>
                            <div class="wrapRowStart ">
                                <p>商品總計</p>
                                <div class="pay_right" id="cartTotal">NT$ 10,000</div>
                            </div>
                            <div class="wrapRowStart ">
                                <p>運費總計</p>
                                <div class="pay_right">NT$ 60</div>
                            </div>
                            <div class="wrapRowStart ">
                                <p>其他折抵</p>
                                <div class="pay_right">NT$ 0</div>
                            </div>
                            <br>
                            <div class="wrapRowStart " style='border-top: solid #eeeeef; width: 100%'>
                                <p>結帳總金額</p>
                                <div class="pay_right">NT$ 9,500</div>
                            </div>
                        </div>
                        <!--left  -->
                        <!--right  -->
                        <div class="wrapStart " style='width:50%; padding:2% 2%;  background-color: #f7f7f8;
                        box-sizing: border-box;border-radius: 5px;'>
                            <!-- deliver  -->


                            <p>收件資訊</p>
                            <div class="spacingGeneral fullwidth">
                                <div class="fullwidth" style=" border-radius: 5px;background-color: #e5e5e6;padding:5% 2% 5% 2%;">
                                    <p class="spacing_b">姓名</p>
                                    <p class="spacing_b">電話</p>
                                    <p class="spacing_b">地址</p>
                                    <p class="spacing_b">購買人</p>
                                </div>
                                <div class="spacing_top">
                                    <p>運送方式：宅配</p>
                                </div>
                            </div>
                            <div class="memo fullwidth">
                                <p>備註</p>
                                <div class="spacingGeneral fullwidth">
                                    <textarea class="fullwidth" placeholder="給店家的訊息或注意事項" maxlength="200"
                                        onkeyup="autogrow(this);"></textarea>
                                </div>
                            </div>


                            <!-- deliver  -->

                        </div>
                        <!--right  -->


                    </div>
                    <!--one block  -->
                    <!--one block  -->
                    <div class="wrapRow fullwidth" style='border-bottom: solid #eeeeef; box-sizing: border-box;'>

                        <!-- credit card  -->
                        <div class="wrapList fullwidth" style='background-color: #e5e5e6;'>
                            <p class="">新增信用卡快速付款（首次新增送 500 點紅利)</p>
                            <div class="spacingGeneral">
                                <div class="topLine ">
                                    <input type="radio" name="payment" id="convenient7"><label
                                        for="convenient7">信用卡付款</label><br>
                                    <!-- <a href="">
                            <p class="spacing_top" id="pColor" onclick="warn();">+ 新增常用信用卡</p>
                        </a> -->
                                </div>
                            </div>
                            <div class="spacing_top">新增成功後，下次結帳免輸入卡號即可直接付款。新增信用卡時，
                                將會進行一筆 1 元測試交易，此筆款項不會實際扣款，
                                請放心依步驟進行認證。</div>
                            <p class="spacing_top1 text4 spacing_b">其他付款方式</p>
                            <div class="spacingGeneral topLine">
                                <input type="radio" name="payment" id="convenient7"><label for="convenient7">7-11
                                    ibon代碼繳費</label><br>
                                <input type="radio" name="payment" id="convenient_family"
                                    class="spacing_top1"><label for="convenient_family"
                                    class="spacing_top1">全家代碼繳費</label><br>
                                <input type="radio" name="payment" id="atm" class="spacing_top1"><label
                                    for="atm">ATM
                                    轉帳繳費</label><br>
                                <input type="radio" name="payment" id="linepay" class="spacing_top1"><label
                                    for="linepay">LINE
                                    Pay</label><br>
                            </div>
                        </div>
                        <!-- credit card  -->


                    </div>
                    <!--one block  -->
                    <div class="wrapRow fullwidth" style="height:50px; border-bottom: solid #eeeeef;">
                        <div class='free-trial-btn '><a href="free-trail.html" >確定購買 </a></div>
                        
                    </div>


                </div>
                <!-- 結帳明細   -->


            </div>
        </div>
        <!-- content  -->






    
    </div>
    <!-- article -->

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
        <p>Created By: <a href=>Teamwork</a></p>
    </div>
    <!-- footer -->

    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="js/bootstrap.min.js"></script>

    <!-- scripts-->
    <script defer src="js/jquery.flexslider.js"></script>
	<script>
	
	var sc = ${shoppingCartJSON};
	console.log(sc);
	
	
	$(window).load(function () {
        $('.flexslider').flexslider({
            animation: "fade",
            start: function (slider) {
                $('body').removeClass('loading');
            }
        });
        //calculate total of each product
        for(let product = 0; product < sc.length; product++){
        	var sbT = "#subT"+sc[product].productsBean.productID;

        	//when products load calculate each products subtotal
        	var oldtotal = sc[product].quantity*sc[product].productsBean.unitPrice;
        	let oldsubtotal = new Number(oldtotal).toLocaleString("en-AU");
        	$(sbT).text("商品小記：NT$ " + oldsubtotal);
        }
    });

	
	//delete product from shopping cart
	 function del(orderID, productID){
		 console.log(orderID, productID);
		 $.ajax({
				url : "${pageContext.request.contextPath}/deleteProduct",
				data : {orderID: orderID, productID: productID},
				type : "POST",
				success : function() {
					alert("傳送成功");
					window.location.href = "${pageContext.request.contextPath}/index-a";
				}
			});
	 }
	
	
	//calculating the subtotal of a product
	function selectClick(myObj) {
    	//get id of drop-down list e.g.#productQuantity26
    	var pdQty = "#" + myObj.id;
    	//get #productQuantity
        var productQty = pdQty.substring(0, pdQty.length-1);
        //get number in id e.g. #productQuantity26 ==> 26
        //which is also the index for pObj[]
        var index = pdQty.substring(productQty.length-1, pdQty.length);
      //calculate new product total
        newPTotal = newQty(productQty, index);
        
        var unitP = "#unitPrice"+index;
        var price = $(unitP).text().substring(7, $(unitP).text().length);
        var subT = "#subT"+index;
        var newsubtotal = $(pdQty).val()*price;
        let Psubtotal = new Number(newsubtotal).toLocaleString("en-AU");
        console.log($(pdQty).val());
        console.log(Psubtotal);
        console.log($(subT).text());
        $(subT).text("商品小記：NT$ " + Psubtotal);
	}
	
	function newQty(productQty, index){
		//新修改的數量
        let newP = [];
        var newPTotal = 0;
        //跑迴圈計算更改新數量後的金額
        //舊數量的金額計算後
        for(let p = 0; p < sc.length; p++){
        	
        }
	}

$(cartTotal)
	</script>
</body>
</html>