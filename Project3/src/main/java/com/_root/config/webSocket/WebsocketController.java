package com._root.config.webSocket;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.z.model.QuestionContentBean;
import com.z.service.QuestionContentService;

@Controller
public class WebsocketController {
	
	QuestionContentService ConService;
	
	@Autowired
	public void setService(QuestionContentService service) {
		this.ConService = service;
	}
	
	
	
	@MessageMapping("/sendMessage/{questionId}")
	@SendTo("/topic/message/{questionId}")
	public Chat sendMessage(String message,@DestinationVariable Integer questionId) throws Exception {

		System.out.println("sendMessage...ConversationMessage=" + message);
		JSONObject jsonObj = new JSONObject(message);
		System.out.println(jsonObj);
		String name = jsonObj.getString("name");
		String content = jsonObj.getString("message");
		System.out.println(name);
		System.out.println(content);
		Chat chat = new Chat(name, content);
		QuestionContentBean conBean = new QuestionContentBean();
		conBean.setContent(chat.getContent());
		conBean.setQuestionId(questionId);
		conBean.setDatetime(chat.getEndTime());
		ConService.saveMessage(conBean);
		return chat;
	}

}
