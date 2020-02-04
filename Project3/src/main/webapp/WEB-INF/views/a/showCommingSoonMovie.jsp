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
<title>ShowAllMovie</title>

</head>
<body>
	<div id='movie'>
		<c:forEach var="run" items="${rb_page_list}">
			<div class="col-md-3 col-sm-4 col-xs-6"
				onclick='formsubmit(${run.runID})'>
				<div class="movie1">
					<div>
						<!--                         修改處from line 22 to 26 -->
						<%-- 					<img src="<c:url value='/getPicture/${run.movie.movieID}' />" --%>
						width="70%" height="50%">
					</div>
					<div class="m-name">
						<h3>${run.movie.title}</h3>
						<h4>${run.movie.genreBean.genre}</h4>
						<a href="" class="movie-btn1">Action</a> <a href=""
							class="movie-btn1">Thriller</a> <a href="" class="movie-btn1">Drama</a>
					</div>
				</div>
				<form id='runForm${run.runID}'
					action="${pageContext.request.contextPath}/show/this/movie"
					method="post">

					<input name='runID' type='hidden' value='${run.runID}'>

				</form>
				<a href="" class="book-now">BOOK NOW</a>
			</div>
      </c:forEach>
			<br>
    
	</div>
	<div id="paging">
		

	</div>

	<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->

	

	<div id='createPage'>
	<table border="1">
		<tr>
			<td width='76' id='pfirst_tr'><c:if test="${pageNo > 1}">
					<div id="pfirst" values='1' onclick='changePage(this.id)'>第一頁</div>
				</c:if></td>
			<td width='76' id='pprev_tr'><c:if test="${pageNo > 1}">
					<div id="pprev" values="${pageNo-1} " onclick='changePage(this.id)'>
						<a>上一頁</a>
					</div>
				</c:if></td>
			<td width='76'><c:if test="${pageNo != totalPages}">
					<div id="pnext" values='${pageNo+1} ' name='${pageNo+1}'
						onclick='changePage(this.id)'>
						<a>下一頁</a>
					</div>
				</c:if></td>
			<td width='76'><c:if test="${pageNo != totalPages}">
					<div id="plast" values='${totalPages}'
						onclick='changePage(this.id)'>
						<a>最末頁</a>
					</div>
				</c:if></td>
			<td width='176' align='center' id='pageCount'>第${pageNo}頁 /
				共${totalPages}頁</td>
		</tr>
	</table>
	
	</div>





	<script>
       var b=${rb_list};
// 	   var a=${rb_page_list};
	   var page =${pageNo};
	   var total =${totalPages};
	   console.log(page);
	   console.log(total);
	   var NowPage =1;
	   
	   
	   
	   /*	換下面頁數 */
	   function changPageNum (id){
		   console.log(document.getElementById(id).getAttribute("values"));
			var pageNoChange =document.getElementById(id).getAttribute("values"); 
			NowPage = pageNoChange;
			var pprev =document.getElementById(pprev);
			var pnext =document.getElementById(pnext);
			var plast =document.getElementById(plast);
			var count =document.getElementById(pageCount);
			var pfirst_tr =document.getElementById(pfirst_tr);
			alert("pageNoChange:"+pageNoChange);
			
			if(page =="1"){
			   if(pageNoChange*1 > 1){
// 				 $("#pfirst_tr").append("<div id='pfirst' values='1' onclick='changePage(this.id)'><a>第一頁</a></div>");
// 				 $("#pprev_tr").append("<div id='pprev' values='1' onclick='changePage(this.id)'><a>上一頁</a></div>");
				
// 				pfirst_tr.innerHTML="<div id='pfirst' values='1' onclick='changePage(this.id)'>第一頁</div>";
				
			    }else{
// 				   pfirst_tr.innerTest="";
			    }
			}else{}
			if(id =="pprev"){
				alert("上頁");
				document.getElementById(id).setAttribute("values", pageNoChange*1-1);
// 				pnext.setAttribute("values", (pageNoChange*1).toString);
// 				count.innerTest="第"+pageNoChange+"頁 / 共"+total+"頁";
			}else if(id=="pnext"){
				
				alert("下頁");
				document.getElementById(id).setAttribute("values", pageNoChange*1+1);
// 				document.getElementById(pprev).setAttribute("values", pageNoChange*1);
// 				count.innerTest="第"+pageNoChange+"頁 / 共"+total+"頁";
			}else if(id =="plast"){
				alert("最末");
// 				pnext.setAttribute("values", total);
// 				pprev.setAttribute("values", total*1-1);
// 				plast.setAttribute("values", total);
// 				pnext.innerHTML="";
// 				count.innerTest="第"+total+"頁 / 共"+total+"頁";
				
			}else{
// 				pnext.setAttribute("values", 2);
// 				pprev.innerHTML="";
// 				plast.setAttribute("values", total);
// 				count.innerTest="第1頁 / 共"+total+"頁";
			}
		   
	   }
	   
	   
	   
	   
	   
/*	跳轉選指定電影page */
	   function formsubmit(run){
		  alert("formsubmit");
		  console.log(JSON.stringify(run));
// 		  console.log(run.movie.movieID );
		  document.getElementById("runForm"+run).submit()
   
	   }
	   
	   function formsubmit2(runID){
		   alert("formsubmit2");
		   console.log(runID);
		   document.getElementById("runForm"+runID).submit()
	   }
	   
	   
	   
	   /*ajax changePage */
		function changePage(id) {
			console.log(document.getElementById(id).getAttribute("values"));
			var page =document.getElementById(id).getAttribute("values");
			page =page.trim();
			alert("送出page:"+page);
			 
// 			location.replace("${pageContext.request.contextPath}/commingSoon/All/movie"+page);
//             var url2="${pageContext.request.contextPath}/commingSoon/All/movie"+page;
//             console.log(url2);
// 			$.ajax({
// 						url : url2,
// 						type : "Get",
// 						success : function() {
// 							alert("傳送成功-更新頁數");

// 						}
// 					});
			changPageNum (id);
			
			$.ajax({
				url : "${pageContext.request.contextPath}/commingSoon/change/page",
				data : {"page":page},
				type : "POST",
				error: function(){alert("失敗");   },
				success : function(data) {
					
					alert("修改成功"+data);
//  			 	    document.getElementById("movie").remove();
 			 	  var divObj = document.getElementById("movie");
 			 	  var PageObj = document.getElementById("createPage");
 			 	      var a = data;
 			 	      console.log(data);
 			 	     
//  			 	      location.reload();
// 				      divObj.innerHTML ="";
				      alert("修改成功"+data);
				      divObj.innerHTML="";
				      PageObj.innerHTML="";
// 				      $("#movie").append("<div>aaa</div>");

				      //append Json
				      for(let i=0 ;i<a.length;i++){
				    	  
				    	  $("#movie").append("<div id='"+a[i].runID+"' class='col-md-3 col-sm-4 col-xs-6'onclick='formsubmit2(this.id)' >"+
				    		  "<div class='movie1'>"+
								"<div>"+
	                               //圖片
								"</div>"+
								"<div class='m-name'>"+
									"<h3>"+a[i].movie.title+"</h3>"+
									"<h4>"+a[i].movie.genreBean.genre+"</h4>"+
									"<a href='' class='movie-btn1'>"+a[i].movie.movieRatingBean.rating+"</a> <a href=''class='movie-btn1'>"+
									"	Thriller</a> <a href='' class='movie-btn1'>Drama</a>"+
								"</div>"+
							"</div>"+
							"<form id='runForm"+a[i].runID+"'action='${pageContext.request.contextPath}/show/this/movie' method='post'>"+
        			       "<input name='runID' type='hidden' value='"+a[i].runID+"'>"+
							"</form>"+
							"<a href='' class='book-now'>[電影訂票]</a>"+
						"</div>"+

						"<br>");
				      }
				      
				      
				     
				      // append create page
				      $("#createPage").append(
				    		  "<table border='1'>"+
				    		   " <tr>"+
				    		        "<td width='76' id='pfirst_tr'>"+
				    		                "<div id='pfirst'  values='1' onclick='changePage(this.id)'>"+
				    		         " <a>第一頁</a></div>"+
				    		         "  </td>"+
				    		       " <td width='76'>"+
				    		               " <div id='pprev' values='"+(page*1-1)+"' onclick='changePage(this.id)' >"+
				    		                " <a>上一頁</a>"+
				    		               " </div>"+
				    		          " </td>"+
				    		        "<td width='76'>"+
				    		                "<div id='pnext' values='"+(page*1+1)+"' onclick='changePage(this.id)' >"+
				    		                    " <a>下一頁</a>"+
				    		               " </div>"+
				    		           " </td>"+
				    		        "<td width='76'>"+
				    		               " <div id='plast'  values='"+total+"' onclick='changePage(this.id)' >"+
				    		                     "<a>最末頁</a>"+
				    		                "</div>"+
				    		           "</td>"+
				    		        "<td width='176' align='center' id='pageCount'>第"+total+"頁 / 共"+total+"頁</td>"+
				    		   " </tr>"+
				    		"</table>"  
				      
				      
				      );
				      //調整出現
				      if(page == "1"){
				    	  var oneObj = document.getElementById("pfirst");
		 			 	  var pprev = document.getElementById("pprev");
				    	  oneObj.innerHTML="";
				    	  pprev.innerHTML="";
				      }else if(page == total){
				    	  var pnext = document.getElementById("pnext");
				    	  pnext.innerHTML="";
				      }
				      
				      
				    
				    
				}
				   

			});
		}
		
		
			
	
		
		
		//		  {

		//		var release = document.getElementById("release").value;
		// 		var release = $("#release").val();
		//      var expectedOffDate =$('#expectedOffDate').val();
		//      var MustShowDay =$('#MustShowDay').val();
	</script>
</body>
</html>


