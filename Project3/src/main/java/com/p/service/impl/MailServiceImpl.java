//package com.p.service.impl;
//
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//
//import com.p.service.MailService;
//
//@Service
//public class MailServiceImpl implements MailService {
//	
//private static final Logger LOGGER = LoggerFactory.getLogger(MailDaoImpl.class);
//
//	
//	private JavaMailSender javaMailSender;
//
//	private SimpleMailMessage simpleMailMessage;
//
//	@Override
//	public void sendMailSimple(String to, String subject, String content) {
//		try {
//	           //用于接收邮件的邮箱
//	           simpleMailMessage.setTo(to);
//	           //邮件的主题
//	           simpleMailMessage.setSubject(subject);
//	           //邮件的正文，第二个boolean类型的参数代表html格式
//	           simpleMailMessage.setText(content);
//
//	           LOGGER.info("---------------------------{}", simpleMailMessage);
//	           //发送
//	           javaMailSender.send(simpleMailMessage);
//
//	       } catch (Exception e) {
//	           throw new MessagingException("failed to send mail!", e);
//	       }
//	}
//
//}
