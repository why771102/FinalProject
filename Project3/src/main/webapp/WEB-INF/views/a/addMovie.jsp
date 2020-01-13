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

<title>Movie</title>

</head>
<body>


		<form:form method='POST' modelAttribute="Movie" enctype="multipart/form-data" >
		
			<fieldset>

					電影名稱:	<form:input name="title" path="title" type='text' value='a' /><br>
					簽約日:	<form:input name="contractDate" path="contractDate" type='text' value='1992-01-01' /><br>
					預期收益:		<form:input name="expectedProfit" path="expectedProfit" type='text' value='51235' /><br>
					拆帳比:		<form:input name="profitRatio" path="profitRatio" type='text' value='0.6' /><br>
					片長:		<form:input name="runningTime" path="runningTime" type='text' value='102' /><br>
					導演:		<form:input name="director" path="director" type='text' value='雅菁'  /><br>
					演員:		<form:input name="cast" path="cast" type='text' value='雅菁'  /><br>
					類型:		<form:input name="genre" path="genre" type='text' value='1'  /><br>
					分級:		<form:input name="MovieRating" path="MovieRating" type='text' value='0'  /><br>
					預告:		<form:input name="trailer" path="trailer" type='text' value='wjiojfkisdjf' /><br>
					電影介紹:		<form:input name="plotSummary" path="plotSummary" type='text' value='雅菁怡瑩'  /><br>
<%-- 					照片:		<form:input name="photo" path="photo" type='text' /><br> --%>
                   <input id='a' type='submit' onclick="c()"/>
			</fieldset>
		
	   </form:form>
		
<%-- 		<form:form method='POST' modelAttribute="Run" enctype="multipart/form-data" > --%>
		
<!-- 			<fieldset> -->

<%-- 					上映日:		<form:input name="release" path="release" type='text' value='2020-01-14' /><br> --%>
<%-- 					預計播放天數(一定要上映天數):		<form:input name="expectedOnDate" path="expectedOnDate" type='text' value='' /><br> --%>
<%-- <%-- 					實際播放天數:		<form:input name="onDate" path="onDate" type='text' /><br> --%> --%>
<%-- 					下檔日:		<form:input name="expectedOffDate" path="expectedOffDate" type='text' value='2020-01-28' /><br> --%>
<%-- <%-- 					實際下檔日:		<form:input name="offDate" path="offDate" type='text' /><br> --%> --%>
<!--                                                     一定上映的天數:          <input name="MustShowDay"  type='text' value='7' /><br> -->
<%-- 					可否自由下檔:		<form:input name="status" path="status" type='text' value='0' /><br> --%>
				
             
<!-- 			</fieldset> -->
		
<!-- 			<input type='submit' onclick="formSubmit()" id='b' value='送出'/> -->
<%-- 		</form:form> --%>
		
		
		
		<script>
		function c(){
		console.log(document.getElementById("Movie").value);
	
		}
		function formSubmit()
		  {
		  document.getElementById("a").submit()
		  document.getElementById("b").submit()
		  }
		</script>
</body>
</html>


