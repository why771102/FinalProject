package com.p.model;

import java.io.Serializable;

public class MailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String from; //寄件人
	String to; //收件人
	String subject; //信件標題
	String content; //信件內容
	
	public MailBean(){
		
	}
	

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
