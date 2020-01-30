var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS("../myHandler");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/greetings', function(greeting) {
			showGreeting(JSON.parse(greeting.body).content, JSON
					.parse(greeting.body).name);
		});
		stompClient.subscribe('/topic/message/' + list[3], function(greeting) {
			showMessage(JSON.parse(greeting.body).name + ":"
					+ JSON.parse(greeting.body).content);
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
	stompClient.send("/sendName", {}, JSON.stringify({
		'name' : $("#name").val()
	}));
}

function sendMessage() {
	if ($("#message").val().trim().length > 0) {
		stompClient.send("/sendMessage/" + list[3], {}, JSON.stringify({
			'message' : $("#message").val(),
			'name' : $("#name").val(),
			'questionId' : list[3]
		}));
	}
}

function showGreeting(message, name) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");
}
function showMessage(message) {
	$("#greetings").append("<tr><td>" + message + "</td></tr>");

}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		console.log("connect");
		connect();
	});
	$("#disconnect").click(function() {
		console.log("disconnect");
		disconnect();
	});
	$("#sendName").click(function() {
		console.log("sendName");
		sendName();
	});
	$("#sendMessage").click(function() {
		console.log("sendMessage");
		sendMessage();
	});
});

console.log('location.pathname: '+location.pathname);

var str = location.pathname;
var list = str.split("/");

console.log(list[1]);
console.log(list[2]);
console.log(list[3]);

