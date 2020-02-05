package com.p.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;
import com.p.model.MemberBean;
import com.p.service.MemberProductsQueryService;
import com.p.service.MemberService;


@Controller
public class MemberProductsQueryController {
	MemberProductsQueryService service;
	ServletContext context;
	MemberService service2;
	
//	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Autowired
	public void setService(MemberProductsQueryService service, MemberService service2) {
		this.service = service;
		this.service2 = service2;
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
		if(mID == null) {
			return "memberOrderQuery2";
		}
		int nMID = Integer.parseInt(mID);
		List<MOrderBean> molist = service.getMOrderBeanByMemberID(nMID);
		if(molist.size() != 0) {
			List<MOrderDetailBean> modetaillist = service.checkMOrder(nMID);
		    List<TicketBean> tblist = service.checkTicket(nMID);
		    
		
		    	model.addAttribute("molist", molist);
				model.addAttribute("modetaillist",modetaillist);
				model.addAttribute("tblist", tblist);
				
			    
				return "memberOrderQuery";
		}else {
			return "memberOrderQuery2";
		}
	    
	}
	
	@RequestMapping(value = "/employee/memberTicketQuery")
	public String searchEmp(Model model) {
		return "searchMbTicket";
	}
	
	@RequestMapping(value = "/memberTicketForEmployee")
	public String getEmp(@RequestParam("uID") String uID, Model model) {
		MemberBean mb = service2.getEmployeeMember(uID);
		Integer memberID = mb.getMemberID();
		List<MOrderBean> molist = service.getMOrderBeanByMemberID(memberID);
		if(molist.size() != 0) {
	
			List<MOrderDetailBean> modetaillist = service.checkMOrder(memberID);
		    List<TicketBean> tblist = service.checkTicket(memberID);
		    
		    model.addAttribute("molist", molist);
			model.addAttribute("modetaillist",modetaillist);
			model.addAttribute("tblist", tblist);
			return "memberTicketForEmployee";
			
		}else {
			return "memberOrderQuery2";
		}
		//要做無身分證字號的頁面
	}
}
