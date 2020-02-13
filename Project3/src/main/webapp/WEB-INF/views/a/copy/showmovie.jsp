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
 <h1>44444444444</h1>
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

 <jsp:include page="${pageContext.request.contextPath}/a/header.jsp">
     <jsp:param name="a" value="1" />
    <jsp:param name="b" value="1" />
</jsp:include>

    </header>
    <div>${sthb_list1.get(1).run.movie.movieID}</div>
<div>${sthb_list1.get(1).showTimeId}</div>
<div>${sthb_list1.get(1).playStartTime}</div>
<div>${sthb_list1.get(1).run.runID}</div>
    <!-- header -->

    <!-- banner -->

    <!-- banner -->
    <section class='gray-bnr feature-sec ' style='background-color:black;'>
    <div class='container' >
    
        <div class='buy-txt'>   <iframe width='854' height='480' src='https://www.youtube.com/embed/FEf412bSPLs' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe></div>
      
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
                        <h3 style='border-bottom: solid rgb(100, 100, 100) 2px; padding-bottom: 10px'>播放場次</h3>
                        <table>
                            <tr id ='showTime'>
                            <c:forEach var="one" items="${oneMovie1}" >
<%--                                       <c:if test=${oneMovie1.strDay }> --%>
                                     <td style='padding:10px;margin: 0px;'><a href='free-trail.html' class='slider-btn'>${one.strTime}</a></td>
<%--                                       </c:if> --%>
                            </c:forEach>
                                
                                
                               
                            </tr>
                        </table>
                        

                    <!-- </div> -->
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class='contact-sec'>
            <div class='container'>
    
                <div class='buy-txt'>
                    <h2>[ 劇情介紹 ]</h2>
                    <p> </p>
    
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
                <a href="<c:url value='movieIndex#booknow'/>" class='slider-btn'>前往購票</a>
            </div>
        </div>
    </section>

    ｂ
    <!-- footer -->
    <footer class='footer'>
        <div class='container'>
            <div class='row responsiv-div2'>
                <div class='col-sm-3 col-xs-6'>
                    <div class='f-inner'>
                        <h4>關於我們</h4>
                        <ul class='list-unstyled'>
                            <li><a href=''>公司簡介</a>
                            </li>
                            <li><a href=''>企業理念</a>
                            </li>
                            <li><a href=''>影廳介紹</a>
                            </li>
                            <li><a href=''>電影院設備</a>
                            </li>
                            <li><a href=''>相關設施</a>
                            </li>
                          

                        </ul>
                    </div>
                </div>
                <div class='col-sm-3 col-xs-6'>
                    <div class='f-inner'>
                        <h4>其他項目</h4>
                        <ul class='list-unstyled'>
                          
                            <li><a href=''>線上周邊</a>
                            </li>
                            <li><a href=''>包場服務</a>
                            </li>
                            <li><a href=''>餐飲服務</a>
                            </li>
                            <li><a href=''>其他</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class='col-sm-3 col-xs-6'>
                    <div class='f-inner contect-f'>
                        <h4>聯絡我們</h4>
                        <ul class='list-unstyled'>
                            <address>線上客服 <br> 12345 India</address>
                            <br>
                            <li>01 23 456 789</li>
                            <li class='f-link'><a href=''>contact@cineshow.fr</a>
                            </li>
                            <br>

                        </ul>
                    </div>
                </div>
                <div class='col-sm-3 col-xs-6'>
                    <div class='f-inner'>
                        <h4>告訴我們您的建議</h4>
                        <div class='form'>
                            <form>
                                <input type='text' name='nm' class='inp-fild' placeholder='Name'>
                                <input type='text' id='mail' name='mail' class='inp-fild' placeholder='Email Address'>
                            </form>
                            <button class='footer-btn'>Send</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class='footer-line'>
                <div class='im-inner'>
                    <span></span>
                    <a href='index.html'><img src='img/logo.png' class='ftr-logo' width='200'>
                    </a><span></span>
                </div>
                <h4> Copyrights 2020.01.26 | <a href='#'>10.3.7</a></h4>
                <div class='right-icon'>
                    <ul class='list-inline'>
                        <li class='fb'><a href='#'><i class='fb fa fa-facebook'></i></a>
                        </li>
                        <li class='twitter'><a href='#'><i class='twitter fa fa-twitter'></i></a>
                        </li>
                        <li class='google'><a href='#'><i class='google fa fa-google-plus'></i></a>
                        </li>
                        <li class='youtube'><a href='#'><i class='youtube fa fa-youtube-play'></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
     <div class='premium-tagline'>
        <p>Created By: <a href= >Teamwork</a></p>
    </div>
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
