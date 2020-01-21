package com.a.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.a.model.SCOrdersBean;
import com.a.service.SCOrderDetailsService;
import com.a.service.SCOrdersService;
import com.a.service.ShoppingCartService;

@Controller
public class ShoppingCartController {

	ShoppingCartService scservice;
	SCOrderDetailsService scodservice;
	SCOrdersService scoservice;
	
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(ShoppingCartService scservice, SCOrderDetailsService scodservice, SCOrdersService scoservice) {
		this.scservice = scservice;
		this.scodservice = scodservice;
		this.scoservice = scoservice;
	}

	@SuppressWarnings("unused")
	@GetMapping("/getShoppingCart")
	public String getShoppingCart(Model model, HttpServletRequest request) {
		SCOrdersBean scob = new SCOrdersBean();
		scob.setMemberID(5);
		scob.setPaymentStatus(0);
		scob.setShippingStatus(0);
		scoservice.insertOrder(scob);
//		HttpSession session = request.getSession();
//		Cookie[] cookies = request.getCookies();
//		if(cookies.length<2) {
//			MemberBean mb = new MemberBean();
//			model.addAttribute("memberBean", mb);
//			return "redirect:/member/login";
//		}
//		Integer memberID = scservice.getMemberID(request);
//		Integer SCOrderID = scservice.getShoppingCart(memberID);
//		if(SCOrderID != null) {
//			//showShoppingCart
//			List<SCOrderDetailBean> list = scservice.getOrderDetails(SCOrderID);
//			System.out.println("There are items in shopping cart");
//			model.addAttribute("shoppingCart", list);
//		}else {
//			System.out.println("Shopping cart is empty");
//			model.addAttribute("shoppingCart", 0);
//		}
		return "a/ShoppingCart";
	}

	@PostMapping("/getShoppingCart")
	public String showShoppingCartItem() {
		return "a/ShoppingCart";
	}
}
