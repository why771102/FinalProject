package com.a.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.service.SCOrderDetailsService;
import com.a.service.SCOrdersService;
import com.a.service.ShoppingCartService;
import com.p.model.MemberBean;

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
	public void setService(ShoppingCartService scservice, SCOrderDetailsService scodservice,
			SCOrdersService scoservice) {
		this.scservice = scservice;
		this.scodservice = scodservice;
		this.scoservice = scoservice;
	}

	@SuppressWarnings("unused")
	@GetMapping("/getShoppingCart")
	public String getShoppingCart(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		if (cookies.length < 2) {
			MemberBean mb = new MemberBean();
			model.addAttribute("memberBean", mb);
			return "redirect:/member/login";
		}
		Integer memberID = scservice.getMemberID(request);
		System.out.println(memberID);
		Integer SCOrderID = scservice.getShoppingCart(memberID);
		if (SCOrderID != null) {
			// showShoppingCart
			List<SCOrderDetailBean> list = scservice.getOrderDetails(SCOrderID);
			if (list.size() == 0) {
				System.out.println("Shopping cart is empty");
				model.addAttribute("shoppingCart", 0);
			} else {
				for(int products = 0; products < list.size(); products++) {
					int shoppingCartQuantity = list.get(products).getQuantity();
					int stockQuantity = list.get(products).getProductsBean().getUnitStock();
					//若購物車裡的商品選購數已大於存貨
					if(shoppingCartQuantity > stockQuantity && stockQuantity != 0) {
						list.get(products).setQuantity(stockQuantity);
						scservice.updateQty(list.get(products));
					}
				}
				System.out.println("There are items in shopping cart");
				model.addAttribute("shoppingCart", list);
			}
		} else {
			SCOrdersBean scob = new SCOrdersBean();
			scob.setMemberID(memberID);
			scoservice.insertOrder(scob);
			System.out.println("Shopping cart is empty");
			model.addAttribute("shoppingCart", 0);
		}
		return "a/ShoppingCart";
	}

	@PostMapping("/deleteProduct")
	public String showShoppingCartItem() {
		return "a/ShoppingCart";
	}
}
