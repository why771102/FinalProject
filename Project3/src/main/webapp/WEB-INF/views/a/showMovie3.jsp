<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0' />
    <!-- title -->
    <title>Cineshow</title>
    <!-- google fonts -->
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,900' rel='stylesheet' type='text/css'>
    <!-- stylesheets -->
    <link rel='stylesheet' href='css/bootstrap.min.css'>
    <link rel='stylesheet' href='css/font-awesome.min.css'>
    <link rel='stylesheet' href='css/flexslider.css'>
    <link rel='stylesheet' href='css/style.css'>
    <link rel='stylesheet' href='css/responsive.css' type='text/css' />
</head>

<body>
    <header>
        <!-- header -->
<!--         <nav class='navbar navbar-default navbar-static-top'> -->
<!--             <div class='container'> -->
<!--                 <div class='navbar-header'> -->
<!--                     <button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#navbar' aria-expanded='false' aria-controls='navbar'> -->
<!--                         <span class='sr-only'>Toggle navigation</span> -->
<!--                         <span class='icon-bar'></span> -->
<!--                         <span class='icon-bar'></span> -->
<!--                         <span class='icon-bar'></span> -->
<!--                     </button> -->
<!--                     <a class='navbar-brand' href='index.html'><img src='img/logo-1.png' class='logo-hdr' width='180'> -->
<!--                     </a> -->
<!--                 </div> -->
<!--                 <div id='navbar' class='navbar-collapse collapse'> -->
<!--                     <ul class='nav navbar-nav navbar-right'> -->
<!--                         <li><a href='index.html'>home</a> -->
<!--                         </li> -->
<!--                         <li class='active'><a href='features.html'>latest movies</a> -->
<!--                         </li> -->
<!--                         <li><a href='pricing.html'>pricing</a> -->
<!--                         </li> -->
<!--                         <li><a href='up-coming.html'>Up coming</a> -->
<!--                         </li> -->
<!--                         <li><a href='conatct.html'>contact</a> -->
<!--                         </li> -->
<!--                         <li><a href='login-page.html'>login </a> -->
<!--                         </li> -->
<!--                         <li class='free-trial-btn'><a href='free-trail.html'>free trial</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                             <select> -->
<!--                                 <option>ENG</option> -->
<!--                                 <option>FR</option> -->
<!--                             </select> -->
<!--                         </li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--                 /.nav-collapse -->
<!--             </div> -->
<!--         </nav> -->

 <jsp:include page="header.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>

    </header>
   <!--  <div>${sthb_list1.get(1).run.movie.movieID}</div>
<div>${sthb_list1.get(1).showTimeId}</div>
<div>${sthb_list1.get(1).playStartTime}</div>
<div>${sthb_list1.get(1).run.runID}</div>-->
    <!-- header -->

    <!-- banner -->

    <!-- banner -->
    <section class='gray-bnr feature-sec ' style='background-color:black;'>
    <div class='container' >
    
        <div class='buy-txt'> 
        ${sthb_list1.get(1).run.movie.trailer}  
      <!--    <iframe width='854' height='480' src='https://www.youtube.com/embed/FEf412bSPLs' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>
      -->
    </div>
    </section>
    <section class='gray-bnr feature-sec ' style='padding:50px 0px;'>
           
        <div class='container'>
            <div class='row '>
                   <div class='col-md-2'></div>
                
                        <div class='col-md-3 col-sm-4 col-xs-6'>
                                <div class=''>
                                   
                                    <div style='padding:10px'>
                                        <img  style='width: 100%;height: 100%; 'src='img/feature2.jpg'>
                                    </div>
                                   
                                </div>
                               
                        </div>
                          
                
                <div class='col-sm-6'>
                    <!-- <div class='ex-feature'> -->
                       
                        <h2 >${sthb_list1.get(1).run.movie.title}</h2>
                        <table>
                            <tr>
                                <td>導演：</td>
                                <td>${sthb_list1.get(1).run.movie.director}</td>
                            </tr>
                            <tr>
                                <td>演員：</td>
                                <td>${sthb_list1.get(1).run.movie.cast}</td>
                            </tr>
                            <tr>
                                <td>類型：</td>
                                <td>${sthb_list1.get(1).run.movie.genreBean.genre}</td>
                            </tr>
                            <td>分級：</td>
                                <td>${sthb_list1.get(1).run.movie.movieRatingBean.rating}</td>
                            
                            <tr>
                                <td>片長：</td>
                                <td>${sthb_list1.get(0).run.movie.runningTime}</td>
                            </tr>
                        </table>
                        <div id='showTimeHere'>
                     
                        </div>

                    <!-- </div> -->
                    </div>
                </div>
            </div>
        </div>
    </section>
     <!-- banner -->
    <section class=" banner-featured" style='background-color:gray;'>
        <div class="container">
            <div class="ticket-sell">
                <h3 class="font"> 關於電影</h3>
            </div>
        </div>
    </section>
    <!-- banner -->

    <section class='contact-sec'>
            <div class='container'>
    
                <div class='buy-txt'>
                    <h2 style='text-align: left ; color: cornflowerblue;'>[ 劇情介紹 /ABOUT THE STORY ]</h2>
                    <p> </p><br>
    
                </div>
    
                <div class='buy-txt'>
                  
                <div class='col-sm-12 col-xs-12'> 
                <div style='text-align: left; padding:5px; font-size: large; '>
                       ${sthb_list1.get(1).run.movie.plotSummary}
                </div>
                    
                </div>

                </div>
            </div>
            
        </section>
         <!-- banner -->
         
          <!-- banner -->

    <section class='contact-sec'>
          <div class='container'>
    
                <div class='buy-txt'>
                    <h2 style='text-align: left; color: cornflowerblue;'>[ 入場須知/ RULES AND REGULATION ]</h2>
                    <p> </p><br>
    
                </div>
    
                <div class='buy-txt'>
                <div class="col-sm-12 col-xs-12">
                    <div class="ex-feature" style='text-align: left;'>
                       
                        <ul style='text-align: left;'>
                            <li>敬請遵守飲食公告。 </li>
                            <li>本影城全面禁菸。</li>
                            <li>請勿嚼食檳榔、口香糖。</li>
                            <li>請勿攜帶寵物入場。</li>
                            <li>敬請遵守電影分級制度。</li>
                            <li>如須退票，請於電影開演二十分鐘之前至售票處辦理(連結至退/換票須知)。</li>
                            <li>進入影廳前，敬請將行動電話、鬧鐘手錶關機或調成靜音。</li>
                            <li>影片播映時，請勿使用任何錄影(音)器材。</li>
                            <li>本影城之場次時間表僅為參考，如有異動，請以當日售票處公佈之場次為準。</li>
                        </ul>
                    </div>
                </div>

                </div>
            
        </section>
         <!-- banner -->
         
         
         
         
<!--     <section class="ticket-outer banner-featured"> -->
      <section class=" banner-featured" style='background-color:gray;'>
        <div class="container">
            <div class="ticket-sell">
                <h3 class="font"> 留言板</h3>
            </div>
        </div>
    </section>
    <!-- banner -->
     <section class='contact-sec '>
            <div class='container'>
    
                <div class='buy-txt'>
                    <h2>[ 留言板 ]</h2>
                    <p> </p><br>
    
                </div>
    
                <div class='buy-txt'>
                  
                <div class='col-sm-12 col-xs-12'> 
                <div style=''>
                       ${sthb_list1.get(1).run.movie.plotSummary}
                </div>
                    
                </div>

                </div>
            </div>
        </section>

    <section class='dark-blue'>
        <div class='container'>
            <div class='ready'>
                <h4>現在就立刻購票！</h4>
                <p>想要有完美的視覺饗宴，精彩的電影體驗，還不立即登入購票~</p>
                <a href='free-trail.html' class='slider-btn'>前往購票</a>
            </div>
        </div>
    </section>

    ｂ
    <!-- footer -->
    <jsp:include page="footer.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>
    
    <!-- footer -->

    <!-- scripts -->
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>
    <script defer src='js/bootstrap.min.js'></script>


</body>

</html>


	
		
		<script>
		var a =${sthb_list};
		
		console.log(a);
		function c(){
		console.log(document.getElementById("movieBean").value);
		}
		</script>
</body>
</html>
