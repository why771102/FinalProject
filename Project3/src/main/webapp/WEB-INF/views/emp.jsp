<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>員工清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<section>
		<div>
						<div class="caption">
							<p>員工編號：${emp.empId}</p>
							<p>員工姓名：${emp.empName}</p>
							<p>員工信箱：${emp.email}</p>
							<p>員工密碼：${emp.password}</p>
							<p>在職狀態：${emp.status}</p>
							<p>就職日期：${emp.startDate}</p>
							<p>離職日期：${emp.endDate}</p>
							<p>-----------------------</p>
							<hr>
						</div>
					</div>
	</section>
</body>
</html>
