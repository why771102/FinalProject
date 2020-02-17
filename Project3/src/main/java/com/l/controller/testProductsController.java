package com.l.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.l.service.mOrdersService;

@Controller
public class testProductsController {
	// 普通票ID
	public final Integer productNormal = 1;
	// 銀行票ID
	public final Integer productBank = 3;
	// 個人套票ID
	public final Integer productdiscount = 13;
	// 雙人套票ID
	public final Integer productdiscount2 = 15;
	// 熟食頭ID
	public final Integer productfood = 7;
	// 熟食尾ID
	public final Integer productfood2 = 9;
	// 可樂頭ID
	public final Integer productCoke = 4;
	// 可樂尾ID
	public final Integer productCoke2 = 6;
	// 爆米花頭ID
	public final Integer productPopcorn = 10;
	// 爆米花尾ID
	public final Integer productPopcorn2 = 12;

	ProductsService service;
	mOrdersService service2;

	@Autowired
	public void setService(ProductsService service, mOrdersService service2) {
		this.service = service;
		this.service2 = service2;
	}

	// 顯示4種類別資料
	@RequestMapping("/testProducts")
	public String showAllProducts(Model model) {
		// 票
		List<ProductsBean> mapticket = new ArrayList<>();
		List<ProductsBean> mapdiscountTicket = new ArrayList<>();
		// 熱食
		List<ProductsBean> mapfood = new ArrayList<>();
		// 飲料
		List<ProductsBean> mapdrink = new ArrayList<>();
		// 爆米花
		List<ProductsBean> mappopcorn = new ArrayList<>();
		// map加入套票
		mapdiscountTicket.add(service.getProduct(productdiscount));
		// map加入套票2
		mapdiscountTicket.add(service.getProduct(productdiscount2));
		// map加入銀行票
		mapticket.add(service.getProduct(productBank));
		// map加入普通票
		mapticket.add(service.getProduct(productNormal));
		// map加入熟食
		

		for (int ini = productfood; ini <= productfood2; ini++) {
			mapfood.add(service.getProduct(ini));
		}
		// map加入飲料
		for (int ini = productCoke; ini <= productCoke2; ini++) {
			mapdrink.add(service.getProduct(ini));
		}
		// map加入爆米花
		for (int ini = productPopcorn; ini <= productPopcorn2; ini++) {
			mappopcorn.add(service.getProduct(ini));
		}
		model.addAttribute("ticket", mapticket);
		model.addAttribute("disountTicket", mapdiscountTicket);
		model.addAttribute("food", mapfood);
		model.addAttribute("drink", mapdrink);
		model.addAttribute("popcorn", mappopcorn);

		return "l/testBookNormal";
	}

	@RequestMapping("/testOrderConfirm")
	public String orderConfirm(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 票
		List<ProductsBean> mapticket = new ArrayList<>();
		List<ProductsBean> mapdiscountTicket = new ArrayList<>();
		// 熱食
		List<ProductsBean> mapfood = new ArrayList<>();
		// 飲料
		List<ProductsBean> mapdrink = new ArrayList<>();
		// 爆米花
		List<ProductsBean> mappopcorn = new ArrayList<>();
		// map加入套票
		mapdiscountTicket.add(service.getProduct(productdiscount));
		// map加入套票2
		mapdiscountTicket.add(service.getProduct(productdiscount2));
		// map加入銀行票
		mapticket.add(service.getProduct(productBank));
		// map加入普通票
		mapticket.add(service.getProduct(productNormal));
		// map加入熟食
		

		for (int ini = productfood; ini <= productfood2; ini++) {
			mapfood.add(service.getProduct(ini));
		}
		// map加入飲料
		for (int ini = productCoke; ini <= productCoke2; ini++) {
			mapdrink.add(service.getProduct(ini));
		}
		// map加入爆米花
		for (int ini = productPopcorn; ini <= productPopcorn2; ini++) {
			mappopcorn.add(service.getProduct(ini));
		}
		model.addAttribute("ticket", mapticket);
		model.addAttribute("disountTicket", mapdiscountTicket);
		model.addAttribute("food", mapfood);
		model.addAttribute("drink", mapdrink);
		model.addAttribute("popcorn", mappopcorn);
		return "l/testOrderconfirm";
	}

	
	@RequestMapping("/testOrderConfirmOK")
	public String orderconfirmOK(Model model,HttpServletRequest request,HttpServletResponse response){
		
		List<ProductsBean> mapticket = new ArrayList<>();
		List<ProductsBean> mapdiscountTicket = new ArrayList<>();
		// 熱食
		List<ProductsBean> mapfood = new ArrayList<>();
		// 飲料
		List<ProductsBean> mapdrink = new ArrayList<>();
		// 爆米花
		List<ProductsBean> mappopcorn = new ArrayList<>();
		// map加入套票
		mapdiscountTicket.add(service.getProduct(productdiscount));
		// map加入套票2
		mapdiscountTicket.add(service.getProduct(productdiscount2));
		// map加入銀行票
		mapticket.add(service.getProduct(productBank));
		// map加入普通票
		mapticket.add(service.getProduct(productNormal));
		// map加入熟食
	
		for (int ini = productfood; ini <= productfood2; ini++) {
			mapfood.add(service.getProduct(ini));
		}
		// map加入飲料
		for (int ini = productCoke; ini <= productCoke2; ini++) {
			mapdrink.add(service.getProduct(ini));
		}
		// map加入爆米花
		for (int ini = productPopcorn; ini <= productPopcorn2; ini++) {
			mappopcorn.add(service.getProduct(ini));
		}
		model.addAttribute("ticket", mapticket);
		model.addAttribute("disountTicket", mapdiscountTicket);
		model.addAttribute("food", mapfood);
		model.addAttribute("drink", mapdrink);
		model.addAttribute("popcorn", mappopcorn);
		
		MOrderBean mb=new MOrderBean();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("showtimeId")) {
				 String showtimeId = cookie.getValue();
				 mb.setShowTimeID(Integer.parseInt(showtimeId));
				 }
//			if(cookie.getName().equals("memberID")) {
//			
//				String memberID = cookie.getValue();
//				System.out.println(memberID);
//				mb.setMemberID(Integer.parseInt(memberID));
//			}else{
//				
//				mb.setMemberID(1);
//			}
		}
		for(Cookie cookie : cookies){
		
			if(cookie.getName().equals("memberID")) {
				String memberID = cookie.getValue();
				mb.setMemberID(Integer.parseInt(memberID));
				break;
			}else{
				mb.setMemberID(1);
				}
		}
		LocalDate today = (LocalDate.now());
		LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
		String dateTime = today.toString() + " " + time.toString();
		mb.setOrderTime(dateTime);
		mb.setTicketStatus(0);
		mb.setTicketTime("2999-01-01");
		mb.setEmpId(1);
		service2.addMOrder(mb);
		
		MOrderDetailBean mdb=new MOrderDetailBean();
		MOrderDetailBean mdb1=new MOrderDetailBean();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("13")) {
				 String discount = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(13);
				 mdb.setSellUnitPrice(195);
				 mdb.setDiscount(1.0);
				 mdb.setQuantity(Integer.parseInt(discount));
				 service2.addMOrderDetail(mdb); 
				 mdb1.setOrdersID(mb.getOrdersID());
				 mdb1.setProductID(14);
				 mdb1.setSellUnitPrice(175);
				 mdb1.setDiscount(1.0);
				 mdb1.setQuantity(Integer.parseInt(discount));
				 service2.addMOrderDetail(mdb1); 
				 session.removeAttribute("13");
					
			}
			if(cookie.getName().equals("15)")) {
				 String discount2 = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(15);
				 mdb.setSellUnitPrice(370);
				 mdb.setDiscount(1.0);
				 mdb.setQuantity(Integer.parseInt(discount2));
				 service2.addMOrderDetail(mdb);
				 mdb1.setOrdersID(mb.getOrdersID());
				 mdb1.setProductID(16);
				 mdb1.setSellUnitPrice(330);
				 mdb1.setDiscount(1.0);
				 mdb1.setQuantity(Integer.parseInt(discount2));
				 service2.addMOrderDetail(mdb1); 
				 session.removeAttribute("15");
			}
			if(cookie.getName().equals("3")) {
				 String bankticket = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(3);
				 mdb.setSellUnitPrice(220);
				 mdb.setDiscount(1.0);
				 mdb.setQuantity(Integer.parseInt(bankticket));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("3");
				}
			if(cookie.getName().equals("1")) {
				 String normal = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(1);
				 mdb.setSellUnitPrice(290);
				 mdb.setDiscount(1.0);
				 mdb.setQuantity(Integer.parseInt(normal));
				 service2.addMOrderDetail(mdb); 
				 session.removeAttribute("1");
				}
			if(cookie.getName().equals("7")) {
				 String hotdog = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(7);
				 mdb.setSellUnitPrice(120);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(hotdog));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("7");
			}
			if(cookie.getName().equals("8")) {
				 String churro = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(8);
				 mdb.setSellUnitPrice(100);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(churro));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("8");
				 }
			if(cookie.getName().equals("9")) {
				 String friedChicken = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(9);
				 mdb.setSellUnitPrice(200);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(friedChicken));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("9");
				 }
			if(cookie.getName().equals("4")) {
				 String bigCoke = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(4);
				 mdb.setSellUnitPrice(70);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(bigCoke));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("4");
				 }
			if(cookie.getName().equals("5")) {
				 String normalCoke = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(5);
				 mdb.setSellUnitPrice(60);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(normalCoke));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("5");
				 }
			if(cookie.getName().equals("6")) {
				 String smallCoke = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(6);
				 mdb.setSellUnitPrice(54);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(smallCoke));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("6");
				 }
			if(cookie.getName().equals("10")) {
				 String bigPopcorn = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(10);
				 mdb.setSellUnitPrice(140);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(bigPopcorn));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("10");
				 }
			if(cookie.getName().equals("11")) {
				 String normalPopcorn = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(11);
				 mdb.setSellUnitPrice(130);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(normalPopcorn));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("11");
				 }
			if(cookie.getName().equals("12")) {
				 String smallPopcorn = cookie.getValue();
				 mdb.setOrdersID(mb.getOrdersID());
				 mdb.setProductID(12);
				 mdb.setSellUnitPrice(120);
				 mdb.setDiscount(0.9);
				 mdb.setQuantity(Integer.parseInt(smallPopcorn));
				 service2.addMOrderDetail(mdb);
				 session.removeAttribute("12");
			}
//				cookie.setValue(null);
//	            cookie.setMaxAge(0);
//	            cookie.setPath("/");
//	            response.addCookie(cookie);
			
		}
		
		return "l/testOrderConfirmOK";
	}
	
	
	
}
