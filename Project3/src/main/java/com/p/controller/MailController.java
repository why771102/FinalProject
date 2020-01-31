package com.p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com._root.config.RootAppConfig;
import com.p.service.HallOrderService;
import com.p.service.MailService;

@Controller
public class MailController {

	MailService service;
	HallOrderService hoservice;
//	@Autowired
	ApplicationContext context;
	
////	@Autowired
//	public void setContext(ServletContext context) {
//		this.context = context;
//	}
	
	
	@Autowired
	public void setService(MailService service, HallOrderService hoservice) {
		this.service = service;
		this.hoservice = hoservice;
	}
	
	@RequestMapping(value="/hallOrder/mail/{hallOrderNo}")
	public String hallOrderMail(@PathVariable("hallOrderNo") Integer hallOrderNo, Model model) {
//		這邊要設定信件的內容
		System.out.println("SENDING EMAIL");
		AnnotationConfigApplicationContext cntxt = new AnnotationConfigApplicationContext();
		cntxt.register(RootAppConfig.class);
		cntxt.refresh();
		MailService emailService = cntxt.getBean(MailService.class);
		cntxt.close();
		System.out.println("SENDING EMAIL==================");
		String from = "susanbayloi124578@gmail.com";
		String to = "genie.sheu@gmail.com";
		String subject = "76影城包廳繳款通知信";
		String content = "親愛的客戶您好:"+"\n"+"\n"
				+ "感謝您申請76影城包廳服務"+"\n"
				+ "經過我們的評估，您的包廳申請已經通過"+"\n"
				+ "請將包廳金額匯款至以下銀行帳戶:"+"\n"
				+ "銀行：兆豐銀行南台北分行(銀行代碼017)"+"\n"
				+ "帳號：３９２０６１０５８８８６８６"+"\n"
				+ "戶名:76影城"+"\n"
				+ "轉帳後請email回覆「轉帳帳號末5碼」，以利確認，謝謝";
		emailService.sendMailSimple(from, to, subject, content);
		return "redirect:/Employee/hallOrderQuery";
	}
}
