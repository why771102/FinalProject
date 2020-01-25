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
<title>StartTime</title>
</head>
<body> 
	<section>
		<div>
			<div class="container" style="text-align: center">
				<h2>電影資料</h2>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			
				 <p>
                   <b style='font-size: 16px;'>showtimeId:${queryStartTime.showTimeId}</b>
                        </p>
                         <p>
                       		 <b >時間:${queryStartTime.playStartTime}</b>
              		  </p>
                       <p>
                       		 <b >RUNID:${queryStartTime.run.runID}</b>
              		  </p>
				 <p>
                       		 <b >hallID:${queryStartTime.hall.hallID}</b>
              		  </p>
			
			</div>
		</div>
	</section>
</body>
</html>
