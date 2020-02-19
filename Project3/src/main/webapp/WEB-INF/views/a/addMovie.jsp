<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>DataTable</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!--external css-->
<link
	href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/backstagestyle.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style-responsive.css"
	rel="stylesheet">
<!-- Custom styles for jueryDataTable -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">



<!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
<!--  =============================CSS put Here============================== -->
<style>
</style>
<!--  =============================CSS put Here============================== -->
</head>

<body>
	<section id="container">
		<!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
		<!--header start-->
		<jsp:include page="../z/bg-header.jsp">
			<jsp:param name="a" value="1" />
			<jsp:param name="b" value="1" />
		</jsp:include>
		<!--header end-->
		<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<jsp:include page="../z/bg-sidebar.jsp">
			<jsp:param name="c" value="1" />
			<jsp:param name="d" value="1" />
		</jsp:include>
		<!--sidebar end-->
		<!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
 <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
            	<h1  style='padding: 10px 30px;     text-align: center;'>新增電影</h1>
                <div class="row mt">
                
                </div>
                    <!--  DATE PICKERS -->
                    
                    <div class="col-lg-12">
                        <div class="form-panel">
                        
                            <form:form method='POST' modelAttribute="Movie" enctype="multipart/form-data"  class="form-horizontal style-form">
		
                            <fieldset>
                    
                            <!-- <form action="#" class="form-horizontal style-form"> -->
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">電影名稱：</label>
                                    <div class="col-sm-10">
                                    	<form:input id='title' name="title" path="title" type='text' value='' class="form-control"/>
                                       
                                        <span class="help-block">請輸入電影名稱</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">簽約日:</label>
                                        <div class="col-md-4">
                                        <form:input id='contractDate' name="contractDate" path="contractDate" type='text' value='' />
                                          
                                        </div>
                                      </div>
                                <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label">預期收益：</label>
                                            <div class="col-sm-10">
                                            <form:input id='expectedProfit' name="expectedProfit" path="expectedProfit" type='text' value='' class="form-control" />
                   
                                                <span class="help-block">請輸入預期收益(以作為排片權重)</span>
                                            </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">拆帳比例：</label>
                                        <div class="col-sm-10">
                                        <form:input id='profitRatio'  name="profitRatio" path="profitRatio" type='text' value='' class="form-control"/>
                                            
                                            <span class="help-block">請輸入影城方的拆帳比例</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">片長:</label>
                                        <div class="col-sm-10">
                                        <form:input id='runningTime' name="runningTime" path="runningTime" type='text' value='' class="form-control"/>

                                            <span class="help-block">請輸入電影片長 （單位：分鐘）</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">導演:</label>
                                        <div class="col-sm-10">
                                        <form:input id='director' name="director" path="director" type='text' value='' class="form-control"  />
                            
                                            <span class="help-block">請輸入電影導演</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">演員:</label>
                                        <div class="col-sm-10">
                                        <form:input id='cast' name="cast" path="cast" type='text' value='' class="form-control"  />
                  
                                            <span class="help-block">請輸入電影主要演員</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">類型:</label>
                                        <div class="col-sm-10">
                                        <form:input id='genre'  name="genre" path="genre" type='text' value=''  class="form-control"/>
                                          
                                            <span class="help-block">請輸入電影類型 0(其他）1(劇情）2 (喜劇）3(愛情）4(驚悚恐怖）</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">分級:</label>
                                        <div class="col-sm-10">
                                        <form:input id='MovieRating' name="MovieRating" path="MovieRating" type='text' value='' class="form-control"  />
                                           
                                            <span class="help-block">請輸入電影分級 0(普）1(保護）2(輔導級12) 3(輔導級15）4(限制級）</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">預告:</label>
                                        <div class="col-sm-10">
                                        <form:input id='trailer'  name="trailer" path="trailer" type='text' value='' class="form-control" />
                             
                                            <span class="help-block">請輸入電影預告（youtube鑲嵌連結）</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">簡介:</label>
                                        <div class="col-sm-10">
                                        <form:input id='plotSummary'  name="plotSummary" path="plotSummary" type='textarea' value='' class="form-control"/>
                                          

                                            
                                            <span class="help-block">請輸入電影大綱</span>
                                        </div>
                                </div>
                                <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">海報:</label>
                                        <div class="col-sm-10">
                                                <form:input  name="movieImage" path="movieImage" id="movieImage" type='file' onclick="getclass(this)"/><br>
                                                <div>
                                                    <img class="preview" style="max-width: 150px; max-height: 150px;">
                                                    <div class="size"></div>
                                                </div>
                            
                                        </div>
                                </div>

                            </fieldset>
                            <fieldset>


                            </fieldset>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">上映日:</label>
                                    <div class="col-sm-10">
                                        <input id='release'  name="release"  type="text"  value='' id='release' class="form-control"ｂ> 
                                        <span class="help-block">請輸入電影上映日（格式樣板：2020-01-01)</span>
                                    </div>
                            </div>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">下檔日:</label>
                                    <div class="col-sm-10">
                                        <input  id='expectedOffDate'  name="expectedOffDate"   value='' id='expectedOffDate'  type="text" class="form-control">
                                        <span class="help-block">請輸入電影下檔日（格式樣板：2020-01-01)</span>
                                    </div>
                            </div>
                            <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">必須上映:</label>
                                    <div class="col-sm-10">
                                        <input id='MustShowDay'  type='text' name="MustShowDay"   value=''id='MustShowDay' class="form-control">
                                        <span class="help-block">請輸入電影簽約必須播出天數（單位：幾天)</span>
                                    </div>
                            </div>
                            <div  align="center" class="form-group">

                            <button  id='a'class="btn btn-theme" type="submit" onclick="formSubmit()">送出</button>
                        </div>
		
	                        </form:form>

                                <!-- /form-panel -->
                                 <button  id='b'class="btn btn-theme" type="" onclick="getValue()">一鍵輸入</button>
                        </div>
                        <!-- /col-lg-12 -->
                    </div>
                    <!-- /row -->



                    <!-- row -->
            </section>
            <!-- /wrapper -->
        </section>
        <!-- /MAIN CONTENT -->
        <!--main content end-->



        <!--footer start-->
       <jsp:include page="../z/bg-footer.jsp">
			<jsp:param name="e" value="1" />
			<jsp:param name="f" value="1" />
		</jsp:include>
        <!--footer end-->
    </section>



    <!-- javaScript placed at the end of the document so the pages load faster -->
    <script>
	//一鑑輸入
	function getValue(){
// 		alert("change");
		
		var title= document.getElementById("title");
		title.value = "小丑女大解放";
		var contractDate = document.getElementById("contractDate");
		contractDate.value = "2020-02-10";
		var expectedProfit = document.getElementById("expectedProfit");
		expectedProfit.value = "561920";
		var profitRatio = document.getElementById("profitRatio");
		profitRatio.value = "0.6";
		var runningTime = document.getElementById("runningTime");
		runningTime.value = "109";
		var director = document.getElementById("director");
		director.value = "閻羽茜";
		var cast = document.getElementById("cast");
		cast.value = "瑪格羅比、 瑪麗伊莉莎白文斯蒂德 、 伊旺麥奎格";
		var runningTime = document.getElementById("runningTime");
		runningTime.value = "109";
		var genre = document.getElementById("genre");
		genre.value = "1";
		var MovieRating = document.getElementById("MovieRating");
		MovieRating.value = "2";
		var trailer = document.getElementById("trailer");
		trailer.value = "<iframe width='856' height='480' src='https://www.youtube.com/embed/2DZ9zEGN3kY' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen> </iframe> ";
	    var MovieRating = document.getElementById("plotSummary");
	    MovieRating.value = "《猛禽小隊：小丑女大解放》構想來自DC同名漫畫，敘述一個不可能的組合，小丑女哈莉奎茵、黑金絲雀、女獵手與芮妮蒙托亞聯手，企圖從高譚市著名的犯罪首腦：「黑面具」手中拯救出一位名為卡珊卓拉該隱的小女孩。"+
                        " 《猛禽小隊：小丑女大解放》演員陣容包括瑪格羅比飾演小丑女哈利奎茵、朱妮絲莫利特飾演黑金絲雀、瑪麗伊莉莎白文斯蒂德飾演女獵手、蘿西培瑞茲飾演芮妮蒙托亞、伊旺麥奎格在片中飾演反派：「黑面具」。瑪格羅比同時擔任製片，電影由華裔女導演閻羽茜執導，克麗絲汀哈德森擔任編劇。";
		
		var release = document.getElementById("release");
		    release.value = "2020-02-14";
		var expectedOffDate = document.getElementById("expectedOffDate");
		    expectedOffDate.value = "2020-03-10";
		var MustShowDay = document.getElementById("MustShowDay");
		     MustShowDay.value = "30";
		
	}
	
    
    
    
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
        
            function formSubmit() {
             
              
            
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