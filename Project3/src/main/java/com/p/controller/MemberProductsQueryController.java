package com.p.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;
import com.p.service.MemberProductsQueryService;


@Controller
public class MemberProductsQueryController {
	MemberProductsQueryService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Autowired
	public void setService(MemberProductsQueryService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/member/ticket")
	public String memberTicketQuery(Model model,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		List<MOrderBean> molist = service.getMOrderBeanByMemberID(nMID);
	    List<MOrderDetailBean> modetaillist = service.checkMOrder(nMID);
	    List<TicketBean> tblist = service.checkTicket(nMID);
	    
	    model.addAttribute("molist", molist);
		model.addAttribute("modetaillist",modetaillist);
		model.addAttribute("tblist", tblist);
		
	    
		return "memberOrderQuery";
	}
}
