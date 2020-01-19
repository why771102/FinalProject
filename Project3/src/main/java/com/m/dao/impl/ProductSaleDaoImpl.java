package com.m.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.dao.ProductSaleDao;
import com.m.model.ProductSaleBean;

@Repository
public class ProductSaleDaoImpl implements ProductSaleDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getCategoryNames() {
		String hql = "SELECT c.categoryName FROM CategoriesBean c " + "WHERE c.categoryID BETWEEN 4 AND 6";
		Session session = factory.getCurrentSession();
		List<String> categoryNames = new ArrayList<>();
		categoryNames = session.createQuery(hql).getResultList();

		String ans = "";
		ans += "<SELECT id='categoryNames' onclick='sendCate()'>"
				+ "<option value='' selected='' disabled=''>請選擇</option>" + "<option value='all'>全部商品</option>"
				+ "<option value='allFood'>餐點總覽</option>";
		for (String cate : categoryNames) {
			ans += "<option value='" + cate + "'>" + cate + "</option>";
		}
		ans += "</SELECT>";
		return ans;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	// 全部之總飲食
//	public List<ProductSaleBean> showAllProductOrders(String playStartTimeA, String playStartTimeB) {
//		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
//				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
//				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB";
//		// on p.productID = mod.productID
//		// on mod.ordersID = mo.ordersID
//		// on mo.showTimeID = sth.showTimeID
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
//		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
//				.setParameter("playStartTimeB", playStartTimeB).getResultList();
//		return foodOrdersList;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	// 計算周邊商品的過程step1 ===========NEW
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB) {
		String hql = "FROM SCOrdersBean";
//		String hql1 = "FROM products p "
//				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
//				+ "WHERE sco.orderDate BETWEEN :orderDateA AND :orderDateB";
		// on p.productID = scod.productID;
		// on scod.SCOrderID = sc.SCOrderID;
		Session session = factory.getCurrentSession();
		List<SCOrdersBean> SCOrdersList = new ArrayList<>();
		List<SCOrdersBean> SCODList = new ArrayList<>();
		SCOrdersList = session.createQuery(hql).getResultList();
		
		LocalDate Sd = LocalDate.parse(orderDateA);
		LocalDate Ed = LocalDate.parse(orderDateB);
		for(SCOrdersBean scob : SCOrdersList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(scob.getOrderDate(), formatter).toLocalDate();
			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, orderDate);
			if (SdOdDays >= 0 && EdOdDays <= 0) {
				SCODList.add(scob);
				System.out.println("符合 輸入查詢區間與scob日期比較");
				System.out.println("scob=>" + SCODList.size());
			} else {
				System.out.println("不符合 輸入查詢區間與scob日期比較");
			}
		}
		return SCODList;
		// SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost
	}

	// 計算周邊商品的過程step2 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getPeripheralPB() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 6";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 計算周邊商品的p1輸出step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> getPeripheralSCOD(List<ProductsBean> pbList, List<SCOrdersBean> scbList) {
		Session session = factory.getCurrentSession();
		String hql = "FROM SCOrderDetailBean";
		List<SCOrderDetailBean> SCODList1 = new ArrayList<>();
		SCODList1 = session.createQuery(hql).getResultList();
		List<ProductSaleBean> psbList = new ArrayList<>();

		String saveProductName = null;
		Integer unitPrice = 0;
//		Double discount = 0.0;
		Integer qty = 0;
		Integer productSubtotal = 0;
		Integer cost = 0;
		Integer earn = 0;
		Integer earnTotal = 0;
		for (SCOrdersBean scb : scbList) {
			for (SCOrderDetailBean scodb : SCODList1) {
				if (scb.getSCOrderID() == scodb.getSCOrderID()) {
					for (ProductsBean pb : pbList) {
						if (pb.getProductName().equals(scodb.getPrducts().getProductName())) {
							productSubtotal = productSubtotal + scb.getTotal();
							unitPrice = unitPrice + scodb.getPrducts().getUnitPrice(); // getPBean
							saveProductName = scodb.getPrducts().getProductName();
//							scodb.getProductsID();
							qty = qty + scodb.getQuantity();
							cost = cost + scodb.getPrducts().getCost();
							earn = earn + (unitPrice - cost);
							earnTotal = earnTotal + earn;
							productSubtotal = productSubtotal + (unitPrice*qty);
							ProductSaleBean psb = new ProductSaleBean(saveProductName, qty, unitPrice, cost, earn,
									productSubtotal, earnTotal);
							psbList.add(psb);
						} else {
							System.out.println("比對時pb & scod產品名稱不相同");
						}
					}
				} else {
					System.out.println("比對時od & odb OID不相同");
				}
			}
		}
		return psbList;
	}

	
	// 計算4,5的過程step1 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB) {
		String hql = "FROM ShowTimeHistoryBean";
		Session session = factory.getCurrentSession();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		sthbList = session.createQuery(hql).getResultList();
		
		List<ShowTimeHistoryBean> sthbList1 = new ArrayList<>();
		
		LocalDate Sd = LocalDate.parse(playStartTimeA);
		LocalDate Ed = LocalDate.parse(playStartTimeB);
		
		for(ShowTimeHistoryBean sthb: sthbList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate orderDate = LocalDateTime.parse(sthb.getPalyStartTime(), formatter).toLocalDate();
			
			long SdOdDays = ChronoUnit.DAYS.between(Sd, orderDate);
			long EdOdDays = ChronoUnit.DAYS.between(Ed, orderDate);
			
			if (SdOdDays >= 0 && EdOdDays <= 0) {
				sthbList1.add(sthb);
				System.out.println("符合 輸入查詢區間與sthb日期比較");
				System.out.println("scob=>" + sthbList1.size());
			} else {
				System.out.println("不符合 輸入查詢區間與sthb日期比較");
			}
		}
		return sthbList1;
	}

	// 計算4,5的過程step2 ===========NEW

	@SuppressWarnings("unchecked")
	@Override
	public List<MOrderDetailBean> getMODBList() {
		String hql = "FROM MOrderDetailBean";
		List<MOrderDetailBean> modbList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		modbList = session.createQuery(hql).getResultList();
		return modbList;
	}

	// 計算4的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getFoodPB4() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 4";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 計算5的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getFoodPB5() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 5";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}
	
	// 計算4+5的過程step3 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getAllFoodPB() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID BETWEEN 4 AND 5";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	// 選下拉4, 5飲食step4 ====NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showFoodOutput(List<ShowTimeHistoryBean> sthbList, List<MOrderDetailBean> modbList,
			List<ProductsBean> pbList) {
		String hql = "FROM MOrderBean";
		Session session = factory.getCurrentSession();
		List<MOrderBean> mobList = new ArrayList<>();
		mobList = session.createQuery(hql).getResultList();

		List<ProductSaleBean> psbList = new ArrayList<>();
		String saveProductName = null;
		Integer qty = 0;
		Integer unitPrice = 0;
		Integer productSubtotal = 0;
		Integer cost = 0;
		Integer earn = 0;
		Integer earnTotal = 0;
		for (ShowTimeHistoryBean sthb : sthbList) {
			for (MOrderBean mob : mobList) {
				if (sthb.getShowTimeId().equals(mob.getShowTimeHistoryBean().getShowTimeId())) {
					for (MOrderDetailBean modb : modbList) {
						if (mob.getOrdersID() == modb.getmOrderBean().getOrdersID()) {
							for (ProductsBean pb : pbList) {
								if (pb.getProductID() == modb.getProductsBean().getProductID()) {
									saveProductName = pb.getProductName();
									qty = qty + modb.getQuantity();
									unitPrice = unitPrice + (int)Math.round(modb.getSellUnitPrice() * modb.getDiscount());
									productSubtotal = productSubtotal + (unitPrice * qty);
									cost = cost + pb.getCost();
									earn = earn + (unitPrice - cost);
									earnTotal = earnTotal + earn;
									ProductSaleBean psb = new ProductSaleBean(saveProductName, qty, unitPrice, cost, earn,
											productSubtotal, earnTotal);
									psbList.add(psb);
								} else {
									System.out.println("比對時, pb & modb的PID不同");
								}
							}
						} else {
							System.out.println("比對時, mob & modb的OID不同");
						}
					}
				} else {
					System.out.println("比對時, sthb & mob的showtime不同");
				}
			}
		}
		return psbList;
	}
	
	@Override
	public Integer getCategory(String pName) {
		String hql = "SELECT category FROM ProductsBean WHERE productName= :pName";
		Session session = factory.getCurrentSession();
		Integer CID = (Integer) session.createQuery(hql).getSingleResult();
		return CID;
	}
	
	
	
	
//	@SuppressWarnings("unchecked")
//	@Override
//	//選下拉單個周邊p1
//	public List<ProductSaleBean> showPeripheralOrder(String categoryName, String orderDateA, String orderDateB) {
//		String hql = "SELECT p.productName, scod.unitPrice, scod.discount, scod.quantity, p.cost FROM products p left join"
//				+ "p.categories c left join p.SCOrderDetail scod left join scod.SCOrders sco WHERE c.categoryName = :categoryName"
//				+ "AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
//		//	on p.categoryID = c.categoryID
//		//	on p.productID = scod.productID;
//		//	on scod.SCOrderID = sco.SCOrderID;
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> periperalOrderList  = new ArrayList<>();
//		periperalOrderList = session.createQuery(hql).setParameter("categoryName", categoryName)
//				.setParameter("orderDateA", orderDateA)
//				.setParameter("orderDateB", orderDateB).getResultList();
//		return periperalOrderList;
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	//選下拉總周邊p1 
//	public List<ProductSaleBean> showPeriperalOrders(String categoryNameA, String categoryNameB, String orderDateA, String orderDateB) {
//		String hql = "SELECT p.productName, scod.unitPrice, scod.discount, scod.quantity, p.cost FROM products p left join "
//				+ "p.categories c left join p.SCOrderDetail scod left join scod.SCOrders sco WHERE c.categoryName"
//				+ "BETWEEN :categoryNameA AND :categoryNameB AND sco.orderDate BETWEEN :orderDateA AND :orderDateB";
//		//	on p.categoryID = c.categoryID
//		//	on p.productID = scod.productID;
//		//	on scod.SCOrderID = sco.SCOrderID;
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> periperalOrders  = new ArrayList<>();
//		periperalOrders = session.createQuery(hql).setParameter("categoryNameA", categoryNameA)
//				.setParameter("categoryNameB", categoryNameB)
//				.setParameter("orderDateA", orderDateA)
//				.setParameter("orderDateB", orderDateB).getResultList();
//		return periperalOrders;
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
//		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
//				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
//				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND p.productName= :productName"
//				+ "ORDER BY sth.playStartTime ASC";
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> foodOrderByTimeList = new ArrayList<>();
//		foodOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
//				.setParameter("playStartTimeA", playStartTimeA).setParameter("playStartTimeB", playStartTimeB)
//				.getResultList();
//		return foodOrderByTimeList;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
//		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p "
//				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
//				+ "WHERE sco.orderDate BETWEEN :orderDateA AND orderDateB AND p.productName = :productName"
//				+ "ORDER BY sco.orderDate ASC";
//		// on p.productID = scod.productID;
//		// on scod.SCOrderID = sco.SCOrderID;
//		Session session = factory.getCurrentSession();
//		List<ProductSaleBean> peripheralOrderByTimeList = new ArrayList<>();
//		peripheralOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
//				.setParameter("orderDateA", orderDateA).setParameter("orderDateB", orderDateB).getResultList();
//		return peripheralOrderByTimeList;
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<String> getDistinctProductNames() {
//		List<String> productNames = new ArrayList<>();
//		String hql = "SELECT DISTINCT productName FROM products";
//		Session session = factory.getCurrentSession();
//		productNames = session.createQuery(hql).getResultList();
//		return productNames;
//	}

}
