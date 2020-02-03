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

<title>showMovie</title>
<div>${sthb_list1.get(1).run.movie.movieID}</div>
<div>${sthb_list1.get(1).showTimeId}</div>
<div>${sthb_list1.get(1).playStartTime}</div>
<div>${sthb_list1.get(1).run.runID}</div>

</head>
<body>


	
		
		<script>
		var a =${sthb_list};
		
		console.log(a);
		function c(){
		console.log(document.getElementById("movieBean").value);
		}
		</script>
</body>
</html>
