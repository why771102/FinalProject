package com.p.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

	
	JavaMailSender javaMailSender;

	SimpleMailMessage simpleMailMessage;

	@Transactional
	@Override
	public void sendMailSimple(String from, String to, String subject, String content) {
	     try {
	            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	            
	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
	            messageHelper.setFrom(from); //設寄件人
	            messageHelper.setSubject(subject); //設郵件標題
	            messageHelper.setText(content);   //設郵件內容
	            messageHelper.setTo(to);          //設收信人
	            javaMailSender.send(mimeMessage);    //發送html郵件
	 
	        } catch (Exception e) {
	            System.out.println("異常信息：" + e);
	        }
	}

}
