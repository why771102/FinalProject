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

    
<style type="text/css">
 table{
  margin-left:auto; 
  margin-right:auto;
 }
 tr{ 
 	height:30;
	text-align: center;
 	} 
 	
  /* in article have padding */
.wrapList {
	/*Flex撅祆�批�*/
	display: flex;
	flex-flow: column nowrap;
	justify-content: flex-start;
	align-items: flex-start;
	/* border: solid 1px black;
       border-block-end-color: brown; */
	/* ���撖� */
	width: 100%;
	/* height: 100%; */
	/* border and padding in box */
	box-sizing: border-box;
	padding: 0% 0% 0% 2%;
}


div.tablist>ul {
	list-style: none;
	margin: 0;
	display: inline-flex;
}

div.tablist li{
	text-decoration: none;
	font-size: 18px;
	line-height: 54px;
	padding: 10px 40px 0px;
}

div.tablist ul li:hover{
	cursor: pointer;
	font-color: #C21010;
	opacity:0.6;
}
div.empty-list {
	width: 100%;
	margin: 24px 0;
	/* padding: 24px; */
	text-align: center;
}
li.selected{
	border-bottom: solid 5px #C21010;
}

input[type=text], select {
  width: 100%;
  padding: 9px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=text]:focus {
  border: 1px solid #339FFF;
  box-shadow: 0 0 5px rgba(81, 203, 238, 1);
}

</style>

<title>會員登入</title>

</head>
<body>
    <header>
       <jsp:include page="a/header.jsp">
       <jsp:param name="a" value="1" />
</jsp:include>
    </header>
    <div class="wrapList" style="margin-top:64px;">

    <div class="tablist">
      <ul>
        <li id="memberDetail">會員資料</li>
        <li id="memTicket">我的票夾</li>
        <li id="memOrder">訂單查詢</li>
        <li id="hallOrder">包廳申請查詢</li>
      </ul>
      <li style="display: inline; font-size: 16px;">歡迎, <span id="name"></span></li>
    </div>
  </div>
  <hr style="margin-inline-end: 2%; margin-block-start: 0.5em; margin-inline-start: 3%;">
  <div class="empty-list">
    <div class="image">
      <img src="" alt="">
    </div>
    <div id="text"></div>
  </div>
 <section class="login-block" style="padding: 45px 0 110px;">
  <div class="container" id="container">
<!--    <div class="login-inner"> -->
<!--     <h2>會員中心</h2> -->

<!--     <div class="login-form"> -->
<!--      <table> -->
<!--        <fieldset> -->
<!--         <tr> -->
<%--          <td colspan="2"><h3><a href="<c:url value='/member/query' />">會員資料</a></h3></td> --%>
<!--         </tr> -->
<!--         <tr> -->
<%--          <td colspan="2"><h3><a href="<c:url value='/member/ticket' />">我的票夾</a></h3></td> --%>
<!--         </tr> -->
<!--         <tr> -->
<%--          <td colspan="2"><h3><a href="<c:url value='' />">訂單查詢</a></h3></td> --%>
<!--         </tr> -->
<!--         <tr> -->
<%--          <td colspan="2"><h3><a href="<c:url value='/Member/hallOrderQuery' />">包廳申請查詢</a></h3></td> --%>
<!--         </tr> -->
<!--      </table> -->
<!--     </div> -->
<!--    </div> -->
  </div>
 </section>
 
	<!-- footer -->
    <footer style="bottom:0px;">

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->

 <script>
 
 cookieArray = document.cookie.split("; ");
	console.log(cookieArray);

	for (i = 0; i < cookieArray.length; i++) {
			memberIDArrays = cookieArray[i].split("=");
			console.log(memberIDArrays);
			if (memberIDArrays[0] == "memberID" && memberIDArrays[1] == "" || cookieArray.length == 1 || cookieArray.length == 0) {
// 				$("#name").text("訪客");
// 				$("#memberCenter").hide();
// 				$("#logout").hide();
			}else{
				for (i = 0; i < cookieArray.length; i++) {
				nameArrays = cookieArray[i].split("=");
				console.log(nameArrays);
				if (nameArrays[0] == "name") {
				$("#name").text(nameArrays[1]);
				}
			}
// 				$("#register").hide();
// 				$("#login").hide();
		}
	}

 $('#memberDetail').click(function(){
	 $('#memberDetail').addClass("selected");
	 $('#memTicket').removeClass("selected");
	 $('#hallOrder').removeClass("selected");
	 $('#memOrder').removeClass("selected");
	 
	 $.ajax({
			url : "${pageContext.request.contextPath}/member/query",
// 			data : {
				
// 			},
			type : "GET",
			success : function(page) {
// 				alert("新增成功!");
// 				window.location.href = "${pageContext.request.contextPath}/backstageindex";
				$('#container').html(page);
// 				window.history.pushState("object or string", "Title", "${pageContext.request.contextPath}/member/query");
			}
		});
 })
 
 $('#memTicket').click(function(){
	 $('#memTicket').addClass("selected");
	 $('#memberDetail').removeClass("selected");
	 $('#hallOrder').removeClass("selected");
	 $('#memOrder').removeClass("selected");
	 $.ajax({
			url : "${pageContext.request.contextPath}/member/ticket",
// 			data : {
				
				
// 			},
			type : "POST",
			success : function(page) {
// 				alert("新增成功!");
// 				window.location.href = "${pageContext.request.contextPath}/backstageindex";
				$('#container').html(page);
			}
		});
 })
 
 $('#memOrder').click(function(){
	 $('#memOrder').addClass("selected");
	 $('#memberDetail').removeClass("selected");
	 $('#memTicket').removeClass("selected");
	 $('#hallOrder').removeClass("selected");
	 $.ajax({
			url : "${pageContext.request.contextPath}/showSCOrderDetails",
//			data : {
				
				
//			},
			type : "GET",
			success : function(page) {
//				alert("新增成功!");
//				window.location.href = "${pageContext.request.contextPath}/backstageindex";
				$('#container').html(page);
			}
		});
 });
 
 $('#hallOrder').click(function(){
	 $('#hallOrder').addClass("selected");
	 $('#memberDetail').removeClass("selected");
	 $('#memTicket').removeClass("selected");
	 $('#memOrder').removeClass("selected");
	 $.ajax({
			url : "${pageContext.request.contextPath}/Member/hallOrderQuery",
// 			data : {
				
// 			},
			type : "POST",
			success : function(page) {
// 				alert("新增成功!");
// 				window.location.href = "${pageContext.request.contextPath}/backstageindex";
				$('#container').html(page);
			}
		});
 })
 
 
 </script>
</body>
</html>