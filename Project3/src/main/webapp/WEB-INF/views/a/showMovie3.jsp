<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0' />
<!-- title -->
<title>Cineshow</title>
<!-- google fonts -->
<link href='https://fonts.googleapis.com/css?family=Lato:400,300,900'
	rel='stylesheet' type='text/css'>
<!-- stylesheets -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/flexslider.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/style.css'>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/responsive.css'
	type='text/css' />

<style>
/* CSS reset */
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form,
	fieldset, input, textarea, p, blockquote, th, td {
	margin: 0;
	padding: 0;
}

html, /* 這邊做初始化設定 全部字體為正黑體  並且字體大小以百分比控制  */ body {
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
	padding: 1%;
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

.hide {
	display: none;
}
</style>

</head>

<body>
	<header>


		<jsp:include page="header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>

	</header>
	<!--  <div>${sthb_list1.get(1).run.movie.movieID}</div>
<div>${sthb_list1.get(1).showTimeId}</div>
<div>${sthb_list1.get(1).playStartTime}</div>
<div>${sthb_list1.get(1).run.runID}</div>-->
	<!-- header -->

	<!-- banner -->

	<!-- banner -->
	<section class='gray-bnr feature-sec '
		style='background-color: black; margin-top: 64px;'>
		<div class='container'>

			<div class='buy-txt'>
				${run.movie.trailer}
				<!--    <iframe width='854' height='480' src='https://www.youtube.com/embed/FEf412bSPLs' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>
      -->
			</div>
	</section>
	<section class='gray-bnr feature-sec ' style='padding: 50px 0px;'>

		<div class='container'>
			<div class='row '>
				<div class='col-md-2'></div>

				<div class='col-md-3 col-sm-4 col-xs-6'>
					<div class=''>

						<div style='padding: 10px'>
							<img src='<c:url value='/getPicture/${run.movie.movieID}' />'
								width="100%" height="100%"> <img
								style='width: 100%; height: 100%;' src='img/feature2.jpg'>
						</div>

					</div>

				</div>


				<div class='col-sm-6'>
					<!-- <div class='ex-feature'> -->

					<h2>${run.movie.title}</h2>
					<table>
						<tr>
							<td>導演：</td>
							<td>${run.movie.director}</td>
						</tr>
						<tr>
							<td>演員：</td>
							<td>${run.movie.cast}</td>
						</tr>
						<tr>
							<td>類型：</td>
							<td>${run.movie.genreBean.genre}</td>
						</tr>
						<td>分級：</td>
						<td>${run.movie.movieRatingBean.rating}</td>

						<tr>
							<td>片長：</td>
							<td>${run.movie.runningTime}</td>
						</tr>
					</table>
					<div id='showTimeHere'>
						<h3
							style="border-bottom: solid rgb(100, 100, 100) 2px; padding-bottom: 10px">期待度</h3>
						<div>
							<jsp:include page="../t/addexpectation.jsp">
								<jsp:param name="c" value="1" />
								<jsp:param name="d" value="1" />
							</jsp:include>
						</div>
					</div>

					<!-- </div> -->
				</div>
			</div>
		</div>
		</div>
	</section>
	<!-- banner -->
	<section class=" banner-featured" style='background-color: gray;'>
		<div class="container">
			<div class="ticket-sell">
				<h3 class="font">關於電影</h3>
			</div>
		</div>
	</section>
	<!-- banner -->

	<section class='contact-sec'>
		<div class='container'>

			<div class='buy-txt'>
				<h2 style='text-align: left; color: cornflowerblue;'>[ 劇情介紹
					/ABOUT THE STORY ]</h2>
				<p></p>
				<br>

			</div>

			<div class='buy-txt'>

				<div class='col-sm-12 col-xs-12'>
					<div style='text-align: left; padding: 5px; font-size: large;'>
						${run.movie.plotSummary}</div>

				</div>

			</div>
		</div>

	</section>
	<!-- banner -->

	<!-- banner -->

	<section class='contact-sec'>
		<div class='container'>

			<div class='buy-txt'>
				<h2 style='text-align: left; color: cornflowerblue;'>[ 入場須知/
					RULES AND REGULATION ]</h2>
				<p></p>
				<br>

			</div>

			<div class='buy-txt'>
				<div class="col-sm-12 col-xs-12">
					<div class="ex-feature" style='text-align: left;'>

						<ul style='text-align: left;'>
							<li>敬請遵守飲食公告。</li>
							<li>本影城全面禁菸。</li>
							<li>請勿嚼食檳榔、口香糖。</li>
							<li>請勿攜帶寵物入場。</li>
							<li>敬請遵守電影分級制度。</li>
							<li>如須退票，請於電影開演二十分鐘之前至售票處辦理(連結至退/換票須知)。</li>
							<li>進入影廳前，敬請將行動電話、鬧鐘手錶關機或調成靜音。</li>
							<li>影片播映時，請勿使用任何錄影(音)器材。</li>
							<li>本影城之場次時間表僅為參考，如有異動，請以當日售票處公佈之場次為準。</li>
						</ul>
					</div>
				</div>

			</div>
	</section>
	<!-- banner -->




	<!--     <section class="ticket-outer banner-featured"> -->

	<!-- banner -->


	<section class='dark-blue'>
		<div class='container'>
			<div class='ready'>
				<h4>現在就立刻購票！</h4>
				<p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
				<a href='free-trail.html' class='slider-btn'>前往購票</a>
			</div>
		</div>
	</section>

	ｂ
	<!-- footer -->
	<jsp:include page="footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>

	<!-- footer -->

	<!-- scripts -->
	<script
		src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
	<script defer src='js/bootstrap.min.js'></script>


</body>

</html>




<script>
	
</script>
</body>
</html>
