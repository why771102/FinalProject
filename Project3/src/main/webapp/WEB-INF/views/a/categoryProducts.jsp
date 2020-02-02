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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" />
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
                /* order: solid 1px black;
                border-block-end-color: brown; */
    
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
                padding: 0% 1% 1% 1%;
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
                cursor: pointer;
                
            }
    		.submitButton:hover {
    			background: #FFC0CB;
    		}
    
            .gray_border{
                border-block-end:rgb(179, 179, 179) solid 1px ;
            }
            .star_border{
                border-block-start:rgb(179, 179, 179) solid 1px ;
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

    <!-- banner -->

    
     <!-- article -->
     <div class="wrap" style="width: 100%; padding: 100px 100px; ">
     
            <!-- top  -->
            <div class="wrap gray_border" id="chooseAll" style="display:none;">
                <input type="checkbox"> <label for=""> 全部選取</label>
            </div>
            <!-- content  -->
            <div class="wrapRow" id="content">

                <!-- left  -->
                <div class="wrapStart" id="product_left">

                    <!-- 圖片輪播  -->
                    <div class="wrap" id="pictureBG" style="display:none;">
                        <div class="w3-content wrap" style="width:100%; height:100vh ;">

                            <img class="mySlides Bimg" src="a.jpg" style=" display:none">
                            <img class="mySlides Bimg" src="b.jpg">
                            <img class="mySlides Bimg" src="c.png" style="display:none">
                            <img class="mySlides Bimg" src="c.png" style="display:none">

                            <!-- small picture -->
                            <div class="wrapRow" style="height: 15vh; width: 80%; padding: 2vh;">
                                <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px;">
                                    <img class="demo w3-opacity w3-hover-opacity-off" src="a.jpg"
                                        style="width:100%;  height: 100%;  cursor:pointer" onclick="currentDiv(1)">
                                </div>

                                <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px;">
                                    <img class="demo w3-opacity w3-hover-opacity-off" src="b.jpg"
                                        style="width:100%;  height: 100%;  cursor:pointer" onclick="currentDiv(2)">
                                </div>

                                <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px;">
                                    <img class="demo w3-opacity w3-hover-opacity-off" src="c.png"
                                        style="width:100%;  height: 100%;   cursor:pointer" onclick="currentDiv(3)">
                                </div>

                                <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px;">
                                    <img class="demo w3-opacity w3-hover-opacity-off" src="c.png"
                                        style="width:100%;  height: 100%;   cursor:pointer" onclick="currentDiv(4)">
                                </div>


                            </div>
                            <!-- small picture -->
                        </div>
                    </div>
                    <!-- 圖片輪播  -->
                    <!-- 圖片  -->
                    <div class="wrap" id="pictureBG" >
                        <img src="<c:url value='/products/${productList[0].productID}' />" alt="">
                    </div>
                   
                      
                    <!-- 圖片  -->
                    <!-- 空白排版用 -->
                    <div class="wrapList">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                    <!-- 分隔商品資訊框框 -->
                    
                    <!-- 分隔商品資訊框框 -->

                    <!-- 空白排版用 -->
                    
                    <!-- 空白排版用 -->


                   
                </div>

                <!-- right  -->
                <div class="wrapStart " id="product_right">

                    <div class="wrapList">
                        <p class="tital "> ${productList[0].categoriesBean.categoryName}</p>
                    </div>
                  
                    <div class="wrapList" id="productDetail">
                        <p class="tital" id="price">NT$ </p>
                    </div>
                    <br>
                    <div class="wrapList"> <label for="productType">商品款式
                            <select name="productType" id="productType">
                                <option value="default" selected="" disabled="">請選擇樣式</option>
                                <c:forEach items="${productList}" var="typeOfProduct">
									<option value="${typeOfProduct.productID}">${typeOfProduct.productName}</option>
								</c:forEach>
                            </select>
                        </label>
                    </div>
                   
                    <div class="wrapList "> <label for="productQuantity">數量
							<select name="productQuantity" id="productQuantity">
                     		<option value="default" selected="" disabled="">數量</option>          
                        </select>
                        </label>
                    </div>

                    <div class="wrapList ">
                        <br>
                        
                            <div class="submitButton" id="addToCart" onclick="addToCart()">加入購物車</div>
                    

                    </div>
                    <div class="wrapList gray_border ">
                    <p>付款後，從備貨到寄出商品為 2 個工作天。（不包含假日）
                        設計館提供統一發票或免用統一發票收據</p>
                    </div>

                  

                    <!-- 分隔商品資訊框框 -->
                    <div class="wrapList gray_border" style="display:none;">
                        <div class="wrapList">
                            <p class="STital">關於產品</p>
                            <div class="wrapRow">
                                <div class="wrapStart" style="padding: 0px  100px 0px 0px;">

                                    <p class="text">名稱</p>
                                    <p class="text">產地</p>
                                    <p class="text">材質</p>
                                </div>
                                <div class="wrapStart">
                                    <p class="text">不鏽鋼</p>
                                    <p class="text">商品來源</p>
                                    <p class="text">庫存</p>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- 分隔商品資訊框框 -->
                    <!-- 空白排版用 -->
<!--                     need to be in the middle -->
                    <div class="wrapList" style="display:block;" id="prodDetail">
                    <c:forEach items="${productList}" var="pList">
						<img src="<c:url value='/products/${pList.productID}' />" alt="">
						<c:if test = "${pList.productDescription != 'NULL'}">
							<div id="productDescription">${pList.productDescription}</div>
						</c:if>
					</c:forEach>
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                          <!-- 分隔商品資訊框框 -->
                         
                            <!-- 分隔商品資訊框框 -->
                  

                 


                </div>



            </div>






        </div>
     <!-- article -->

    <section class="dark-blue">
        <div class="container">
            <div class="ready">
                <h4>現在就立刻購買！</h4>
                <p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
                <a href="free-trail.html" class="slider-btn">前往購票</a>
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

    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

 <!-- scripts-->
 <script defer src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
 <script>
 var products = ${prod};
 console.log(products);
 console.log(products.length)
 
 
     $(window).load(function() {
         $('.flexslider').flexslider({
             animation: "fade",
             start: function(slider) {
                 $('body').removeClass('loading');
             }
         });
         //if there are more than one product in this category
         //there should be a price range NT$.. - NT$..
         if(products.length > 1){
         	var lowestprice = 1000000;
         	var highestprice = 0;
         	for(let c = 0; c < products.length; c++){
       	 	 	if(products[c].unitPrice < lowestprice){
        		 	lowestprice = products[c].unitPrice;
        	 	}
        	 	console.log("lowestprice: " + lowestprice);
        	 	if(products[c].unitPrice > highestprice){
        		 	highestprice = products[c].unitPrice;
        	 	}
        	 	console.log("highestprice: " + highestprice);
//         	 	if(products[c].productDescription != "NULL"){
//         	 		document.getElementById("prodDetail").innerHTML += ""
//              		document.getElementById("productDescription").innerText += products[c].productDescription;
//              	}
         	}//end of for
         	document.getElementById("price").innerText += lowestprice + " - NT$" + highestprice;
         	
         }//end of if(products.length > 1)
         else{
        	 document.getElementById("price").innerText += products[0].unitPrice;
         }//end of else
     });//end of $(window).load(function()
     
    //user selects the type of product drop-down list
    //which will change the price and the quantity
     $('#productType').change(function(){
    	 document.getElementById("productQuantity").innerHTML = "";
    	 document.getElementById("productQuantity").prepend("<option value='default' selected='' disabled=''>數量</option>");
    	 document.getElementById("price").innerText = "";
    	 let pdID = $('#productType').val();
    	 for(let index = 0; index < products.length; index++){
    		 if(pdID == products[index].productID){
    			 for(let prdQuantity = 1; prdQuantity<= products[index].unitStock; prdQuantity++){
    				 document.getElementById("productQuantity").innerHTML +="<option value="+prdQuantity+">"+prdQuantity+"</option>"
    				 document.getElementById("price").innerText = "NT$" + products[index].unitPrice;
    			 }
    			 
    		 }
    		 console.log(products[index]);
    	 }
     });
     
     
     //add products to shopping cart
     function addToCart(){
    	 console.log("addtoCart");
    	 console.log($('#productType').val());
//     	 if($('#productType').val()!=null){
//     	 	localStorage.setItem($('#productType').val(), $('#productQuantity').val());
//     		console.log("成功");
//     	 }
    	 $.ajax({
     		url: "${pageContext.request.contextPath}/addToShoppingCart", 
     		data : {prodID: $('#productType').val(), qty: $('#productQuantity').val()},
     		type : "POST",
     		success : function() {
     			//need to add my new gadget here afterwards彈跳的購物車
 				alert("加入購物車成功");
     		}
     	 });
     }
  
 </script>

</body>
</html>