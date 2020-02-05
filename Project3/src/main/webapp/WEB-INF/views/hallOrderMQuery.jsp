<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<!-- stylesheets -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/flexslider.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">
<meta charset="UTF-8">
<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
		border:3px #cccccc solid;
	}
	
	#test{
		height:300px;
	}
	
	footer{
		bottom:0;
	}
	
	td{
		width:100px;
	}
	
</style>
</head>
<body>
    <header>
       <jsp:include page="a/header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
    <!-- header-->
<!-- header -->
<!--         <nav class="navbar navbar-default navbar-static-top my-navigation"> -->
<!--             <div class="container"> -->
<!--                 <div class="navbar-header"> -->
<!--                     <button type="button" class="navbar-toggle collapsed my-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> -->
<!--                         <span class="sr-only">Toggle navigation</span> -->
<!--                         <span class="icon-bar"></span> -->
<!--                         <span class="icon-bar"></span> -->
<!--                         <span class="icon-bar"></span> -->
<!--                     </button> -->
<%--                     <a class="navbar-brand" href="<c:url value='/' />"><img src="../img/logo-1.png" class="logo-hdr" width="180"> --%>
<!--                     </a> -->
<!--                 </div> -->
<!--                 <div id="navbar" class="navbar-collapse collapse my-nav-collapse"> -->
<!--                     <ul class="nav navbar-nav navbar-right"> -->
<%--                         <li class="active"><a href="<c:url value='/' />">home</a> --%>
<!--                         </li> -->
<!--                         <li><a href="latest.html">即將上映</a> -->
<!--                         </li> -->
<!--                         <li><a href="latest.html">熱映中</a> -->
<!--                         </li> -->
<!--                         <li><a href="up-coming.html">購票</a> -->
<!--                         </li> -->
<!--                         <li><a href="conatct.html">contact</a> -->
<!--                         </li> -->
<!--                         <li><a href="products.html">周邊商品</a> -->
<!--                         <li><a href="shopCart.html" style='padding:5px;'><img src="../img/shoppingcart.png" alt="" srcset=""width='25' height='20'style='position:relative;'></a> -->
<!--                         </li> -->
<%--                         <li class="free-trial-btn" id="login"><a href="<c:url value='/member/login' />">登入</a> --%>
<%--                         <li class="free-trial-btn" id="logout"><a href="<c:url value='/member/logout' />">登出</a>     --%>
<!--                         </li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--                 /.nav-collapse -->
<!--             </div> -->
<!--         </nav> -->
<!--     </header> -->
<!--     header -->
	<section>
		<div>
			<div style="text-align: center">
				<h1>您的包廳申請清單</h1>
			</div>
		</div>
	</section>
<!-- 	<hr -->
<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
	<div id="test">
		<table >
		<tr style="text-align: center">
			<td><b>申請編號</b></td>
			<td><b>申請廳院</b></td>
			<td><b>申請日期</b></td>
			<td><b>起始時間</b></td>
			<td><b>結束時間</b></td>
			<td><b>申請總時數</b></td>
			<td><b>申請總金額</b></td>
			<td><b>申請狀態</b></td>
			<td><b>付款狀態</b></td>
		</tr>
			<c:forEach var="hoA" items="${allMHO}">
		<tr style="text-align: center">
			<td>${hoA.hallOrderNo}</td>
			<td>${hoA.hb.hallID}廳</td>
			<c:set var="date1" value="${hoA.orderDate}"/>
			<c:set var="date2" value="${fn:substring(date1, 0, 10)}" />
			<td>${date2}</td>
			<c:set var="startTime1" value="${hoA.startTime}"/>
			<c:set var="startTime2" value="${fn:substring(startTime1, 11, 16)}" />
			<td>${startTime2}</td>
			<c:set var="endTime1" value="${hoA.endTime}"/>
			<c:set var="endTime2" value="${fn:substring(endTime1, 11, 16)}" />
			<td>${endTime2}</td>
			<td>${hoA.orderHours}小時</td>
			<td>${hoA.hallSubtotal}元</td>
			<td>${hoA.hob.hallOrderStatus}</td> 
			<td>${hoA.psb.payStatus}</td> 
		</tr>
			</c:forEach>
		</table>
	</div>
	<!-- footer -->
    <footer>

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->
    <script>
//     cookieArray = document.cookie.split("; ");
// 	console.log(cookieArray);

// 	for (i = 0; i < cookieArray.length; i++) {
// 			memberIDArrays = cookieArray[i].split("=");
// 			console.log(memberIDArrays);
// 			if (memberIDArrays[0] == "memberID" && memberIDArrays[1] == " ") {
// // 				$("#name").text("訪客");
// 				$("#logout").hide();
// 			}else{
// 				for (i = 0; i < cookieArray.length; i++) {
// 				nameArrays = cookieArray[i].split("=");
// 				console.log(nameArrays);
// // 				if (nameArrays[0] == "name") {
// // 				$("#name").text(nameArrays[1]);
// // 				}
// 			}
// // 				$("#register").hide();
// 				$("#login").hide();
// 		}
// 	}
    </script>
</body>
</html>
