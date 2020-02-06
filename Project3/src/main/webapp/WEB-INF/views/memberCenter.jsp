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
<link rel="stylesheet"
 href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 
<!-- stylesheets -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/flexslider.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/responsive.css">
    
<style type="text/css">
 table{
  margin-left:auto; 
  margin-right:auto;
 }
 tr{ 
 	height:30;
	text-align: center;
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
 <section class="login-block">
  <div class="container">
   <div class="login-inner">
    <h2>會員中心</h2>

    <div class="login-form">
     <table>
       <fieldset>
        <tr>
         <td colspan="2"><h3><a href="<c:url value='/member/query' />">會員資料</a></h3></td>
        </tr>
        <tr>
         <td colspan="2"><h3><a href="<c:url value='/member/ticket' />">我的票夾</a></h3></td>
        </tr>
        <tr>
         <td colspan="2"><h3><a href="<c:url value='' />">訂單查詢</a></h3></td>
        </tr>
        <tr>
         <td colspan="2"><h3><a href="<c:url value='/Member/hallOrderQuery' />">包廳申請查詢</a></h3></td>
        </tr>
     </table>
    </div>
   </div>
  </div>
 </section>
 
	<!-- footer -->
    <footer>

       <jsp:include page="a/footer.jsp">
       	<jsp:param name="a" value="1" />
       </jsp:include>

    </footer>
       
    <!-- footer -->

 <script>

 </script>
</body>
</html>