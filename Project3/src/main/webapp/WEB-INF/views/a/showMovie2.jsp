<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
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

.likeclicked {
	border : 0 ;
	font-size : 20px;
	color : white;
	background-color: #c21010;
	border-radius: 4px;
}

.likenormal {
	border : 0 ;
	font-size : 20px;
	color : black;
	background-color: white;
	border-radius: 4px;
}

.fa{
	font-size : 20px;
}

.icon-thumbs-up{
	font-size : 20px;
}

.icon-thumbs-down{
	font-size : 20px;
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
/* 留言編輯 項目名 */
.control-label head {
	padding: 0;
	font-size: 20px;
}

.col-lg inner {
	text-align: left;
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
		<!-- header -->
		<!--         <nav class='navbar navbar-default navbar-static-top'> -->
		<!--             <div class='container'> -->
		<!--                 <div class='navbar-header'> -->
		<!--                     <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'> -->
		<!--                         <span class='sr-only'>Toggle navigation</span> -->
		<!--                         <span class='icon-bar'></span> -->
		<!--                         <span class='icon-bar'></span> -->
		<!--                         <span class='icon-bar'></span> -->
		<!--                     </button> -->
		<!--                     <a class='navbar-brand' href='index.html'><img src='img/logo-1.png' class='logo-hdr' width='180'> -->
		<!--                     </a> -->
		<!--                 </div> -->
		<!--                 <div id='navbar' class='navbar-collapse collapse'> -->
		<!--                     <ul class='nav navbar-nav navbar-right'> -->
		<!--                         <li><a href='index.html'>home</a> -->
		<!--                         </li> -->
		<!--                         <li class='active'><a href='features.html'>latest movies</a> -->
		<!--                         </li> -->
		<!--                         <li><a href='pricing.html'>pricing</a> -->
		<!--                         </li> -->
		<!--                         <li><a href='up-coming.html'>Up coming</a> -->
		<!--                         </li> -->
		<!--                         <li><a href='conatct.html'>contact</a> -->
		<!--                         </li> -->
		<!--                         <li><a href='login-page.html'>login </a> -->
		<!--                         </li> -->
		<!--                         <li class='free-trial-btn'><a href='free-trail.html'>free trial</a> -->
		<!--                         </li> -->
		<!--                         <li> -->
		<!--                             <select> -->
		<!--                                 <option>ENG</option> -->
		<!--                                 <option>FR</option> -->
		<!--                             </select> -->
		<!--                         </li> -->
		<!--                     </ul> -->
		<!--                 </div> -->
		<!--                 /.nav-collapse -->
		<!--             </div> -->
		<!--         </nav> -->

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
	<!-- 電影介紹 -->
	<!-- banner -->
	<section class='gray-bnr feature-sec '
		style='background-color: black; margin-top: 64px;'>
		<div class='container'>

			<div class='buy-txt'>
				${sthb_list1.get(1).run.movie.trailer} 
				<!--    <iframe width='854' height='480' src='https://www.youtube.com/embed/FEf412bSPLs' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>
      -->
			</div>
		</div>
	</section>
	<!-- banner -->

	<section class=' feature-sec '
		style='padding: 50px 0px; background-color: white;'>

		<div class='container'>
			<div class='row '>
				<div class='col-md-2'></div>

				<div class='col-md-3 col-sm-4 col-xs-6'>
					<div class=''>

						<div style='padding: 10px'>
							<img
								src='<c:url value='/getPicture/${sthb_list1.get(1).run.movie.movieID}' />'
								width="100%" height="80%">
							<!--                                         <img  style='width: 100%;height: 100%; 'src='img/feature2.jpg'> -->
						</div>

					</div>

				</div>


				<div class='col-sm-6'>
					<!-- <div class='ex-feature'> -->

					<div class='wrapStart fullwidth'
						style='padding: 20px; height: auto;'>
						<h2 style='font-weight: bold;'>${sthb_list1.get(1).run.movie.title}</h2>
						<br>
						<div class='wrapRowStart fullwidth'
							style='padding: 5px; height: auto; font-size: 16px;'>
							<div>導演：</div>
							<div>${sthb_list1.get(1).run.movie.director}</div>
						</div>

						<div class='wrapRowStart fullwidth'
							style='padding: 5px; font-size: 16px;'>
							<div style='width: auto'>演員：</div>
							<div>${sthb_list1.get(1).run.movie.cast}</div>
						</div>
						<div class='wrapRowStart fullwidth'
							style='padding: 5px; font-size: 16px;'>
							<div>類型：</div>
							<div>${sthb_list1.get(1).run.movie.genreBean.genre}</div>
						</div>
						<div class='wrapRowStart fullwidth'
							style='padding: 5px; font-size: 16px;'>
							<div>分級：</div>
							<div>${sthb_list1.get(1).run.movie.movieRatingBean.rating}</div>
						</div>
						<div class='wrapRowStart fullwidth'
							style='padding: 5px; font-size: 16px;'>
							<div>片長：</div>
							<div>${sthb_list1.get(0).run.movie.runningTime}</div>
						</div>

					</div>

					<!-- </div> -->
				</div>
			</div>
		</div>


	</section>


	<!-- 播放時間 -->
	<!-- banner -->

	<section class='contact-sec gray-bnr' style='padding: 10px 0px;'>
		<div class='container'>

			<div class='buy-txt' onclick='showhide("showDisplay");'>
				<h2
					style='text-align: left; color: cornflowerblue; font-weight: bold; padding-top: 40px;'
					id='ShowTitle'>[ 電影場次 /MOVIE TIME ]</h2>
				<p></p>
				<br>

			</div>

			<div class='buy-txt ' id='showDisplay' style="display: none;">

				<div class='col-sm-12 col-xs-12'>
					<div class='wrapStart fullwidth' id='showTime_table'
						style='height: auto;'></div>


				</div>

			</div>
		</div>

	</section>
	<!-- banner -->


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
						${sthb_list1.get(1).run.movie.plotSummary}</div>

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
		</div>
	</section>
	<!-- banner -->
	<!--     <section class="ticket-outer banner-featured"> -->
	<section class=" banner-featured" style='background-color: gray;'>
		<div class="container">
			<div class="ticket-sell">
				<h3 class="font">留言板</h3>
			</div>
		</div>
	</section>
<!-- 	banner -->
    <section class='contact-sec '>
        <div class='container'>
            <c:forEach var="list" items="${haveComment}">
                <c:choose>
                    <c:when test='${list == "1"}'>
                        <div class='buy-txt'>
                            <form:form method='POST' modelAttribute="updateComment"
                                action="${pageContext.request.contextPath}/update/comment/${run.runID} ?id=${updateComment.commentID}"
                                class='form-horizontal'>
                                <h2 style='text-align: left; color: cornflowerblue;'>[修改留言]</h2>
                                <p></p>
                                <br>
                                <fieldset>
                                    <div class="form-group" style="text-align: left">
                                        <div>
                                            <label class="control-label"
                                                style="padding: 0; font-size: 20px" for='watched'>
                                                已觀賞: </label>
                                            <div class="col-lg inner" style="font-size: 20px">
                                                <form:radiobutton id="watched" path="watched" value="1" />
                                                已觀看
                                                <form:radiobutton id="watched" path="watched" value="0" />
                                                未觀看
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group" style="text-align: left">
                                        <label class="control-label"
                                            style="padding: 0; font-size: 20px" for='grade'>
                                            評分: </label>
                                        <div class="col-lg inner">
                                            <form:select id="grade" path="grade" class='form:input-large'
                                                style=" width : auto;font-size:20px;height: auto">
                                                <%--                                                 <form:option --%>
                                                <%--                                                     style="font-size : 10px" value="-1" label="請挑選" /> --%>
                                                <form:option style="font-size : 20px" value="1" label="1" />
                                                <form:option style="font-size : 20px" value="2" label="2" />
                                                <form:option style="font-size : 20px" value="3" label="3" />
                                                <form:option style="font-size : 20px" value="4" label="4" />
                                                <form:option style="font-size : 20px" value="5" label="5" />
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="form-group" style="text-align: left">
                                        <label class='control-label'
                                            style="padding: 0; font-size: 20px" for="commentContent">
                                            <br>
                                            短評:</label>                                            
                                        <div class='col-lg inner' style  ="font-size: 20px;text-align:center">
                                            <form:textarea
                                                style="font-size: 20px; resize: none ;width: 95%;height: 300;padding:15px"
                                                rows="5" cols="40" id="commentContent" path="commentContent"
                                                type='text' class='form:input-comment' />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class='col-lg inner' style="text-align: center">
                                            <input id="btnAdd" type='submit' style="font-size: 20px;background-color: #C21010;border-color: #C21010"
                                                class='btn btn-primary' onclick = "fixcomment()" value="修改" /> <a
                                                href="<spring:url value='/comments/delete/${run.runID} ?id=${updateComment.commentID}' />"
                                                id = "deleteComment" onclick = "deletecomment()" class="btn btn-primary" style="font-size: 20px;background-color: #C21010;border-color: #C21010">刪除
                                            </a>
                                        </div>
                                    </div>
                                </fieldset>
                            </form:form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class='buy-txt'>

                            <%--                 <jsp:include page="../t/addcomment.jsp"> --%>
                            <%--                     <jsp:param name="c" value="1" /> --%>
                            <%--                     <jsp:param name="d" value="1" /> --%>
                            <%--                 </jsp:include> --%>
                            <form:form method='POST' modelAttribute="commentBean"
                                action="${pageContext.request.contextPath}/comments/add/${run.runID}"
                                class='form-horizontal'>
                                <h2 style='text-align: left; color: cornflowerblue;'>[新增留言]</h2>
                                <p></p>
                                <br>
                                <fieldset>
                                    <div class="form-group" style="text-align: left">
                                        <div>
                                            <label class="control-label"
                                                style="padding: 0; font-size: 20px" for='watched'>
                                                已觀賞: </label>
                                            <div class="col-lg inner" style="font-size: 20px">
                                                <form:radiobutton id="watched" path="watched" value="1" />
                                                已觀看
                                                <form:radiobutton id="watched" path="watched" value="0" />
                                                未觀看
                                            </div>
                                        </div>
                                        <br><span class="notice" id="test123"></span>
<%--                                         <form:errors path="watched" cssClass="error" /> --%>
                                    </div>

                                    <div class="form-group" style="text-align: left">
                                        <label class="control-label"
                                            style="padding: 0; font-size: 20px" for='grade'> 評分 :</label>
                                        <div class="col-lg inner" style="font-size: 20px">
                                            <form:select id="grade" style=" width : auto;font-size:20px;height: auto" path="grade">
                                                <%--                             <form:option value = "-1" label = "請挑選"/> --%>
                                                <form:option value="1" style="text-align:left" label="1" />
                                                <form:option value="2" label="2" />
                                                <form:option value="3" label="3" />
                                                <form:option value="4" label="4" />
                                                <form:option value="5" label="5" />
                                            </form:select>
                                        </div>
                                        <form:errors path="grade" cssClass="error" />
                                    </div>
                                    <div class="form-group" style="text-align: left">
                                    <br>
                                        <label class='control-label'
                                            style="padding: 0; font-size: 20px" for="commentContent">
                                            短評 :</label>
                                        <div class='col-lg inner' style="font-size: 20px;text-align:center">
                                            <form:textarea id="commentContent" path="commentContent"
                                                type='text' class='form:input-large'
                                                style="font-size: 20px; resize: none ;width: 95%;height: 300;padding:15px"
                                                rows="5" cols="40" />
                                        </div>
                                        <form:errors path="commentContent" cssClass="error" />
                                    </div>
                                    <div class="form-group" style="text-align: left">
                                        <label class='control-label' for="commentTime"> </label>
                                        <div class='col-lg-10'>
                                            <form:input id="commentTime" path="commentTime" type='hidden'
                                                class='form:input-large' />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class='col-lg inner' style="text-align: center">
                                            <input id="btnAddcomment" type='submit'
                                                class='btn btn-primary' style="font-size: 20px;background-color: #C21010;border-color: #C21010" value="送出" />
                                            <input id="btnAddcomment2" onclick  ="quickenter()"
                                                class='btn btn-primary' style="font-size: 20px;width: 150px;background-color: #C21010;border-color: #C21010" value="一鍵輸入" />
                                        </div>
                                    </div>
                                </fieldset>
                            </form:form>
                        </div>

                    </c:otherwise>

                </c:choose>
            </c:forEach>



            <div class='buy-txt'>
                <h2>
                    <b style='font-size: 20px;'> 排序 : <a href="<spring:url value='/show/this/movie/bytime/${run.runID }' />"
                        class="btn btn-primary" style = "background-color: #C21010;border-color: #C21010">依時間 </a> <a
                        href="<spring:url value='/show/this/movie/bygrade/${run.runID }' />" class="btn btn-primary" style = "background-color: #C21010;border-color: #C21010">依評分 </a>
                        期待度: ${AVGExpectation} 平均評分:${AVGGrade} 
                    </b>
                </h2>
                <p></p>
                <br>

            </div>

            <div class='buy-txt'>

                <div class='col-sm-12 col-xs-12'>
                    <!--                     <div class="avggrade"> -->

                    <!--                         <p> -->
                    <%--                             <b style='font-size: 16px;'> ${AVGExpectation}%期待 --%>
                    <%--                                 平均評分:${AVGGrade} <a href="<spring:url value='/' />" --%>
                    <!--                                 class="btn btn-primary">發表時間 </a> <a -->
                    <%--                                 href="<spring:url value='/' />" class="btn btn-primary">評分 </a> --%>
                    <!--                             </b> -->
                    <!--                         </p> -->

                    <!--                     </div> -->
                    <c:forEach var='comment' items='${Comments}'>
                        <div class="comments" id = "comment${comment.commentID }" style="width: 100%; height: 330px">
                            <div class="thumbnail" style="border:3px solid #ddd;width: 100%; height: 300px">
                                <div class="caption_comment"
                                    style="text-align: left; padding: 25px; line-height: 2.5; font-size: 20px">
                                    <div>評分等級:${comment.grade} &nbsp&nbsp
                                    <c:choose>
                                    <c:when test="${comment.haveLike == 1}"> 
                                    	<button id="likebutton${comment.commentID }" onclick="notlike(${comment.commentID})" class = "likeclicked"><i class="icon-thumbs-up"></i>&nbsp${comment.likeNum}</button>&nbsp&nbsp
                                        <button id="badbutton${comment.commentID }" onclick="tobad(${comment.commentID})" class = "likenormal"><i class="fa fa-thumbs-o-down"></i>&nbsp${comment.badNum}</button>                                   
<!--                                         	<a -->
<%--                                             href="<spring:url value='/preference/addlike/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "good${comment.commentID}" style = "background-color: #c21010;border-color: white;font-size : 20px;color : white"><i class="icon-thumbs-up" style = "font-size : 20px"></i>&nbsp ${comment.likeNum} </a>&nbsp&nbsp <a --%>
<%--                                             href="<spring:url value='/preference/addbad/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "bad${comment.commentID}" style = "background-color: #ffffff;border-color: white;font-size : 20px;color : black"><i class="fa fa-thumbs-o-down" style = "font-size : 20px"></i>&nbsp ${comment.badNum} </a> --%>
                                    </c:when>
                                    <c:when test="${comment.haveBad == 1}">
                                        <button id="likebutton${comment.commentID }" onclick="tolike(${comment.commentID})" class = "likenormal"><i class="fa fa-thumbs-o-up"></i>&nbsp${comment.likeNum}</button>&nbsp&nbsp
                                        <button id="badbutton${comment.commentID }" onclick="notbad(${comment.commentID})" class = "likeclicked"><i class="icon-thumbs-down"></i>&nbsp${comment.badNum}</button>
<!--                                         	<a -->
<%--                                             href="<spring:url value='/preference/addlike/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "good${comment.commentID}" style = "background-color: #ffffff;border-color: white;font-size : 20px;color : black"><i class="fa fa-thumbs-o-up" style = "font-size : 20px"></i>&nbsp ${comment.likeNum} </a>&nbsp&nbsp <a --%>
<%--                                             href="<spring:url value='/preference/addbad/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "bad${comment.commentID}" style = "background-color: #c21010;border-color: white;font-size : 20px;color : white"><i class="icon-thumbs-down" style = "font-size : 20px"></i>&nbsp ${comment.badNum} </a> --%>
                                    </c:when>
                                    <c:otherwise>
                                        <button id="likebutton${comment.commentID }" onclick="like(${comment.commentID})" class = "likenormal"><i class="fa fa-thumbs-o-up"></i>&nbsp${comment.likeNum}</button>&nbsp&nbsp
                                        <button id="badbutton${comment.commentID }" onclick="bad(${comment.commentID})" class = "likenormal"><i class="fa fa-thumbs-o-down"></i>&nbsp${comment.badNum}</button>
                                    </c:otherwise> 
<%--                                         評分等級:${comment.grade} &nbsp&nbsp<a --%>
<%--                                             href="<spring:url value='/preference/addlike/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "good${comment.commentID}" style = "background-color: #C21010;border-color: #C21010">${comment.likeNum}讚 </a>&nbsp&nbsp <a --%>
<%--                                             href="<spring:url value='/preference/addbad/${run.runID } ?id=${comment.commentID}' />" --%>
<%--                                             class="btn btn-primary" id = "bad${comment.commentID}" style = "background-color: #C21010;border-color: #C21010">${comment.badNum}噓 </a> --%>
                                    </c:choose>
                                    </div>
                                    <div>
   										 <input id="likeNum${comment.commentID }" value="${comment.likeNum}" type="hidden"/>
   									</div>
   									<div>
   										 <input id="badNum${comment.commentID }" value="${comment.badNum}" type="hidden"/>
   									</div>
                                    <div>會員帳號:${comment.memberBean.account}</div>
                                    <div>短評內文:${comment.commentContent}</div>
                                    <c:set var="commentTime1" value="${comment.commentTime}" />
                                    <c:set var="commentTime2"
                                        value="${fn:substring(commentTime1, 0, 16)}" />
                                    <div>${commentTime2}</div>
                                    <div>
                                    	<button onclick="block(${comment.commentID})" id = "block${comment.commentID}" style = "border:0;color: #337ab7;background: white">
                                             	屏蔽</button>                                        
                                        <button onclick="report(${comment.commentID})" id = "reportbutton${comment.commentID}" style = "border:0;color: #337ab7;background: white">
                                             	檢舉</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>
        </div>
    </section>
<!-- 	banner -->
	<section class='dark-blue'>
		<div class='container'>
			<div class='ready'>
				<h4>現在就立刻購票！</h4>
				<p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
				<a href='<c:url value="movieIndex#booknow"/>' class='slider-btn'>前往購票</a>
			</div>
		</div>
	</section>


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
var a =${sthb_list};
var b=${oneMovie};
console.log(a);
console.log(b);
var  StratTime= b[0].strDay;
var  EndTime = b[(b.length)-1].strDay;
console.log(StratTime);
console.log(EndTime);
var today = new Date(StratTime+" "+"00:00");
var todayMonth =today.getMonth()*1+1;
var todayDate = today.getDate()*1;
var during = new Date(EndTime+" "+"00:00");
var endMonth = during.getMonth()*1+1;
var endDate = during.getDate()*1;
console.log(endMonth);
console.log(endDate);
console.log(todayMonth);
console.log(EndTime);
var diff = during-today;//差多少毫秒數
var diffDay = diff/(1000*60*24*60) //差幾日
console.log("diff"+diff);
console.log("diff"+diffDay);






// 處理showTime 時間





	for(let day =0 ;day<=diffDay;day++){
		 $("#showTime_table").append("<div class='wrapRowStart fullwidth' style=' padding: 10px 20px; font-size: 20px; font-weight: bold;' >"+"2020"+"年"+(todayMonth)+"月"+(todayDate+day)+"日</div>"+
				                      " <div class='wrapRowStart fullwidth' style=' padding-bottom: 30px;' id ='showTime_tr"+day+"'></div>"
		                            );
		for(let i =0;i<=(b.length-1);i++){
//				console.log("b"+b.length);
//				console.log("i"+i);
			var during2 = new Date(b[i].strDay+" "+"00:00");
//				var during3 = new Date(b[i+1].strDay+" "+"00:00");
//              console.log("todayMonth"+todayMonth);
//              console.log((during2.getMonth()*1)+1);
			if(todayMonth == (during2.getMonth()*1)+1){
//					console.log("during2"+ during2.getDate()*1);
//					console.log("today+day"+todayDate+day);
				if(during2.getDate()*1 ==todayDate+day ){
					
					console.log("相同月份");
				
					 document.getElementById("showTime_tr"+day).innerHTML+= "<a href='${pageContext.request.contextPath}/buyticket' class='slider-btn' style='margin: 5px 20px' onclick='formsubmit()'>"+b[i].strTime+"</a>";
					 document.getElementById("showTime_tr"+day).innerHTML+= "<form id='showForm"+b[i].sthb.showTimeId+"'action='${pageContext.request.contextPath}/show/this/movie'method='post'>";
					 document.getElementById("showTime_tr"+day).innerHTML+="<input name='showTimeId' type='hidden' value="+b[i].sthb.showTimeId+">"+"</form>" ;

				}else{}
					
				
				
		
			}else{
// 				alert("月份不同");
			}
			
		} 
		
		
		
		

}


function c(){
console.log(document.getElementById("movieBean").value);
}
</script>

<script>
function showhide(id) {
// alert("id"+id);

var divid = document.getElementById(id);
var divs = document.getElementsByClassName('hide');
var showElement = true;
// alert("aaa"+divid.style.display);
if (divid.style.display === 'none') {
// alert("bbbb");
divid.style.display = 'block';
showElement = false;
}else{
// alert("cccc");
divid.style.display = 'none';
}
// for (var i = 0; i < divs.length; i++) {
//     divs[i].style.display = 'none';
// }
// if (showElement) {
//     divid.style.display = 'block';
// }
// return false;
}


/*	跳轉選指定電影page */
function formsubmit(){

//console.log(run.movie.movieID );
document.getElementById("showIDForm"+b[i].sthb.showTimeId).submit()

}

</script>

<script>
	function showhide(id) {
// 		alert("id" + id);

		var divid = document.getElementById(id);
		var divs = document.getElementsByClassName('hide');
		var showElement = true;
// 		alert("aaa" + divid.style.display);
		if (divid.style.display === 'none') {
			//         alert("bbbb");
			divid.style.display = 'block';
			showElement = false;
		} else {
			//         alert("cccc");
			divid.style.display = 'none';
		}
		// for (var i = 0; i < divs.length; i++) {
		//     divs[i].style.display = 'none';
		// }
		// if (showElement) {
		//     divid.style.display = 'block';
		// }
		// return false;
	}

	/*	跳轉選指定電影page */
	function formsubmit() {

		//	  console.log(run.movie.movieID );
		document.getElementById("showIDForm" + b[i].sthb.showTimeId).submit()

	}

//	var cID = location.pathname.split("/questionRep/")[1];
	
	$("#btnAddcomment").click(
			function() {
				var d = new Date();
				$("#commentTime").val(
						d.getFullYear() + "-" + (parseInt(d.getMonth()) + 1)
								+ "-" + d.getDate() + " " + d.getHours() + ":"
								+ d.getMinutes() + ":" + d.getSeconds()
								+ ".000");
			});
	
	$("#btnAddcomment").click(function(){		
		if($("#commentContent").val == null){
			alert("欄位不可空白");
		}
	});
	
	$("#btnAdd").click(function(){		
		if($("#commentContent").val == null){
			alert("欄位不可空白");
		}
	});
	
	
// 	$("#block${comment.commentID}").click(function(){			
// 		$.ajax({
// 			type : "POST",
// 			url : "${pageContext.request.contextPath}/preference/addblock",
// 			data : {commentID : cID},
// 			success : function(data) {

// 			},
// 			error : function(data) {
// 				$("#close").removeClass();
// 				$("#close").addClass("btn btn-danger");
// 				$("#close").val("已結案");
// 				status = 2;
// 			}
// 		})
// 		alert("屏蔽成功");			
// 	});
	
// 	$("#good${comment.commentID}").click(function(){	
// 		$.ajax({
// 			type : "POST",
// 			url : "${pageContext.request.contextPath}/preference/addlike",
// 			data : {commentID : cID},
// 			success : function(data) {

// 			},
// 			error : function(data) {
// 				$("#close").removeClass();
// 				$("#close").addClass("btn btn-danger");
// 				$("#close").val("已結案");
// 				status = 2;
// 			}
// 		})
// });
	
	//讚+1
 function like(commentID){
  
    let likeNum= parseInt($("#likeNum"+commentID).val())+1;
//    var conn = $("#likeNum"+commentID).val();
    $.ajax({
    url:"${pageContext.request.contextPath}/addcommentlike",
    type:"POST",
    data:{"commentID":commentID,"memberID":getCookie("memberID")},
    dataType:"text",
   success:function(data){
    $("#likeNum" + commentID).val(likeNum);
	$("#likebutton" + commentID).html('<i class="icon-thumbs-up"></i>&nbsp' + likeNum);
	$("#likebutton" + commentID).removeClass("likenormal");
	$("#likebutton" + commentID).addClass("likeclicked");
    $("#likebutton" + commentID).attr("onclick","notlike("+commentID+")");
    $("#badbutton" + commentID).attr("onclick","tobad("+commentID+")");
   },
    error : function(data){
    	alert("請先登入");
       }
   }) 
 }
 //讚-1
 function notlike(commentID){
	let likeNum= parseInt($("#likeNum"+commentID).val())-1;
   $.ajax({
   url:"${pageContext.request.contextPath}/addcommentlike",
   type:"POST",
   data:{"commentID":commentID ,"memberID":getCookie("memberID")},
   dataType:"text",
   success:function(data){
	   $("#likeNum" + commentID).val(likeNum);
		$("#likebutton" + commentID).removeClass("likeclicked");
		$("#likebutton" + commentID).addClass("likenormal");
		$("#likebutton" + commentID).html('<i class="fa fa-thumbs-o-up"></i>&nbsp' + likeNum);
	    $("#likebutton" + commentID).attr("onclick","like("+commentID+")");
        $("#badbutton" + commentID).attr("onclick","bad("+commentID+")");
   },
   error : function(data){
	   alert("請先登入");
      }
   })
 }
 //噓+1
  function bad(commentID){
	  
	  let  badNum= parseInt($("#badNum"+commentID).val())+1;
	    $.ajax({
	    url:"${pageContext.request.contextPath}/addcommentbad",
	    type:"POST",
	    data:{"commentID":commentID,"memberID":getCookie("memberID")},
	    dataType:"text",
	   success:function(data){
	    $("#badNum" + commentID).val(badNum);
		$("#badbutton" + commentID).html('<i class="icon-thumbs-down"></i>&nbsp' + badNum);
		$("#badbutton" + commentID).removeClass("likenormal");
		$("#badbutton" + commentID).addClass("likeclicked");
	    $("#badbutton" + commentID).attr("onclick","notbad("+commentID+")");
        $("#likebutton" + commentID).attr("onclick","tolike("+commentID+")");
	   },
	   error : function(data){
		   alert("請先登入");
	      }		   
	   }) 
	 }
  //噓-1
	 function notbad(commentID){
		 let  badNum= parseInt($("#badNum"+commentID).val())-1;
	   $.ajax({
	   url:"${pageContext.request.contextPath}/addcommentbad",
	   type:"POST",
	   data:{"commentID":commentID ,"memberID":getCookie("memberID")},
	    dataType:"text",
	   success:function(data){
		   $("#badNum" + commentID).val(badNum);
		    $("#badbutton" + commentID).html('<i class="fa fa-thumbs-o-down"></i>&nbsp' + badNum);
			$("#badbutton" + commentID).removeClass("likeclicked");
			$("#badbutton" + commentID).addClass("likenormal");
		    $("#badbutton" + commentID).attr("onclick","bad("+commentID+")");
	        $("#likebutton" + commentID).attr("onclick","like("+commentID+")");
		   },
		error : function(data){
			alert("請先登入");
		  }	
	   })
	 }
  
  //讚+1 噓-1
  function tolike(commentID){
	  let  likeNum= parseInt($("#likeNum"+commentID).val())+1;
	  let  badNum= parseInt($("#badNum"+commentID).val())-1;
	   $.ajax({
	   url:"${pageContext.request.contextPath}/addcommentlike",
	   type:"POST",
	   data:{"commentID":commentID ,"memberID":getCookie("memberID")},
	    dataType:"text",
	   success:function(data){
		   $("#likeNum" + commentID).val(likeNum);
		   $("#badNum" + commentID).val(badNum);
			$("#likebutton" + commentID).removeClass("likenormal");
			$("#likebutton" + commentID).addClass("likeclicked");
			$("#badbutton" + commentID).removeClass("likeclicked");
			$("#badbutton" + commentID).addClass("likenormal");
		   $("#likebutton" + commentID).html('<i class="icon-thumbs-up"></i>&nbsp' + likeNum);
		    $("#badbutton" + commentID).html('<i class="fa fa-thumbs-o-down"></i>&nbsp' + badNum);
		    $("#badbutton" + commentID).attr("onclick","tobad("+commentID+")");
	        $("#likebutton" + commentID).attr("onclick","notlike("+commentID+")");
		   },
		error : function(data){
			alert("請先登入");
		  }	
	   })
	 }
  
  //讚-1 噓+1
  function tobad(commentID){
	  let  likeNum= parseInt($("#likeNum"+commentID).val())-1;
	  let  badNum= parseInt($("#badNum"+commentID).val())+1;
	   $.ajax({
	   url:"${pageContext.request.contextPath}/addcommentbad",
	   type:"POST",
	   data:{"commentID":commentID ,"memberID":getCookie("memberID")},
	   dataType:"text",
	   success:function(data){
		   $("#likeNum" + commentID).val(likeNum);
		   $("#badNum" + commentID).val(badNum);
			$("#likebutton" + commentID).removeClass("likeclicked");
			$("#likebutton" + commentID).addClass("likenormal");
			$("#badbutton" + commentID).removeClass("likenormal");
			$("#badbutton" + commentID).addClass("likeclicked");
			$("#likebutton" + commentID).html('<i class="fa fa-thumbs-o-up"></i>&nbsp' + likeNum);
			$("#badbutton" + commentID).html('<i class="icon-thumbs-down"></i>&nbsp' + badNum);
		    $("#badbutton" + commentID).attr("onclick","notbad("+commentID+")");
	        $("#likebutton" + commentID).attr("onclick","tolike("+commentID+")");
		   },
		error : function(data){
			alert("請先登入");
		  }	
	   })
	 }
	 
function report(commentID){
	alert("檢舉成功");
		$.ajax({
		url:"${pageContext.request.contextPath}/comments/report",
	    type:"POST",
	    data:{"commentID":commentID},
	    dataType:"text",
	    success:function(data){
	   }
	})
}
	 
function block(commentID){	  	
	$.ajax({
	url:"${pageContext.request.contextPath}/addcommentblock",
	type:"POST",
	data:{"commentID":commentID,"memberID":getCookie("memberID")},
	dataType:"text",
	success:function(data){
		alert("屏蔽成功");
		$("#comment" + commentID).remove();
		},
	error : function(data){
		alert("請先登入");
		}		   
	})
}
	 
	 function deletecomment(){
		  alert("刪除成功");		
	 }
	 
	 function fixcomment(){
		  alert("修改成功");		
	 }
	 
	 function quickenter(){
		 $("#commentContent").val("今年看過最好看的電影，大家不要考慮了，趕快去看!!!!!");
	 }
 
 function getCookie(cname) {
		var name = cname + "=";
		var ca = document.cookie.split(';');
		for (var i = 0; i < ca.length; i++) {
			var c = ca[i].trim();
			if (c.indexOf(name) == 0)
				return c.substring(name.length, c.length);
		}
		return "";
	}

</script>
</body>
</html>
