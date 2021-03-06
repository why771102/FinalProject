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
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->

<!-- stylesheets -->
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="../css/font-awesome.min.css"> -->
<!-- <link rel="stylesheet" href="../css/flexslider.css"> -->
<!-- <link rel="stylesheet" href="../css/style.css"> -->
<!-- <link rel="stylesheet" href="../css/responsive.css"> -->
<meta charset="UTF-8">
<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
/* 		border:3px #cccccc solid; */
	}
	
	#test{
		height:300px;
/* 		border:3px #cccccc solid; */
	}
	
	footer{
		bottom:0;
	}
	
	td{
		width:100px;
	}
	
	.tdWidth{
		width:10px;
	}
	
	
</style>
</head>
<body>
<!--     <header> -->
<%--        <jsp:include page="a/header.jsp"> --%>
<%--        <jsp:param name="a" value="1" /> --%>
<%-- </jsp:include> --%>
<!--     </header> -->
    <!-- header-->
	<section>
		<div>
			<div style="text-align: center">
				<h1>歷史訂票查詢結果</h1>
			</div>
		</div>
	</section>
<!-- 	<hr -->
<!-- 		style="height: 1px; border: none; color: #333; background-color: #333;"> -->
	<div id="test">
		<table>
		<tr style="text-align: center">
			<td>訂單編號</td>
			<td>會員編號</td>
			<td>電影名稱</td>
			<td>場次時間</td>
<!-- 			<td>票種</td> -->
<!-- 			<td>張數</td> -->
			<td>座位代碼</td>
		</tr>
			
		<c:forEach var="mo" items="${molist}">	
		<tr style="text-align: center">
			
				<td>${mo.ordersID}</td>
				<td>${mo.memberBean.memberID}</td>
				<td>${mo.showTimeHistoryBean.run.movie.title}</td>
				<c:set var="playTime1" value="${mo.showTimeHistoryBean.playStartTime}"/>
				<c:set var="playTime2" value="${fn:substring(playTime1, 0, 16)}" />
				<td>${playTime2}</td>
				
				
				<td class="tdWidth">
			<c:forEach var="tb" items="${tblist}">
							
							<c:if test="${tb.size()>1}">
							
								<c:forEach begin="0" end="${tb.size()-1}" var="seats">
								
								<c:if test="${tb[seats].mOrderBean.ordersID == mo.ordersID}">
								${tb[seats].seatsBean.seatID}  &nbsp;
								</c:if>

								</c:forEach>

								</c:if>
							
							
							<c:if test="${tb.size() == 1}">

							<c:forEach begin="0" end="${tb.size()-1}" var="seats">
							<c:if test="${tb[seats].mOrderBean.ordersID == mo.ordersID}">
							${tb[0].seatsBean.seatID}
							</c:if>
							
							</c:forEach>
						
							</c:if>
		
				</c:forEach>
					</td>
				</tr>	
			</c:forEach>
		
			
		</table>
	</div>
	<!-- footer -->
<!--     <footer> -->

<%--        <jsp:include page="a/footer.jsp"> --%>
<%--        	<jsp:param name="a" value="1" /> --%>
<%--        </jsp:include> --%>

<!--     </footer> -->
       
    <!-- footer -->

</body>
</html>
