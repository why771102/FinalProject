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
<style>
.ticketInfo{
    width:100%;
    
  	text-align: center;
    min-height: 480px;
}
.bookBtn{
width:57%;
text-align:left;
display: inline-block;}
.t-button{
text-align:left;
margin-top :15px;
border-radius: 37px;
padding: 20px 50px;
width:100%}

.ticketInfo  {
 display: inline-block;
  font-size: 20px;
  padding: 20px;
  
}
.bookInfo{
text-align:left;
}
</style>
</head>
<body>
	<header>
	<jsp:include page="../a/header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>

	</header>
	 <section class="ticket-outer banner-featured">
        <div class="container">
            <div class="ticket-sell">
                <h3 class="font"> 請選擇票種</h3>
            </div>
        </div>
    </section>
<!-- 		<section> -->
<!--        	 <div> -->
<!--          	   <div class="container" style="text-align: center" > -->
<!--          	       <h1>請選擇票種</h1> -->
<!--        	     </div> -->
<!--      	   </div> -->
<!--    	 </section> -->


<div class="ticketInfo"  >
     <div class="bookBtn" >  
     	<font color="#FF0000" style="font-size:27px" ><b>請注意！76影城絕不會要求顧客至 ATM操作解除分期或補繳金額，請貴賓提高警覺避免受騙。</b></font>
        	<table style="display:inline-block " >
        		<tr>
　					<td><a href="<spring:url value='/bookNormal' />"class="icon-vsgeneral">
				<button class="t-button">  <h1>一般 / 銀行優惠 / 76會員票種</h1>
	                <h3>GENERAL / BANK PRIVILEGE TICKET / 76 SVC DISCOUNT TICKET</h3></button>
			</a></td>
　
　				</tr>
					<tr>
　					<td><a href="<spring:url value='/bookNormal' />"class="icon-vsgeneral">
				<button class="t-button">  <h1>團體優待票券 / 愛心票 / 敬老票 / 免費兌換券</h1>
	                <h3>CORPORATE MOVIE MONEY / DISABILITY TICKET / ELDERLY TICKET / READMISSION</h3></button>
			</a></td>
　
　				</tr>
        	
        	 
        	  
			 </table>
			    
	           
              <div class="bookInfo">
                <h1>注意事項</h1>
                <ol>
	              <li>一般電影票種 / 銀行優惠票種將於交易後，立即由您的信用卡帳戶中進行扣款。</li>
	              <li>會員票種每日訂票張數以 4 張為限，於交易後立即由您的儲值金中進行扣款。</li>
	              <li>「團體優待票券 / 愛心票 / 敬老票」無法和「一般電影票種 / 銀行優惠/ iShow會員票種」同時訂票，請分次訂購。</li>
	              <li>銀行優惠票種與iShow會員票種無法於同筆訂單中，請分次訂購，唯兩筆訂票無法保證座位。</li>
		      <li>為維護顧客權益，惡意佔位或影響他人正常訂位使用者，威秀影城保有調整或取消訂位之權利。</li>
                </ol>
              </div>
            </div>
           </div> 
<!-- footer -->
	<jsp:include page="../a/footer.jsp">
		<jsp:param name="a" value="1" />
		<jsp:param name="b" value="1" />
	</jsp:include>

	<!-- footer -->

</body>
</html>