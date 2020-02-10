var str = location.pathname;
var list = str.split("/");

var memberName = document.cookie;
var cookies = memberName.split("; ");
for(var i = 0; i < cookies.length; i++) {
	var c = cookies[i];
	if (c.indexOf("name=")==0) {
		var nameeee = c.substring(5,c.length);
	}
}
console.log(nameeee);

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

//function connect() {
	var socket = new SockJS("../myHandler");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/message/' + list[3], function(greeting) {
			showMessage(JSON.parse(greeting.body).name, JSON.parse(greeting.body).content, JSON.parse(greeting.body).endTime);
			var txt = document.getElementById("div1");
            document.body.focus();
            txt.scrollTop = txt.scrollHeight;
		});
	});
//}

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
			'name' : nameeee,
			'questionId' : list[3]
		}));
		$("#message").val("");
	}
}

function showMessage(name, message, endTime) {
	$("#greetings").append("<tr><td>" + name + "：</td><td>" + message + "</td><td>" + endTime.substring(5, 16) + "</td></tr>");

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


