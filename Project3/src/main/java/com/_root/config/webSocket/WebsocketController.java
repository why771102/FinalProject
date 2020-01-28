package com._root.config.webSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebsocketController {
	
	@MessageMapping("/sendMessage")
	@SendTo("/topic/message")
	public Chat sendMessage(Chat message) throws Exception {
		System.out.println("123");
		System.out.println("sendMessage...ConversationMessage=" + message);
		System.out.println("sendMessage...message.getName()=" + HtmlUtils.htmlEscape(message.getName()));
		System.out.println("sendMessage...message.getMessage()=" + HtmlUtils.htmlEscape(message.getContent()));
		return new Chat(HtmlUtils.htmlEscape(message.getName()), HtmlUtils.htmlEscape(message.getContent()));
	}

}
