<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>

<meta charset="UTF-8">

<title>Products</title>
<link href="${pageContext.request.contextPath}/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath}/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/css/bg-style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/style-responsive.css" rel="stylesheet">
<style>
	body{
		font-family: arial, "Microsoft JhengHei", "微軟正黑體", sans-serif !important;
	}
</style>
</head>
<body>
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="<c:url value='/emp/updatePwd'/>"><img src="${pageContext.request.contextPath}/img/penguin.png" class="img-circle" width="80"></a></p>
          <h5 class="centered" id="name"></h5>
<!--           <li class="mt"> -->
<!--             <a href="index.html"> -->
<!--               <i class="fa fa-dashboard"></i> -->
<!--               <span>Dashboard</span> -->
<!--               </a> -->
<!--           </li> -->
          <li class="sub-menu">
            <a href="javascript:;">
              <i class=" fa fa-bar-chart-o"></i>
              <span>營收報表</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/ticket/sale'/>">票卷銷售</a></li>
              <li><a href="<c:url value='/ticket/earn'/>">票卷利潤</a></li>
              <li><a href="<c:url value='/product/sale'/>">產品銷售</a></li>
              <li><a href="<c:url value='/product/earn'/>">產品利潤</a></li>
              <li><a href="<c:url value='/hall/sale'/>">廳院出借</a></li>
            </ul>
          </li>
<!--           <li class="sub-menu"> -->
<!--             <a href="javascript:;"> -->
<!--               <i class="fa fa-desktop"></i> -->
<!--               <span>UI Elements</span> -->
<!--               </a> -->
<!--             <ul class="sub"> -->
<!--               <li><a href="general.html">General</a></li> -->
<!--               <li><a href="buttons.html">Buttons</a></li> -->
<!--               <li><a href="panels.html">Panels</a></li> -->
<!--               <li><a href="font_awesome.html">Font Awesome</a></li> -->
<!--             </ul> -->
<!--           </li> -->
<!--           <li class="sub-menu"> -->
<!--             <a href="javascript:;"> -->
<!--               <i class="fa fa-cogs"></i> -->
<!--               <span>Components</span> -->
<!--               </a> -->
<!--             <ul class="sub"> -->
<!--               <li><a href="grids.html">Grids</a></li> -->
<!--               <li><a href="calendar.html">Calendar</a></li> -->
<!--               <li><a href="gallery.html">Gallery</a></li> -->
<!--               <li><a href="todo_list.html">Todo List</a></li> -->
<!--               <li><a href="dropzone.html">Dropzone File Upload</a></li> -->
<!--               <li><a href="inline_editor.html">Inline Editor</a></li> -->
<!--               <li><a href="file_upload.html">Multiple File Upload</a></li> -->
<!--             </ul> -->
<!--           </li> -->
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>員工管理</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/emp/add'/>">新增員工</a></li>
              <li><a href="<c:url value='/emps'/>">員工列表</a></li>
              <li><a href="<c:url value='/searchEmp'/>">單一員工查詢</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-tasks"></i>
              <span>公告</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/anno/add'/>">新增公告</a></li>
              <li><a href="<c:url value='/bgAnnos'/>">公告列表</a></li>
            </ul>
          </li>
<!--           <li class="sub-menu"> -->
<!--             <a href="javascript:;"> -->
<!--               <i class="fa fa-th"></i> -->
<!--               <span>Data Tables</span> -->
<!--               </a> -->
<!--             <ul class="sub"> -->
<!--               <li><a href="basic_table.html">Basic Table</a></li> -->
<!--               <li><a href="responsive_table.html">Responsive Table</a></li> -->
<!--               <li><a href="advanced_table.html">Advanced Table</a></li> -->
<!--             </ul> -->
<!--           </li> -->
          
           <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-address-card"></i>
              <span>查詢會員</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/employee/memberQuery'/>">會員資料</a></li>
              <li><a href="<c:url value='/employee/memberTicketQuery'/>">會員訂票紀錄</a></li>
            </ul>
          </li>
          
           <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-adjust"></i>
              <span>影廳管理</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/hall/add'/>">新增影廳</a></li>
              <li><a href="<c:url value='/seats/showSeats'/>">調整影廳</a></li>
              <li><a href="<c:url value='/Employee/hallOrderQuery'/>">包廳管理</a></li>
            </ul>
          </li>
          
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-adjust"></i>
              <span>電影管理/排片</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/movie/add'/>">新增電影</a></li>
              <li><a href="<c:url value='/movie/autoRun'/>">排片</a></li>
              <li><a href="<c:url value='/oldShowTimeHistory'/>">查詢排片紀錄</a></li>
              <li><a href="<c:url value='/findAllReportComment'/>">管理短評</a></li>
            </ul>
          </li>
          
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-shopping-cart"></i>
              <span>商品管理</span>
              </a>
            <ul class="sub">
              <li><a href="<c:url value='/products'/>">查詢產品</a></li>
            </ul>
          </li>
<!--           <li> -->
<!--             <a href="inbox.html"> -->
<!--               <i class="fa fa-envelope"></i> -->
<!--               <span>Mail </span> -->
<!--               <span class="label label-theme pull-right mail-info">2</span> -->
<!--               </a> -->
<!--           </li> -->
          <li class="sub-menu">
            <a href="<c:url value='/questionListForEmp'/>">
              <i class="fa fa-comments-o"></i>
              <span>客服列表</span>
              </a>
          </li>
<!--           <li> -->
<!--             <a href="google_maps.html"> -->
<!--               <i class="fa fa-map-marker"></i> -->
<!--               <span>Google Maps </span> -->
<!--               </a> -->
<!--           </li> -->
          <li class="sub-menu">
            <a href="<c:url value='/emp/updatePwd'/>">
              <i class="fa fa-cogs"></i>
              <span>修改密碼</span>
              </a>
              </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="${pageContext.request.contextPath}/lib/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="${pageContext.request.contextPath}/lib/jquery.scrollTo.min.js"></script>
  <script src="${pageContext.request.contextPath}/lib/jquery.nicescroll.js" type="text/javascript"></script>
 <!--common script for all pages-->
  <script src="${pageContext.request.contextPath}/lib/common-scripts.js"></script>
  <!--script for this page-->
  <!-- MAP SCRIPT - ALL CONFIGURATION IS PLACED HERE - VIEW OUR DOCUMENTATION FOR FURTHER INFORMATION -->
  <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASm3CwaK9qtcZEWYa-iQwHaGi3gcosAJc&sensor=false"></script>
 <script type="application/javascript">
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });
    })
    
    
    cookieArray = document.cookie.split("; ");
	console.log(cookieArray);

	for (i = 0; i < cookieArray.length; i++) {
			memberIDArrays = cookieArray[i].split("=");
			console.log(memberIDArrays);
			
				for (i = 0; i < cookieArray.length; i++) {
				nameArrays = cookieArray[i].split("=");
				console.log(nameArrays);
				if (nameArrays[0] == "EmpName") {
				$("#name").text(nameArrays[1]);
				
			}

		}
	}
    
      </script>
</body>
</html>
