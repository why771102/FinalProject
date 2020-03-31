package com._root.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c.model.HallBean;
import com.c.service.HallService;
import com.c.service.impl.HallServiceImpl;
import com.z.test.QRcode.C.QRCodeZServiceImpl;

//範本
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index2";
	}
	
	@RequestMapping("index")
	public String oldIndex() {
		return "index";
	}
	
	@RequestMapping("index-a")
	public String indexa(Model model, HttpServletRequest req) {
		return "index-a";
	}
	
	@RequestMapping("index-c")
	public String indexc(Model model, HttpServletRequest req) {
		return "index-c";
	}
	
	@RequestMapping("index-l")
	public String indexl(Model model, HttpServletRequest req) {
		return "index-l";
	}
	
	@RequestMapping("index-m")
	public String indexm(Model model, HttpServletRequest req) {
		return "index-m";
	}
	
	@RequestMapping("index-p")
	public String indexp(Model model, HttpServletRequest req) {
		return "index-p";
	}
	
	@RequestMapping("index-t")
	public String indext(Model model, HttpServletRequest req) {
		return "index-t";
	}
	
	@RequestMapping("index-z")
	public String indexz(Model model, HttpServletRequest req) {
		return "index-z";
	}
	
	@RequestMapping("qrcode")
	@ResponseBody
	public void qrcode(Model model, HttpServletRequest req,HttpServletResponse res) {
		
		QRCodeZServiceImpl qrcodeService = new QRCodeZServiceImpl();
		String text = "Dennis!!!";
		File a = new File("D:\\22.png");
		File codeFile =new File("D:\\3.jpg");
		String qrUrl = "https://www.youtube.com/";
		String note = "李怡瑩";
		qrcodeService.drawLogoQRCode(a, codeFile, qrUrl, note, res);

	}
}
