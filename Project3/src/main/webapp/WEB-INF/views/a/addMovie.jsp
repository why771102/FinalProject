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
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>AddMovie</title>

</head>
<body>
   <jsp:include page="header.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>


		<form:form method='POST' modelAttribute="Movie" enctype="multipart/form-data" >
		
			<fieldset>

					電影名稱:	<form:input name="title" path="title" type='text' value='a' /><br>
					簽約日:	<form:input name="contractDate" path="contractDate" type='text' value='1992-01-01' /><br>
					預期收益:		<form:input name="expectedProfit" path="expectedProfit" type='text' value='300' /><br>
					拆帳比:		<form:input name="profitRatio" path="profitRatio" type='text' value='0.6' /><br>
					片長:		<form:input name="runningTime" path="runningTime" type='text' value='102' /><br>
					導演:		<form:input name="director" path="director" type='text' value='雅菁'  /><br>
					演員:		<form:input name="cast" path="cast" type='text' value='雅菁'  /><br>
					類型:		<form:input name="genre" path="genre" type='text' value='1'  /><br>
					分級:		<form:input name="MovieRating" path="MovieRating" type='text' value='0'  /><br>
					預告:		<form:input name="trailer" path="trailer" type='text' value='wjiojfkisdjf' /><br>
					電影介紹:		<form:input name="plotSummary" path="plotSummary" type='text' value='雅菁怡瑩'  /><br>
					照片:		<form:input name="movieImage" path="movieImage" id="movieImage" type='file' onclick="getclass(this)"/><br>
					<div>
						<img class="preview" style="max-width: 150px; max-height: 150px;">
						<div class="size"></div>
					</div>
                 
			</fieldset>
		
	  				
	   
	   
		
	
		
			<fieldset>

					上映日:		<input type='text' name="release"   value='2020-01-14' id='release' /><br>
<!-- 					預計播放天數(一定要上映天數):<input type='text' name="expectedOnDate"  value='14' id='expectedOnDate'/><br> -->
<%-- 					實際播放天數:		<form:input name="onDate" path="onDate" type='text' /><br> --%>
					下檔日:		<input type='text'  name="expectedOffDate"   value='2020-01-28' id='expectedOffDate'/><br>
<%-- 					實際下檔日:		<form:input name="offDate" path="offDate" type='text' /><br> --%>
                                                    一定上映的天數:          <input type='text' name="MustShowDay"   value='7'id='MustShowDay' /><br>
					
				
             
			</fieldset>
		  <input id='a' type='submit' onclick="formSubmit()"/>
		
	   </form:form>
		

		
		<script>
		
		//照片預覽功能
		function getclass(obj) {
			//get photo input id
			var photo = "#" + obj.id;
// 			var p = photo.substring(photo.length-1, photo.length);
			$("body").on("change", photo, function() {
				preview(this);
			})
		}
		function preview(input) {
			if (input.files && input.files[0]) {
				var image = ".preview";
				console.log(image);
				var reader = new FileReader();
				reader.onload = function(e) {
					$(image).attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
	
		function formSubmit()
		  {
		 
		  
		
		var release = document.getElementById("release").value;
// 		var release = $("#release").val();
        var expectedOffDate =$('#expectedOffDate').val();
        var MustShowDay =$('#MustShowDay').val();
        
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/movie/add",
			data : {release: release, expectedOffDate: expectedOffDate, MustShowDay: MustShowDay},
			type : "POST",
			success : function() {
				alert("新增成功");
				window.location.href = "${pageContext.request.contextPath}/index-a";
			}
		});
		  }
		</script>
</body>
</html>


