//package com.p.mail;
//
//import java.util.Properties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//@Configuration
//public class MailConfig {
//	public static String MAILUsername="fanshuwei1995@gmail.com";
//	 private static String Password = "yuutawes0616";
//	 @Bean
//	 public JavaMailSenderImpl mailSender() {
//	  JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	  mailSender.setHost("smtp.office365.com");
//	  mailSender.setPort(587);
//
//	  mailSender.setUsername(MAILUsername);
//	  mailSender.setPassword(Password);
//
//	  Properties props = mailSender.getJavaMailProperties();
//	  props.put("mail.transport.protocol", "smtp");
//	  props.put("mail.smtp.auth", "true");
//	  props.put("mail.smtp.starttls.enable", "true");
//	  props.put("mail.debug", "true");
//
//	  return mailSender;
//	 }
////	 //轉換成SpringMailUtil用，不然Spring IoC會出問題
////	 @Bean
////	 public SpringMailUtil mailSend() {
////	  SpringMailUtil util=new SpringMailUtil();
////	  util.setMailSender(mailSender());
////	  return util;
////	 }
//}
