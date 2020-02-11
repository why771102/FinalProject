<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" -->
<!-- 	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> -->
<!-- stylesheets -->
<!--     <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!--     <link rel="stylesheet" href="../css/font-awesome.min.css"> -->
<!--     <link rel="stylesheet" href="../css/flexslider.css"> -->
<!--     <link rel="stylesheet" href="../css/style.css"> -->
<!--     <link rel="stylesheet" href="../css/responsive.css"> -->
 <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/img/favicon.png" rel="icon">
    <link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">

    
    <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/bg-style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet">
    
<style type="text/css">
	table{
		margin-left:auto; 
		margin-right:auto;
	}
</style>

<title>76影城</title>

</head>
<body>

	<div id="login-page">
        <div class="container">
            <div class="form-login">
                <h2 class="form-login-heading">76 影城</h2>
                <div class="login-wrap">

                    
                    
                    
                    
                    <form:form method='POST' modelAttribute="empBean" enctype="multipart/form-data">

                        <form:input type="text" class="form-control" placeholder="E-Mail" path="email"></form:input>
                        <br>
                        <form:input type="password" class="form-control" placeholder="Password" path="password"></form:input>
                        <label class="checkbox">
                            &emsp;&nbsp;&nbsp;<input type="checkbox" value="remember-me"> 記住我
                            <span class="pull-right">
                                <a data-toggle="modal" href="login.html#myModal"> 忘記密碼?</a>
                            </span>
                        </label>
                        <input type='submit' value="登入" id="sumit1"  class="btn btn-theme btn-block"/>

                    </form:form>
                    
                    

                </div>
                <!-- Modal -->
                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title">重置密碼</h4>
                            </div>
                            <div class="modal-body">
                                <p>請輸入電子信箱</p>
                                <input type="text" name="email" id="email2" autocomplete="off" class="form-control placeholder-no-fix">
                            </div>
                            <div class="modal-body">
                                <p>請輸入身分證字號</p>
                                <input type="text" name="uid" id="uid" autocomplete="off" class="form-control placeholder-no-fix">
                            </div>
                            <div class="modal-footer">
                                <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                                <button class="btn btn-theme" type="button" id="reset">送出</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- modal -->
            </div>
        </div>
    </div>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("${pageContext.request.contextPath}/img/login-bg.jpg", {
            speed: 500
        });
        
        
        $("#reset").click(function(){
        	var email = $("#email2").val();
            var uid = $("#uid").val();
            console.log(email);
            console.log(uid);
        	$.ajax({
        		url : "${pageContext.request.contextPath}/checkUid",
        		type : "POST",
        		data : {email : email , uid : uid},
        		success : function(data) {
        			console.log(data.empId);
        			var empId = data.empId;
        			$.ajax({
        				url : "${pageContext.request.contextPath}/resetPwd",
                		type : "POST",
                		data : {empId : empId},
        				success: function(data) {
        					alert("密碼已重置，請重新登入！");
        				},
        				error: function(data) {
        					alert("發生不明錯誤，請重試！");
        				}
        			})
        		},
        		error: function(data) {
        			alert("輸入的資料有誤，請重新輸入！");
        		}
        	})
        })
        
        

    </script>
	


</body>
</html>
