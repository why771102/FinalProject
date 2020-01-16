package com.p.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;
import com.p.service.HallOrderService;

@Controller
public class HallOrderController {
	HallOrderService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	@Autowired
	public void setService(HallOrderService service) {
		this.service = service;
	}
	
	//以下為新增包廳申請的方法
	@RequestMapping(value="/hallOrder/apply", method = RequestMethod.GET)
	public String hallOrderApply(Model model) {
		HallOrderBean hob = new HallOrderBean();
		model.addAttribute("hallOrderBean",hob);
		return "hallOrderApply";
	}
	@RequestMapping(value = "/hallOrder/apply", method = RequestMethod.POST)
	public String processMemberRegister(@ModelAttribute("hallOrderBean")HallOrderBean hob,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String mID = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("memberID")) {
				mID = cookie.getValue();
			}
		}
		int nMID = Integer.parseInt(mID);
		hob.setMemberID(nMID);
		service.hallOrderApply(hob);
		return "hallOrderApply";
	}
	
	//此為動態新增Hall欄位的
	@ModelAttribute("hallList")
	public List<String> getAllhallID() {
		return service.getAllhallID();
	}
	
	//以下為會員查詢包廳申請
	@RequestMapping(value = "/Member/hallOrderQuery")
	public String hallOrderMemberQuery(Model model,@ModelAttribute("hallOrderBean")HallOrderBean hob) {
		List<HallOrderBean> allMHO = service.hallOrderMQuery(hob.getMb().getMemberID());
		model.addAttribute("allMHO", allMHO);
		return "hallOrderMQuery";
	}
	
	//後台功能:以下為員工查詢所有包廳申請
	@GetMapping(value = "/Employee/hallOrderQuery")
	public String hallOrderEmployeeQuery(Model model) {
		HallOrderBean Hob = new HallOrderBean();
		List<HallOrderBean> allEHO = service.hallOrderEQuery();
		model.addAttribute("allEHO", allEHO);
		model.addAttribute("hallOrderBean",Hob);
		return "hallOrderEQuery2";
	}
	
	@PostMapping(value = "/Employee/hallOrderQuery")
	public String processHallOrderQuery(@ModelAttribute("hallOrderBean")HallOrderBean hob) {
		System.out.println("安安:" + hob.getHallOrderStatusNo());
		System.out.println("看這邊:" + hob.getPayStatusNo());
		//在這邊寫if，用來判斷是否有改變
//		if(hob.getHallOrderStatusNo()==0 || hob.getHallOrderStatusNo()==1 || hob.getHallOrderStatusNo()==2) {
			service.hallOrderStatusChange(hob);
			service.payStatusChange(hob);
//		}
//		
//		if(hob.getPayStatusNo()==0 || hob.getPayStatusNo()==1) {
//			service.payStatusChange(hob);
//		}
//		service.hallOrderApply(hob);
		return "redirect:/Employee/hallOrderQuery";
	}
	
	//以下為讓前台可以選出相符的兩項狀態
	
	@ModelAttribute("hallOrderStatusList")
	public Map<Integer, String> getHallOrderStatusList() {
		Map<Integer, String> hallOrderStatusMap = new HashMap<>();
		List<HallOrderStatusBean> list = service.getHallOrderStatusList();
		for (HallOrderStatusBean Hob : list) {
			hallOrderStatusMap.put(Hob.getHallOrderStatusNo(), Hob.getHallOrderStatus());
		}
		return hallOrderStatusMap;
	}
	
	@ModelAttribute("payStatusList")
	public Map<Integer, String> getPayStatusList() {
		Map<Integer, String> payStatusMap = new HashMap<>();
		List<PayStatusBean> list = service.getPayStatusList();
		for (PayStatusBean Psb : list) {
			payStatusMap.put(Psb.getPayStatusNO(), Psb.getPayStatus());
		}
		return payStatusMap;
	}
	
//	//以下為員工進行包廳狀態更新的方法
//	@PostMapping(value = "/Employee/hallOrderQuery")
//	public String updateHallOrderStatus() {
//		
//		
//		return null;
//	}
	
	
	
	
	
	
}
