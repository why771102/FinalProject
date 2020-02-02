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

<title>ShowAllMovie</title>

</head>
<body>
	<c:forEach var="run" items="${rb_page_list}">
		<div class="col-md-3 col-sm-4 col-xs-6" onclick='formsubmit(this.value)' value='${run.runID}'>
			<div class="movie1">
				<div>
					<!--                         修改處from line 22 to 26 -->
					<img src="<c:url value='/getPicture/${run.movie.movieID}' />"
						width="70%" height="50%">
				</div>
				<div class="m-name">
					<h3>${run.movie.title}</h3>
					<h4>${run.movie.genreBean.genre}</h4>
					<a href="" class="movie-btn1">Action</a> <a href=""
						class="movie-btn1">Thriller</a> <a href="" class="movie-btn1">Drama</a>
				</div>
			</div>
			<form id='runForm${run.runID}' action="${pageContext.request.contextPath}/show/this/movie" method="post">
			
			<input  name='runBean' type='hidden' value='${run}'>
			</form>
			<a href="" class="book-now">BOOK NOW</a>
		</div>

		<br>

		<div id="paging">
	</c:forEach>
	<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
	<table border="1">
		<tr>
			<td width='76'><c:if test="${pageNo > 1}">
					<div id="pfirst" onclick='changePage()'>第一頁</div>
				</c:if></td>
			<td width='76'><c:if test="${pageNo > 1}">
					<div id="pprev" onclick='changePage(this.value)'
						value='${pageNo-1}'>
						<a>上一頁</a>
					</div>
				</c:if></td>
			<td width='76'><c:if test="${pageNo != totalPages}">
					<div id="pnext" onclick='changePage(this.value)'
						value='${pageNo+1}'>
						<a>下一頁</a>
					</div>
				</c:if></td>
			<td width='76'><c:if test="${pageNo != totalPages}">
					<div id="plast" onclick='changePage(this.value)'
						value='${totalPages}'>
						<a>最末頁</a>
					</div>
				</c:if></td>
			<td width='176' align="center">第${pageNo}頁 / 共${totalPages}頁</td>
		</tr>
	</table>
	</div>

	<script>
		
	</script>



	<script>
	   
	
	   function formsubmit(run){
		  
		  console.log( JSON.stringify(run));
		  console.log(run.movie.movieID );
		  document.getElementById("runForm"+run).submit()
		  
		  
		/*   var runID = run.runID;
		  $.ajax({
				url : "${pageContext.request.contextPath}/show/this/movie",
				data : {"run" :JSON.stringify(run) },
				type : "POST",
				success : function(data) {
					alert("傳送成功傳過去-runID");
					 window.location.href = "${pageContext.request.contextPath}/show/this/movie"+data;

				}
			}); */
		   
	   }
	   
	   
	
		function changePage(value) {
			var page = value;

			$.ajax({
						url : "${pageContext.request.contextPath}/commingSoon/All/movie",
						data : {
							page : page
						},
						type : "POST",
						success : function() {
							alert("傳送成功-更新頁數");

						}
					});
		}
		
		formsubmit(){
			
		}
		
		
		//		  {

		//		var release = document.getElementById("release").value;
		// 		var release = $("#release").val();
		//      var expectedOffDate =$('#expectedOffDate').val();
		//      var MustShowDay =$('#MustShowDay').val();
	</script>
</body>
</html>


