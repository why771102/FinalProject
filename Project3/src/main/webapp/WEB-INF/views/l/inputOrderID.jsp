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
<title>OrderID</title>
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
  	<form method='POST' action="${pageContext.request.contextPath}/searchTicket" >

					請輸入訂單ID:	<input name="orderID"  type='text' /><br>
					
						<input type='submit'/>
						

	</form>
	
</body>
</html>
    