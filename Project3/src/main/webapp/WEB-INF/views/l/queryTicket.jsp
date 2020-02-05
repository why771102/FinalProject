<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>queryTicket</title>

</head>
<body> 
	<section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>請輸入OrderID</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
	<section>
		<div>
			<div class="caption">
				<table>
					<tr>
						<td>訂單ID：</td>
						<td>${getOrderByID.ordersID}</td>
					</tr>
					<tr>
						<td>票狀態：</td>
						<td>${getOrderByID.ticketStatus}</td>
					</tr>
					<tr>
						<td>訂單成立時間：</td>
						<td>${getOrderByID.orderTime}</td>
					</tr>
					<tr>
						<td>場次ID：</td>
						<td>${getOrderByID.showTimeHistoryBean.showTimeId}</td>
					</tr>
					<tr>
						<td>會員編號：</td>
						<td>${getOrderByID.memberBean.memberID}</td>
					</tr>
					<tr>
						<td>領票時間</td>
						<td>${getOrderByID.ticketTime}</td>
					</tr>
					<tr>
						<td>員工ID：</td>
						<td>${getOrderByID.empBean.empId}</td>
					</tr>

					
				</table>
 					<a href="<spring:url value='/updateTicket/${getOrderByID.ordersID}' />">
 					修改</a>
			</div>
		</div>
	</section>
</body>
</html>
