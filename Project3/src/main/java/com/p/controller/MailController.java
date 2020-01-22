package com.p.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.p.model.HallOrderBean;
import com.p.service.HallOrderService;
import com.p.service.MailService;

@Controller
public class MailController {

	MailService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Autowired
	public void setService(MailService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/hallOrder/mail/{mail}")
	public String hallOrderMail(@PathVariable("mail") String mail, Model model) {
//		這邊要設定信件的內容
		String from = "fanshuwei1995@gmail.com";
		String to = mail;
		String subject = "76影城包廳繳款通知信";
		String content = "<html><body><P>親愛的客戶您好:</P>"
				+ "感謝您申請76影城包廳服務<br>"
				+ "經過我們的評估，您的包廳申請已經通過<br>"
				+ "請將包廳金額匯款至以下銀行帳戶:<br>"
				+ "銀行：兆豐銀行南台北分行(銀行代碼017)<br>"
				+ "帳號：３９２０６１０５８８８６８６<br>"
				+ "戶名:76影城"
				+ "轉帳後請email回覆「轉帳帳號末5碼」，以利確認，謝謝"
				+ "<body></html>"; 
		service.sendMailSimple(from, to, subject, content);
		return "redirect:/Employee/hallOrderQuery";
	}
}
