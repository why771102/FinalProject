package com._root.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.c.model.HallBean;
import com.c.service.HallService;
import com.c.service.impl.HallServiceImpl;

//範本
@Controller
public class HomeController {
	@RequestMapping("/123")
	public String welcome1219(Model model, HttpServletRequest req) {
		model.addAttribute("items", new String[] {"KOBE","HOWARD","76"});
		model.addAttribute("title", "歡迎光臨");
		model.addAttribute("subtitle", "網路上獨一無二的購物天堂");
		req.setAttribute("test", "測試用");
		HallBean hb = new HallBean("A", 300, 1500, 0);
		HallService hs = new HallServiceImpl();
		hs.insertHall(hb);
		return "welcome";
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
