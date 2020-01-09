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

<title>包廳申請</title>

</head>
<body>


		<form:form method='POST' modelAttribute="hallOrderBean" enctype="multipart/form-data" >
		
			<fieldset>
<%-- 						<form:input id="memberID" path="memberID" type='hidden'/><br> --%>
					租借日期:<form:input id="date" path="orderDate" type='date'/><br>
					租借起始時間:	<form:input id="startTime" path="startTime" type='date'/><br>
					租借結束時間:<form:input id="endTime" path="endTime" type='date' /><br>
<%-- 					選擇影廳:<form:input id="hallID" path="hallID" type='text' /><br> --%>
					包廳目的:<form:input id="hallPurpose" path="hallPurpose" type='text' /><br>
					原因詳述:<form:input id="hallPurposeDetail" path="hallPurposeDetail" type='text' /><br>
					預估包廳總金額:<form:input id="hallSubtotal" path="hallSubtotal" type='text' /><br>
					<input type='submit' value="送出申請"/>
					
			</fieldset>
		</form:form>
</body>
</html>
