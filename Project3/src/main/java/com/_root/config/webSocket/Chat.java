package com._root.config.webSocket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;

public class Chat {

	private String name;
	private String content;
//	@Column(columnDefinition = "smalldatetime")
	private String endTime;

	public Chat(String name, String content) {
		super();
		this.name = name;
		this.content = content;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		String localTime = df.format(time);
		this.setEndTime(localTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
