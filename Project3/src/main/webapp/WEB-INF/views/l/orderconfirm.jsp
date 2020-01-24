<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Tickets</title>
</head>
<body>
	<section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>請選擇票種</h1>
            </div>
        </div>
    </section>
<div class="ticketInfo bookBtn">
              <ul>
	            <li><a href="#bookNormal" class="icon-vsgeneral">
	                <h1>一般 / 銀行優惠 / iShow會員票種</h1>
	                <h2>GENERAL / BANK PRIVILEGE TICKET / iShow SVC DISCOUNT TICKET</h2></a></li>
	            <li><a href="#bookGroup" class="icon-vsgroup">
	                <h1>團體優待票券 / 愛心票 / 敬老票 / 免費兌換券</h1>
	                <h2>CORPORATE MOVIE MONEY / DISABILITY TICKET / ELDERLY TICKET / READMISSION</h2></a></li>
	          </ul>
              <div class="bookInfo">
                <h1>注意事項</h1>
                <ol>
	              <li>一般電影票種 / 銀行優惠票種將於交易後，立即由您的信用卡帳戶中進行扣款。</li>
	              <li>iShow會員票種每日訂票張數以 10 張為限，於交易後立即由您的儲值金中進行扣款。</li>
	              <li>「團體優待票券 / 愛心票 / 敬老票」無法和「一般電影票種 / 銀行優惠/ iShow會員票種」同時訂票，請分次訂購。</li>
	              <li>銀行優惠票種與iShow會員票種無法於同筆訂單中，請分次訂購，唯兩筆訂票無法保證座位。</li>
		      <li>為維護顧客權益，惡意佔位或影響他人正常訂位使用者，威秀影城保有調整或取消訂位之權利。</li>
                </ol>
              </div>
            </div>
</body>
</html>