<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>電影期待度列表</title>
</head>
<body>
    <section>
        <div>
            <div class="container" style="text-align: center" >
                <h1>電影期待度列表</h1>
            </div>
        </div>
    </section>
    <hr style="height:1px;border:none;color:#333;background-color:#333;">
    <section class="container">
        <div class="row">
          <c:forEach var='expect' items='${Expectations}'>
            <div class="col-sm-6 col-md-3" style="width: 360px; height: 360px">
                <div class="thumbnail" style="width: 320px; height: 340px">
                    <div class="caption">
                        <p>
                            <b style='font-size: 16px;'>電影ID:${expect.movieBean.movieID}</b>
                        </p>
                        <p>會員ID:${expect.memberBean.memberID}</p>
                        <p>期待:${expect.expective}</p>
                        <p>
                   </div>
                </div>
            </div>
        </c:forEach>
        </div>
    </section>
</body>
</html>
    