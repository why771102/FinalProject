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
	<section>
		<div>
			<div style="text-align: center">
				<h1>歷史訂票查詢結果</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div id="test">
		<table>
		<tr style="text-align: center">
			<td>訂單編號</td>
			<td>會員編號</td>
			<td>電影名稱</td>
			<td>場次時間</td>
			<td>票種</td>
			<td>張數</td>
			<td>座位代碼</td>
		</tr>
			
		<tr style="text-align: center">
			<c:forEach var="mo" items="${molist}">
				<td>${mo.ordersID}</td>
				<td>${mo.memberBean.memberID}</td>
				<td>${mo.showTimeHistoryBean.run.movie.title}</td>
				<td>${mo.showTimeHistoryBean.playStartTime}</td>
			</c:forEach>
			

			<c:forEach var="modetail" items="${modetaillist}">
				<td>${modetail.productsBean.productName}</td>
				<td>${modetail.quantity}</td>
			</c:forEach>
			
			<c:forEach var="tb" items="${tblist}">
				<td>${tb.seatsBean.seatID}</td>
			</c:forEach>
		</tr>
			
		</table>
	</div>
	<!-- footer -->
    <footer>

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->
</body>
</html>
