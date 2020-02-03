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
<title>StartTimes</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>電影時間</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
          <c:forEach var='MovieID' items='${playStartTime}'>
            <div class="col-sm-6 col-md-3" style="width: 200px; height: 200px">
                <div class="thumbnail" style="width: 200px; height: 200px">
                    <div class="caption">
                       <p>
                       		 <b >showtimeId:${MovieID.showTimeId}</b>
              		  </p>
              		  <p>
                       		 <b >時間:${MovieID.playStartTime}</b>
              		  </p>
                       <p>
                       		 <b >RUNID:${MovieID.run.runID}</b>
              		  </p>
                       <a href="<spring:url value='/queryStartTime?showTimeId=${MovieID.showTimeId}' />"
    							class="btn btn-primary">
    							<span class="glyphicon-info-sigh glyphicon"></span>詳細資料
 					</a>
						
                   </div>
                </div>
            </div>
        </c:forEach>
        </div>
         </section>
<script>
function quicklyQuery(){
	var showTimeId = document.getElementById("MovieID.showTimeId").value;
	$.ajax({  
    url: "${pageContext.request.contextPath}/quicklyQueryMovie",
    data : {showTimeId: showTimeId},
    type : "POST",
    dataType:"json",  
    success:function(data){  
         if(data.result=='SUCCESS'){  
            alert("修改成功");  
         }else{  
             alert("修改失败，失败原因[" + data + "]");  
         }  
         }
	}
	}
</script>
</body>
</html>
    