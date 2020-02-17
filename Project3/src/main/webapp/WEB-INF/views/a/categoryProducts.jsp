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
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,900'
	rel='stylesheet' type='text/css'>
<!-- stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/flexslider.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/responsive.css"
	type="text/css" />
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
                width: 50%;
                height: 50%;
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
    
    
            .gray_border{
                border-block-end:rgb(179, 179, 179) solid 1px ;
            }
            .star_border{
                border-block-start:rgb(179, 179, 179) solid 1px ;
            }
            
            .w3-hover-opacity-off:hover{
            	opacity: 0.6;
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
	<!-- slider -->
    <section class="slider-sec" style="margin-top:64px;">
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
                                            <h5>不想排隊?</h5>
                                            <h4>快線上訂位!<br> </h4>
                                            <a href="${pageContext.request.contextPath}/movieIndex#booknow" class="slider-btn">立即訂位</a>
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
                                            <h5>不想排隊? </h5>
                                            <h4>快線上訂位!</h4>
                                            <a href="${pageContext.request.contextPath}/movieIndex#booknow" class="slider-btn">立即訂位</a>
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
                                            <h5>不想排隊? </h5>
                                            <h4>快線上訂位!</h4>
                                            <a href="${pageContext.request.contextPath}/movieIndex#booknow" class="slider-btn">立即訂位</a>
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



<!-- 商品選擇 -->
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
                    <div class="wrap" id="pictureBG">
                        <div class="w3-content wrap" style="width:100%; height:auto;">

                            <img class="mySlides P_Bimg" src="<c:url value='/products/${productList[0].productID}' />"alt="">
					<c:forEach begin='1' end='${productList.size()-1}' var='x'>
					<img class="mySlides P_Bimg" src="<c:url value='/products/${productList[x].productID}' />" style="display:none">
					</c:forEach>

                            <!-- small picture -->
                            <div class="wrapRow" style="height: 13vh; width: 50%; padding: 2vh 0vh;">
                            	<c:forEach begin='0' end='${productList.size()-1}' var='x'>
                                <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px; padding:0px 6px 0px 0px;">
                                    <img class="demo w3-opacity w3-hover-opacity-off" src="<c:url value='/products/${productList[x].productID}' />"
                                        style="width:100%;  height: 100%;  cursor:pointer" onclick="currentDiv(${x+1})">
                                </div>
								</c:forEach>
<!--                                 <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px ;padding:0px 6px 0px 0px; "> -->
<!--                                     <img class="demo w3-opacity w3-hover-opacity-off" src="img/feature10.jpg" -->
<!--                                         style="width:100%;  height: 100%;  cursor:pointer" onclick="currentDiv(2)"> -->
<!--                                 </div> -->

<!--                                 <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px; padding:0px 6px 0px 0px;"> -->
<!--                                     <img class="demo w3-opacity w3-hover-opacity-off" src="img/feature11.jpg" -->
<!--                                         style="width:100%;  height: 100%;   cursor:pointer" onclick="currentDiv(3)"> -->
<!--                                 </div> -->

<!--                                 <div class="w3-col s4 " style="height: 100%; width: 80%; margin:0px; "> -->
<!--                                     <img class="demo w3-opacity w3-hover-opacity-off" src="img/feature3.jpg" -->
<!--                                         style="width:100%;  height: 100%;   cursor:pointer" onclick="currentDiv(4)"> -->
<!--                                 </div> -->


                            </div>
                            <!-- small picture -->
                        </div>
                    </div>
                    <!-- 圖片輪播  -->
                    
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
                  
                    <div class="wrapList">
                        <p class="tital" id="price">NT$</p>
                    </div>
                    <br>
                    <div class="wrapList "> 
                    <label for="productType">商品款式 
                    <select name="productType" id="productType">
          
                                <option value="default" selected="" disabled="">請選擇樣式</option>
							<c:forEach items="${productList}" var="typeOfProduct">
								<option value="${typeOfProduct.productID}">${typeOfProduct.productName}</option>
							</c:forEach>
                            </select>
                        </label>
                    </div>
                   
                    <div class="wrapList "> <label for="productQuantity">數量 </label></div>


                    <div class="wrapList"> <select
						name="productQuantity" id="productQuantity">
							<option value="default" selected="" disabled="">數量</option>
					</select>
                            
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
                    <div class="wrapList" style="display:none;">
                        <p></p><br><br>
                    </div>
                    <!-- 空白排版用 -->

                          <!-- 分隔商品資訊框框 -->
                         
                            <!-- 分隔商品資訊框框 -->
                  

                 


                </div>



            </div>






        </div>
    </div>
     <!-- article -->
<!-- 商品選擇 -->

<!-- 樣式圖片1 -->
<section class='contact-sec' style="padding: 0px 0px 0px 0px; ">
    <div class='container'>
        <div class='wrap'>
        	
            <div style="width:100%; border-bottom: 1px lightgrey solid;">
                    <h2 style="padding: 50px ;">${productList[0].categoriesBean.categoryName}</h2>
            </div>
            <c:forEach items="${productList}" var="pList">
                <!-- 樣式圖片1 -->
                <div class="wrapRowStart" style="width: 80%; border-bottom: 1px lightgrey solid;" >
                    <div>
                            <h3 style="padding: 30px 50px;">${pList.productName}</h3>
                            <img src="<c:url value='/products/${pList.productID}' />" alt="" style="padding:20px 50px">
                    </div>
                    <c:if test="${pList.productDescription != 'NULL'}">
					<br>
					<div id="productDescription" style="padding:150px 100px; " >
                        <p>${pList.productDescription}</p>
                    </div>
					<br>
				</c:if>
                    
                      
                </div> 
                </c:forEach>
                <!-- 樣式圖片1 -->
                <!-- 樣式圖片2 -->
<!--                 <div class="wrapRowStart" style="width: 80%; border-bottom: 1px black solid;" > -->
<!--                         <div> -->
<!--                                 <h3 style="padding: 30px 50px;">[ 樣式1 ]</h3> -->
<!--                                 <img src="img/feature2.jpg" alt="" style="padding:20px 50px"> -->
<!--                         </div> -->
<!--                         <div style="padding:150px 100px; " > -->
<!--                             <p>這部電影豪華的演員陣容還包括安東尼奧班德拉斯、麥可辛（《黛妃與女皇》）以及奧斯卡金像獎得主吉姆布洛班特，並且還有更多的配音演員，包括金獎影后瑪莉詠柯蒂亞、湯姆霍蘭德、賽琳娜戈梅茲以及雷夫范恩斯。</p> -->
<!--                         </div> -->
                          
<!--                     </div>  -->
                    <!-- 樣式圖片2 -->
        </div>
<!-- 圖片  -->


<!-- 圖片  -->
        

        
    </div>
</section>

	 <!-- footer -->
    <footer>

       <jsp:include page="footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->

	<!-- scripts -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script defer
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<!-- scripts-->
	<script defer
		src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
	<script>
	
	/*輪播圖 */
    function currentDiv(n) {
        showDivs(slideIndex = n);
    }
	
    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("mySlides");
        var dots = document.getElementsByClassName("demo");
        if (n > x.length) { slideIndex = 1 }
        if (n < 1) { slideIndex = x.length }
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" w3-opacity-off", "");
        }
        x[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " w3-opacity-off";
    }
    /*輪播圖 */
    
		var products = ${prod};
		console.log(products);
		console.log(products.length)

		$(window)
				.load(
						function() {
							$('.flexslider').flexslider({
								animation : "fade",
								start : function(slider) {
									$('body').removeClass('loading');
								}
							});
							//if there are more than one product in this category
							//there should be a price range NT$.. - NT$..
							if (products.length > 1) {
								var lowestprice = 1000000;
								var highestprice = 0;
								for (let c = 0; c < products.length; c++) {
									if (products[c].unitPrice < lowestprice) {
										lowestprice = products[c].unitPrice;
									}
									console.log("lowestprice: " + lowestprice);
									if (products[c].unitPrice > highestprice) {
										highestprice = products[c].unitPrice;
									}
									console
											.log("highestprice: "
													+ highestprice);
									//         	 	if(products[c].productDescription != "NULL"){
									//         	 		document.getElementById("prodDetail").innerHTML += ""
									//              		document.getElementById("productDescription").innerText += products[c].productDescription;
									//              	}
								}//end of for
								document.getElementById("price").innerText += lowestprice
										+ " - NT$" + highestprice;

							}//end of if(products.length > 1)
							else {
								document.getElementById("price").innerText += products[0].unitPrice;
							}//end of else
						});//end of $(window).load(function()

		//user selects the type of product drop-down list
		//which will change the price and the quantity
		$('#productType')
				.change(
						function() {
							document.getElementById("productQuantity").innerHTML = "";
							document
									.getElementById("productQuantity")
									.prepend(
											"<option value='default' selected='' disabled=''>數量</option>");
							document.getElementById("price").innerText = "";
							let pdID = $('#productType').val();
							for (let index = 0; index < products.length; index++) {
								if (pdID == products[index].productID) {
									for (let prdQuantity = 1; prdQuantity <= products[index].unitStock; prdQuantity++) {
										document
												.getElementById("productQuantity").innerHTML += "<option value="+prdQuantity+">"
												+ prdQuantity + "</option>"
										document.getElementById("price").innerText = "NT$"
												+ products[index].unitPrice;
									}

								}
								console.log(products[index]);
							}
						});

		//add products to shopping cart
		function addToCart() {
			console.log("addtoCart");
			console.log($('#productType').val());
			//     	 if($('#productType').val()!=null){
			//     	 	localStorage.setItem($('#productType').val(), $('#productQuantity').val());
			//     		console.log("成功");
			//     	 }
			$.ajax({
				url : "${pageContext.request.contextPath}/addToShoppingCart",
				data : {
					prodID : $('#productType').val(),
					qty : $('#productQuantity').val()
				},
				type : "POST",
				error : function(){
					window.location.href = "${pageContext.request.contextPath}/member/login";
				},
				success : function() {
					//need to add my new gadget here afterwards彈跳的購物車
					alert("加入購物車成功");
				}
			});
		}
	</script>

</body>
</html>