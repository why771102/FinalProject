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

		JSONObject jsonObj = new JSONObject(message);
		String name = jsonObj.getString("name");
		String content = jsonObj.getString("message");
		Chat chat = new Chat(name, content);
		QuestionContentBean conBean = new QuestionContentBean();
		conBean.setContent(chat.getContent());
		conBean.setQuestionId(questionId);
		conBean.setDatetime(chat.getEndTime());
		conBean.setName(name);
		ConService.saveMessage(conBean);
		return chat;
	}

}
