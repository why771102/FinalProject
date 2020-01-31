package com.p.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.p.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
//private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

	@Autowired
	JavaMailSender javaMailSender;
	public void sendMailSimple(String from, String to, String subject, String content) {
	     try {
	    	 SimpleMailMessage SimpleMailMessage = new SimpleMailMessage();
	            
//	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
	            SimpleMailMessage.setFrom(from); //設寄件人
	            SimpleMailMessage.setSubject(subject); //設郵件標題
	            SimpleMailMessage.setText(content);   //設郵件內容
	            SimpleMailMessage.setTo(to);          //設收信人
	            javaMailSender.send(SimpleMailMessage);    //發送html郵件
	            
	        } catch (Exception e) {
	            System.out.println("異常信息：" + e);
	        }
	}

}
