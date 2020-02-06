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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flexslider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" />
    <!-- scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script defer src="js/bootstrap.min.js"></script>
     <style>
    body{
    	font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
    }
    
    html {
  		scroll-behavior: smooth;
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
                    <a class="navbar-brand" href="<c:url value='/movieIndex'/>"><img src="img/logo-1.png" class="logo-hdr" width="180">
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse my-nav-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="<c:url value='/movieIndex'/>">home</a>
                        </li>
                        <li><a href="latest.html">即將上映</a>
                        </li>
                        <li><a href="latest.html">熱映中</a>
                        </li>
                        <li><a href="up-coming.html">購票</a>
                        </li>
                        <li><a href="conatct.html">contact</a>
                        </li>
                        <li><a href="showAllProducts">周邊商品</a>
                        </li>

                        <li><a href="getShoppingCart" style='padding:5px;'><img src="img/shoppingcart.png" alt="" srcset=""width='25' height='20'style='position:relative;'></a>
                        </li>
                        <li class="free-trial-btn btn222" id="login"><a href="<c:url value='/member/login' />">登入</a></li>
                        <li class="free-trial-btn btn222" id="register"><a href="<c:url value='/member/register' />">註冊</a></li>
                        <li class="btn222" id="memberCenter"><a href="<c:url value='/memberCenter' />">會員中心</a></li>
                        <li class="free-trial-btn btn222" id="logout"><a href="<c:url value='/member/logout' />">登出</a></li>

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
                                            <h5>不想排隊?</h5>
                                            <h4>快線上訂位!<br> </h4>
                                            <a href="#booknow" class="slider-btn">立即訂位</a>
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
                                            <a href="#booknow" class="slider-btn">立即訂位</a>
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
                                            <a href="#booknow" class="slider-btn">立即訂位</a>
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
                        <h4>訂票系統</h4>
                        <p>線上快速訂票</p>
                    </div>
                </div>
                <div class="col-sm-4 col-xs-4">
                    <div class="serv-box">
                        <span>
                        	<img src="img/icon-2.png">
                        </span>
                        <h4>頂尖設備</h4>
                        <p>影廳播放之畫面色彩、對比度、聲音響度及音場頻率皆達最高規格 </p>
                    </div>
                </div>
                <div class="col-sm-4 col-xs-4">
                    <div class="serv-box">
                        <span>
                        	<img src="img/icon-3.png">
                        </span>
                        <h4>影廳租借</h4>
                        <p>全系列影廳 開放租借中 各種活動都適合</p>
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



    <section class="ticket-outer" id="booknow">
        <div class="container">
            <div class="ticket-sell">
                <div class="row clearfix">
                    <div class="col-sm-6 pull-left">
                        <div class="tc-con">
                            <h5>快速訂票</h5>
                            <h3>購票須知</h3>
                            <ul class="list-unstyled">
                                <li>非影城網路會員也可以使用</li>
                                <li>每個帳號每筆交易最多可購買 6 張電影票劵。</li>
                                <li>訂單成立視同票券售出，逾時未取票者並不會自動取消座位或退款，沒有在開演前取票或票券隔場作廢，一概不得退票或換票，票款與手續費皆不退回。</li>
                                <li>本系統銷售票劵與影城現場同步，一旦結帳成功，現場座位就已經同步售出。</li>
                                <li>請選擇正確的票種，以免影響自身權益。</li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-6 pull-right">
                        <div class="tc-girl" id="booktickets">
                        <select id="movie">
                        	<option value="default" selected="" disabled="">請選擇</option>
                        	<c:forEach var="movies" items="${movielist}">
                            	<option value="${movies.movie.movieID}">${movies.movie.title}</option>
                        	</c:forEach>
                        </select>
                            <select id="playdate">
                            	<option value="default" selected="" disabled="">請選擇</option>
                            </select>
                            <select id="movieStartTime">
                            	<option value="default" selected="" disabled="">請選擇</option>
                            </select>
                        </div>
                        <form id="purchaseTicket">
							<div class="slider-btn slider-g-btn" id="pt" onclick="buyticket()">前往訂票</div>
                       
                        </form>
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
       
    <!-- footer -->

    <!-- scripts-->
    <script defer src="js/jquery.flexslider.js"></script>
    <script type="text/javascript">
     var allshowtimelist = ${allshowtimelistJSON};
     console.log(allshowtimelist);
     
        $(window).load(function() {
            $('.flexslider').flexslider({
                animation: "fade",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });
        });
        
        function addDays(date, days) {
      	  const copy = new Date(Number(date))
      	  copy.setDate(date.getDate() + days)
      	  return copy
      	}
        
        //append date into the date drop-down menu
        $('#movie').change(function(){
        	var movie = $('#movie').val();
        	$('#playdate').html("<option value='default' selected='' disabled=''>請選擇</option>");
        	$('#movieStartTime').html("<option value='default' selected='' disabled=''>請選擇</option>");
        	//get today's date
        	var today = new Date();
        	var days = [];
        	var count = 0;
        	//need to change this if number of days are not 7
        	for(let d = 0; d < 7; d++){
        		console.log("THIS IS TODAY: "+today);
				//get the format required to add into drop-down menu 
        		var month = today.getMonth();
        		if(today.getMonth()+1<10){
        			month = "0" + (today.getMonth()+1);
        		}
        		var day = today.getDate();
        		if(today.getDate()<10){
        			day = "0" + today.getDate();
        		}
        		var date = today.getFullYear()+'-'+month+'-'+day;
        		for(let x = 0; x < allshowtimelist.length; x++){
       
            		if(allshowtimelist[x].run.movie.movieID == movie && (allshowtimelist[x].playStartTime.substring(0, 10)) == date){
 
            			if(days.length >= 1){
//             				console.log("This is if");
//             				console.log("days[count] " + days[count] );
//             				console.log("date: " + date);
            				if(days[count] == date){
//             					console.log("if(days[count] == date)");
            					continue;
            				}else{
            					days.push(date);
            					count++;
            				}
            			}else{
//             				console.log("This is else");
            				days.push(date);
            			}
            		}
            	}
        		console.log(date);
        		
        		today = addDays(today, 1);
        	}
        	for(let a = 0; a < days.length; a++){
        		console.log(days[a]);
        		document.getElementById("playdate").innerHTML += "<option value='" + days[a] +"'>" + days[a] + "</option>";
        	}
        	
        	console.log($('#movie').val());
        });
        
//         console.log(allshowtimelist[0].playStartTime.substring(0, 10));
        $('#playdate').change(function(){
        	$('#movieStartTime').html("<option value='default' selected='' disabled=''>請選擇</option>");
        	var chosenDate = $('#playdate').val();
//         	console.log("chosenDate: " + chosenDate);
//         	console.log(typeof(chosenDate));
        	var chosenMovie = $('#movie').val();
//         	console.log("chosenMovie: " + chosenMovie);
        	for(let x = 0; x < allshowtimelist.length; x++){
//         		console.log(allshowtimelist[x].run.movie.movieID == chosenMovie);
//         		console.log((allshowtimelist[x].playStartTime.substring(0, 10)) == chosenDate);
        		if(allshowtimelist[x].run.movie.movieID == chosenMovie && (allshowtimelist[x].playStartTime.substring(0, 10)) == chosenDate){
        			document.getElementById('movieStartTime').innerHTML += "<option value='" + allshowtimelist[x].showTimeId +"'>" + allshowtimelist[x].playStartTime.substring(11, 16) + "</option>";
        		}
        	}

        })
        
        console.log(allshowtimelist[$('movieStartTime').val()]);
        $('#movieStartTime').change(function(){
        	console.log($('#movieStartTime').val());
        	document.getElementById('purchaseTicket').innerHTML += "<input type='hidden' name='showTimeBean' value='"
				+ $('#movieStartTime').val() + "'>" 
//         	console.log(allshowtimelist[$('#movieStartTime').val()]);
//         	$.ajax({
// 				url : "${pageContext.request.contextPath}/purchaseTickets",
// 				data : {
// 					showTimeBean: allshowtimelist[$('#movieStartTime').val()]
// 				},
// 				type : "POST",
// 				success : function() {
// 					alert("訂票成功!");
// 					window.location.href = "${pageContext.request.contextPath}/purchaseTickets";
// 				}
// 			});
        });
        
        cookieArray = document.cookie.split("; ");
    	console.log(cookieArray);

    	for (i = 0; i < cookieArray.length; i++) {
    			memberIDArrays = cookieArray[i].split("=");
    			console.log(memberIDArrays);
    			if (memberIDArrays[0] == "memberID" && memberIDArrays[1] == "" || cookieArray.length == 1 || cookieArray.length == 0) {
//     				$("#name").text("訪客");
					$("#memberCenter").hide();
    				$("#logout").hide();
    			}else{
//     				for (i = 0; i < cookieArray.length; i++) {
//     				nameArrays = cookieArray[i].split("=");
//     				console.log(nameArrays);
//     				if (nameArrays[0] == "name") {
//     				$("#name").text(nameArrays[1]);
//     				}
//     			}
    				$("#register").hide();
    				$("#login").hide();
    		}
    	}
    	
    	
    	function buyticket(){
    		document.forms[0].action="<c:url value='/purchaseTickets'/>";
            document.forms[0].method = "POST";
    		document.forms[0].submit();
    	}
    	
    </script>


</body>
</html>