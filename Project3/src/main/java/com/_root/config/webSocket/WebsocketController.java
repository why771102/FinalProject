package com._root.config.webSocket;

import org.json.JSONObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;

@Controller
public class WebsocketController {
	
	@MessageMapping("/sendMessage")
	@SendTo("/topic/message")
	public Chat sendMessage(String message) throws Exception {
		System.out.println("123");
		System.out.println("sendMessage...ConversationMessage=" + message);
		JSONObject jsonObj = new JSONObject(message);
		System.out.println(jsonObj);
		String name = jsonObj.getString("name");
		String content = jsonObj.getString("message");
		System.out.println(name);
		System.out.println(content);
		Chat chat = new Chat(name, content);
//		System.out.println("sendMessage...message.getName()=" + HtmlUtils.htmlEscape(message.getName()));
//		System.out.println("sendMessage...message.getMessage()=" + HtmlUtils.htmlEscape(message.getContent()));
//		return new Chat(HtmlUtils.htmlEscape(message.getName()), HtmlUtils.htmlEscape(message.getContent()));
		return chat;
	}

}
