<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello WebSocket</title>
    <link href="${pageContext.request.contextPath}/js/main.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.js"></script>
    <script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
</head>

<body>  
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="sendName" class="btn btn-default" type="submit">Send</button>
            </form>
             <form class="form-inline">
                <div class="form-group">
                    <label for="name">訊息</label>
                    <input type="text" id="message" class="form-control" placeholder="Your message here...">
                </div>
                <button id="sendMessage" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                    <th>使用者: <span id="user"></span></th>
                </tr>
                </thead>
                <tbody id="greetings">
                	<c:forEach var="list" items="${content}">
                		<tr>
                			<td>${list.content }</td>
                		</tr>
                	
                	
                	</c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

	<script>
		var history = ${content};
		console.log(history);
	
	
	</script>


</body>
</html>
