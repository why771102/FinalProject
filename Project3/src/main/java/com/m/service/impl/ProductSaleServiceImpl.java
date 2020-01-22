package com.m.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;
import com.m.model.ProductSaleEarnBean;
import com.m.service.ProductSaleService;

@Service
public class ProductSaleServiceImpl implements ProductSaleService {
	
	ProductSaleDao dao;

	@Autowired
	public void setDao(ProductSaleDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public String getCategoryNames() {
		return dao.getCategoryNames();
	}
	
	@Transactional
	@Override
	public List<ProductSaleEarnBean> getAllProductInfo(String sDate, String eDate) {
		return dao.getAllProductInfo(sDate, eDate);
	}
	@Transactional
	@Override
	public List<ProductSaleEarnBean> getAllFoodInfo(String sDate, String eDate){
		return dao.getAllFoodInfo(sDate, eDate);
	}
	
	@Transactional
	@Override
	public List<ProductSaleEarnBean> getFoodInfo4(String sDate, String eDate) {
		return dao.getFoodInfo4(sDate, eDate);
	}
	
	@Transactional
	@Override
	public List<ProductSaleEarnBean> getFoodInfo5(String sDate, String eDate) {
		return dao.getFoodInfo5(sDate, eDate);
	}
	
	@Transactional
	@Override
	public List<ProductSaleEarnBean> getPeripheralInfo(String sDate, String eDate){
		return dao.getPeripheralInfo(sDate, eDate);
	}
	
	
//	@Transactional
//	@Override
//	public List<LocalDate> getPeripheralDates(){
//		return dao.getPeripheralDates();
//	}
//
//	@Override
//	public List<SCOrdersBean> getPeripheralSCOrder(LocalDate orderDate) {
//		return dao.getPeripheralSCOrder(orderDate);
//	}
//
//	@Override
//	public List<SCOrderDetailBean> getPeripheralSCODs(List<SCOrdersBean> scbList) {
//		return dao.getPeripheralSCODs(scbList);
//	}
//
//	@Override
//	public List<ProductSaleEarnBean> getPeripheralPBs(List<SCOrderDetailBean> scodList) {
//		return dao.getPeripheralPBs(scodList);
//	}
	
	@Transactional
	@Override
	public List<LocalDate> getFoodDates(){
		return dao.getFoodDates();
	}
	
//	@Transactional
//	@Override
//	public List<MOrderBean> getFoodSCOrder(LocalDate date) {
//		return dao.getFoodSCOrder(date);
//	}
//	
//	@Transactional
//	@Override
//	public List<MOrderDetailBean> getFoodSCODs(List<MOrderBean> moList) {
//		return dao.getFoodSCODs(moList);
//	}
//	
//	@Transactional
//	@Override
//	public List<ProductSaleEarnBean> getFoodPBs(List<MOrderDetailBean> modbList) {
//		return dao.getFoodPBs(modbList);
//	}
	
//	@Transactional
//	@Override
//	public List<ProductSaleEarnBean> savePSEB1(){
//		return dao.savePSEB1();
//	}
	
//	@Transactional
//	@Override
//	public List<ProductSaleEarnBean> savePSEB1(){
//		return dao.savePSEB1();
//	}
//	
//	@Transactional
//	@Override
//	public Boolean savePSEB(List<ProductSaleEarnBean> psebList) {
//		System.out.println("service call savePSEB()");
//		System.out.println(dao.savePSEB(psebList));
//		return dao.savePSEB(psebList);
//	}

	
	
	
	
	
	


	// 取得周邊商品3方法
	@Transactional
	@Override
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB) {
		return dao.getPeripheralSCOrders(orderDateA, orderDateB);
	}

	@Transactional
	@Override
	public List<ProductsBean> getPeripheralPB() {
		return dao.getPeripheralPB();
	}

	@Transactional
	@Override
	public List<ProductSaleBean> getPeripheralOutput(List<ProductsBean> pbList, List<SCOrdersBean> scbList) {
		return dao.getPeripheralSCOD(pbList, scbList);
	}

	// 取得食物方法
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB) {
		return dao.getMovieDate(playStartTimeA, playStartTimeB);
	}

	@Transactional
	@Override
	public List<MOrderDetailBean> getMODBList() {
		return dao.getMODBList();
	}

	@Transactional
	@Override
	public List<ProductsBean> getFoodPB4() {
		return dao.getFoodPB4();
	}

	@Transactional
	@Override
	public List<ProductsBean> getFoodPB5() {
		return dao.getFoodPB5();
	}

	@Transactional
	@Override
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList) {
		return dao.showFoodOutput(sthbList, modbList, pbList);
	}

	@Transactional
	@Override
	public List<ProductsBean> getAllFoodPB() {
		return dao.getAllFoodPB();
	}

//	@Transactional
//	@Override
//	public List<ProductSaleBean> showFoodOrder(String categoryName, String playStartTimeA, String playStartTimeB) {
//		return dao.showFoodOrder(categoryName, playStartTimeA, playStartTimeB);
//	}
//
//	@Transactional
//	@Override
//	public List<ProductSaleBean> showFoodOrders(String playStartTimeA,
//			String playStartTimeB) {
//		return dao.showFoodOrders(playStartTimeA, playStartTimeB);
//	}
//
//	@Transactional
//	@Override
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB) {
//		return dao.showPeripheralOrder(categoryName, orderDateA, orderDateB);
//	}

//	@Transactional
//	@Override
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA,
//			String orderDateB) {
//		return dao.showPeriperalOrders(categoryNameA, categoryNameB, orderDateA, orderDateB);
//	}

//	
//	@Transactional
//	@Override
//	public List<String> getDistinctProductNames() {
//		List<String> productNamesList = dao.getDistinctProductNames();
//		return productNamesList;
//	}
//
//	@Transactional
//	@Override
//	public List<ProductSaleBean> getProductSaleOutput(List<ProductSaleBean> psbList) {
//		List<ProductSaleBean> PSBList = new ArrayList<>();
//		List<String> productNames = dao.getDistinctProductNames();
//
//		for (String productName : productNames) {
//			String saveProductName = null;
//			Integer unitPrice = 0;
//			Double discount = 0.0;
//			Integer qty = 0;
//			Double productSubtotal = 0.0;
//			
//			for (ProductSaleBean psb : psbList) {
//				//如果產品名稱相同就存
//				if(productName.equals(psb.getProductName())) {
//					saveProductName = productName;
//					qty = qty + psb.getQty();
//					unitPrice = psb.getUnitPrice();
//					discount = psb.getDiscount();
//					productSubtotal = productSubtotal + unitPrice*discount*qty;
//					psbList.remove(psb);
//				}else {
//					System.out.println("比對時,DB產品名稱&psb名稱不同");
//				}
//			}
//			ProductSaleBean psb = new ProductSaleBean(saveProductName, unitPrice, qty, productSubtotal);
//			PSBList.add(psb);
//		}
//		return PSBList;
//	}
//
//	@Transactional
//	@Override
//	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
//		return dao.showFoodOrderByTime(productName, playStartTimeA, playStartTimeB);
//	}
//
//	@Transactional
//	@Override
//	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
//		return dao.showPeripheralOrderByTime(productName, orderDateA, orderDateB);
//	}

	@Transactional
	@Override
	public List<LocalDate> showEachDate(String sDate, String eDate) {
		LocalDate start = LocalDate.parse(sDate);
		LocalDate end = LocalDate.parse(eDate);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		return totalDates;
	}

	@Transactional
	@Override
	// showByDate
	public List<ProductSaleBean> getByDateOutput(List<LocalDate> datesList, String pName) {
		List<ProductSaleBean> psbList = new ArrayList<>();
		List<SCOrdersBean> scobList = new ArrayList<>();
		List<ProductsBean> pbList = new ArrayList<>();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		List<MOrderDetailBean> modbList = new ArrayList<>();
		for (LocalDate date : datesList) {
			if (dao.getCategory(pName) == 6) {
				scobList = dao.getPeripheralSCOrders(date.toString(), date.toString());
				pbList = dao.getPeripheralPB();
				psbList = dao.getPeripheralSCOD(pbList, scobList);
			} else if (dao.getCategory(pName) == 4) {
				sthbList = dao.getMovieDate(date.toString(), date.toString());
				modbList = dao.getMODBList();
				pbList = dao.getFoodPB4();
				psbList = dao.showFoodOutput(sthbList, modbList, pbList);
			} else if (dao.getCategory(pName) == 5) {
				sthbList = dao.getMovieDate(date.toString(), date.toString());
				modbList = dao.getMODBList();
				pbList = dao.getFoodPB5();
				psbList = dao.showFoodOutput(sthbList, modbList, pbList);
			} else {
				System.out.println("不應該出現在這裡的CID");
			}
		}
		return psbList;
	}



//	@Override
//	public List<MOrderDetailBean>  getFoodSCOrder1() {
//		return dao.getFoodSCOrder1();
//	}



//	@Transactional
//	@Override
//	// showPeripheralSaleByDate
//	public List<ProductSaleBean> getPeripheralSaleByDateOutput(List<LocalDate> datesList, String productName) {
//		List<ProductSaleBean> PSBList = new ArrayList<>();
//
//		for (LocalDate date : datesList) {
//			PSBList = dao.showPeripheralOrderByTime(productName, date.toString(), date.toString());
//		}
//		return PSBList;
//	}
}
