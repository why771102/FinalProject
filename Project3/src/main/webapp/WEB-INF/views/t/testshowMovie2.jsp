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
	<section class='gray-bnr feature-sec ' style='background-color: black;'>
		<div class='container'>

			<div class='buy-txt'>
				${sthb_list1.get(1).run.movie.trailer}
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
							<img style='width: 100%; height: 100%;' src='img/feature2.jpg'>
						</div>

					</div>

				</div>


				<div class='col-sm-6'>
					<!-- <div class='ex-feature'> -->

					<h2>${sthb_list1.get(1).run.movie.title}</h2>
					<table>
						<tr>
							<td>導演：</td>
							<td>${sthb_list1.get(1).run.movie.director}</td>
						</tr>
						<tr>
							<td>演員：</td>
							<td>${sthb_list1.get(1).run.movie.cast}</td>
						</tr>
						<tr>
							<td>類型：</td>
							<td>${sthb_list1.get(1).run.movie.genreBean.genre}</td>
						</tr>
						<td>分級：</td>
						<td>${sthb_list1.get(1).run.movie.movieRatingBean.rating}</td>

						<tr>
							<td>片長：</td>
							<td>${sthb_list1.get(0).run.movie.runningTime}</td>
						</tr>
					</table>
					<div id='showTimeHere'>
						<h3
							style='border-bottom: solid rgb(100, 100, 100) 2px; padding-bottom: 10px'>播放場次</h3>
						<table id='showTime_table'>
							<!--                             <tr id ='showTime_tr'> -->
							<%--                             <c:forEach var="one" items="${oneMovie1}" > --%>
							<%--                                       <c:if test=${oneMovie1.strDay }> --%>
							<%--                                      <td style='padding:10px;margin: 0px;'><a href='free-trail.html' class='slider-btn'>${one.strTime}</a></td> --%>
							<%--                                       </c:if> --%>
							<%--                             </c:forEach> --%>



							</tr>
						</table>
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
	<!-- banner -->
	<section class='contact-sec '>
		<div class='container'>

			<div class='buy-txt'>
				<h2>
					<b style='font-size: 16px;'> ${AVGExpectation}%期待
						平均評分:${AVGGrade} <a href="<spring:url value='/' />"
						class="btn btn-primary">發表時間 </a> <a
						href="<spring:url value='/' />" class="btn btn-primary">評分 </a>
					</b>
				</h2>
				<p></p>
				<br>

			</div>

			<div class='buy-txt'>

				<div class='col-sm-12 col-xs-12'>
					<!-- 					<div class="avggrade"> -->

					<!-- 						<p> -->
					<%-- 							<b style='font-size: 16px;'> ${AVGExpectation}%期待 --%>
					<%-- 								平均評分:${AVGGrade} <a href="<spring:url value='/' />" --%>
					<!-- 								class="btn btn-primary">發表時間 </a> <a -->
					<%-- 								href="<spring:url value='/' />" class="btn btn-primary">評分 </a> --%>
					<!-- 							</b> -->
					<!-- 						</p> -->

					<!-- 					</div> -->
					<c:forEach var='comment' items='${Comments}'>
						<div class="comments" style="width: 100%; height: 300px">
							<div class="thumbnail" style="width: 100%; height: 280px">
								<div class="caption_comment" style="text-align: left">
									<p>
										評分等級:${comment.grade} <a
											href="<spring:url value='/preference/addlike/${comment.movieBean.movieID } ?id=${comment.commentID}' />"
											class="btn btn-primary">${comment.likeNum}讚 </a> <a
											href="<spring:url value='/preference/addbad/${comment.movieBean.movieID } ?id=${comment.commentID}' />"
											class="btn btn-primary">${comment.badNum}噓 </a>
									</p>
									<p>會員ID:${comment.memberBean.account}</p>
									<p>已觀賞:${comment.watched}</p>
									<p>短評內文:${comment.commentContent}</p>
									<c:set var="commentTime1" value="${comment.commentTime}" />
									<c:set var="commentTime2"
										value="${fn:substring(commentTime1, 0, 16)}" />
									<p>${commentTime2}</p>
									<p>
										<a
											href="<spring:url value='/preference/addblock/${comment.movieBean.movieID } ?id=${comment.commentID}' />"
											class="btn btn-primary"> <span
											class="glyphicon-info-sigh glyphicon"></span>屏蔽
										</a> <a
											href="<spring:url value='/comments/report/${comment.movieBean.movieID } ?id=${comment.commentID}' />"
											class="btn btn-primary"> <span
											class="glyphicon-info-sigh glyphicon"></span>檢舉
										</a>
									</p>

								</div>
							</div>
						</div>
					</c:forEach>

				</div>

			</div>
		</div>
	</section>

	<section class='dark-blue'>
		<div class='container'>
			<div class='ready'>
				<h4>現在就立刻購票！</h4>
				<p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
				<a href="<c:url value='movieIndex#booknow'/>" class='slider-btn'>前往購票</a>
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
	var a = $
	{
		sthb_list
	};
	var b = $
	{
		oneMovie
	};
	console.log(a);
	console.log(b);
	var StratTime = b[0].strDay;
	var EndTime = b[(b.length) - 1].strDay;
	console.log(StratTime);
	console.log(EndTime);
	var today = new Date(StratTime + " " + "00:00");
	var todayMonth = today.getMonth() * 1 + 1;
	var todayDate = today.getDate() * 1;
	var during = new Date(EndTime + " " + "00:00");
	var endMonth = during.getMonth() * 1 + 1;
	var endDate = during.getDate() * 1;
	console.log(endMonth);
	console.log(endDate);
	console.log(todayMonth);
	console.log(EndTime);
	var diff = during - today;//差多少毫秒數
	var diffDay = diff
	/(1000*60*24*60) / / 差幾日
	console.log("diff" + diff);
	console.log("diff" + diffDay);

	// 處理showTime 時間

	for (let day = 0; day <= diffDay; day++) {
		$("#showTime_table").append(
				"<tr><td>" + "2020" + "-" + (todayMonth) + "-"
						+ (todayDate + day) + "</td></tr>"
						+ "<tr id ='showTime_tr"+day+"'></tr>");
		for (let i = 0; i <= (b.length - 1); i++) {
			console.log("b" + b.length);
			console.log("i" + i);
			var during2 = new Date(b[i].strDay + " " + "00:00");
			// 					var during3 = new Date(b[i+1].strDay+" "+"00:00");
			console.log("todayMonth" + todayMonth);
			console.log((during2.getMonth() * 1) + 1);
			if (todayMonth == (during2.getMonth() * 1) + 1) {
				console.log("during2" + during2.getDate() * 1);
				console.log("today+day" + todayDate + day);
				if (during2.getDate() * 1 == todayDate + day) {

					console.log("相同月份");

					document.getElementById("showTime_tr" + day).innerHTML += "<td style='padding:10px;margin: 0px;'><a href='free-trail.html' class='slider-btn'>"
							+ b[i].strTime + "</a></td>";
					//  							  $("#showTime_tr0").append(

					//  			                       "<td style='padding:10px;margin: 0px;'><a href='free-trail.html' class='slider-btn'>"+b[i].strTime+"</a></td>" 

					//  							  );
				} else {
				}

			} else {
				alert("月份不同");
			}

		}

	}

	function c() {
		console.log(document.getElementById("movieBean").value);
	}
</script>
</body>
</html>
