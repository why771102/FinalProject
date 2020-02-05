<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>訂單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<section>
		<div>
			<div class="caption">
				<form:form method='POST' modelAttribute="MOrderBean" >
					<table>
						<tr>
							<td>訂單ID：</td>
<%-- 							<td>${MOrderBean.ordersID}</td> --%>
							<td><form:input name="ordersID" path="ordersID" type='text' /></td>
						</tr>
						<tr>
							<td>票狀態：</td>
							<td><form:input name="ticketStatus" path="ticketStatus" type='text' /></td>
						</tr>
						<tr>
							<td>訂單成立時間：</td>
							<td><form:input name="orderTime" path="orderTime" type='text' /></td>
						</tr>
						<tr>
							<td>場次ID：</td>
							<td><form:input name="showTimeHistoryBean.showTimeId" path="showTimeHistoryBean.showTimeId" type='text' /></td>
						</tr>
						<tr>
							<td>會員編號：</td>
							<td><form:input name="memberBean.memberID" path="memberBean.memberID" type='text' /></td>
						</tr>
						<tr>
							<td>領票時間：</td>
							<td><form:input name="ticketTime" path="ticketTime" type='text' /></td>
						</tr>
						<tr>
							<td>員工ID：</td>
							<td><form:input name="empBean.empId" path="empBean.empId" type='text' /></td>
						</tr>
					
					</table>
					<input id="btnAdd" type="submit" value="已領票" />
				</form:form>
			</div>
		</div>
	</section>
	
</body>
</html>
