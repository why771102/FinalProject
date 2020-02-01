<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
</head>
<body>
	<h1 style="text-align: center">MVC Exercise</h1>
	<hr>
	<table border="1" style="margin: 0px auto;">
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> <a href='questionListForEmp'>顯示客服列表(員工用)</a><BR></td>
			<td width="350"><p align="left" /> <a href='emps'>查詢所有員工</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='emp/add'>新增會員</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='searchEmp'>查詢單一員工</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='bgAnnos'>公告清單查詢(後台排序)</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='anno/add'>新增公告</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='annos'>公告清單(前台排序)</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='questionList'>顯示客服列表</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='emp/login'>員工登入</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='emp/logout'>員工登出</a><br>
    		</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='emp/updatePwd'>員工修改密碼</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='emp/logout'>員工登出</a><br>
    		</td>
		</tr>
		
		
		
	</table>

</body>
</html>