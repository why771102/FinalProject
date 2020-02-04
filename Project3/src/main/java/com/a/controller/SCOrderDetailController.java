package com.a.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.service.SCOrderDetailsService;
import com.a.service.SCOrdersService;
import com.a.service.ShoppingCartService;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;
import com.p.service.MemberService;

//製造假資料
@Controller
public class SCOrderDetailController {

	MemberService mservice;
	SCOrdersService scoservice;
	SCOrderDetailsService scodservice;
	ProductsService pservice;
	ShoppingCartService scservice;

	@Autowired
	public void setService(MemberService mservice, SCOrdersService scoservice, 
			SCOrderDetailsService scodservice, ProductsService pservice,
			ShoppingCartService scservice) {
		this.mservice = mservice;
		this.scodservice = scodservice;
		this.scoservice = scoservice;
		this.pservice = pservice;
		this.scservice = scservice;
	}

	@GetMapping("/fakeSCOrder")
	public String fakeSCOrder() {
		//get list of memberID
		//list.get(index).getMemberID()
		List<MemberBean> listmb = mservice.getMemberList();
		//get all products in shopping cart category
		List<ProductsBean> listpb  = new ArrayList<>();
		for(int categories = 17; categories <=33; categories++) {
			ProductsBean pb = pservice.getProduct(categories);
			listpb.add(pb);
		}
		//get dates
		LocalDate startdate = LocalDate.parse("2019-11-09");
		LocalDate endDate = LocalDate.parse("2020-02-21");
		long days = ChronoUnit.DAYS.between(startdate, endDate);
		System.out.println("days: " + days);
		int count = 1;
		for (Integer day = 0; day < days; day++) {
			System.out.println("day "+ day);
			//random number of orders per day
			//maximum no of orders each day must equal number of members
			
			Integer noOfOrdersEachDay = (int) (Math.random()*20)+50;
			System.out.println("noOfOrdersPerDay: " + noOfOrdersEachDay);
//			Integer[] prod = new Integer[listpb.size()];
			for(int member = 0; member < noOfOrdersEachDay; member++) {
				//memberBean index
				Integer memID = (int) (Math.random()*listmb.size());
				System.out.println("memberID:" + listmb.get(memID).getMemberID());
				SCOrdersBean scob = new SCOrdersBean();
				scob.setMemberID(listmb.get(memID).getMemberID());
				System.out.println("memberID:" + listmb.get(memID).getMemberID());
				LocalDate ldt = startdate.plusDays(day);
				String orderDate = ldt.toString();
				scob.setOrdDate(orderDate);
				scob.setShippingAddress(listmb.get(memID).getAddress());
				scoservice.insertOrder(scob);
				//random number of products per order
				Integer noOfProductsPerOrder = (int) (Math.random()*3)+1;
				System.out.println("noOfProductsPerOrder: " + noOfProductsPerOrder);
				Integer SCOrderID = scservice.getShoppingCart(listmb.get(memID).getMemberID());
				for(int product = 0; product < noOfProductsPerOrder; product++) {
					SCOrderDetailBean scodb = new SCOrderDetailBean();
					Integer productID = listpb.get((int) (Math.random()*listpb.size())).getProductID();
					System.out.println("productID: " + productID);
					System.out.println("ProductName: " + listpb.get((int) (Math.random()*listpb.size())).getProductName());
					ProductsBean prodbean = pservice.getProduct(productID);
					Integer buyingquantity = (int) (Math.random()*10)+1;
					System.out.println("buyingquantity: " + buyingquantity);
					scodb.setProductID(productID);
					scodb.setQuantity(buyingquantity);
					scodb.setSCOrderID(SCOrderID);
					scodservice.insertOrderDetails(scodb);
					System.out.println("insertOrderDetails");
				}
				List<SCOrderDetailBean> listscodb = scodservice.getOrderDetails(SCOrderID);
				Integer total = 0;
				for(int orderDetail = 0; orderDetail < listscodb.size(); orderDetail++) {
					System.out.println("for(int orderDetail = 0; orderDetail < listscodb.size(); orderDetail++)");
					total += listscodb.get(orderDetail).getQuantity()* listscodb.get(orderDetail).getProductsBean().getUnitPrice();
				}
				PayStatusBean payStatusBean = new PayStatusBean(1);
				SCOrdersBean ob = new SCOrdersBean();
				ob.setPayStatusBean(payStatusBean);
				ob.setTotal(total);
				ob.setsCOrderID(SCOrderID);
				scoservice.updateStatus(ob);
				System.out.println("Insert successful!!! no:" + count);
				count++;
			}
		}
		return null;
	}
}
