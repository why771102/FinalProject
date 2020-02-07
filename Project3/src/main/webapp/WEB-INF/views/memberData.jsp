<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
	
<!-- stylesheets -->
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="../css/font-awesome.min.css"> -->
<!-- <link rel="stylesheet" href="../css/flexslider.css"> -->
<!-- <link rel="stylesheet" href="../css/style.css"> -->
<!-- <link rel="stylesheet" href="../css/responsive.css"> -->

<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
</style>

<!-- <title>會員資料</title> -->
</head>
<body>
<!--     <header> -->
<%--        <jsp:include page="a/header.jsp"> --%>
<%--        <jsp:param name="a" value="1" /> --%>
<%-- </jsp:include> --%>
<!--     </header> -->
<!-- 	<section class="login-block"> -->
<!-- 		<div class="container"> -->
			<div class="login-inner">
				<h2>會員資料</h2>
				<div class="login-form">
					<table>
						<form:form method='POST' modelAttribute="mData"
							enctype="multipart/form-data">

							<tr>
								<td>會員姓名：</td>
								<td><form:input id="name" path="name" type='text' /></td>
							</tr>
							<tr>
								<td>信箱：</td>
								<td><form:input id="email" path="email" type='text' /></td>
							</tr>
							<tr>
								<td>生日：</td>
								<td>${mData.birth}</td>
							</tr>
							<tr>
								<td>性別：</td>
								<td>${mData.gender}</td>
							</tr>
							<tr>
								<td>身分證字號：</td>
								<td>${mData.uID}</td>
							</tr>

							<tr>
								<td>連絡電話：</td>
								<td><form:input id="mobile" path="mobile" type='text' /></td>
							</tr>

							<tr>
								<td>住址：</td>
								<td><form:input id="address" path="address" type='text' /></td>
							</tr>
							<tr>
								<td><form:input id="memberID" path="memberID" type='hidden' /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="修改資料" class="inlog-btn" /></td>
							</tr>
						</form:form>
							<tr>
								<td colspan="2"><input type='button' value="回首頁" onclick="javascript:location.href='<c:url value='/' />'" class="inlog-btn"/></td>
							</tr>
					</table>
				</div>
			</div>
<!-- 		</div> -->
<!-- 	</section> -->
	
		<!-- footer -->
<!--     <footer> -->

<%--        <jsp:include page="a/footer.jsp"> --%>
<%--        	<jsp:param name="a" value="1" /> --%>
<%--        </jsp:include> --%>

<!--     </footer> -->
       
    <!-- footer -->
<script>
$('#memberDetail').click(function(){
	 $.ajax({
			url : "${pageContext.request.contextPath}/member/query",
			data : {
				mail:$('#email').val()
			},
			type : "GET",
			success : function(page) {
//				alert("新增成功!");
//				window.location.href = "${pageContext.request.contextPath}/backstageindex";
				$('#container').html(page);
//				window.history.pushState("object or string", "Title", "${pageContext.request.contextPath}/member/query");
			}
		});
})
</script>
</body>
</html>
