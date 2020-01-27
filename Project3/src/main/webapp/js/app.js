var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
   var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content, JSON.parse(greeting.body).name);
        });
        stompClient.subscribe('/topic/message', function (greeting) {
        	showMessage(JSON.parse(greeting.body).name + ":" + JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/sendName", {}, JSON.stringify({'name': $("#name").val()}));
}

function sendMessage() {
	if ($("#message").val().trim().length > 0){
		stompClient.send("/app/sendMessage", {}, JSON.stringify({'message': $("#message").val(), 'name': $("#name").val()}));
	}
}

function showGreeting(message, name) {
  	$("#greetings").append("<tr><td>" + message + "</td></tr>");
//	$("#user").html(name);
}
function showMessage(message) {
  	$("#greetings").append("<tr><td>"+ message + "</td></tr>");

}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#sendName" ).click(function() { sendName(); });
    $( "#sendMessage" ).click(function() { sendMessage(); });
});