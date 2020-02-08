<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- title -->
    <title>76影城</title>
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
    <script defer src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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
	
	header{
		position: fixed;
    	width: 100%;
    	display: block;
    	top: 0;
    	transition: top 0.3s;
	}
    </style>

</head>
<body>
<!-- 	<header> -->
<%-- 		<jsp:include page="../a/header.jsp"> --%>
<%-- 			<jsp:param name="a" value="1" /> --%>
<%-- 		</jsp:include> --%>
<!-- 	</header> -->
	<div class="container">
		<section>
			<div class="buy-block">
				<div style="text-align: center">
					<h1>公告</h1>
				</div>
			</div>
		</section>
		<hr
			style="height: 1px; border: none; color: #333; background-color: #333;">
<!-- 		<div> -->

<%-- 			<c:forEach var="anno" items="${annoList}"> --%>
<!-- 				<div> -->
<!-- 					<h4> -->
<%-- 						<a href="anno/${anno.annoId }">${anno.title} <span>${fn:substring(anno.startTime, 0 ,10)}</span></a> --%>
<!-- 					</h4> -->

<!-- 				</div> -->
<!-- 				<hr> -->
<%-- 			</c:forEach> --%>

<!-- 		</div> -->
	</div>

<div class="ser-list">
        <div class="container">
            <div class="row">

                <div class="col-sm-4" style="width: 116%;">
                    <ul class="nav nav-tabs list-items">
                    <c:forEach var="anno" items="${annoList}">
                        <li class="arrow_box" style="text-align: left;"><a href="anno/${anno.annoId }">&emsp; ${anno.title}</a>
                        </li>
                       </c:forEach> 
                    </ul>
                    <ul>
                    <li>
                    <a href="">read more</a>
                    </li>
                    </ul>
                </div>

<!--                 <div class="col-sm-8"> -->

<!--                     Tab panes -->
<!--                     <div class="tab-content"> -->
<%--                     <c:forEach var="ann" items="${annoList}"> --%>
                    
<!--                         <div class="tab-pane fade active in" id="1"> -->
<!--                             <div class="tab-data-info"> -->
<%--                                 ${ann.content} --%>
<!--                             </div> -->
<!--                         </div> -->
<%--                         </c:forEach>  --%>
<!--                     </div> -->

<!--                 </div> -->

            </div>
        </div>
    </div>



<!-- 	<footer> -->
<%-- 		<jsp:include page="../a/footer.jsp"> --%>
<%-- 			<jsp:param name="a" value="1" /> --%>
<%-- 		</jsp:include> --%>
<!-- 	</footer> -->

</body>
</html>
