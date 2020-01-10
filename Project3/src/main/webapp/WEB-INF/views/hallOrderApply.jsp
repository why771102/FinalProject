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

<table>
<%-- 						<form:input id="memberID" path="memberID" type='hidden'/><br> --%>
		<form:form method='POST' modelAttribute="hallOrderBean" enctype="multipart/form-data" >
		
			<fieldset>
			
				<tr>
					<td>租借日期:</td>
					<td><form:input id="date" path="orderDate" type='date'/></td>
				</tr>
				
				<tr>
					<td>租借起始時間:</td>
					<td><form:input id="startTime" path="startTime" type='date'/></td>
				</tr>
				<tr>
					<td>租借結束時間:</td>
					<td><form:input id="endTime" path="endTime" type='date' /></td>
				</tr>
				<tr>
					<td>選擇影廳:</td>
					<td><form:select path="hallID">
								<form:option value="-1">
									請選擇
								</form:option>
								<form:options items="${hallList}"/>
							</form:select></td>
				</tr>
				<tr>
					<td>包廳目的:</td>
					<td><form:input id="hallPurpose" path="hallPurpose" type='text' /></td>
				</tr>
				<tr>
					<td>原因詳述:</td>
					<td><form:input id="hallPurposeDetail" path="hallPurposeDetail" type='text' /></td>
				</tr>
				<tr>
					<td>預估包廳總金額:</td>
					<td><form:input id="hallSubtotal" path="hallSubtotal" type='text' /></td>
				</tr>
				<tr>
					<td><input type='submit' value="送出申請"/></td>
				</tr>
			</fieldset>
		</form:form>
</table>
</body>
</html>
