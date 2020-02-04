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
<title>quickyQuery</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>快速查詢</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
 		<form><p><b>choose a name</b></p>
 		<span id ="show"></span>
 		</form>
        </div>
         </section>
<script>
function quicklyQuery(){
	var title = document.getElementById("MovieBean.title").value;
	$.ajax({  
    url: "${pageContext.request.contextPath}/quicklyQueryMovie",
    data : {title: title},
    type : "GET",
    success:function(data){  
         showNames(data);
         }
	});
	
	function showNames(data){
		var txt="";
		for(i in names)
			txt+="<option value='"+name[i]+"'>" +names[i]+"</option>";
			$('#show').html(txt);
	};
}
</script>
</body>
</html>
    