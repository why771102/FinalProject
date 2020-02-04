<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>oldShowTimeHitory</title>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

</head>
<body>
   <h1>排片查詢</h1>
    <label>請選擇日期：</label>

    <label>起始日期：</label>
    <input type="date" id="startShowDate" name="startDate" min="2019-11-01" max="2020-04-30">
    <label>結束日期：</label>
    <input type="date" id="endShowDate" name="endDate" min="2019-11-01" max="2020-04-30">
    <select name='hallID' id='hall'  value=''>
    <option  selected='' disabled='' value=''>請選擇廳</option>
    <option  selected=''  value='All'>全部</option>
    <option  selected=''  value='A'>A廳</option>
    <option  selected=''  value='B'>B廳</option>
    </select>
    
    <input id='a' type='submit' onclick="formSubmit()" value='確定送出'/>
   <br>
<!--    <div id ='AllTable'> -->
	<table id="table" class="display">
		<thead id='table_thead'>
			<tr id=>
				<td>日期:</td>
                <td>廳:</td>
                <td>showID</td>
                <td>runID</td>
                <td>代號:</td>
                <td>電影名稱:</td>
                <td>片長:</td>
                <td>播出時間:</td>
                <td>權重:</td>
                <td>修改：</td>
			</tr>
		</thead>
		<tbody id='table_tbody'>
		
		</tbody>
		
		
			
	
	</table>
<!-- 	</div> -->
	<script>
	  $(document).ready(function() {
		$("#table").dataTable();
	  });
	  
	  function updateSubmit(row){
		  alert("uapdate");
		  var date = document.getElementById("strDay" + row).innerHTML;
          var time = document.getElementById("time" + row).childNodes[0].value;
          var hallID= "All";
              hallID = (document.getElementById("hallID" + row)).innerHTML;
			console.log(date);
			console.log(time);
			console.log(hallID);
			location.replace("${pageContext.request.contextPath}/showTime/update/"+date+"="+time+"="+hallID);
	  }
	
	  
	  
	  function formSubmit(){
		  var start = document.getElementById("startShowDate").value;
		  var end = document.getElementById("endShowDate").value;
		  var hallID =document.getElementById("hall").value;
			console.log(start);
			console.log(end);
			console.log(hallID);
			
			
			$.ajax({
				url : "${pageContext.request.contextPath}/showTimeHistory/show",
				data : {start: start, end: end,hallID:hallID},
				type : "POST",
				success : function(data) {
					alert("送出成功");
					 var a =data;
// 					 var b=${showTime};
// 					 console.log(b);
// 					 alert(b);
// 						console.log("stID"+a[0].stID);
// 					  var divObj = document.getElementById("AllTable");
// 					  divObj.innerHTML = "";
// 	                    $("#AllTable").append(
// 		                    		"<table id='table' class='display'>"+
// 		                    		"<thead id='table_thead'>"+
// 		                    			"<tr id='table_tr' >"+
// 		                    				 "<td>日期:</td>"+
// 		                                   " <td>廳:</td>"+
// 		                                   " <td>showID</td>"+
// 		                                    "<td>runID</td>"+
// 		                                    "<td>代號:</td>"+
// 		                                   " <td>電影名稱:</td>"+
// 		                                   " <td>片長:</td>"+
// 		                                   " <td>播出時間:</td>"+
// 		                                   " <td>權重:</td>"+
// 		                    			"</tr>"+
// 		                    		"</thead>	");
					     var divObj = document.getElementById("table_tbody");
					     divObj.innerHTML = "";
					     var channelName=encodeURI(encodeURI(a[0].sthb.run.movie.title));
					     alert(channelName);
						for(i=0;i<a.length-1;i++){
 		                    $("#table_tbody").append(

		                    		
		                        " <tr id=tr" + i + ">" +
		                        "<td id='strDay" + i + "'>" + a[i].strDay + "</td>" +
		                        "<td id='hallID" + i + "'>" + a[i].sthb.hall.hallID + "</td>" +
		                        "<td  id='showTimeId" + i + "'>" + a[i].sthb.showTimeId + "</td>" +
		                        "<td id='runID" + i + "'>" + a[i].sthb.run.runID + "</td>" +
		                        "<td>" + a[i].stID + "</td>" +
		                        "<td>" +
		                        "<select name='' id='title' onchange='change(this.value," + i + ")' value='" + i + "'>" +
		                       
		                        "<option  selected='' disabled='' value='" + i + "'>" + a[i].sthb.run.movie.title + "</option>" +

		                        "</select>" +

		                        "</td>" +
		                        "<td><p id='runningTime" + i + "'>" + a[i].runningTime + "</p></td>" +
		                        "<td id='time" + i + "'>" + "<input id='appt-time' type='time' name='appt-time'" +
		                        "value='" + a[i].strTime + "'min='" + a[i].strTime + "' max='24:00' onchange='changeTime(this.value," + i + ")'><span class='validity'></span>"


		                        + "</td>" +
		                        "<td id='price_time" + i + "'>" + a[i].price_time + "</td>" +
		                        
		                        "<td id='update" + i + "'>"+" <input id='update' type='submit' onclick='updateSubmit("+i+")' value='修改'/>"+ "</td>" +

		                        "</tr>");
		                
						}
						$("#table").dataTable();

				}
			});
		  
	  }
	  
	</script>
</body>
</html>