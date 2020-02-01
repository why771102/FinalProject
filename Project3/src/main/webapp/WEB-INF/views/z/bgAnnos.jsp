<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<section>
		<div>
			<div style="text-align: center">
				<h1>公告清單</h1>
			</div>
		</div>
	</section>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;">
	<div>
		<table>
		<tr>
			<td>公告編號</td>
			<td>公告標題</td>
			<td>公告狀態</td>
			<td>開始時間</td>
			<td>結束時間</td>
			<td>權重</td>
			<td>操作</td>
		</tr>
			<c:forEach var="anno" items="${allAnnos}">
		<tr>
			<td>${anno.annoId}</td>
			<td>${anno.title}</td>
			<td>${anno.annoStatusBean.statusName}</td>
			<td>${fn:substring(anno.startTime, 0, 10)}</td>
			<td>${fn:substring(anno.endTime, 0, 10)}</td>
			<td>${anno.priority}</td>
			<td><a href="anno/update/${anno.annoId}">修改公告</a>
			<a href="anno/launch/${anno.annoId}">上架</a>
			<a href="anno/takeoff/${anno.annoId}">下架</a></td>
		</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
