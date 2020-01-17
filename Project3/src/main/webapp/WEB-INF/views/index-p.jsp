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
			<td width="350"><p align="left" /> <a href='member/register'>註冊會員(范)</a><BR></td>
			<td width="350"><p align="left" /> <a href='emps'>查詢所有員工</a><BR>
			</td>
		</tr>

		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='member/query'>查詢會員資料</a><BR>
			</td>
			<td width="350"><p align="left" /> 
				<a href='searchEmp'>查詢單一員工</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='hallOrder/apply'>包廳申請</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href='Member/hallOrderQuery'>包廳查詢(會員)</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='member/register'>註冊會員(范)</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href="Employee/hallOrderQuery">包廳查詢(員工)</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
			<td width="350"><p align="left" /> 
				<a href='member/login'>會員登入</a><BR>
			</td>
			<td width="350"><p align="left" />
				<a href="member/logout">會員登出</a><BR>
			</td>
		</tr>
		
		<tr height="52" bgcolor="lightblue" align="center">
    		<td width="350"><p align="left" /> 
    			<a href='forwardDemo'>RedirectView: forwardDemo</a><br> 
    		</td>
		    <td width="350"><p align="left" />
		    	<a href='redirectDemo'>RedirectView: redirectDemo</a><br>
    		</td>
		</tr>
	</table>

</body>
</html>