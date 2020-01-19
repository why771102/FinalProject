package com.m.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
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
		ans += "<SELECT id='categoryNames' onchange='showCate()'>"
				+ "<option value='' selected='' disabled=''>請選擇</option>" + "<option value='all'>全部商品</option>"
				+ "<option value='allFood'>餐點總覽</option>";
		for (String cate : categoryNames) {
			ans += "<option value='" + cate + "'>" + cate + "</option>";
		}
		ans += "</SELECT>";
		return ans;
	}

	@SuppressWarnings("unchecked")
	@Override
	// 全部之總飲食
	public List<ProductSaleBean> showAllProductOrders(String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB";
		// on p.productID = mod.productID
		// on mod.ordersID = mo.ordersID
		// on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB).getResultList();
		return foodOrdersList;
	}

	@SuppressWarnings("unchecked")
	@Override
	//計算周邊商品的過程step1 ===========NEW
	public List<SCOrdersBean> getPeripheralSCOrders(String orderDateA, String orderDateB) {
		String hql = "FROM SCOrdersBean WHERE orderDate BETWEEN :orderDateA AND :orderDateB";
//		String hql1 = "FROM products p "
//				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
//				+ "WHERE sco.orderDate BETWEEN :orderDateA AND :orderDateB";
		// on p.productID = scod.productID;
		// on scod.SCOrderID = sc.SCOrderID;
		Session session = factory.getCurrentSession();
		List<SCOrdersBean> SCOrdersList = new ArrayList<>();
		SCOrdersList = session.createQuery(hql).setParameter("orderDateA", orderDateA)
				.setParameter("orderDateB", orderDateB).getResultList();
		return SCOrdersList;
		// SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost
	}

	//計算周邊商品的過程step2 ===========NEW
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsBean> getPeripheralPB() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 6";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}

	//計算周邊商品的p1輸出step3 ===========NEW
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
		Double productSubtotal = 0.0;
		Integer cost = 0;
		Integer earn = 0;
		Integer earnTotal = 0;
		for (SCOrdersBean scb : scbList) {
			for (SCOrderDetailBean scodb : SCODList1) {
				if (scb.getSCOrderID().equals(scodb.getSCOrderID())) {
					for (ProductsBean pb : pbList) {
						if (pb.getProductName().equals(scodb.getPrducts().getProductName())) {
							productSubtotal = productSubtotal + scb.getTotal();
							unitPrice = unitPrice + scodb.getPrducts().getUnitPrice(); // getPBean
							saveProductName =  scodb.getPrducts().getProductName();
//							scodb.getProductsID();
							qty = qty + scodb.getQuantity();
							cost = cost + scodb.getPrducts().getCost();
							earn = unitPrice - cost;
							earnTotal = earnTotal + earn;
							ProductSaleBean psb = new ProductSaleBean(saveProductName, qty, unitPrice,
									 cost, earn, productSubtotal, earnTotal);
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

	//計算4,5的過程step1 ===========NEW
	@SuppressWarnings("unchecked")

	public List<ShowTimeHistoryBean> getMovieDate(String playStartTimeA, String playStartTimeB) {
		String hql = "FROM ShowTimeHistoryBean WHERE playStartTime BETWEEN :playStartTimeA AND :playStartTimeB";
		Session session = factory.getCurrentSession();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		sthbList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB).getResultList();
		return sthbList;
	}
	
	//計算4的過程step2 ===========NEW
	@SuppressWarnings("unchecked")

	public List<ProductsBean> getFoodPB4() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 4";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}
	
	//計算5的過程step2 ===========NEW
	@SuppressWarnings("unchecked")

	public List<ProductsBean> getFoodPB5() {
		List<ProductsBean> pbList = new ArrayList<>();
		String hql = "FROM ProductsBean WHERE categoryID = 5";
		Session session = factory.getCurrentSession();
		pbList = session.createQuery(hql).getResultList();
		return pbList;
	}
	
	// 選下拉4, 5飲食step3 ====NEW
	@SuppressWarnings("unchecked")

	public List<ProductSaleBean> showFoodOrder(List<ShowTimeHistoryBean> sthbList) {
		String hql = "FROM MOrderBean";
		Session session = factory.getCurrentSession();
		List<MOrderBean> mobList = new ArrayList<>();
		mobList = session.createQuery(hql).getResultList();
		
		List<ProductSaleBean> psbList = new ArrayList<>();
		
		for(ShowTimeHistoryBean sthb : sthbList) {
			for(MOrderBean mob : mobList) {
				if(sthb.getShowTimeId().equals(mob.getShowTimeHistoryBean().getShowTimeId())) {
					
				}else {
					System.out.println("比對時, sthb & mob的showtime不同");
				}
			}
		}
		
		
//				+ "left join c.mOrderDetail mod left join mod.mOrder mo left join mo.showTimeHistory sth"
//				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB";
		//SELECT p.productName, mod.unitPrice, mod.discount, mod.quantity, p.cost 
		// on p.productID = mod.productID
		// on mod.ordersID = mo.ordersID
		// on mo.showTimeID = sth.showTimeID
		return psbList;
	}

	@SuppressWarnings("unchecked")
	@Override
	// 選下拉總飲食p1
	public List<ProductSaleBean> showFoodOrders(String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT p.productName, mod.unitPrice, mod.discount, mod.quantity, p.cost FROM products p left join p.categories c"
				+ "p.mOrderDetail mod left join mod.mOrder mo left join mo.showTimeHistory sth WHERE sth.playStartTime BETWEEN"
				+ ":playStartTimeA AND :playStartTimeB AND c.categoryID BETWEEN 4 AND 5";
		// on p.categoryID = c.categoryID
		// on p.productID = mod.productID
		// on mod.ordersID = mo.ordersID
		// on mo.showTimeID = sth.showTimeID
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrdersList = new ArrayList<>();
		foodOrdersList = session.createQuery(hql).setParameter("playStartTimeA", playStartTimeA)
				.setParameter("playStartTimeB", playStartTimeB).getResultList();
		return foodOrdersList;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showFoodOrderByTime(String productName, String playStartTimeA, String playStartTimeB) {
		String hql = "SELECT productName, mod.unitPrice, mod.discount, mod.quantity, cost FROM products p left join p.mOrderDetail mod"
				+ "left join mod.mOrder mo left join mo.showTimeHistory sth "
				+ "WHERE sth.playStartTime BETWEEN :playStartTimeA AND :playStartTimeB AND p.productName= :productName"
				+ "ORDER BY sth.playStartTime ASC";
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> foodOrderByTimeList = new ArrayList<>();
		foodOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
				.setParameter("playStartTimeA", playStartTimeA).setParameter("playStartTimeB", playStartTimeB)
				.getResultList();
		return foodOrderByTimeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductSaleBean> showPeripheralOrderByTime(String productName, String orderDateA, String orderDateB) {
		String hql = "SELECT productName, scod.unitPrice, scod.discount, scod.quantity, cost FROM products p "
				+ "left join p.SCOrderDetail scod left join scod.SCOrders sco "
				+ "WHERE sco.orderDate BETWEEN :orderDateA AND orderDateB AND p.productName = :productName"
				+ "ORDER BY sco.orderDate ASC";
		// on p.productID = scod.productID;
		// on scod.SCOrderID = sco.SCOrderID;
		Session session = factory.getCurrentSession();
		List<ProductSaleBean> peripheralOrderByTimeList = new ArrayList<>();
		peripheralOrderByTimeList = session.createQuery(hql).setParameter("productName", productName)
				.setParameter("orderDateA", orderDateA).setParameter("orderDateB", orderDateB).getResultList();
		return peripheralOrderByTimeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDistinctProductNames() {
		List<String> productNames = new ArrayList<>();
		String hql = "SELECT DISTINCT productName FROM products";
		Session session = factory.getCurrentSession();
		productNames = session.createQuery(hql).getResultList();
		return productNames;
	}

}
